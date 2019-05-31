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
import msd.mobile.enji.model.PROC_MTD_STOCK_STORE_CODE;

public class StoreStockCodeAdapter extends RecyclerView.Adapter<StoreStockCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_STOCK_STORE_CODE> listData;

    public StoreStockCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_STOCK_STORE_CODE> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_store_stock,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_STOCK_STORE_CODE dataModel = listData.get(position);

        holder.tvInfo.setText(dataModel.getInfo());
        holder.tvInfo.setTextColor((Color.BLUE));
        holder.tvMtdBom.setText(dataModel.getMtdBom());
        holder.tvMtdRec.setText(dataModel.getMtdRec());
        holder.tvMtdRetIn.setText(dataModel.getMtdRetIn());

        holder.tvMtdRetOut.setText(dataModel.getMtdRetOut());
        holder.tvMtdSls.setText(dataModel.getMtdSls());
        holder.tvMtdEom.setText(dataModel.getMtdEom());
        holder.tvMtdEom.setTextColor((Color.BLUE));


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
        private TextView tvInfo,tvMtdBom,tvMtdRec,tvMtdRetIn,tvMtdRetOut,tvMtdSls,tvMtdEom;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvInfo = itemView.findViewById(R.id.tv_info);
            tvMtdBom = itemView.findViewById(R.id.tv_mtd_bom);
            tvMtdRec = itemView.findViewById(R.id.tv_mtd_rec);
            tvMtdRetIn = itemView.findViewById(R.id.tv_mtd_ret_in);
            tvMtdRetOut = itemView.findViewById(R.id.tv_mtd_ret_out);
            tvMtdSls = itemView.findViewById(R.id.tv_mtd_sls);
            tvMtdEom = itemView.findViewById(R.id.tv_mtd_eom);


            //    tvPctAch = itemView.findViewById(R.id.tv_pct_achieve);

     }
    }
}
