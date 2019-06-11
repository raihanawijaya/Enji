package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_DAILY_SALES_ARTICLE_CODE {
    @SerializedName("INFO")    @Expose    private String Info;
    @SerializedName("MTD_QTY")    @Expose    private String MtdQty;
    @SerializedName("MTD_NETT")    @Expose    private String MtdNett;
    @SerializedName("AVG_NETT")    @Expose    private String AvgNett;

    //-------------------------------------------------------------------------------------------
    public String getInfo() {
        return Info;
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
