package com.logixcess.republiccargo.interfaces;

import com.logixcess.republiccargo.models.Box;
import com.logixcess.republiccargo.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {
    //Add All API End Points Here
    //@GET("/photos")
    //Call<List<RetroPhoto>> getAllPhotos();
//    @GET("/user")
//    Call<User> getUser();
    @POST("/api/register")
    Call<User> createUser(@Body User user);

    @POST("/api/login")
    Call<User> loginUser(@Body User user);

    @POST("/api/booking")
    Call<User> booking(@Body ArrayList<Box> boxes);

}
