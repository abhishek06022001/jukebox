package com.crio.jukebox.service;

import java.util.List;
import com.crio.jukebox.dto.PlaylistDTO;
import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.entities.Playlist;

public interface Iplaylist {
    public SongDTO playplaylist(String userid, String playlistid);
    public Playlist modifyplaylistaddsong( String userid, String playlistid,List<String> songids);
    public Playlist modifyplaylistdeletesong( String userid, String playlistid,List<String> songids);
    public Playlist createplaylist(String userid, String name,List<String> songids);
    public Boolean deleteplaylist(String userid, String playlistid);
    public SongDTO playsong(String userid, String operationorsongid);
}
