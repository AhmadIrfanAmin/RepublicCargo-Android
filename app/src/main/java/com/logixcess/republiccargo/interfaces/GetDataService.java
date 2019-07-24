package com.logixcess.republiccargo.interfaces;

import com.logixcess.republiccargo.models.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    //Add All API End Points Here
    //@GET("/photos")
    //Call<List<RetroPhoto>> getAllPhotos();
    @GET("/user")
    Call<User> getUser();

}
