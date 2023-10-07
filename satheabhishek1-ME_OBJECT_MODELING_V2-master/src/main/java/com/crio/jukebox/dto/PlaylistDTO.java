package com.crio.jukebox.dto;

import java.util.List;
import com.crio.jukebox.entities.Baseentity;


public class PlaylistDTO extends Baseentity  {
//     Playlist ID - { Playlist ID  }
// Playlist Name - { Playlist Name }
// Song IDs - { List of final Song IDs }
   // private String playlistid;
    private String playlistName;
    private List<String> songIds;
    public PlaylistDTO(String playlistid,String playlistName, List<String> songIds){
        this.id= playlistid;
        this.playlistName=playlistName;
        this.songIds=songIds;

    }
    public String getplaylistid(){
        return id;
    }
    public String getplaylistName(){
        return playlistName;
    }
    public List<String> getsongIds(){
        return songIds;
    }

   

    @Override
    public String toString() {
        //Playlist ID - 1
// Playlist Name - MY_PLAYLIST_1
// Song IDs - 1 2 5 6 7
        return "Playlist ID - "+id+
                "Playlist Name - "+playlistName+
                "Song IDs - "+songIds;

    }
    

}
