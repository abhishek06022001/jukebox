package com.crio.jukebox.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exceptions.PlaylistnotfoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("UserTest")
public class UserTest {
    @Test
    @DisplayName("SelectPlaylistthrowsexception")
    void selectplaylisttest() {
        //Arrange 
        List<Song> ok = new ArrayList<Song>() ;
            ok.add(new Song("ahh","2"));
            ok.add(new Song("ahsh","3"));
            ok.add(new Song("ahsh","34"));

       
        Playlist pehla = new Playlist("pehla","1",ok,"1");
        Playlist dusra = new Playlist("dusra","3",ok,"2");
        Playlist tesra = new Playlist("tesra","4",ok,"3");

        List<Playlist> playlist = new ArrayList<Playlist>();
        playlist.add(pehla);
        playlist.add(dusra);
        playlist.add(tesra);
        User mai = new User("mai",playlist,"2");
        // act 
        
        Assertions.assertThrows(PlaylistnotfoundException.class,()->mai.selectplaylist("5"));
        Assertions.assertEquals(pehla, mai.selectplaylist("1"));    


    }
 







   

    
}
