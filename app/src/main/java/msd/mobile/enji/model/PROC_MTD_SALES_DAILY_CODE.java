package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_SALES_DAILY_CODE {
    @SerializedName("DAILY_CODE")    @Expose    private String DailyCode;
    @SerializedName("DAILY_STORE_COUNT")    @Expose    private String DailyStoreCount;
    @SerializedName("DAILY_QTY")    @Expose    private String DailyQty;
    @SerializedName("DAILY_NETT")    @Expose    private String DailyNett;
    @SerializedName("AVG_NETT")    @Expose    private String AvgNett;
    //-------------------------------------------------------------------------------------------
    public String getDailyCode() {
        return DailyCode;
    }
    //-------------------------------------------------------------------------------------------
    public String getDailyStoreCount() {
        return DailyStoreCount;
    }
    //-------------------------------------------------------------------------------------------
    public String getDailyQty() {return DailyQty;}
    //---------------------------------------------------------------------------------------------
    public String getDailyNett() {
        return DailyNett;
    }

    public String getAvgNett() {
        return AvgNett;
    }

}
