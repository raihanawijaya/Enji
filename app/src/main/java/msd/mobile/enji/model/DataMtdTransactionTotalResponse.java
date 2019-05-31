package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataMtdTransactionTotalResponse {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("dataMtdTransactionTotal")
    @Expose
    private DataMtdTransactionTotalModel dataMtdTransactionTotal;
    @SerializedName("countToday")
    @Expose
    private CountTodayModel countToday;

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

    public DataMtdTransactionTotalModel getDataMtdTransactionTotal() {return dataMtdTransactionTotal;
    }

    public void setDataMtdTransactionTotal(DataMtdTransactionTotalModel dataMtdTransactionTotal) {
        this.dataMtdTransactionTotal = dataMtdTransactionTotal;
    }

    public CountTodayModel getCountToday() {
        return countToday;
    }

    public void setCountToday(CountTodayModel countToday) {
        this.countToday = countToday;
    }
}
