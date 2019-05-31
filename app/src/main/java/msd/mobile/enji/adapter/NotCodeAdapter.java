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

import java.util.ArrayList;
import java.util.List;

import msd.mobile.enji.R;
import msd.mobile.enji.model.PROC_MTD_STORE_NOT_SEND;

public class NotCodeAdapter extends RecyclerView.Adapter<NotCodeAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_STORE_NOT_SEND> listData;

    public NotCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<PROC_MTD_STORE_NOT_SEND> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_store_not_send,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PROC_MTD_STORE_NOT_SEND dataModel = listData.get(position);


        holder.tvStoreName.setText(dataModel.getStoreName());
        holder.tvStoreName.setTextColor(Color.RED);

        holder.tvStoreCode.setText(dataModel.getStoreCode());
        holder.tvTrxDate.setText(dataModel.getTrxdate());
        //holder.tvChiefCode.setText(dataModel.getChiefCode());
        holder.tvDeptStore.setText(dataModel.getDeptStore());

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
        private TextView tvStoreName,tvTrxDate,tvStoreCode,tvChiefCode,tvDeptStore;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvTrxDate = itemView.findViewById(R.id.tv_trx_date);
            tvStoreCode = itemView.findViewById(R.id.tv_store_code);
            tvStoreName = itemView.findViewById(R.id.tv_store_name );
            tvChiefCode = itemView.findViewById(R.id.tv_chief_code);
            tvDeptStore = itemView.findViewById(R.id.tv_dept_store);

     }
    }
}
