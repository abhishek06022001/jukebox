package com.crio.jukebox.exceptions;

public class PlaylistnotfoundException extends RuntimeException{
    public PlaylistnotfoundException(){
        super();
    }
    public PlaylistnotfoundException(String msg){
        super(msg);
    }

    
}
