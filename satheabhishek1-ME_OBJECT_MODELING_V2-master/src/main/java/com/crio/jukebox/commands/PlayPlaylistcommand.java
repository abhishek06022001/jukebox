package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.exceptions.PlaylistnotfoundException;
import com.crio.jukebox.service.Iplaylist;

public class PlayPlaylistcommand implements ICommand {
    private Iplaylist playlistservice;
    public PlayPlaylistcommand( Iplaylist playlistservice){
        this.playlistservice= playlistservice;
    }
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        //PLAY-PLAYLIST  { USER_ID } { Playlist-ID }
        String userid = tokens.get(1);
        String playlistid = tokens.get(2);
     
        try{
           SongDTO ans = playlistservice.playplaylist(userid, playlistid);
           System.out.println("Current Song Playing");
           System.out.println("Song - "+ans.getsongname());
           System.out.println("Album - "+ans.getalbumname());
           System.out.println("Artists - "+ans.getfeatureartist());
           
        //System.out.print(playlistservice.playplaylist(userid, playlistid).toString());
        }catch(PlaylistnotfoundException e){
            System.out.print(e.getMessage());
        }
     

        
    }
    
}
