package com.example.form.service;

import com.example.form.dto.CredentialDto;
import com.example.form.dto.LoginDto;
import com.example.form.dto.LoginToken;
import com.example.form.entity.Account;
import com.example.form.entity.Song;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AccountService {

    String SERVER_URL = "https://music-i-like.herokuapp.com";

    @POST("/api/v1/accounts")
    Call<Account> register(@Body Account account);

    @POST("/api/v1/accounts/authentication")
    Call<LoginToken> login(@Body LoginDto login);

    @GET("api/v1/songs")
    Call<List<Song>> getSong();

}
