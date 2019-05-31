package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_SALES_CTGR_CODE {
    @SerializedName("CTGR_CODE")
    @Expose
    private String CtgrCode;

    @SerializedName("MTD_QTY")
    @Expose
    private String MtdQty;

    @SerializedName("MTD_NETT")
    @Expose
    private String mtdNett;

    @SerializedName("MTD_NETT_TOTAL")
    @Expose
    private String mtdNettTotal;

    public String getCtgrCode() {
        return CtgrCode;
    }
    public String getMtdQty() {return MtdQty;}
    public String getMtdNett() {
        return mtdNett;
    }
    public String getMtdNettTotal() {
        return mtdNettTotal;
    }

}
