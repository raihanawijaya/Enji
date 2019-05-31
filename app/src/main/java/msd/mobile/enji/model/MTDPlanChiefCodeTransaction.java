package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MTDPlanChiefCodeTransaction {
    @SerializedName("CHIEF")
    @Expose
    private String Chief;

    @SerializedName("MTD_PLAN")
    @Expose
    private String mtdPlan;

    @SerializedName("MTD_NETT")
    @Expose
    private String mtdNett;

    @SerializedName("MTD_NETT_LY")
    @Expose
    private String mtdNettLy;

    public String getChief() {
        return Chief;
    }

    public String getMtdPlan() {return mtdPlan;}

    public String getMtdNett() {return mtdNett;}

    public String getMtdNettLy() {return mtdNettLy;}


}
