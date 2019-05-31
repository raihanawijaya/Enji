package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_SALES_STORE_WORST_CODE {
    @SerializedName("STORE_NAME_CHIEF")
    @Expose
    private String StoreNameChief;

    @SerializedName("MTD_QTY")
    @Expose
    private String MtdQty;

    @SerializedName("MTD_NETT")
    @Expose
    private String MtdNett;

    @SerializedName("MTD_PLAN")
    @Expose
    private String MtdPlan;

    @SerializedName("PCT_ACH")
    @Expose
    private String PctAch;

    //-------------------------------------------------------------------------------------------
    public String getStoreNameChief() {
        return StoreNameChief;
    }
    //-------------------------------------------------------------------------------------------
    public String getMtdQty() {
        return MtdQty;
    }
    //-------------------------------------------------------------------------------------------
    public String getMtdNett() {return MtdNett;}
    //---------------------------------------------------------------------------------------------
    public String getMtdPlan() {
        return MtdPlan;
    }
    //---------------------------------------------------------------------------------------------
    public String getPctAch() {
        return PctAch;
    }
}
