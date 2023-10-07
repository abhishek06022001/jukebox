package com.crio.jukebox.repository;

import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.service.Iplaylist;

public interface ISongrepo  extends CRUDRepository<Song,String>{
    // public Optional<Song> findbyname();
    //SongDTO playSong(String userId, String songIdOrOperation);
}
