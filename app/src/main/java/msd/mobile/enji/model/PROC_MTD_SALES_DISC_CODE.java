package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_SALES_DISC_CODE {
    @SerializedName("DISC_CODE")
    @Expose
    private String DiscCode;

    @SerializedName("MTD_QTY")
    @Expose
    private String MtdQty;

    @SerializedName("MTD_NETT")
    @Expose
    private String mtdNett;


    @SerializedName("SUM_NETT")
    @Expose
    private String SumNett;

//-------------------------------------------------------------------------------------------
    public String getDiscCode() {
        return DiscCode;
    }

    public void setDiscCode(String DiscCode) { this.DiscCode = DiscCode;}
//-----------------------------------------------------------------------------------------------
    public String getMtdQty() {return MtdQty;}

    public void setMtdQty(String MtdQty) {this.MtdQty = MtdQty;}
//----------------------------------------------------------------------------------------------
    public String getMtdNett() {return mtdNett;}

    public void setMtdNett(String mtdNett) {this.mtdNett = mtdNett;}
//-----------------------------------------------------------------------------------------------
    public String getSumNett() {return SumNett;}

    public void setSumNett(String SumNett) {this.mtdNett = SumNett;}


}
