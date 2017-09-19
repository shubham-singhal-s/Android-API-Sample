package com.madexample.apitest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mahe on 22-08-2017.
 */

public class ProfileModel {

    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("dob")
    @Expose
    private String dob;

    @SerializedName("address")
    @Expose
    private Address addr;

    public String getSuccess() {
        return success;
    }

    public String getUsername() {
        return username;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public Address getAdd() {
        return addr;
    }
}
