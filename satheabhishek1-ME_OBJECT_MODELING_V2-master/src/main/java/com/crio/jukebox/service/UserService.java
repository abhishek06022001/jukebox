package com.crio.jukebox.service;

import java.nio.file.attribute.UserPrincipal;
import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.repository.IPlaylistrepo;
import com.crio.jukebox.repository.ISongrepo;
import com.crio.jukebox.repository.IUserrepo;
import com.crio.jukebox.repository.Userrepository;

public class UserService implements IUserservice {
    private final IUserrepo userrepository;
    private final IPlaylistrepo playlistrepository;
    private final ISongrepo songrepository;

   public UserService( IUserrepo userrepository, IPlaylistrepo playlistrepository,ISongrepo songrepository){
    this.userrepository=userrepository;
    this.playlistrepository=playlistrepository;
    this.songrepository=songrepository;
   }

    @Override
    public User create(String username) {
        // TODO Auto-generated method stub
        User ans = new User(username);
        return userrepository.save(ans);
       
        

        
        
       
    }
    

    // @Override
    // public SongDTO playsong(String userid, String operationorsongid) {
    //     // TODO Auto-generated method stub
    //     SongDTO ans = new SongDTO();
       



        
    //     return null;
    // }
    
}
