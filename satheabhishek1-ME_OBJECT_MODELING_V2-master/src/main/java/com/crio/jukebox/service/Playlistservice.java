package com.crio.jukebox.service;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.dto.PlaylistDTO;
import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exceptions.PlaylistnotfoundException;
import com.crio.jukebox.exceptions.SongNotfoundException;
import com.crio.jukebox.repository.IPlaylistrepo;
import com.crio.jukebox.repository.ISongrepo;
import com.crio.jukebox.repository.IUserrepo;

public class Playlistservice implements Iplaylist {
    private final IUserrepo userrepository;
    private final IPlaylistrepo playlistrepository;
    private final ISongrepo songrepository;
    private String activeplaylist;
    public Playlistservice( IUserrepo userrepository,IPlaylistrepo playlistrepository,ISongrepo songrepository){
        this.userrepository= userrepository;
        this.playlistrepository=playlistrepository;
        this.songrepository=songrepository;
    }
    @Override
    public Boolean deleteplaylist(String userid, String playlistid) {
        // TODO Auto-generated method stub
    //     User ans =  userrepository.findById(userid);
    //    Playlist playing = playlistrepository.getplaylistbycreatorandplaylistid(userid, playlistid);
        try{
            playlistrepository.deleteById(playlistid);
            User user = userrepository.getuserfromid(userid);
            user.deleteplaylistbyid(playlistid);
            User ans1 = userrepository.save(user);
            return true ;
        }catch(PlaylistnotfoundException e){
           // throw new PlaylistnotfoundException("Playlist Not Found");
             return false;
        }
      
       // System.out.print("Delete Successful");
        
      
        

       

        
    }


    @Override
    public SongDTO playplaylist(String userid, String playlistid)  {
        // TODO Auto-generated method stub
        Playlist playing = playlistrepository.getplaylistbycreatorandplaylistid(userid, playlistid);
        // activeplaylist = playing.getid();
        User a = userrepository.getuserfromid(userid);
        a.setActiveplaylist( playing.getid());
        Song bajrha = playing.play();
        SongDTO ans = new SongDTO(bajrha.getname(),bajrha.getAlbum(),bajrha.getArtist());



        
        
        return ans;
    }

    @Override
    public Playlist modifyplaylistaddsong(String userid, String playlistid, List<String> songids) {
        // TODO Auto-generated method stub
        Playlist playing = playlistrepository.getplaylistbycreatorandplaylistid(userid, playlistid);
        for(String id : songids){
            Song s = songrepository.findById(id);
             if(!playing.containssong(s)){
                playing.addsong(s);
             }

        }
       Playlist p =  playlistrepository.save(playing);
        User dummy = userrepository.getuserfromid(userid);
        dummy.modifiedplaylist(playing);
        User ans = userrepository.save(dummy);
        return p;
    }

    @Override
    public Playlist modifyplaylistdeletesong(String userid, String playlistid,
            List<String> songids) {
        // TODO Auto-generated method stub
        Playlist playing = playlistrepository.getplaylistbycreatorandplaylistid(userid, playlistid);
        for(String id : songids){
            Song s = songrepository.findById(id);
            playing.removesong(s);

        }
       Playlist p =  playlistrepository.save(playing);
        User dummy = userrepository.getuserfromid(userid);
        dummy.modifiedplaylist(playing);
        User ans = userrepository.save(dummy);

        return p;
    }

    @Override
    public Playlist createplaylist(String userid, String Name, List<String> songids) {
        // TODO Auto-generated method stub
      //  CREATE-PLAYLIST { USER_ID } { PLAYLIST_NAME } { List of Song IDs }

      List<Song> songs = new ArrayList<>();
      for( String ganaid : songids){
         songs.add(songrepository.findById(ganaid));
      }
      //user se playlistids lele aur fir append kar isme 
      //getplaylistsrfromuserids then append in playlistsave
      
      
      //ab a user se uska list count of playlist lele 
      Playlist ans = new Playlist(userid, Name, songs);

     Playlist ans1 =  playlistrepository.save(ans);
      User a = userrepository.getuserfromid(userid);
      a.addplaylist(ans1);
     User ans2 = userrepository.save(a);
        return ans1;
    }

  

    @Override
    public SongDTO playsong(String userid, String operationorsongid) throws SongNotfoundException {
        // TODO Auto-generated method stub
        Song s ;
        // User ahh= userrepository.getuserfromid(userid);
        String activeplaylist= userrepository.getuserfromid(userid).getactiveplaylist();
        Playlist playing = playlistrepository.getplaylistbycreatorandplaylistid(userid, activeplaylist);
        
         if(operationorsongid.equals("NEXT")){
           s= playing.next();
         }else if(operationorsongid.equals("BACK")){
           s= playing.prev();
         }else{
            s=playing.getSong(operationorsongid);
         }
         SongDTO DTO = new SongDTO(s.getname(), s.getAlbum(), s.getArtist());
         return DTO;
        
        
    }

}
