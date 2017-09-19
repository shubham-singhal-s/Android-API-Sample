package com.madexample.apitest;

/**
 * Created by mahe on 22-08-2017.
 */

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


class APIClient {

    private static Retrofit retrofit = null;

    public static APIInterface getAPIInterface(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl("http://139.59.19.98:8080/api/").addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(APIInterface.class);
    }

    public interface APIInterface{
        @GET("profile")
        Call<ProfileModel> getProfileList(@Query("username") String username);

        @POST("searchprofiles")
        @FormUrlEncoded
        Call<Post[]> searchProfile(@Field ("searchString") String searchString);

        @POST("authenticate")
        @FormUrlEncoded
        Call<Login> login(@Field ("username") String username,
                          @Field("password") String password);

        @POST("addProject")
        @FormUrlEncoded
        Call<Project> addProject(@Field ("username") String username,
                                 @Field("projectName") String projectName,
                                 @Field("tags") String tags[],
                                 @Field("languages") String languages[],
                                 @Field("description") String description,
                                 @Field("private") Boolean priv);

        //Call<Post> searchProfile(@Body Post post);
    }


}
