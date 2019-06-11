package msd.mobile.enji.adapter;

import android.content.Context;
import android.graphics.Color;
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

import msd.mobile.enji.R;
import msd.mobile.enji.model.PROC_MTD_SALES_DAILY_CODE;

public class DailyCodeAdapter extends RecyclerView.Adapter<DailyCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_SALES_DAILY_CODE> listData;

    public DailyCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_SALES_DAILY_CODE> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_daily,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_SALES_DAILY_CODE dataModel = listData.get(position);
        String DayName ="",Day="";

        DayName = dataModel.getDailyCode().toString();
        Day = DayName.toString().substring(5,7);

        if (Day.equalsIgnoreCase("SU")){
            holder.tvDailyCode.setTextColor(Color.RED);
            holder.tvDailyStoreCount.setTextColor(Color.RED);
            }

        holder.tvDailyCode.setText(dataModel.getDailyCode());
        holder.tvDailyStoreCount.setText(dataModel.getDailyStoreCount());
        holder.tvDailyQty.setText(dataModel.getDailyQty());
        holder.tvDailyNett.setText(dataModel.getDailyNett());
        holder.tvDailyAvg.setText(dataModel.getAvgNett());

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
        private TextView tvDailyCode,tvDailyStoreCount, tvDailyQty,tvDailyNett,tvDailyAvg;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvDailyCode = itemView.findViewById(R.id.tv_daily_date);
            tvDailyStoreCount = itemView.findViewById(R.id.tv_daily_store_count);
            tvDailyQty = itemView.findViewById(R.id.tv_daily_qty);
            tvDailyNett = itemView.findViewById(R.id.tv_daily_nett);
            tvDailyAvg = itemView.findViewById(R.id.tv_daily_avg);
     }
    }
}
