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
import msd.mobile.enji.model.PROC_MTD_SALES_STORE_CODE;

public class StoreCodeAdapter extends RecyclerView.Adapter<StoreCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_SALES_STORE_CODE> listData;

    public StoreCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_SALES_STORE_CODE> listData) {
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
        final PROC_MTD_SALES_STORE_CODE dataModel = listData.get(position);

        holder.tvStoreNameChief.setText(dataModel.getStoreNameChief());
        holder.tvStoreNameChief.setTextColor((Color.BLUE));
        holder.tvMtdQty.setText(dataModel.getMtdQty()+ " Pcs");
        holder.tvMtdAvg.setText(dataModel.getAvgNett());
        holder.tvMtdNett.setText(dataModel.getMtdNett());

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
        private TextView tvStoreNameChief,tvMtdQty,tvMtdNett,tvMtdAvg;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvStoreNameChief = itemView.findViewById(R.id.tv_store_name_chief);
            tvMtdQty = itemView.findViewById(R.id.tv_mtd_qty);
            tvMtdNett = itemView.findViewById(R.id.tv_mtd_nett );
            tvMtdAvg = itemView.findViewById(R.id.tv_mtd_avg);
        }
    }
}
