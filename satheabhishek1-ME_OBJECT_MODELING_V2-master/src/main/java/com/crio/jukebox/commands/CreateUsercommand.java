package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.service.IUserservice;

public class CreateUsercommand implements ICommand {

    public IUserservice userservice;
    public CreateUsercommand(IUserservice userservice){
        this.userservice=userservice;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String name = tokens.get(1);
        System.out.println(userservice.create(name));

        
    }
    
}
