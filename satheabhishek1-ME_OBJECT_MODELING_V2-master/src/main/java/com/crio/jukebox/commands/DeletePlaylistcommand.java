package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.service.Iplaylist;

public class DeletePlaylistcommand implements ICommand{
    public Iplaylist playlistservice;
    public DeletePlaylistcommand(Iplaylist playlistservice){
        this.playlistservice=playlistservice;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        /*DELETE-PLAYLIST { USER_ID } { Playlist-ID } */
        String userid = tokens.get(1);
        String playlistid = tokens.get(2);
       // System.out.println( return true ;);
        if(playlistservice.deleteplaylist(userid, playlistid)){
             System.out.println("Delete Successful");
        }else{
            System.out.println("Playlist Not Found");
        }
    }
    
}
