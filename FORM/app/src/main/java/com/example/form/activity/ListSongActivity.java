package com.example.form.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.form.R;
import com.example.form.adapter.ListSongAdapter;
import com.example.form.entity.Song;
import com.example.form.service.AccountService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListSongActivity extends AppCompatActivity {

    private List<Song> listSong;
    ListView lvListSong;
    ListSongAdapter adapter;
    private TextView nameSong, nameSinger;
    private ImageView imgSong;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listsong);
        initView();
        getData();
    }
    private void initView(){
        listSong = new ArrayList<>();
        Song s = new Song();
        s.setId(1);
        s.setName("Helo");
        s.setSinger("Hung");
        listSong.add(s);
        nameSong = findViewById(R.id.nameSong);
        nameSinger = findViewById(R.id.nameSinger);
        imgSong = findViewById(R.id.imgSong);
        lvListSong = findViewById(R.id.lvListSong);
        adapter = new ListSongAdapter(this, listSong);
        lvListSong.setAdapter(adapter);
    }
    private void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AccountService.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AccountService accountService = retrofit.create(AccountService.class);
        accountService.getSong().enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                Log.d("WTH", response.message());
                Log.d("WTH", String.valueOf(response.isSuccessful()));
                Log.d("WTH", String.valueOf(response.code()));
                listSong.clear();
                listSong.addAll(response.body());

                ((BaseAdapter) lvListSong.getAdapter()).notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }
}
