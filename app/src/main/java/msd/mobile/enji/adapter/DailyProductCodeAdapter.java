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
import msd.mobile.enji.model.PROC_DAILY_SALES_PRODUCT_CODE;

public class DailyProductCodeAdapter extends RecyclerView.Adapter<DailyProductCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_DAILY_SALES_PRODUCT_CODE> listData;

    public DailyProductCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_DAILY_SALES_PRODUCT_CODE> listData) {
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
        final PROC_DAILY_SALES_PRODUCT_CODE dataModel = listData.get(position);

        holder.tvInfo.setText(dataModel.getInfo());
        holder.tvmtdNett.setText(dataModel.getMtdNett());
        holder.tvmtdQty.setText(dataModel.getMtdQty());
        holder.tvAvgNett.setText(dataModel.getAvgNett());

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
        private TextView tvInfo,tvmtdQty,tvmtdNett,tvAvgNett;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvInfo = itemView.findViewById(R.id.tv_store_name_chief);
            tvmtdQty = itemView.findViewById(R.id.tv_mtd_qty);
            tvmtdNett = itemView.findViewById(R.id.tv_mtd_nett );
            tvAvgNett = itemView.findViewById(R.id.tv_mtd_avg);

     }
    }
}
