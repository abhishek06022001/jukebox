package com.crio.jukebox.exceptions;

public class SongNotfoundException  extends RuntimeException {
    public SongNotfoundException(){
        super();
    }
    public SongNotfoundException(String msg){
        super(msg);
    }

    
}
