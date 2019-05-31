package msd.mobile.enji;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

import msd.mobile.enji.adapter.ViewPagerAdapter;
import msd.mobile.enji.fragment.AbsensiFragment;
import msd.mobile.enji.fragment.ChiefFragment;
import msd.mobile.enji.fragment.CtgrFragment;
import msd.mobile.enji.fragment.DailyFragment;
import msd.mobile.enji.fragment.DailyLyFragment;
import msd.mobile.enji.fragment.DeliveryChiefFragment;
import msd.mobile.enji.fragment.DeliveryDailyFragment;
import msd.mobile.enji.fragment.DeptStoreFragment;
import msd.mobile.enji.fragment.DiscFragment;
import msd.mobile.enji.fragment.LiveFragment;
import msd.mobile.enji.fragment.ArticleFragment;
import msd.mobile.enji.fragment.ModelFragment;
import msd.mobile.enji.fragment.NotFragment;
import msd.mobile.enji.fragment.AnnualFragment;
import msd.mobile.enji.fragment.StoreBestFragment;
import msd.mobile.enji.fragment.StoreFragment;
import msd.mobile.enji.fragment.StoreStockFragment;
import msd.mobile.enji.fragment.StoreStockFragment;

//--------------------------------------------Start Public Class MainActivity-----------------------
public class MainActivity extends AppCompatActivity {
//public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tvCompName,tvMonthCode,tvYearCode,tvReportName,tvReportHeader;
    private FloatingActionButton fabNext, fabPrev;
    private int y_code,m_code;
    private Calendar calendar;
    private ViewPagerAdapter viewPagerAdapter;
    private int viewPagerPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = Calendar.getInstance();
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        tvCompName = findViewById(R.id.tv_comp_name);
        tvMonthCode = findViewById(R.id.tv_month_code);
        tvReportName = findViewById(R.id.report_name);
        tvReportHeader = findViewById(R.id.report_header);
        tvYearCode = findViewById(R.id.tv_year_code);
        fabNext = findViewById(R.id.fab_next_date);
        fabPrev = findViewById(R.id.fab_previous_date);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //------Initial Values ------------------------------------------------
        m_code =calendar.get(Calendar.MONTH)+1;
        y_code =calendar.get(Calendar.YEAR);

        tvCompName.setText("Enji Collection");
        tvMonthCode.setText(Integer.toString(m_code));
        tvYearCode.setText(Integer.toString(y_code));

        m_code = Integer.parseInt(tvMonthCode.getText().toString());
        y_code = Integer.parseInt(tvYearCode.getText().toString());


        tvReportName.setText("   Report Live Sales");
        tvReportHeader.setText(" Info                                                        Nilai ");

        setViewPager(viewPager);
       // viewPagerPosition = viewPager.getCurrentItem();
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
           }

