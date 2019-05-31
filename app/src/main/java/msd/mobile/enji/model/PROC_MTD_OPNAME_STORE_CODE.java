package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_OPNAME_STORE_CODE {
    @SerializedName("STORE_NAME_CHIEF")
    @Expose
    private String StoreNameChief;
    @SerializedName("TRX_DATE")
    @Expose
    private String TrxDate;
    @SerializedName("OPN_QTY")
    @Expose
    private String OpnQty;

    //-------------------------------------------------------------------------------------------
    public String getStoreNameChief() {
        return StoreNameChief;
    }
    //-------------------------------------------------------------------------------------------
    public String getTrxDate() {
        return TrxDate;
    }
    //-------------------------------------------------------------------------------------------
    public String getOpnQty() {return OpnQty;}
    //---------------------------------------------------------------------------------------------

}
