package com.madexample.apitest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mahe on 22-08-2017.
 */

public class Address {

    @SerializedName("street")
    @Expose
    private String street;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("pinCode")
    @Expose
    private String pincode;


    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPincode() {
        return pincode;
    }

}