//----------------------------- START : // when fragment is selected -------------------------------
            @Override
            public void onPageSelected(int position) {
                viewPagerPosition = position;

                Fragment fragment = viewPagerAdapter.getItem(position);
                m_code = Integer.parseInt(tvMonthCode.getText().toString());
                y_code = Integer.parseInt(tvYearCode.getText().toString());

                if (fragment instanceof ChiefFragment) {
                    ChiefFragment ChiefFragment = (ChiefFragment) fragment;
                    ChiefFragment.setYearCode(y_code);
                    ChiefFragment.setMonthCode(m_code);
                    ChiefFragment.onRefresh();
                    tvReportName.setText("   Report By Chief Act vs Pln");
                    tvReportHeader.setText(" Chief               Nett      Pln         Ly       %Pl      %Ly");
                } else if (fragment instanceof DiscFragment) {
                    DiscFragment DiscFragment = (DiscFragment) fragment;
                    DiscFragment.setYearCode(y_code);
                    DiscFragment.setMonthCode(m_code);
                    DiscFragment.onRefresh();
                    tvReportName.setText("   Report By Disc Code");
                    tvReportHeader.setText(" Disc Code       Qty          Nett     %Cont");
                } else if (fragment instanceof DailyFragment) {
                    DailyFragment DailyFragment = (DailyFragment) fragment;
                    DailyFragment.setYearCode(y_code);
                    DailyFragment.setMonthCode(m_code);
                    DailyFragment.onRefresh();
                    tvReportName.setText("   Report By Day Qty And Nett");
                    tvReportHeader.setText(" Day                Str#          Qty         Nett       ");
                } else if (fragment instanceof StoreFragment) {
                    StoreFragment StoreFragment = (StoreFragment) fragment;
                    StoreFragment.setYearCode(y_code);
                    StoreFragment.setMonthCode(m_code);
                    StoreFragment.onRefresh();
                    tvReportName.setText("   Report By Store ");
                    tvReportHeader.setText(" Qty        Nett    ");
                } else if (fragment instanceof CtgrFragment) {
                    CtgrFragment CtgrFragment = (CtgrFragment) fragment;
                    CtgrFragment.setYearCode(y_code);
                    CtgrFragment.setMonthCode(m_code);
                    CtgrFragment.onRefresh();
                    tvReportName.setText("   Report By Category MTD");
                    tvReportHeader.setText(" Category              Qty           Nett          %Cont");
                } else if (fragment instanceof DeptStoreFragment) {
                    DeptStoreFragment DeptStoreFragment = (DeptStoreFragment) fragment;
                    DeptStoreFragment.setYearCode(y_code);
                    DeptStoreFragment.setMonthCode(m_code);
                    DeptStoreFragment.onRefresh();
                    tvReportName.setText("   Report By Department Store");
                    tvReportHeader.setText(" DeptStore           TY        PL           LY       %Pl   %ly");
                } else if (fragment instanceof StoreBestFragment) {
                    StoreBestFragment StoreBestFragment = (StoreBestFragment) fragment;
                    StoreBestFragment.setYearCode(y_code);
                    StoreBestFragment.setMonthCode(m_code);
                    StoreBestFragment.onRefresh();
                    tvReportName.setText("   Report Best Store");
                    tvReportHeader.setText(" Qty        Nett    Pln      %Ach");
                } else if (fragment instanceof StoreStockFragment) {
                    StoreStockFragment StoreStockFragment = (StoreStockFragment) fragment;
                    StoreStockFragment.setYearCode(y_code);
                    StoreStockFragment.setMonthCode(m_code);
                    StoreStockFragment.onRefresh();
                    tvReportName.setText("   Report Stock Store");
                    tvReportHeader.setText("  BOM     REC    RTR IN   RTR OUT      SLS    EOM");
                } else if (fragment instanceof DailyLyFragment) {
                    DailyLyFragment DailyLyFragment = (DailyLyFragment) fragment;
                    DailyLyFragment.setYearCode(y_code);
                    DailyLyFragment.setMonthCode(m_code);
                    DailyLyFragment.onRefresh();
                    tvReportName.setText("   Report By Day Vs Last Year");
                    tvReportHeader.setText(" Day                 #Str        NettTY    NettLY    %O/U");
                } else if (fragment instanceof NotFragment) {
                    NotFragment NotFragment = (NotFragment) fragment;
                    NotFragment.setYearCode(y_code);
                    NotFragment.setMonthCode(m_code);
                    NotFragment.onRefresh();;
                    tvReportName.setText("   Report List Store Not Send");
                    tvReportHeader.setText(" Trx Date - Chief - Storename ");
                } else if (fragment instanceof DeliveryChiefFragment) {
                    DeliveryChiefFragment DeliveryChiefFragment = (DeliveryChiefFragment) fragment;
                    DeliveryChiefFragment.setYearCode(y_code);
                    DeliveryChiefFragment.setMonthCode(m_code);
                    DeliveryChiefFragment.onRefresh();
                    tvReportName.setText("   Report Delivery by Chief");
                    tvReportHeader.setText(" Chief             #SJ       QTY           Gross       Weight");
                } else if (fragment instanceof DeliveryDailyFragment) {
                    DeliveryDailyFragment DeliveryDailyFragment = (DeliveryDailyFragment) fragment;
                    DeliveryDailyFragment.setYearCode(y_code);
                    DeliveryDailyFragment.setMonthCode(m_code);
                    DeliveryDailyFragment.onRefresh();
                    tvReportName.setText("   Report Delivery by Date");
                    tvReportHeader.setText(" Date                    Qty              Gross             Weight");
                } else if (fragment instanceof ModelFragment) {
                    ModelFragment ModelFragment = (ModelFragment) fragment;
                    ModelFragment.setYearCode(y_code);
                    ModelFragment.setMonthCode(m_code);
                    ModelFragment.onRefresh();
                    tvReportName.setText("   Report By Product Name");
                    tvReportHeader.setText(" Product Name - Qty - Nett");
                } else if (fragment instanceof ArticleFragment) {
                    ArticleFragment ArticleFragment = (ArticleFragment) fragment;
                    ArticleFragment.setYearCode(y_code);
                    ArticleFragment.setMonthCode(m_code);
                    ArticleFragment.onRefresh();
                    tvReportName.setText("   Report Best Article ");
                    tvReportHeader.setText(" Article - Colour             Qty               Nett");
                }  else if (fragment instanceof AnnualFragment) {
                    AnnualFragment AnnualFragment = (AnnualFragment) fragment;
                    AnnualFragment.setYearCode(y_code);
                    AnnualFragment.setMonthCode(m_code);
                    AnnualFragment.onRefresh();
                    tvReportName.setText("   Report By Month");
                    tvReportHeader.setText(" Month                                Qty            Nett");
                }else if (fragment instanceof AbsensiFragment) {
                    AbsensiFragment AbsensiFragment = (AbsensiFragment) fragment;
                    AbsensiFragment.setYearCode(y_code);
                    AbsensiFragment.setMonthCode(m_code);
                    AbsensiFragment.onRefresh();
                    tvReportName.setText("   Report Absensi");
                    tvReportHeader.setText(" Store Code Chief / Nik                      HK     HB    HL");
                } else if (fragment instanceof LiveFragment) {
                    LiveFragment LiveFragment = (LiveFragment) fragment;
                    LiveFragment.setYearCode(y_code);
                    LiveFragment.setMonthCode(m_code);
                    LiveFragment.onRefresh();
                    tvReportName.setText("   Report Live Sales");
                    tvReportHeader.setText(" Info                                                        Nilai ");

                }
            }
