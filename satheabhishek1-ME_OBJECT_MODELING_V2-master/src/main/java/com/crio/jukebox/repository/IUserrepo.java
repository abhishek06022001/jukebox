package com.crio.jukebox.repository;


import com.crio.jukebox.entities.User;

public interface IUserrepo extends CRUDRepository<User,String>{
    public User createuser(String name );

    public User getuserfromid(String userid);
          
  
    
}
