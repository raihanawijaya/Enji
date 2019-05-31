package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyMTDNotCodeTransactionResponse {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("dataTransaction")
    @Expose
    private List<DailyMTDNotCodeTransaction> dataTransaction = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DailyMTDNotCodeTransaction> getDataTransactionNot() {
        return dataTransaction;
    }

    public void setDataTransaction(List<DailyMTDNotCodeTransaction> dataTransaction) {
        this.dataTransaction = dataTransaction;
    }
}
