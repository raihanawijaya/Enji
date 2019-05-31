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
import java.util.Locale;

import msd.mobile.enji.R;
import msd.mobile.enji.model.MTDPlanChiefCodeTransaction;

public class ChiefCodeAdapter extends RecyclerView.Adapter<ChiefCodeAdapter.ViewHolder>{
    private Context context;
    private List<MTDPlanChiefCodeTransaction> listData;

    public ChiefCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<MTDPlanChiefCodeTransaction> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_chief,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MTDPlanChiefCodeTransaction dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float Pct,PctLyAch;
        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");

        holder.tvChief.setText(dataModel.getChief());
        holder.tvMtdNett.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdNett())/1000000));
        holder.tvMtdPlan.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdPlan())/1000000));
        holder.tvMtdLy.setTextColor(Color.MAGENTA);
        holder.tvMtdLy.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdNettLy())));

        Pct = (Float.parseFloat(dataModel.getMtdNett())*100)/ Float.parseFloat(dataModel.getMtdPlan());
        holder.tvPct.setText(numberFormatCurrency.format(Float.parseFloat(Pct.toString())));

        if (Pct <= 100) {
            holder.tvPct.setTextColor(Color.BLUE);
            holder.tvMtdPlan.setTextColor(Color.BLUE);
            holder.cvItem.setCardBackgroundColor(Color.RED);
        }

        PctLyAch = (Float.parseFloat(dataModel.getMtdNett())*100)/(Float.parseFloat(dataModel.getMtdNettLy())*1000000);

        holder.tvPctLy.setText(numberFormatCurrency.format(Float.parseFloat(PctLyAch.toString())));
        holder.tvPctLy.setTextColor(Color.MAGENTA);

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
        private TextView tvChief, tvMtdPlan, tvMtdNett,tvPct,tvMtdLy,tvPctLy;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvChief = itemView.findViewById(R.id.tv_chief);
            tvMtdPlan = itemView.findViewById(R.id.tv_mtd_plan);
            tvMtdNett = itemView.findViewById(R.id.tv_mtd_nett);
            tvMtdLy = itemView.findViewById(R.id.tv_mtd_ly);
            tvPct = itemView.findViewById(R.id.tv_pct);
            tvPctLy = itemView.findViewById(R.id.tv_pct_ly);
     }
    }
}
