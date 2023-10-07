package com.crio.jukebox.appconfig;

import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.commands.CreatePlaylistcommand;
import com.crio.jukebox.commands.CreateUsercommand;
import com.crio.jukebox.commands.DeletePlaylistcommand;
import com.crio.jukebox.commands.ICommand;
import com.crio.jukebox.commands.Loaddatacsvcommand;
import com.crio.jukebox.commands.ModifyPlaylistcommand;
import com.crio.jukebox.commands.PlayPlaylistcommand;
import com.crio.jukebox.commands.PlaySongcommand;
import com.crio.jukebox.commands.data.DataLoader;
import com.crio.jukebox.commands.data.Songdata;
import com.crio.jukebox.repository.IPlaylistrepo;
import com.crio.jukebox.repository.ISongrepo;
import com.crio.jukebox.repository.IUserrepo;
import com.crio.jukebox.repository.Playlistrepository;
import com.crio.jukebox.repository.Songrepository;
import com.crio.jukebox.repository.Userrepository;
import com.crio.jukebox.service.IUserservice;
import com.crio.jukebox.service.Iplaylist;
import com.crio.jukebox.service.Playlistservice;
import com.crio.jukebox.service.UserService;

public class  ApplicationConfig{
    private IPlaylistrepo playlistrepository = new Playlistrepository();
    private ISongrepo songrepository = new Songrepository();
    private IUserrepo userrepository = new Userrepository();

    private final Iplaylist playlistservice = new Playlistservice(userrepository, playlistrepository, songrepository);
    private final IUserservice userservice = new UserService(userrepository, playlistrepository, songrepository);
    
    private final ICommand createplaylistcommand = new CreatePlaylistcommand(playlistservice);
    private final ICommand createusercommand = new CreateUsercommand(userservice);
    private final ICommand deleteplaylistcommand =  new DeletePlaylistcommand(playlistservice);
    private final ICommand modifyplaylistcommand = new ModifyPlaylistcommand(playlistservice);
    private final ICommand playplaylistcommand = new PlayPlaylistcommand(playlistservice);
    private final ICommand playsongcommand = new PlaySongcommand(playlistservice);
    private final ICommand loaddataCommand = new Loaddatacsvcommand(playlistservice);

    private final CommandInvoker commandInvoker = new CommandInvoker();
    private final DataLoader dataLoader = new DataLoader();

   

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("CREATE-USER",createusercommand);
        commandInvoker.register("CREATE-PLAYLIST",createplaylistcommand);
        commandInvoker.register("DELETE-PLAYLIST",deleteplaylistcommand);
        commandInvoker.register("MODIFY-PLAYLIST",modifyplaylistcommand);
        commandInvoker.register("PLAY-PLAYLIST",playplaylistcommand);
        commandInvoker.register("PLAY-SONG",playsongcommand);
        commandInvoker.register("LOAD-DATA",loaddataCommand);
        return commandInvoker;

    }
    public DataLoader getDataLoader(){
        dataLoader.register("SONG-DATA",new Songdata(songrepository));
        return dataLoader;
    }


    
}
