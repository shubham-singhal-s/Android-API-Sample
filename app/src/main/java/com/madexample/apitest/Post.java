package com.madexample.apitest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("username")
    @Expose
    private String username;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }


}