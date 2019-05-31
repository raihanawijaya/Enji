package msd.mobile.enji.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import msd.mobile.enji.R;
import msd.mobile.enji.model.PROC_MTD_SALES_DAILY_LY_CODE;

public class DailyLyCodeAdapter extends RecyclerView.Adapter<DailyLyCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_SALES_DAILY_LY_CODE> listData;

    public DailyLyCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_SALES_DAILY_LY_CODE> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_daily_ly,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_SALES_DAILY_LY_CODE dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float Pct;
        String DayName ="",Day="";

        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");


        DayName = dataModel.getDailyCode().toString();
        Day = DayName.toString().substring(5,7);
        if (Day.equalsIgnoreCase("SU")){
            holder.tvDailyCode.setTextColor(Color.RED);
            holder.tvDailyStoreCount.setTextColor(Color.RED);
        }

        holder.tvDailyCode.setText(dataModel.getDailyCode());
        holder.tvDailyStoreCount.setText(numberFormatQty.format(Float.parseFloat(dataModel.getDailyStoreCount())));
        holder.tvDailyNett.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getDailyNett())));

        holder.tvDailyNett.setTextColor((Color.BLUE));
        holder.tvDailyNett.setTypeface(Typeface.DEFAULT_BOLD);
        holder.tvDailyNettLy.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getDailyNettLy())));

        Pct = ((Float.parseFloat(dataModel.getDailyNett())- Float.parseFloat(dataModel.getDailyNettLy())))*100/ Float.parseFloat(dataModel.getDailyNettLy());
        if (Pct <= 0) {
            holder.tvDailyPct.setTextColor(Color.RED);
        }else{
            holder.tvDailyPct.setTextColor(Color.BLUE);
        }

        holder.tvDailyPct.setText(numberFormatCurrency.format(Float.parseFloat(Pct.toString())));

    holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
     return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvItem;
        private TextView tvDailyCode,tvDailyStoreCount, tvDailyNettLy,tvDailyNett, tvDailyQtyLy,tvDailyQty,tvDailyPct  ;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvDailyCode = itemView.findViewById(R.id.tv_daily_date);
            tvDailyStoreCount = itemView.findViewById(R.id.tv_daily_store_count);
            tvDailyQty = itemView.findViewById(R.id.tv_daily_qty);
            tvDailyNettLy = itemView.findViewById(R.id.tv_daily_nett_ly);
            tvDailyNett = itemView.findViewById(R.id.tv_daily_nett);
            tvDailyPct = itemView.findViewById(R.id.tv_daily_pct);

     }
    }
}
