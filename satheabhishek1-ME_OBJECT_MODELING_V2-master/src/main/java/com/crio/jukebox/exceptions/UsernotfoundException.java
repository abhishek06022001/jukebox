package com.crio.jukebox.exceptions;

public class UsernotfoundException extends RuntimeException {
    public UsernotfoundException(){
        super();
    }
    public UsernotfoundException(String msg){
        super(msg);
    }
    
}
