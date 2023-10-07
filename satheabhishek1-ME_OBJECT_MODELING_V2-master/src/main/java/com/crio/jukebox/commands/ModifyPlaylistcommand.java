package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.service.Iplaylist;

public class ModifyPlaylistcommand implements ICommand{
    public Iplaylist playlistservice;
    public ModifyPlaylistcommand(Iplaylist playlistservice){
        this.playlistservice=playlistservice;
    }

    @Override
    public void execute(List<String> tokens) {

        // TODO Auto-generated method stub
        /*
         *     To add Song
       MODIFY-PLAYLIST ADD-SONG { USER_ID } {Playlist-ID } { List of Song IDs }*/
       String userid = tokens.get(2);
       String playlistid = tokens.get(3);
       List<String> songids = new ArrayList<>();
        for(int i = 4 ; i < tokens.size(); i++){
            songids.add(tokens.get(i));

        }
       if(tokens.get(1).equals("ADD-SONG")){
         Playlist ans = playlistservice.modifyplaylistaddsong(userid, playlistid, songids);
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < ans.getsongids().size(); i++) {
              sb.append(ans.getsongids().get(i));
          if (i < ans.getsongids().size() - 1) {
              sb.append(" ");
          }
        }
        System.out.println("Playlist ID - "+ans.getid());
        System.out.println("Playlist Name - "+ans.getName());
        System.out.println("Song IDs - "+sb.toString());
        //System.out.print("Playlist ID - "+ans.getid()+"\n"+"Playlist Name - "+ans.getName()+"\n"+"Song IDs - "+sb+"\n");
       }else if(tokens.get(1).equals("DELETE-SONG")){   
        Playlist ans2 = playlistservice.modifyplaylistdeletesong(userid, playlistid, songids);
        StringBuilder sb1 = new StringBuilder();
         for (int i = 0; i < ans2.getsongids().size(); i++) {
              sb1.append(ans2.getsongids().get(i));
          if (i < ans2.getsongids().size() - 1) {
              sb1.append(" ");
          }
        }
         // System.out.println("Playlist ID - "+ans2.getid()+"\n"+"Playlist Name - "+ans2.getName()+"\n"+"Song IDs - "+sb+"\n");
         System.out.println("Playlist ID - "+ans2.getid());
         System.out.println("Playlist Name - "+ans2.getName());
         System.out.println("Song IDs - "+sb1.toString());

        }


       

         

    }   
        

        
    
    
}
