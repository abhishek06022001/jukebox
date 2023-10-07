package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.service.Iplaylist;

public class Loaddatacsvcommand implements ICommand {
    public Iplaylist playlistservice;
    public Loaddatacsvcommand(Iplaylist playlistservice){
        this.playlistservice=playlistservice;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println("Songs Loaded successfully");
        
    }
    
}
