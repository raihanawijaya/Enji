package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PROC_MTD_OPNAME_STORE_CODE_RESPONSE {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("dataTransaction")
    @Expose
    private List<PROC_MTD_OPNAME_STORE_CODE> dataTransaction = null;

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

    public List<PROC_MTD_OPNAME_STORE_CODE> GET_MTD_OPNAME_STORE_CODE() {
        return dataTransaction;
    }

    public void setDataTransaction(List<PROC_MTD_OPNAME_STORE_CODE> dataTransaction) {
        this.dataTransaction = dataTransaction;
    }
}
