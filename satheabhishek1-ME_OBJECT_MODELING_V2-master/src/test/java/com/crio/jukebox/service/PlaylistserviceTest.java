package com.crio.jukebox.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.entities.Album;
import com.crio.jukebox.entities.Artist;
import com.crio.jukebox.entities.Genre;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exceptions.PlaylistnotfoundException;
import com.crio.jukebox.repository.IPlaylistrepo;
import com.crio.jukebox.repository.ISongrepo;
import com.crio.jukebox.repository.IUserrepo;
import com.crio.jukebox.service.Iplaylist;
import com.crio.jukebox.service.Playlistservice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@DisplayName("PlaylistserviceTest")
@ExtendWith(MockitoExtension.class)

public class PlaylistserviceTest {
  
    
    @Mock
    private IUserrepo userRepositoryMock;
    @Mock
    private IPlaylistrepo playlistrepositoryMock;
    @Mock
    private ISongrepo songrepoMock;
    @InjectMocks
    private Playlistservice Playlistservice;
    
    @Test
    @DisplayName("createplaylist should create a playlits")
    public void createplaylistreturnplaylist(){
        //arrange
        String name = "playlist";
        String userid= "1";
        Song s = new Song(name, "2");
        List<Song> songid= new ArrayList<>();
          songid.add(s);
          Playlist ans = new Playlist(userid, name, songid);
        List<String> songids= new ArrayList<>();
        songids.add("2");
        User user = new User("username");

        
        //assert
        when(userRepositoryMock.getuserfromid(anyString())).thenReturn(user);
        when(songrepoMock.findById(any(String.class))).thenReturn(s);
       

     
        

        when(playlistrepositoryMock.save(any(Playlist.class))).thenReturn(ans);
        
        //act
        Playlist p = Playlistservice.createplaylist(userid, ans.getName(), songids);
        //assert 
        Assertions.assertEquals(p, ans);
        

        

    }

    @Test
    @DisplayName("Deleteplaylist")
    /*Output Format Schema:
Delete Successful
Or
Error Message if the Playlist IDs do not exist.
 */
   public void deleteplaylist(){
    String username = "bhola";
    String userid = "1";
    String playlistid= "2";
    String wrongplaylistid= "3";
    //arrange
    
     User user = new User(username, userid);
     Song s = new Song("naam", "2");
     List<Song> songid= new ArrayList<>();
     songid.add(s);
     Playlist entity = new Playlist(username, "naam", playlistid, songid);
     user.addplaylist(entity);
     when(userRepositoryMock.getuserfromid(anyString())).thenReturn(user);
     
     //doThrow(PlaylistnotfoundException.class).when(playlistrepositoryMock).deleteById(wrongplaylistid);
    Boolean a = Playlistservice.deleteplaylist(userid,wrongplaylistid);
    Assertions.assertEquals(a, false);

    //Assertions.assertThrows(PlaylistnotfoundException.class,() -> Playlistservice.deleteplaylist(userid,wrongplaylistid));   

   }
   @Test
   @DisplayName("modifyadd  add the diff song")
   public void modifyadd(){
   //arrange
   User user = new User("abhishek");
   String creatorid = "1";
   // check if same song gets added twice
   Song song1 = new Song("tevvez", "1");
   Song song2 = new Song("tevvesz", "2");
   List<Song> listofsong2 = new ArrayList<>();
   listofsong2.add(song1);
   listofsong2.add(song2);
   List<Song> listofsong = new ArrayList<>();
   listofsong.add(song1);
   List<String> songids= new ArrayList<>() ;
    songids.add("1");
    songids.add("2");
    Playlist entity = Mockito.spy(new Playlist(creatorid, "mera", listofsong));
   //Playlist entity = new Playlist(creatorid, "mera", listofsong);
   Playlist entity2 = new Playlist(creatorid, "mera", listofsong2);
   Playlist spy = Mockito.spy(entity);
  when(playlistrepositoryMock.getplaylistbycreatorandplaylistid(creatorid, entity.getid())).thenReturn(entity);
  when(songrepoMock.findById("1")).thenReturn(song1);
  when(songrepoMock.findById("2")).thenReturn(song2);
  when(playlistrepositoryMock.save(any(Playlist.class))).thenReturn(entity2);
  when(userRepositoryMock.getuserfromid(anyString())).thenReturn(user);
  when(userRepositoryMock.save(any(User.class))).thenReturn(user);
  //act
  Playlist p = Playlistservice.modifyplaylistaddsong(creatorid, entity.getid(), songids);

  //assert
  List<Song> arr= new ArrayList<>();
   arr.add(song1);
   arr.add(song2);
 Assertions.assertEquals(arr, p.getsonglist());
  

  verify(entity, times(1)).addsong(any(Song.class));
   
  

   }

