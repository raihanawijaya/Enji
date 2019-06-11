package msd.mobile.enji;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import msd.mobile.enji.adapter.ViewPagerAdapter;
import msd.mobile.enji.fragment.ArticleDailyFragment;
import msd.mobile.enji.fragment.ProductDailyFragment;
import msd.mobile.enji.fragment.StoreDailyFragment;
import msd.mobile.enji.utils.SharedPreference;


public class DailyActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tvDate,tvCompName,tvDailyReportName,tvDailyReportHeader;

    private FloatingActionButton fabNext, fabPrev;
    private SharedPreference sharedPreference;
    private String date, dateView;
    private int y_id;
    private int m_id;
    private Calendar calendar;
    private SimpleDateFormat sdf, sdfView;
    private int dateInc = 0;
    private ProgressDialog addLoading;
    private ViewPagerAdapter viewPagerAdapter;
    private int viewPagerPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        calendar = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdfView = new SimpleDateFormat("dd MMM yyyy");

        addLoading = new ProgressDialog(this);
        addLoading.setMessage("Log In . . .");
        addLoading.setCancelable(false);

        date = sdf.format(calendar.getTime());
        dateView = sdfView.format(calendar.getTime());

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);

        tvCompName=findViewById(R.id.tv_comp_name);
        tvDailyReportHeader=findViewById(R.id.tv_daily_report_header);
        tvDailyReportName=findViewById(R.id.tv_daily_report_name);
        tvDate = findViewById(R.id.tv_trx_date);

        fabNext = findViewById(R.id.fab_next_date);
        fabPrev = findViewById(R.id.fab_previous_date);


        tvDate.setText(dateView);
        tvCompName.setText("Enji Collection");
        tvDailyReportName.setText("   Report Live Sales");
        tvDailyReportHeader.setText(" Info                                                        Nilai ");



        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

          setViewPager(viewPager);
        viewPagerPosition = viewPager.getCurrentItem();

        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                viewPagerPosition = position;

                 Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);

                if (fragment instanceof StoreDailyFragment) {
                    StoreDailyFragment StoreDailyFragment = (StoreDailyFragment) fragment;
                    StoreDailyFragment.setYearCode(2019);
                    StoreDailyFragment.setMonthCode(4);
                    StoreDailyFragment.onRefresh();
                    tvDailyReportName.setText(" Daily Sales By Store ");
                    tvDailyReportHeader.setText("  Info - Qty - Nett - AvgPrice");
                } else if (fragment instanceof ProductDailyFragment) {
                    ProductDailyFragment ProductDailyFragment = (ProductDailyFragment) fragment;
                    ProductDailyFragment.setDate(date);
                    ProductDailyFragment.onRefresh();
                    tvDailyReportName.setText(" Daily Sales By Product ");
                    tvDailyReportHeader.setText("  Info - Qty - Nett - AvgPrice");
                } else if (fragment instanceof ArticleDailyFragment) {
                    ArticleDailyFragment ArticleDailyFragment = (ArticleDailyFragment) fragment;
                    ArticleDailyFragment.setDate(date);
                    ArticleDailyFragment.onRefresh();
                    tvDailyReportName.setText(" Daily Sales By Article ");
                    tvDailyReportHeader.setText("  Info - Qty - Nett - AvgPrice");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        DailyActivity.this,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        fabPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG ", "onClick(-): "+dateInc);
//                dateInc--;
                Calendar prevDate = calendar;
                //prevDate.setTime(calendar.getTime());
                prevDate.add(Calendar.DAY_OF_YEAR, -1);

                calendar.setTime(prevDate.getTime());
                date = sdf.format(calendar.getTime());
                dateView = sdfView.format(calendar.getTime());

                y_id = calendar.get(Calendar.YEAR);
                m_id = calendar.get(Calendar.MONTH) + 1;

                Log.d("MainDate", "onClick: " + date + " " + m_id);

                tvDate.setText(dateView);

            //    GetViewDailyMTDTransaction(date, storeCode);

                Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);
                if (fragment instanceof StoreDailyFragment) {
                    StoreDailyFragment StoreDailyFragment = (StoreDailyFragment) fragment;
                    StoreDailyFragment.setDate(date);
                    StoreDailyFragment.onRefresh();
                }  else if (fragment instanceof ProductDailyFragment) {
                    ProductDailyFragment ProductDailyFragment = (ProductDailyFragment) fragment;
                    ProductDailyFragment.setDate(date);
                    ProductDailyFragment.onRefresh();
                } else if (fragment instanceof ArticleDailyFragment) {
                    ArticleDailyFragment ArticleDailyFragment = (ArticleDailyFragment) fragment;
                    ArticleDailyFragment.setDate(date);
                    ArticleDailyFragment.onRefresh();
                }
            }
        });

        //------------------------------------------------------------------------------------
        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG ", "onClick(+): " + dateInc);
