package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@DisplayName("PlaylistTest")
public class PlaylistTest {
    @Test
    @DisplayName("addsong test")
     
    void testingplaylist(){
        String name = "king";
        String id = "1";
        List<Song> gaane = new ArrayList<>();
        Playlist mera = new Playlist("djabd",name, gaane);
        // assert
        String songname = "aja";
        String songid = "1";
        Song song = new Song(songname,songid);
        //act 
        mera.addsong(song);
        //assert
        Assertions.assertEquals(song, mera.getSong("1"));
        
    }
    @Test
    @DisplayName("playsong test")
     
    void playsong(){
        //ARRANGE
        String playlistname = "mera";
        String playid = "1";
        List<Song> songs = new ArrayList<>();
        Song song1 = new Song("Tu Aake Dekhle","1");
        Song song2 = new Song("Accha","2");
        songs.add(song1);
        songs.add(song2);
       
        Playlist myplaylist = new Playlist("sbfj",playlistname, songs);
    
      

         Assertions.assertEquals( song1 ,  myplaylist.play() );

        
    }
    @Test
    @DisplayName("playsong next")
    
    void playsongnext(){
        String playlistname = "mera";
        String playid = "1";
        List<Song> songs = new ArrayList<>();
        Song song1 = new Song("Tu Aake Dekhle","1");
        Song song2 = new Song("Accha","2");
        songs.add(song1);
        songs.add(song2);
        //act
        Playlist myplaylist = new Playlist("shbcha",playlistname, songs);
        //ssert
        Assertions.assertEquals( song2 ,  myplaylist.next() );
        Assertions.assertEquals( song1 ,  myplaylist.prev() );
    }
    @Test
    @DisplayName("playsong prev")
     
    void playsongprev(){
        String playlistname = "mera";
        String playid = "1";
      
        List<Song> songs = new ArrayList<>();
        Song song1 = new Song("Tu Aake Dekhle","1");
        Song song2 = new Song("Accha","2");
        songs.add(song1);
        songs.add(song2);
        //act
        Playlist myplaylist = new Playlist("sji",playlistname, songs);
        //Assert
        Assertions.assertEquals( song2 ,  myplaylist.prev() );
    }


}
    

     

    
    
        
    
  

