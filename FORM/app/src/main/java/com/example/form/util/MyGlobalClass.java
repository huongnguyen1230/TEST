package com.example.form.util;

import android.media.MediaPlayer;

public class MyGlobalClass {
    private static MediaPlayer mediaPlayer;
    
    public static MediaPlayer getMediaPlayer(){
        if (mediaPlayer == null){
            mediaPlayer = new MediaPlayer();
        }
        return mediaPlayer;
    }
}
