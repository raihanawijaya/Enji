package msd.mobile.enji.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseModel<T> {
    @SerializedName("error")
    @Expose
    public String error;
    @SerializedName("msg")
    @Expose
    public String msg;
    @SerializedName("dataTransaction")
    @Expose
    public List<T> dataTransaction;

}
