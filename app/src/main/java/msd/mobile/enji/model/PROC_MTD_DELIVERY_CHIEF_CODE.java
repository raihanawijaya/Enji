package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_DELIVERY_CHIEF_CODE {
    @SerializedName("CHIEF_CODE")
    @Expose
    private String ChiefCode;

    @SerializedName("MTD_QTY")
    @Expose
    private String MtdQty;

    @SerializedName("MTD_GROSS")
    @Expose
    private String MtdGross;

    @SerializedName("MTD_WEIGHT")
    @Expose
    private String MtdWeight;

    @SerializedName("COUNT_TRX_NO")
    @Expose
    private String CountTrxNo;

    public String getCtgrCode() {
        return ChiefCode;
    }

    public String getMtdQty() {return MtdQty;}

    public String getMtdNett() {
        return MtdGross;
    }

    public String getMtdWeight() {return MtdWeight;}

    public String getCountTrxNo() {return CountTrxNo;}
}
