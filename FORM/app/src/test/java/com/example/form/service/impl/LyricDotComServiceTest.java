package com.example.form.service.impl;

import com.example.form.service.LyricsService;

import junit.framework.TestCase;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class LyricDotComServiceTest extends TestCase {

    @Test
    public void testSearchSongByName() throws IOException {
        LyricsService lyricsService = new LyricDotComService();
        List<String> listLink = lyricsService.searchSongByName("Permission to Dance");
        for (String link: listLink){
            System.out.println(link);
        }
    }

    @Test
    public void testGetSongLyricByLink() throws IOException {
            String link = "https://www.lyrics.com/lyric/39174316/%EB%B0%A9%ED%83%84%EC%86%8C%EB%85%84%EB%8B%A8/Permission+to+Dance";
            LyricsService lyricsService = new LyricDotComService();
            String htmlLyric = lyricsService.getSongLyricByLink(link);
            System.out.println(htmlLyric);
        }
    }