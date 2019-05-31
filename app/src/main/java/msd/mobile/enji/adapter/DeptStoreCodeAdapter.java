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
import msd.mobile.enji.model.PROC_MTD_SALES_DEPT_STORE_CODE;

public class DeptStoreCodeAdapter extends RecyclerView.Adapter<DeptStoreCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_SALES_DEPT_STORE_CODE> listData;

    public DeptStoreCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_SALES_DEPT_STORE_CODE> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_dept_store,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_SALES_DEPT_STORE_CODE dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float PctPlAch,PctLyAch;
        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");

        holder.tvDeptStoreCode.setText(dataModel.getDeptStoreCode());
        holder.tvMtdPlan.setTextColor(Color.BLUE);
        holder.tvMtdPlan.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdPlan())/1000000));
        holder.tvMtdNett.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdNett())/1000000));
        holder.tvMtdNettLy.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdNettLy())));
        holder.tvMtdNettLy.setTextColor(Color.MAGENTA);


        //holder.tvMtdQty.setText(numberFormatQty.format(Long.parseLong(dataModel.getMtdQty())));
        PctPlAch = Float.parseFloat(dataModel.getMtdNett())*100/ Float.parseFloat(dataModel.getMtdPlan());
        PctLyAch = (Float.parseFloat(dataModel.getMtdNett())*100)/ Float.parseFloat(dataModel.getMtdNettLy())/1000000;

        holder.tvPctPl.setTextColor(Color.BLUE);
        holder.tvPctly.setTextColor(Color.MAGENTA);

        holder.tvPctPl.setText(numberFormatCurrency.format(Float.parseFloat(PctPlAch.toString())));
        holder.tvPctly.setText(numberFormatCurrency.format(Float.parseFloat(PctLyAch.toString())));

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
        private TextView tvDeptStoreCode, tvMtdQty, tvMtdNett,tvMtdPlan,tvMtdNettLy,tvPctPl,tvPctly;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvDeptStoreCode = itemView.findViewById(R.id.tv_dept_store_code);
            tvMtdQty = itemView.findViewById(R.id.tv_mtd_qty);
            tvMtdNett = itemView.findViewById(R.id.tv_mtd_nett);
            tvMtdPlan = itemView.findViewById(R.id.tv_mtd_plan);
            tvMtdNettLy = itemView.findViewById(R.id.tv_mtd_nett_ly);
            tvPctPl = itemView.findViewById(R.id.tv_pct_pl);
            tvPctly = itemView.findViewById(R.id.tv_pct_ly);
     }
    }
}
