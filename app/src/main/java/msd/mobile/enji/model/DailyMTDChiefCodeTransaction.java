package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyMTDChiefCodeTransaction {
    @SerializedName("STORE_CODE")
    @Expose
    private String storeCode;
    @SerializedName("SALES_CODE")
    @Expose
    private String salesCode;
    @SerializedName("TRX_DATE")
    @Expose
    private String trxDate;
    @SerializedName("TRX_QTY")
    @Expose
    private String trxQty;
    @SerializedName("NETT")
    @Expose
    private String trxNett;
    @SerializedName("MTD_QTY")
    @Expose
    private String mtdQty;
    @SerializedName("MTD_NETT")
    @Expose
    private String mtdNett;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getSalesCode() {
        return salesCode;
    }

    public void setSalesCode(String salesCode) {
        this.salesCode = salesCode;
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public String getTrxQty() {
        return trxQty;
    }

    public void setTrxQty(String trxQty) {
        this.trxQty = trxQty;
    }

    public String getTrxNett() {
        return trxNett;
    }

    public void setTrxNett(String trxNett) {
        this.trxNett = trxNett;
    }

    public String getMtdQty() {
        return mtdQty;
    }

    public void setMtdQty(String mtdQty) {
        this.mtdQty = mtdQty;
    }

    public String getMtdNett() {
        return mtdNett;
    }

    public void setMtdNett(String mtdNett) {
        this.mtdNett = mtdNett;
    }
}