   @Test
   @DisplayName("modify delete songfrom playlist")
   public void delsongfromplay(){
    User user = new User("abhishek");
   String creatorid = "1";
   
   Song song1 = new Song("tevvez", "1");
   Song song2 = new Song("tevvesz", "2");
   Song song3 = new Song("tevvsez", "3");
   Song song4 = new Song("tevveqsz", "4");
   List<Song> listofsong2 = new ArrayList<>();
   listofsong2.add(song1);
   listofsong2.add(song2);
   List<Song> finals = new ArrayList<>();
   //finals.add(song1);
   List<String> wrongsongids= new ArrayList<>() ;
   wrongsongids.add("3");
   wrongsongids.add("4");
   List<String> songids= new ArrayList<>() ;
    songids.add("1");
    songids.add("2");
    Playlist entity = Mockito.spy(new Playlist(creatorid, "mera", listofsong2));
   
   Playlist entity2 = new Playlist(creatorid, "mera", finals);
   //act and assert
  when(playlistrepositoryMock.getplaylistbycreatorandplaylistid(creatorid, entity.getid())).thenReturn(entity);
   when(songrepoMock.findById("1")).thenReturn(song1);
   when(songrepoMock.findById("2")).thenReturn(song2);
   //when(songrepoMock.findById("3")).thenReturn(song3);
  // when(songrepoMock.findById("4")).thenReturn(song4);
   when(playlistrepositoryMock.save(any(Playlist.class))).thenReturn(entity2);
   when(userRepositoryMock.getuserfromid(anyString())).thenReturn(user);
   when(userRepositoryMock.save(any(User.class))).thenReturn(user);
   //act
   Playlist p = Playlistservice.modifyplaylistdeletesong(creatorid, entity.getid(), songids);
 
   //assert
   List<Song> arr= new ArrayList<>();
    
  Assertions.assertEquals(arr, p.getsonglist());
   
 
   verify(entity, times(2)).removesong(any(Song.class));
    

   }

