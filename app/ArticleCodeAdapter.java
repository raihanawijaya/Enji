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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import msd.mobile.enji.R;
import msd.mobile.enji.model.PROC_MTD_SALES_MODEL_CODE;

public class ModelCodeAdapter extends RecyclerView.Adapter<ModelCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_SALES_MODEL_CODE> listData;

    public ModelCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_SALES_MODEL_CODE> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_model,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_SALES_MODEL_CODE dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float Pct;

        NumberFormat numberFormatCurrency = new DecimalFormat("#,###");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");;

        holder.tvModelCode.setText(dataModel.getModelCode());
     //   holder.tvModelCode.setTextColor(Color.BLUE);
     //   holder.tvModelCode.setTypeface(Typeface.DEFAULT_BOLD);

        holder.tvMtdNett.setText(numberFormatCurrency.format(Float.parseFloat(dataModel.getMtdNett())));
     //   holder.tvMtdNett.setTextColor(Color.BLUE);
     //   holder.tvMtdNett.setTypeface(Typeface.DEFAULT_BOLD);

        holder.tvMtdQty.setText(numberFormatQty.format(Long.parseLong(dataModel.getMtdQty())));

      //  Pct = ((Float.parseFloat(dataModel.getMtdNett())))*100/ Float.parseFloat(dataModel.getMtdNettTotal());
      //  holder.tvPctCont.setText(numberFormatCurrency.format(Float.parseFloat(Pct.toString())));

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
        private TextView tvModelCode, tvMtdQty, tvMtdNett,tvPctCont;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvModelCode = itemView.findViewById(R.id.tv_model_code);
            tvMtdQty = itemView.findViewById(R.id.tv_mtd_qty);
            tvMtdNett = itemView.findViewById(R.id.tv_mtd_nett);
       //     tvPctCont = itemView.findViewById(R.id.tv_pct_cont);
      }
    }
}
