package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyTransactionStore {
    @SerializedName("TRX_DATE")
    @Expose
    public String TRX_DATE;
    @SerializedName("QTY")
    @Expose
    public String QTY;
    @SerializedName("NETT")
    @Expose
    public String NETT;

    public DailyTransactionStore(String TRX_DATE, String QTY, String NETT) {
        this.TRX_DATE = TRX_DATE;
        this.QTY = QTY;
        this.NETT = NETT;
    }
}
