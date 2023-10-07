package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.service.Iplaylist;
/*
 * @author me 
 * @param tokens CREATE-PLAYLIST { USER_ID } { PLAYLIST_NAME } { List of Song IDs }
 * @since 1.0
 * @return output to syso when playlist played wth playlistid
 * @see https://docs.google.com/document/d/1I88MfqspjSu1jJxEQjIORMS1hoS8GXijLinqlNV-tzA/edit
 * 
 */
public class CreatePlaylistcommand implements ICommand{
    public Iplaylist playlistservice;
    public CreatePlaylistcommand(Iplaylist playlistservice){
        this.playlistservice=playlistservice;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        //CREATE-PLAYLIST { USER_ID } { PLAYLIST_NAME } { List of Song IDs }
        String userid = tokens.get(1);
        String playlistname = tokens.get(2);
        List<String> songids = new ArrayList<>();
        for(int i = 3 ; i < tokens.size(); i++){
            songids.add(tokens.get(i));

        }
        Playlist ans =    (playlistservice.createplaylist(userid, playlistname, songids));
        System.out.println("Playlist ID - "+ans.getid());
        

        

        
    }
    
}
