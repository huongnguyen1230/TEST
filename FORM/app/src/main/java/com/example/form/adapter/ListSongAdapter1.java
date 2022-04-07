package com.example.form.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.form.R;
import com.example.form.activity.SongDetailActivity;
import com.example.form.entity.Song;
import com.example.form.entity.SongResponse;

import java.util.ArrayList;
import java.util.List;

public class ListSongAdapter1 extends RecyclerView.Adapter<ListSongAdapter1.ViewHolder>{
    Context currentContext;
    List<Song> songs;

    public ListSongAdapter1(Context currentContext, List<Song> songs) {
        this.songs = songs;
        this.currentContext = currentContext;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(currentContext).inflate(R.layout.recycle_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Song currentSong = songs.get(position);
        Glide.with(currentContext).load(currentSong.getThumbnail()).into(holder.imageView);
        holder.songTxtView.setText(currentSong.getName());
        holder.singerTxtView.setText((currentSong.getSinger()));
        holder.songWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(currentContext, SongDetailActivity.class);
                intent.putExtra("songs", (ArrayList<Song>) songs);
                int mLastPosition = holder.getAdapterPosition();
                intent.putExtra("position", mLastPosition);
                currentContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView songTxtView, singerTxtView;
        RelativeLayout songWrapper;

        public ViewHolder(View itemView){
            super(itemView);
            songWrapper = itemView.findViewById(R.id.songs_wrapper);
            imageView = itemView.findViewById(R.id.image_thumbnail);
            songTxtView = itemView.findViewById(R.id.song_name);
            singerTxtView = itemView.findViewById(R.id.song_singer);
        }
    }
}
