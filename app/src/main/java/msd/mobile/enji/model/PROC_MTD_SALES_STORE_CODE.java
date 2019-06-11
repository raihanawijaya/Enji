package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_SALES_STORE_CODE {
    @SerializedName("STORE_NAME_CHIEF")    @Expose    private String StoreNameChief;
    @SerializedName("MTD_QTY")    @Expose    private String MtdQty;
    @SerializedName("MTD_NETT")    @Expose    private String MtdNett;
    @SerializedName("AVG_NETT")    @Expose    private String AvgNett;

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
    public String getAvgNett() {
        return AvgNett;
    }
    //---------------------------------------------------------------------------------------------

}
