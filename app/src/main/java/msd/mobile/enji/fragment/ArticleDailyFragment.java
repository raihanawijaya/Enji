package msd.mobile.enji.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import msd.mobile.enji.R;
import msd.mobile.enji.adapter.DailyArticleCodeAdapter;
import msd.mobile.enji.adapter.DailyArticleCodeAdapter;
import msd.mobile.enji.model.PROC_DAILY_SALES_ARTICLE_CODE;
import msd.mobile.enji.model.PROC_DAILY_SALES_ARTICLE_CODE_RESPONSE;
import msd.mobile.enji.services.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleDailyFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rvList;
    private DailyArticleCodeAdapter adapter;
    private List<PROC_DAILY_SALES_ARTICLE_CODE> listData = new ArrayList<>();
    private String date, dateView;

    private Calendar calendar;

    private SimpleDateFormat sdf, sdfView;
    private Integer y_id,m_id;

    public ArticleDailyFragment() {
        // Required empty public constructor
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public Integer getYearCode() {
        return y_id;
    }
    public void setYearCode(Integer y_id ) {
        this.y_id = y_id; }

    public Integer getMonthCode() {
        return m_id;
    }
    public void setMonthCode(Integer m_id ) {
        this.m_id = m_id;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_store, container, false);


        calendar = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdfView = new SimpleDateFormat("dd MMM yyyy");


        date = sdf.format(calendar.getTime());
        dateView = sdfView.format(calendar.getTime());

        swipeRefreshLayout = v.findViewById(R.id.swipe);
        rvList = v.findViewById(R.id.rv_list);

        adapter = new DailyArticleCodeAdapter(getContext());
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);

        getDataTransactionArticleCode(date);

        return  v;
    }
    private void getDataTransactionArticleCode(String date) {
        swipeRefreshLayout.setRefreshing(true);
        listData.clear();

        try {
            Call<PROC_DAILY_SALES_ARTICLE_CODE_RESPONSE> call = RetrofitServices.sendDataRequest().GET_DAILY_SALES_ARTICLE_CODE(date);
            if (call != null) {
                call.enqueue(new Callback<PROC_DAILY_SALES_ARTICLE_CODE_RESPONSE>() {
                    @Override
                    public void onResponse(Call<PROC_DAILY_SALES_ARTICLE_CODE_RESPONSE> call, Response<PROC_DAILY_SALES_ARTICLE_CODE_RESPONSE> response) {
                        swipeRefreshLayout.setRefreshing(false);
                        Locale localeID = new Locale("in", "ID");

                        NumberFormat numberFormatCurrency = NumberFormat.getCurrencyInstance(localeID);
                        numberFormatCurrency.setMaximumFractionDigits(0);
                        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormatCurrency).getDecimalFormatSymbols();
                        decimalFormatSymbols.setCurrencySymbol("");
                        ((DecimalFormat) numberFormatCurrency).setDecimalFormatSymbols(decimalFormatSymbols);

                        if (response.isSuccessful()) {
                            boolean error = response.body().getError();
                            String msg = response.body().getMsg();
                            PROC_DAILY_SALES_ARTICLE_CODE dataDAILYTransactionModel = null;
                            if (!error) {
                                listData = response.body().GET_DAILY_SALES_ARTICLE_CODE();
                            } else {
                             //   Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                            }
                            adapter.setData(listData);

                        } else {
                            Toast.makeText(getContext(), "Connection error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PROC_DAILY_SALES_ARTICLE_CODE_RESPONSE> call, Throwable t) {
                        swipeRefreshLayout.setRefreshing(false);
                        Log.e("error", t.getMessage());
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRefresh() {
        getDataTransactionArticleCode(date);
       //getDataTransactionChief("2018/08/15");
    }
}

