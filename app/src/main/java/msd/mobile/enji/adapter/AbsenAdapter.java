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
import msd.mobile.enji.model.PROC_MTD_ABSENSI_STORE_CODE;

//import com.resysxp.AddAbsensiActivity;

public class AbsenAdapter extends RecyclerView.Adapter<AbsenAdapter.ViewHolder>{
    private Context context;
    private List<PROC_MTD_ABSENSI_STORE_CODE> listData;

    public AbsenAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();}

    public void setData(List<PROC_MTD_ABSENSI_STORE_CODE> listData) {
        this.listData = listData;
        notifyDataSetChanged();}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_absen,parent,false);
        return new ViewHolder(v);}

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final PROC_MTD_ABSENSI_STORE_CODE dataModel = listData.get(position);
        NumberFormat numberFormatQty = new DecimalFormat("#,###");;

        holder.tvStoreNameChief.setText(dataModel.get_store_name());
        holder.tvNikCode.setText(dataModel.get_nik_code());
        holder.tvNikName.setText(dataModel.get_nik_name());
        holder.tvHariKerja.setText(numberFormatQty.format(Integer.parseInt(dataModel.get_hari_kerja())));
        holder.tvHariBesar.setText(numberFormatQty.format(Integer.parseInt(dataModel.get_hari_besar())));
        holder.tvHariLembur.setText(numberFormatQty.format(Integer.parseInt(dataModel.get_hari_lembur())));

        //------ ini kal di click...pas di list absen..
        /*
        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i = new Intent(context, AddAbsensiActivity.class);
                    i.putExtra("status", "edit");
                    i.putExtra("trxcode", dataModel.get_trx_code());
                    i.putExtra("ycode", dataModel.get_y_code());
                    i.putExtra("mcode", dataModel.get_m_Code());
                    i.putExtra("nikcode", dataModel.get_nik_code());
                    i.putExtra("harikerja", dataModel.get_hari_kerja());
                    i.putExtra("haribesar", dataModel.get_hari_besar());
                    i.putExtra("harilembur", dataModel.get_hari_lembur());
                context.startActivity(i);
            }
        });*/

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

    //----------------------------------Deklarasi RecyclerView.ViewHolder----------------------
    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvItem;
        private TextView tvStoreNameChief,tvNikCode,tvNikName, tvHariKerja,tvHariBesar,tvHariLembur;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvStoreNameChief = itemView.findViewById(R.id.tv_store_name_chief);
            tvNikCode = itemView.findViewById(R.id.tv_nik_code);
            tvNikName = itemView.findViewById(R.id.tv_nik_name);
            tvHariKerja = itemView.findViewById(R.id.tv_hari_kerja);
            tvHariBesar = itemView.findViewById(R.id.tv_hari_besar);
            tvHariLembur = itemView.findViewById(R.id.tv_hari_lembur);
        }
    }
}
