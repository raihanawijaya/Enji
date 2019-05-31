package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_SALES_MODEL_CODE {
    @SerializedName("MODEL_CODE")        @Expose private String ModelCode;
    @SerializedName("MTD_QTY")           @Expose private String MtdQty;
    @SerializedName("MTD_NETT")          @Expose private String mtdNett;
    @SerializedName("MTD_NETT_TOTAL")    @Expose private String mtdNettTotal;

    public String getModelCode() {
        return ModelCode;
    }
    public String getMtdQty() {return MtdQty;}
    public String getMtdNett() {
        return mtdNett;
    }
    public String getMtdNettTotal() {
        return mtdNettTotal;
    }

}
