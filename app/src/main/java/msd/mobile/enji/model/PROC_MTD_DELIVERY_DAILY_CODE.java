package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_DELIVERY_DAILY_CODE {
    @SerializedName("TRX_DLV_DATE")
    @Expose
    private String TrxDlvDate;

    @SerializedName("MTD_QTY")
    @Expose
    private String MtdQty;

    @SerializedName("MTD_GROSS")
    @Expose
    private String mtdGross;

    @SerializedName("MTD_WEIGHT")
    @Expose
    private String mtdWeight;

    public String getTrxDlvDate() {return TrxDlvDate;}

    public String getMtdQty() {return MtdQty;}

    public String getMtdGross() {return mtdGross;}

    public String getMtdWeight() {return mtdWeight;}

}
