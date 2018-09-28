package com.zolbayar.cracking_the_oyster.object_oriented_design;

/*
    Purpose: Design a musical jukebox using object oriented principles

    1. 6 Ws: I assume it's just a standard jukebox
    2. Main Classes: Song, Playlist, MusicPlayer, Coin, Person
    3. Class relationships: Playlist is consisted of songs and the MusicPlayer should have a playlist.
        Coin is the trigger for starting a playlist.
    4. Actions: Playlist should play songs, MusicPlayer should receive coin and start the playlist, Person
        should put the coin into the MusicPlayer
 */

import java.util.ArrayList;
import java.util.List;

public class Jukebox {

    class MusicPlayer {
        Coin insertedCoin;
        String enteredId;

        public void startPlaying(){

        }
    }

    class Person {
        public void putCoin(MusicPlayer player, Coin coin){

        }

        public void enterId(){

        }
    }

    enum Coin {
        QUARTER, HALF, DOLLAR
    }

    class Playlist {
        List<Song> songList;

        public Playlist(List<Song> songList) {
            this.songList = songList;
        }

        public void startPlaying(){
            for(Song song : songList){
                playSong(song);
            }
        }

        private void playSong(Song song){

        }

        public void addSong(Song song){
            if(songList == null){
                songList = new ArrayList<>();
            }
            songList.add(song);
        }


    }

    class Song {
        String name;
        String id;

        public Song(String name, String id) {
            this.name = name;
            this.id = id;
        }
    }
}
