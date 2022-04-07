package com.example.form.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

import com.example.form.R;
import com.example.form.adapter.ListSongAdapter1;
import com.example.form.entity.Song;
import com.example.form.entity.SongResponse;
import com.example.form.service.SongService;
import com.example.form.util.RetrofitGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class ListSongActivity1 extends AppCompatActivity {
    private SongService songService;
    private RecyclerView recyclerViewListSong;
    private List<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int SDK_INT = Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);
        initView();
        initData();
    }
    private void initView(){
        songs = new ArrayList<>();
        recyclerViewListSong = findViewById(R.id.recycle_view_list_song);
        recyclerViewListSong.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewListSong.setAdapter(new ListSongAdapter1(this, songs));
    }
    private void initData() {
        if (songService == null){
            songService = RetrofitGenerator.createService(SongService.class);
        }
        try {
            Response<SongResponse> listResponse = songService.getSong().execute();
            if (listResponse.isSuccessful()){
                songs.clear();
                songs.addAll(listResponse.body().getData());

                ((RecyclerView.Adapter) recyclerViewListSong.getAdapter()).notifyDataSetChanged();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}