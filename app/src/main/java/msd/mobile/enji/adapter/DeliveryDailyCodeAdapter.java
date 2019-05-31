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
import msd.mobile.enji.model.PROC_MTD_DELIVERY_DAILY_CODE;

public class DeliveryDailyCodeAdapter extends RecyclerView.Adapter<DeliveryDailyCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_DELIVERY_DAILY_CODE> listData;

    public DeliveryDailyCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_DELIVERY_DAILY_CODE> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_delivery_daily,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_DELIVERY_DAILY_CODE dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");

        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");;

        holder.tvTrxDlvCode.setText(dataModel.getTrxDlvDate());

        holder.tvMtdQty.setTextColor(Color.MAGENTA);
        holder.tvMtdQty.setText(numberFormatQty.format(Long.parseLong(dataModel.getMtdQty())));
        holder.tvMtdGross.setText(numberFormatQty.format(Float.parseFloat(dataModel.getMtdGross())/1000000));
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
        private TextView tvTrxDlvCode, tvMtdQty, tvMtdGross,tvMtdWeight,tvCountTrxNo;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvTrxDlvCode = itemView.findViewById(R.id.tv_trx_dlv_code);

            tvMtdQty = itemView.findViewById(R.id.tv_mtd_qty);
            tvMtdGross = itemView.findViewById(R.id.tv_mtd_gross);
            tvMtdWeight = itemView.findViewById(R.id.tv_mtd_weight);
      }
    }
}
