package com.madexample.apitest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {


    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("msg")
    @Expose
    private String msg;

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return msg;
    }


}