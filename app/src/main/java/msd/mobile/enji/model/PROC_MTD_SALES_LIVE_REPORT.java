package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_MTD_SALES_LIVE_REPORT {
    @SerializedName("CODE")    @Expose    private String Code;
    @SerializedName("INFO")    @Expose    private String Info;
    @SerializedName("NILAI")    @Expose    private String Nilai;

    //-------------------------------------------------------------------------------------------
    public String getCode() {
        return Code;
    }
    //-------------------------------------------------------------------------------------------
    public String getInfo() {
        return Info;
    }
    //-------------------------------------------------------------------------------------------
    public String getNilai() {return Nilai;}
}
