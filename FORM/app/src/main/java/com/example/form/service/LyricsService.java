package com.example.form.service;

import java.io.IOException;
import java.util.List;

public interface LyricsService {
    List<String> searchSongByName(String name) throws IOException;
    String getSongLyricByLink(String link) throws IOException;
}