//----------------------------------------FINISH : when fragment is selected -----------------------

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

//---------------------------------------------------------------------------------------------------
        fabPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m_code,y_code;

                m_code = Integer.parseInt(tvMonthCode.getText().toString());
                y_code = Integer.parseInt(tvYearCode.getText().toString());

                if (m_code == 1) {
                    y_code = y_code - 1;
                    m_code = 12;
                 } else {
                    m_code = m_code - 1;
                }

                // ----- Change Textview Value to New m_code and y_code  -----//
                tvMonthCode.setText(Integer.toString(m_code));
                tvYearCode.setText(Integer.toString(y_code));

                Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);
                if (fragment instanceof ChiefFragment) {
                    ChiefFragment ChiefFragment = (ChiefFragment) fragment;
                    ChiefFragment.setYearCode(y_code);
                    ChiefFragment.setMonthCode(m_code);
                    ChiefFragment.onRefresh();
                } else if (fragment instanceof DiscFragment) {
                    DiscFragment DiscFragment = (DiscFragment) fragment;
                    DiscFragment.setYearCode(y_code);
                    DiscFragment.setMonthCode(m_code);
                    DiscFragment.onRefresh();
                } else if (fragment instanceof DailyFragment) {
                    DailyFragment DailyFragment = (DailyFragment) fragment;
                    DailyFragment.setYearCode(y_code);
                    DailyFragment.setMonthCode(m_code);
                    DailyFragment.onRefresh();
                } else if (fragment instanceof StoreFragment) {
                    StoreFragment StoreFragment = (StoreFragment) fragment;
                    StoreFragment.setYearCode(y_code);
                    StoreFragment.setMonthCode(m_code);
                    StoreFragment.onRefresh();
                } else if (fragment instanceof CtgrFragment) {
                    CtgrFragment CtgrFragment = (CtgrFragment) fragment;
                    CtgrFragment.setYearCode(y_code);
                    CtgrFragment.setMonthCode(m_code);
                    CtgrFragment.onRefresh();
                } else if (fragment instanceof DeptStoreFragment) {
                    DeptStoreFragment DeptStoreFragment = (DeptStoreFragment) fragment;
                    DeptStoreFragment.setYearCode(y_code);
                    DeptStoreFragment.setMonthCode(m_code);
                    DeptStoreFragment.onRefresh();
                }  else if (fragment instanceof DailyLyFragment) {
                    DailyLyFragment DailyLyFragment = (DailyLyFragment) fragment;
                    DailyLyFragment.setYearCode(y_code);
                    DailyLyFragment.setMonthCode(m_code);
                    DailyLyFragment.onRefresh();
                } else if (fragment instanceof NotFragment) {
                    NotFragment NotFragment = (NotFragment) fragment;
                    NotFragment.setYearCode(y_code);
                    NotFragment.setMonthCode(m_code);
                    NotFragment.onRefresh();
                }else if (fragment instanceof DeliveryChiefFragment) {
                    DeliveryChiefFragment DeliveryChiefFragment = (DeliveryChiefFragment) fragment;
                    DeliveryChiefFragment.setYearCode(y_code);
                    DeliveryChiefFragment.setMonthCode(m_code);
                    DeliveryChiefFragment.onRefresh();
                }else if (fragment instanceof DeliveryDailyFragment) {
                    DeliveryDailyFragment DeliveryDailyFragment = (DeliveryDailyFragment) fragment;
                    DeliveryDailyFragment.setYearCode(y_code);
                    DeliveryDailyFragment.setMonthCode(m_code);
                    DeliveryDailyFragment.onRefresh();
                } else if (fragment instanceof ModelFragment) {
                    ModelFragment ModelFragment = (ModelFragment) fragment;
                    ModelFragment.setYearCode(y_code);
                    ModelFragment.setMonthCode(m_code);
                    ModelFragment.onRefresh();
                } else if (fragment instanceof ArticleFragment) {
                    ArticleFragment ArticleFragment = (ArticleFragment) fragment;
                    ArticleFragment.setYearCode(y_code);
                    ArticleFragment.setMonthCode(m_code);
                    ArticleFragment.onRefresh();
                } else if (fragment instanceof AnnualFragment) {
                    AnnualFragment AnnualFragment = (AnnualFragment) fragment;
                    AnnualFragment.setYearCode(y_code);
                    AnnualFragment.setMonthCode(m_code);
                    AnnualFragment.onRefresh();
                } else if (fragment instanceof AbsensiFragment) {
                    AbsensiFragment AbsensiFragment = (AbsensiFragment) fragment;
                    AbsensiFragment.setYearCode(y_code);
                    AbsensiFragment.setMonthCode(m_code);
                    AbsensiFragment.onRefresh();
                }else if (fragment instanceof StoreBestFragment) {
                    StoreBestFragment StoreBestFragment = (StoreBestFragment) fragment;
                    StoreBestFragment.setYearCode(y_code);
                    StoreBestFragment.setMonthCode(m_code);
                    StoreBestFragment.onRefresh();
                }  else if (fragment instanceof LiveFragment) {
                    LiveFragment LiveFragment = (LiveFragment) fragment;
                    LiveFragment.setYearCode(y_code);
                    LiveFragment.setMonthCode(m_code);
                    LiveFragment.onRefresh();
                }   else if (fragment instanceof StoreStockFragment) {
                    StoreStockFragment StoreStockFragment = (StoreStockFragment) fragment;
                    StoreStockFragment.setYearCode(y_code);
                    StoreStockFragment.setMonthCode(m_code);
                    StoreStockFragment.onRefresh();
                }
            }
        });

