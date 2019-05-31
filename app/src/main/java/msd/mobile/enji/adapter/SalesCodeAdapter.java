package msd.mobile.enji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import msd.mobile.enji.R;
import msd.mobile.enji.model.DailyMTDSalesCodeTransaction;

public class SalesCodeAdapter extends RecyclerView.Adapter<SalesCodeAdapter.ViewHolder>{
    private Context context;
    private List<DailyMTDSalesCodeTransaction> listData;

    public SalesCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<DailyMTDSalesCodeTransaction> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_disc,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DailyMTDSalesCodeTransaction dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");

        NumberFormat numberFormatCurrency = NumberFormat.getCurrencyInstance(localeID);
        numberFormatCurrency.setMaximumFractionDigits(0);
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormatCurrency).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) numberFormatCurrency).setDecimalFormatSymbols(decimalFormatSymbols);

        holder.tvMtdNett.setText(numberFormatCurrency.format(Integer.parseInt(dataModel.getMtdNett())));
        holder.tvTodayNett.setText(numberFormatCurrency.format(Integer.parseInt(dataModel.getTrxNett())));
        holder.tvMtdQty.setText(dataModel.getMtdQty());
        holder.tvTodayQty.setText(dataModel.getTrxQty());
        holder.tvSlsCode.setText(dataModel.getSalesCode());
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
        private TextView tvSlsCode, tvTodayQty, tvMtdQty, tvTodayNett, tvMtdNett;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvSlsCode = itemView.findViewById(R.id.tv_sls_code);
            tvTodayQty = itemView.findViewById(R.id.tv_today_qty);
            tvMtdQty = itemView.findViewById(R.id.tv_mtd_qty);
            tvTodayNett = itemView.findViewById(R.id.tv_today_nett);
            tvMtdNett = itemView.findViewById(R.id.tv_mtd_nett);

        }
    }
}
