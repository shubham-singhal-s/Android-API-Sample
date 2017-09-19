package com.madexample.apitest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {


    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("value")
    @Expose
    private String value;

    @SerializedName("token")
    @Expose
    private String token;

    public String getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public String getValue() {
        return value;
    }

    public String getToken() {
        return token;
    }


}