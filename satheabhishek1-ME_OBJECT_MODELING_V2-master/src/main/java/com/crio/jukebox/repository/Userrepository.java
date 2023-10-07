package com.crio.jukebox.repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exceptions.UsernotfoundException;

public class Userrepository implements IUserrepo{
    /*
     *   private final Map<String,User> userMap;
    private Integer autoIncrement = 0;

     */
    private final Map<String,User> usermap;

    private static  Integer userid=0;
    public Userrepository(){
        usermap = new HashMap<String,User>();
    }
    /*
    public UserRepository(Map<String, User> userMap) {
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    } */
    public Userrepository( Map<String,User> usermap,Integer counter){
        this.usermap =usermap;
        this.userid = counter;

    }
    public User getuserfromid(String useridinput){
        
       for(Map.Entry<String,User> entry :usermap.entrySet()){
           if(entry.getKey().equals(useridinput)){
                return entry.getValue();
           }
       }
       throw new UsernotfoundException();

    }

    @Override
    public User save(User entity) {
       if(entity.getid()==(null)){
           userid++;
           User u = new User(entity.getName(),userid.toString());
           usermap.put(u.getid(),u);
            return u ; 
       }else{
            usermap.put(entity.getid(),entity);
            return entity ; 
       }
       
       
    }
      

       
        
        
        
    
   

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findById(String id) {
        // TODO Auto-generated method stub
        User ans = usermap.get(id);
        return ans;
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(User entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public User createuser(String name) {
        // TODO Auto-generated method stub
      
        return null;
    }
    
}
