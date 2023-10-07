package com.crio.jukebox.repository;


import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;


public interface IPlaylistrepo extends CRUDRepository<Playlist,String> {

    Playlist getplaylistbycreatorandplaylistid(String creatorid,String playlistid);
    
    
    
    
}
