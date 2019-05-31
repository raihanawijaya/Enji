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
import msd.mobile.enji.model.PROC_MTD_SALES_STORE_WORST_CODE;

public class StoreWorstCodeAdapter extends RecyclerView.Adapter<StoreWorstCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_SALES_STORE_WORST_CODE> listData;

    public StoreWorstCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_SALES_STORE_WORST_CODE> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_store,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_SALES_STORE_WORST_CODE dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float PctAch;
        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");

        holder.tvStoreNameChief.setText(dataModel.getStoreNameChief());
        holder.tvStoreNameChief.setTextColor(Color.RED);
        holder.tvMtdPlan.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdPlan())/1000000));


        holder.tvMtdNett.setTextColor(Color.BLUE);
        holder.tvMtdNett.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdNett())/1000000));

        holder.tvMtdQty.setText(numberFormatQty.format(Long.parseLong(dataModel.getMtdQty()))+ " Pcs");
        PctAch = Float.parseFloat(dataModel.getMtdNett())*100/(Float.parseFloat(dataModel.getMtdPlan()));
        holder.tvPctAch.setText(numberFormatCurrency.format(Float.parseFloat(PctAch.toString()))+ " %");

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
        private TextView tvStoreNameChief,tvMtdQty,tvMtdNett,tvMtdPlan,tvPctAch;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvStoreNameChief = itemView.findViewById(R.id.tv_store_name_chief);
            tvMtdQty = itemView.findViewById(R.id.tv_mtd_qty);
            tvMtdNett = itemView.findViewById(R.id.tv_mtd_nett );
            tvMtdPlan = itemView.findViewById(R.id.tv_mtd_plan);
         //   tvPctAch = itemView.findViewById(R.id.tv_pct_achieve);

     }
    }
}