//--------------------------------------------------------------------------------------------------
        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m_code,y_code;
                // ----- Get Current Text View Value to m_code and y_code  -----//
                m_code = Integer.parseInt(tvMonthCode.getText().toString());
                y_code = Integer.parseInt(tvYearCode.getText().toString());

                if (m_code == 12) {
                    y_code = y_code + 1;
                    m_code = 1;
                } else {
                    m_code = m_code + 1;
                }

                // ----- Change Text View Value to New m_code and y_code  -----//
                tvMonthCode.setText(Integer.toString(m_code));
                tvYearCode.setText(Integer.toString(y_code));

                Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);
                if (fragment instanceof ChiefFragment) {
                    ChiefFragment ChiefFragment = (ChiefFragment) fragment;
                    ChiefFragment.setYearCode(y_code);
                    ChiefFragment.setMonthCode(m_code);
                    ChiefFragment.onRefresh();
                } else if (fragment instanceof DiscFragment) {
                    DiscFragment DiscFragment = (DiscFragment) fragment;
                    DiscFragment.setYearCode(y_code);
                    DiscFragment.setMonthCode(m_code);
                    DiscFragment.onRefresh();
                } else if (fragment instanceof DailyFragment) {
                    DailyFragment DailyFragment = (DailyFragment) fragment;
                    DailyFragment.setYearCode(y_code);
                    DailyFragment.setMonthCode(m_code);
                    DailyFragment.onRefresh();
                } else if (fragment instanceof StoreFragment) {
                    StoreFragment StoreFragment = (StoreFragment) fragment;
                    StoreFragment.setYearCode(y_code);
                    StoreFragment.setMonthCode(m_code);
                    StoreFragment.onRefresh();
                } else if (fragment instanceof CtgrFragment) {
                    CtgrFragment CtgrFragment = (CtgrFragment) fragment;
                    CtgrFragment.setYearCode(y_code);
                    CtgrFragment.setMonthCode(m_code);
                    CtgrFragment.onRefresh();
                } else if (fragment instanceof DeptStoreFragment) {
                    DeptStoreFragment DeptStoreFragment = (DeptStoreFragment) fragment;
                    DeptStoreFragment.setYearCode(y_code);
                    DeptStoreFragment.setMonthCode(m_code);
                    DeptStoreFragment.onRefresh();
                } else if (fragment instanceof DeptStoreFragment) {
                    DeptStoreFragment DeptStoreFragment = (DeptStoreFragment) fragment;
                    DeptStoreFragment.setYearCode(y_code);
                    DeptStoreFragment.setMonthCode(m_code);
                    DeptStoreFragment.onRefresh();
                } else if (fragment instanceof DailyLyFragment) {
                    DailyLyFragment DailyLyFragment = (DailyLyFragment) fragment;
                    DailyLyFragment.setYearCode(y_code);
                    DailyLyFragment.setMonthCode(m_code);
                    DailyLyFragment.onRefresh();
                } else if (fragment instanceof NotFragment) {
                    NotFragment NotFragment = (NotFragment) fragment;
                    NotFragment.setYearCode(y_code);
                    NotFragment.setMonthCode(m_code);
                    NotFragment.onRefresh();;
                } else if (fragment instanceof DeliveryChiefFragment) {
                    DeliveryChiefFragment DeliveryChiefFragment = (DeliveryChiefFragment) fragment;
                    DeliveryChiefFragment.setYearCode(y_code);
                    DeliveryChiefFragment.setMonthCode(m_code);
                    DeliveryChiefFragment.onRefresh();
                } else if (fragment instanceof DeliveryDailyFragment) {
                    DeliveryDailyFragment DeliveryDailyFragment = (DeliveryDailyFragment) fragment;
                    DeliveryDailyFragment.setYearCode(y_code);
                    DeliveryDailyFragment.setMonthCode(m_code);
                    DeliveryDailyFragment.onRefresh();
                } else if (fragment instanceof ModelFragment) {
                    ModelFragment ModelFragment = (ModelFragment) fragment;
                    ModelFragment.setYearCode(y_code);
                    ModelFragment.setMonthCode(m_code);
                    ModelFragment.onRefresh();
                } else if (fragment instanceof ArticleFragment) {
                    ArticleFragment ArticleFragment = (ArticleFragment) fragment;
                    ArticleFragment.setYearCode(y_code);
                    ArticleFragment.setMonthCode(m_code);
                    ArticleFragment.onRefresh();
                } else if (fragment instanceof AnnualFragment) {
                    AnnualFragment AnnualFragment = (AnnualFragment) fragment;
                    AnnualFragment.setYearCode(y_code);
                    AnnualFragment.setMonthCode(m_code);
                    AnnualFragment.onRefresh();
                } else if (fragment instanceof AbsensiFragment) {
                    AbsensiFragment AbsensiFragment = (AbsensiFragment) fragment;
                    AbsensiFragment.setYearCode(y_code);
                    AbsensiFragment.setMonthCode(m_code);
                    AbsensiFragment.onRefresh();
                } else if (fragment instanceof LiveFragment) {
                    LiveFragment LiveFragment = (LiveFragment) fragment;
                    LiveFragment.setYearCode(y_code);
                    LiveFragment.setMonthCode(m_code);
                    LiveFragment.onRefresh();
                }else if (fragment instanceof StoreBestFragment) {
                    StoreBestFragment StoreBestFragment = (StoreBestFragment) fragment;
                    StoreBestFragment.setYearCode(y_code);
                    StoreBestFragment.setMonthCode(m_code);
                    StoreBestFragment.onRefresh();
                } else if (fragment instanceof StoreStockFragment) {
                    StoreStockFragment StoreStockFragment = (StoreStockFragment) fragment;
                    StoreStockFragment.setYearCode(y_code);
                    StoreStockFragment.setMonthCode(m_code);
                    StoreStockFragment.onRefresh();
                }
            }
        });
    }

