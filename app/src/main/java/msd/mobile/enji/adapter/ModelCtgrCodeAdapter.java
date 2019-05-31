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
import msd.mobile.enji.model.PROC_MTD_SALES_MODEL_CTGR_CODE;

public class ModelCtgrCodeAdapter extends RecyclerView.Adapter<ModelCtgrCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_SALES_MODEL_CTGR_CODE> listData;

    public ModelCtgrCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_SALES_MODEL_CTGR_CODE> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_model_ctgr,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_SALES_MODEL_CTGR_CODE dataModel = listData.get(position);
        //Locale localeID = new Locale("in","ID");
        Float AvgPrice ;
        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");;

        String CtgrName = dataModel.getModelCode().toString();
        String Ctgr = CtgrName.toString().substring(0,2);

        if (Ctgr.equalsIgnoreCase("CA")){
            holder.tvModelCode.setTextColor(Color.RED);
            holder.tvMtdQty.setTextColor(Color.RED);
            holder.tvMtdNett.setTextColor(Color.RED);
            holder.tvAvgPrice.setTextColor(Color.RED);
        } else if(Ctgr.equalsIgnoreCase("DN")){
            holder.tvModelCode.setTextColor(Color.BLACK);
            holder.tvMtdQty.setTextColor(Color.BLACK);
            holder.tvMtdNett.setTextColor(Color.BLACK);
            holder.tvAvgPrice.setTextColor(Color.BLACK);
        } else if(Ctgr.equalsIgnoreCase("SF")){
            holder.tvModelCode.setTextColor(Color.MAGENTA);
            holder.tvMtdQty.setTextColor(Color.MAGENTA);
            holder.tvMtdNett.setTextColor(Color.MAGENTA);
            holder.tvAvgPrice.setTextColor(Color.MAGENTA);
        } else if(Ctgr.equalsIgnoreCase("JA")){
            holder.tvModelCode.setTextColor(Color.RED);
            holder.tvMtdQty.setTextColor(Color.RED);
            holder.tvMtdNett.setTextColor(Color.RED);
            holder.tvAvgPrice.setTextColor(Color.RED);
        } else if(Ctgr.equalsIgnoreCase("JD")){
            holder.tvModelCode.setTextColor(Color.BLACK);
            holder.tvMtdQty.setTextColor(Color.BLACK);
            holder.tvMtdNett.setTextColor(Color.BLACK);
            holder.tvAvgPrice.setTextColor(Color.BLACK);
        } else {
            holder.tvModelCode.setTextColor(Color.BLUE);
            holder.tvMtdQty.setTextColor(Color.BLUE);
            holder.tvMtdNett.setTextColor(Color.BLUE);
            holder.tvAvgPrice.setTextColor(Color.BLUE);
        }

       //  System.out.println(Ctgr);
        holder.tvModelCode.setText(dataModel.getModelCode());
       // holder.tvModelCode.setTextColor(Color.BLUE);
      //  holder.tvModelCode.setTypeface(Typeface.DEFAULT_BOLD);

        holder.tvMtdNett.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdNett())/1000000));
        holder.tvMtdQty.setText(numberFormatQty.format(Long.parseLong(dataModel.getMtdQty())));

        AvgPrice= Float.parseFloat(dataModel.getMtdNett())/ Long.parseLong(dataModel.getMtdQty());
        holder.tvAvgPrice.setText(numberFormatQty.format(Float.parseFloat(AvgPrice.toString())));

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
        private TextView tvModelCode, tvMtdQty, tvMtdNett,tvAvgPrice ;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvModelCode = itemView.findViewById(R.id.tv_model_code);
            tvMtdQty = itemView.findViewById(R.id.tv_mtd_qty);
            tvMtdNett = itemView.findViewById(R.id.tv_mtd_nett);
            tvAvgPrice = itemView.findViewById(R.id.tv_avg_price);
      }
    }
}
