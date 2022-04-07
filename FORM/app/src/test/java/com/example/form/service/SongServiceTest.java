package com.example.form.service;

import com.example.form.entity.Song;
import com.example.form.entity.SongResponse;
import com.example.form.util.RetrofitGenerator;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

public class SongServiceTest extends TestCase {
    private SongService songService;

    public void setUp() throws Exception {
        songService = RetrofitGenerator.createService(SongService.class);
    }

    public void testGetSong() throws IOException {
        Response<SongResponse>listResponse = songService.getSong().execute();
        if (listResponse.isSuccessful()){
            SongResponse listSong = listResponse.body();
            for (Song song: listSong.getData()){
                System.out.println(song.toString());
            }
        }
    }
}