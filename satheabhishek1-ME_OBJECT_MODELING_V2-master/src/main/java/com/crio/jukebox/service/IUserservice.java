package com.crio.jukebox.service;


import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.entities.User;

public interface IUserservice {
    public User create(String username);
    //public SongDTO playsong(String userid, String operationorsongid);
}
