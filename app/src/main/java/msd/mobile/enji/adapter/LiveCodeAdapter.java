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

import msd.mobile.enji.R;
import msd.mobile.enji.model.PROC_MTD_SALES_LIVE_REPORT;

public class LiveCodeAdapter extends RecyclerView.Adapter<LiveCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_SALES_LIVE_REPORT> listData;

    public LiveCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_SALES_LIVE_REPORT> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_live,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_SALES_LIVE_REPORT dataModel = listData.get(position);
        Float AvgPrice;
        String Code;

        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");


        holder.tvInfo.setText(dataModel.getInfo());
        holder.tvNilai.setText(dataModel.getNilai());
        //holder.tvNilai.setText(numberFormatQty.format(Float.parseFloat(dataModel.getNilai())));
     //   holder.tvNilai.setTextColor(Color.BLUE);
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
        private TextView tvInfo,tvNilai;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvInfo = itemView.findViewById(R.id.tv_info);
            tvNilai = itemView.findViewById(R.id.tv_nilai);

     }
    }
}
