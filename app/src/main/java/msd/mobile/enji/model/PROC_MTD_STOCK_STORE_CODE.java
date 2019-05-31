package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_STOCK_STORE_CODE {
    @SerializedName("INFO")     @Expose private String Info;
    @SerializedName("MTD_BOM")  @Expose private String MtdBom;
    @SerializedName("MTD_REC")  @Expose private String MtdRec;
    @SerializedName("MTD_RET_IN")  @Expose private String MtdRetIn;
    @SerializedName("MTD_RET_OUT")  @Expose private String MtdRetOut;
    @SerializedName("MTD_SLS")  @Expose private String MtdSls;
    @SerializedName("MTD_EOM")  @Expose private String MtdEom;

    //-------------------------------------------------------------------------------------------
    public String getInfo() {
        return Info;
    }
    //-------------------------------------------------------------------------------------------
    public String getMtdBom() {
        return MtdBom;
    }
    //-------------------------------------------------------------------------------------------
    public String getMtdRec() {return MtdRec;}
    //---------------------------------------------------------------------------------------------
    public String getMtdRetIn() {
        return MtdRetIn;
    }
    //---------------------------------------------------------------------------------------------
    public String getMtdRetOut() {
        return MtdRetOut;
    }
    //---------------------------------------------------------------------------------------------
    public String getMtdSls() {
        return MtdSls;
    }
    //---------------------------------------------------------------------------------------------
    public String getMtdEom() {
        return MtdEom;
    }
}
