package com.example.form.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.form.R;
import com.example.form.entity.Song;

import java.util.List;

public class ListSongAdapter extends BaseAdapter {
    private Activity activity;
    private List<Song> listSong;


    public ListSongAdapter(Activity activity, List<Song> listSong) {
        this.activity = activity;
        this.listSong = listSong;
    }

    @Override
    public int getCount() {
        return listSong.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater= activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_song, parent, false);
            ViewHolder holder =new ViewHolder();
            holder.nameSong = convertView.findViewById(R.id.nameSong);
            holder.nameSinger =  convertView.findViewById(R.id.nameSinger);
            holder.imgSong =  convertView.findViewById(R.id.imgSong);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Song song = listSong.get(position);
        holder.nameSong.setText(song.getName());
        holder.nameSinger.setText(song.getSinger());
        try{
            Glide.with(activity).load(song.getThumbnail()).into(holder.imgSong);
        }catch (Exception e){
            holder.imgSong.setImageResource(R.drawable.avatar);
        }

        return convertView;
    }
    static class ViewHolder{
        TextView nameSong;
        TextView nameSinger;
        ImageView imgSong;
    }
}
