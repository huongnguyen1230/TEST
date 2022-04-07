package com.example.form.service;

import com.example.form.entity.SongResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SongService {
    @GET("api/v1/songs?page=2")
    Call<SongResponse> getSong();
}
