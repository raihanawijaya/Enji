package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_STORE_NOT_SEND {
    @SerializedName("TRX_DATE")
    @Expose
    private String Trxdate;

    @SerializedName("STORE_CODE")
    @Expose
    private String StoreCode;

    @SerializedName("STORE_NAME")
    @Expose
    private String StoreName;

    @SerializedName("CHIEF")
    @Expose
    private String ChiefCode;

    @SerializedName("DEPT_STORE")
    @Expose
    private String DeptStore;

    //-------------------------------------------------------------------------------------------
    public String getTrxdate() {
        return Trxdate;
    }
    //-------------------------------------------------------------------------------------------
    public String getStoreCode() {
        return StoreCode;
    }
    //-------------------------------------------------------------------------------------------
    public String getStoreName() {return StoreName;}
    //---------------------------------------------------------------------------------------------
    public String getChiefCode() {
        return ChiefCode;
    }
    //---------------------------------------------------------------------------------------------
    public String getDeptStore() {
        return DeptStore;
    }
}