   @Test 
   @DisplayName("Playplaylist")
   public void playplaylist(){
   
    String creatorid = "1";
    Artist a = new Artist("kk");
   
    List<Song> song = new ArrayList<>();
    Album album = new Album("album", "1");
    List<Artist> artist = new ArrayList<>();
    artist.add(new Artist("kk"));
    Genre genre = new Genre("pop");

    Song s1 = new Song("1", "gana1", genre, album, a,artist);
    Song s2 = new Song("2", "gana2",genre,album,a,artist);
    song.add(s1);
    song.add(s2);
    String playlistid= "playlistid";
    SongDTO expected = new SongDTO("gana1", album, artist);
    Playlist spy = (new Playlist(creatorid, "entity", song));
    User an = new User("name", creatorid);
    when(playlistrepositoryMock.getplaylistbycreatorandplaylistid(creatorid, playlistid)).thenReturn(spy);
    when(userRepositoryMock.getuserfromid(creatorid)).thenReturn(an);
    //act 
    SongDTO actual = Playlistservice.playplaylist(creatorid, playlistid);
    //assert
    Assertions.assertEquals(expected, actual);





    

   }
   @Test
   @DisplayName("PlaysongBack")
   public void playsongback(){
    String creatorid = "1";
    List<Song> song = new ArrayList<>();
    Album album = new Album("album", "1");
    List<Artist> artist = new ArrayList<>();
    artist.add(new Artist("kk"));
    Genre genre = new Genre("pop");
    Artist a = new Artist("kk");
    Song s1 = new Song("1", "gana1", genre, album, a,artist);
    Song s2 = new Song("2", "gana2",genre,album,a,artist);
    song.add(s1);
    song.add(s2);
    String playlistid = "playlistid";
    SongDTO expected = new SongDTO("gana2", album, artist);

    Playlist spys = new Playlist(creatorid, "entity", song);
    User an = new User("name", creatorid);
    an.setActiveplaylist(playlistid);
    when(userRepositoryMock.getuserfromid(creatorid)).thenReturn(an);
    //when(an.getactiveplaylist()).thenReturn(playlistid);
    when(playlistrepositoryMock.getplaylistbycreatorandplaylistid(creatorid, playlistid)).thenReturn(spys);

    //act
    SongDTO ans = Playlistservice.playsong(creatorid, "BACK");

    //assert
    Assertions.assertEquals(expected, ans);

   }
   @Test
   @DisplayName("PlaysongNext")
   public void playsongNext(){
    String creatorid = "1";
    List<Song> song = new ArrayList<>();
    Album album = new Album("album", "1");
    List<Artist> artist = new ArrayList<>();
    artist.add(new Artist("kk"));
    Genre genre = new Genre("pop");
    Artist a = new Artist("kk");
    Song s1 = new Song("1", "gana1", genre, album, a,artist);
    Song s2 = new Song("2", "gana2",genre,album,a,artist);
    song.add(s1);
    song.add(s2);
    String playlistid = "playlistid";
    SongDTO expected = new SongDTO("gana2", album, artist);
    SongDTO expected2 = new SongDTO("gana1", album, artist);

    Playlist spys = new Playlist(creatorid, "entity", song);
    User an = new User("name", creatorid);
    an.setActiveplaylist(playlistid);
    when(userRepositoryMock.getuserfromid(creatorid)).thenReturn(an);
    //when(an.getactiveplaylist()).thenReturn(playlistid);
    when(playlistrepositoryMock.getplaylistbycreatorandplaylistid(creatorid, playlistid)).thenReturn(spys);

    //act
    SongDTO ans = Playlistservice.playsong(creatorid, "NEXT");
    SongDTO ans2 = Playlistservice.playsong(creatorid, "BACK");

    //assert
   // Assertions.assertEquals(expected, ans);
    Assertions.assertEquals(expected2, ans2);

   }
   @Test
   @DisplayName("Playsongid")
   public void playsongbyid(){
    String creatorid = "1";
    List<Song> song = new ArrayList<>();
    Album album = new Album("album", "1");
    List<Artist> artist = new ArrayList<>();
    artist.add(new Artist("kk"));
    Genre genre = new Genre("pop");
    Artist a = new Artist("kk");
    Song s1 = new Song("1", "gana1", genre, album, a,artist);
    Song s2 = new Song("2", "gana2",genre,album,a,artist);
    song.add(s1);
    song.add(s2);
    String playlistid = "playlistid";
    SongDTO expected = new SongDTO("gana1", album, artist);

    Playlist spys = new Playlist(creatorid, "entity", song);
    User an = new User("name", creatorid);
    an.setActiveplaylist(playlistid);
    when(userRepositoryMock.getuserfromid(creatorid)).thenReturn(an);
    //when(an.getactiveplaylist()).thenReturn(playlistid);
    when(playlistrepositoryMock.getplaylistbycreatorandplaylistid(creatorid, playlistid)).thenReturn(spys);

    //act
    SongDTO ans = Playlistservice.playsong(creatorid, "1");

    //assert
    Assertions.assertEquals(expected, ans);

   }
  
    
    
    
}
