package com.company.Arrays_and_Java_Built_in_Lists.LinkedLists.LinkedLists_Challenge;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song checkedSong: this.songs) { // for each statement
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong; //return the actual title
            }
        }
        return null; // song not found, add the song
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber-1;
        if (index >= 0 && index <= this.songs.size()) { //checking a song in that index
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track: " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have song: " + title);
        return false;
    }

}
