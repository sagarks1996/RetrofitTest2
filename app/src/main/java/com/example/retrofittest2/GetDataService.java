package com.example.retrofittest2;

import com.example.retrofittest2.model.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("listUsers")
    Call<User> getAllUsers();
}