//---------------- Opening Main Activity ----------------------------------------------------------
    private void setViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        LiveFragment  LiveFragment = new  LiveFragment();
        viewPagerAdapter.addFragment(LiveFragment,"DASHBOARD");
        viewPagerAdapter.addFragment(new DailyFragment(), "DAILY");
        viewPagerAdapter.addFragment(new AnnualFragment(),"MONTHLY");
    //    viewPagerAdapter.addFragment(new DeptStoreFragment(),"DEPT TY");
    //    viewPagerAdapter.addFragment(new ChiefFragment(), "CHF TY-PL");
    //    viewPagerAdapter.addFragment(new DiscFragment(),"DISC TY");
        viewPagerAdapter.addFragment(new StoreFragment(),"BY STORE");
        viewPagerAdapter.addFragment(new StoreStockFragment(),"STOCK STORE");

        //    viewPagerAdapter.addFragment(new StoreBestFragment(),"BEST STORE");
    //    viewPagerAdapter.addFragment(new StoreStockFragment(),"Stock STORE");
        viewPagerAdapter.addFragment(new ModelFragment(),"BY PRODUCT");
        viewPagerAdapter.addFragment(new ArticleFragment(),"BY ARTICLE");
        viewPagerAdapter.addFragment(new NotFragment(),"NOT SYNC");


        //   viewPagerAdapter.addFragment(new ArticleFragment(),"MODEL CTGR");
    //    viewPagerAdapter.addFragment(new CtgrFragment(),"CTGR TY");
     //   viewPagerAdapter.addFragment(new DeliveryDailyFragment(),"DLV DATE");
     //   viewPagerAdapter.addFragment(new DeliveryChiefFragment(),"DLV CHIEF");
     // viewPagerAdapter.addFragment(new DeliveryChiefFragment(),"DLV STORE");
     // viewPagerAdapter.addFragment(new DeliveryChiefFragment(),"RTR DLV CHF");
     //   viewPagerAdapter.addFragment(new AnnualFragment(),"Annual");
     //   viewPagerAdapter.addFragment(new NotFragment(),"NOT SENT");
    //    viewPagerAdapter.addFragment(new AbsensiFragment(),"ABSENSI");
        viewPager.setAdapter(viewPagerAdapter);

        m_code = Integer.parseInt(tvMonthCode.getText().toString());
        y_code = Integer.parseInt(tvYearCode.getText().toString());

        LiveFragment.setYearCode(y_code);
        LiveFragment.setMonthCode(m_code);
   }


//--------------------------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


//--------------------------------------------------------------------------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_daily:
                startActivity(new Intent(this, DailyActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

//--------------------------------------------------------------------------------------------------
    private void logout() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}
//----------------------------------END OF MAIN ACTIVITY JAVA---------------------------------------
