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
import msd.mobile.enji.model.PROC_MTD_DELIVERY_CHIEF_CODE;

public class DeliveryChiefCodeAdapter extends RecyclerView.Adapter<DeliveryChiefCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_DELIVERY_CHIEF_CODE> listData;

    public DeliveryChiefCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_DELIVERY_CHIEF_CODE> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_delivery_chief,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_DELIVERY_CHIEF_CODE dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Long Pct;
        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");;

        holder.tvCtgrCode.setText(dataModel.getCtgrCode());
        holder.tvCountTrxNo.setText(numberFormatQty.format(Long.parseLong(dataModel.getCountTrxNo())));
        holder.tvMtdQty.setTextColor(Color.BLUE);
        holder.tvMtdQty.setText(numberFormatQty.format(Long.parseLong(dataModel.getMtdQty())));
        holder.tvMtdNett.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdNett())/1000000));
        holder.tvMtdWeight.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdWeight())));

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
        private TextView tvCtgrCode, tvMtdQty, tvMtdNett,tvMtdWeight,tvCountTrxNo;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvCtgrCode = itemView.findViewById(R.id.tv_ctgr_code);
            tvCountTrxNo = itemView.findViewById(R.id.tv_count_trx_no);
            tvMtdQty = itemView.findViewById(R.id.tv_mtd_qty);
            tvMtdNett = itemView.findViewById(R.id.tv_mtd_nett);
            tvMtdWeight = itemView.findViewById(R.id.tv_mtd_weight);
      }
    }
}