//                dateInc++;
                Calendar nextDate = calendar;
                //nextDate.setTime(calendar.getTime());
                nextDate.add(Calendar.DAY_OF_YEAR, 1);

                calendar.setTime(nextDate.getTime());

                date = sdf.format(calendar.getTime());
                dateView = sdfView.format(calendar.getTime());

                y_id = calendar.get(Calendar.YEAR);
                m_id = calendar.get(Calendar.MONTH) + 1;

                Log.d("MainDate", "onClick: " + y_id + " " + m_id);

                tvDate.setText(dateView);

            //    GetViewDailyMTDTransaction(date, storeCode);

                Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);
                if (fragment instanceof StoreDailyFragment) {
                    StoreDailyFragment StoreDailyFragment = (StoreDailyFragment) fragment;
                    StoreDailyFragment.setDate(date);
                    StoreDailyFragment.onRefresh();
                }  else if (fragment instanceof ProductDailyFragment) {
                    ProductDailyFragment ProductDailyFragment = (ProductDailyFragment) fragment;
                    ProductDailyFragment.setDate(date);
                    ProductDailyFragment.onRefresh();
                } else if (fragment instanceof ArticleDailyFragment) {
                    ArticleDailyFragment ArticleDailyFragment = (ArticleDailyFragment) fragment;
                    ArticleDailyFragment.setDate(date);
                    ArticleDailyFragment.onRefresh();
                }

            }
        });

        
    }

    private void setViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        StoreDailyFragment StoreDailyFragment = new StoreDailyFragment();
        tvDailyReportName.setText(" Daily Sales By Store ");
        tvDailyReportHeader.setText("  Info - Qty - Nett - AvgPrice");  viewPagerAdapter.addFragment(StoreDailyFragment, "By Store");
        viewPagerAdapter.addFragment(new ProductDailyFragment(), "By Product");
        viewPagerAdapter.addFragment(new ArticleDailyFragment(), "By Article");
        viewPager.setAdapter(viewPagerAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
      //  GetViewDailyMTDTransaction(date, storeCode);

  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //case R.id.menu_logout:
             //   logout();
            //    break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        dateInc = 0;
        String month;
        if ((monthOfYear + 1) < 10) {
            month = "0" + (monthOfYear + 1);
        } else {
            month = String.valueOf(monthOfYear + 1);
        }

        date = year + "-" + month + "-" + dayOfMonth;
        try {
            Date dt = sdf.parse(date);
            calendar.setTime(dt);
            dateView = sdfView.format(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        y_id = year;
        m_id = monthOfYear + 1;

        tvDate.setText(dateView);

        // line code dibawah ini untuk merefresh data mtd
       // GetViewDailyMTDTransaction(date, storeCode);

        Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);
        if (fragment instanceof StoreDailyFragment) {
            StoreDailyFragment StoreDailyFragment = (StoreDailyFragment) fragment;
            StoreDailyFragment.setDate(date);
            StoreDailyFragment.onRefresh();
        } else if (fragment instanceof StoreDailyFragment) {
            StoreDailyFragment StoreDailyFragment = (StoreDailyFragment) fragment;
            StoreDailyFragment.setDate(date);
            StoreDailyFragment.onRefresh();
        }
    }



}

