package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_SALES_DEPT_STORE_CODE {
    @SerializedName("DEPT_STORE_CODE")
    @Expose
    private String DeptStoreCode;

    @SerializedName("MTD_QTY")
    @Expose
    private String MtdQty;

    @SerializedName("MTD_NETT")
    @Expose
    private String mtdNett;

    @SerializedName("MTD_PLAN")
    @Expose
    private String mtdPlan;

    @SerializedName("MTD_NETT_LY")
    @Expose
    private String mtdNettLy;

    public String getDeptStoreCode() {return DeptStoreCode;}
    public String getMtdQty() {return MtdQty;}
    public String getMtdNett() {
        return mtdNett;
    }
    public String getMtdPlan() {
        return mtdPlan;
    }
    public String getMtdNettLy() {
        return mtdNettLy;
    }


}
