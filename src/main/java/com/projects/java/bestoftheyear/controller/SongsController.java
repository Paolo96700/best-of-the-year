package com.projects.java.bestoftheyear.controller;

import com.projects.java.bestoftheyear.model.Movie;
import com.projects.java.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongsController {

    @GetMapping
    public String songs(Model model){
        List<Song> songList = getBestSongs();
        model.addAttribute("songList", songList);
        return "songs";
    }

    @GetMapping("/{id}")
    public String SongDetails(@PathVariable("id") int movieId, Model model) {
        Song song = getSongById(movieId);
        model.addAttribute("song", song);
        return "song-details";
    }

    // METODI PRIVATE
    private List<Song> getBestSongs(){
        Song[] songsArray = {
                new Song(1, "Without You"),
                new Song(2, "The End"),
                new Song(3, "The Resistance")};
        return Arrays.asList(songsArray);
    }

    private Song getSongById(int id) {
        for (Song song : getBestSongs()) {
            if (song.getId() == id) {
                return song;
            }
        }
        return null;
    }
}
