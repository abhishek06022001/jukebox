package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.exceptions.SongNotfoundException;
import com.crio.jukebox.service.Iplaylist;

public class PlaySongcommand implements ICommand{
    private Iplaylist playlistservice;
    public PlaySongcommand(Iplaylist playlistservice){
        this.playlistservice=playlistservice;

    }
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        //Given song id is not a part of the active playlist
/*   Switch to play a previous song in the active playlist.
       PLAY-SONG { USER_ID }  BACK
       Switch to play the next song in the active playlist.
       PLAY-SONG  { USER_ID } NEXT
       Switch to the preferred song in the playlist.
        PLAY-SONG { USER_ID }  { Song ID }
        Current Song Playing
Song - Cross Me
Album - No.6 Collaborations Project
Artists - Ed Sheeran,Chance The Rapper,PnB Rock

 */   
       String userid = tokens.get(1);
       String operationorsongid= tokens.get(2);
       try{
       SongDTO ans =  playlistservice.playsong(userid, operationorsongid);
       System.out.println("Current Song Playing");
       System.out.println("Song - "+ans.getsongname());
       System.out.println("Album - "+ans.getalbumname());
       System.out.println("Artists - "+ans.getfeatureartist());
       

       }catch(SongNotfoundException e){
        System.out.print(e.getMessage());
        
       }
    

        
    }
    
}
