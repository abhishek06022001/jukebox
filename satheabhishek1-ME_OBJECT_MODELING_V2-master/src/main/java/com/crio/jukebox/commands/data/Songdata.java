package com.crio.jukebox.commands.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import com.crio.jukebox.entities.Album;
import com.crio.jukebox.entities.Artist;
import com.crio.jukebox.entities.Genre;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repository.ISongrepo;

/*
 * song  data with methods etc
 * @author   Abhishek 
 * @link{https://gitlab.crio.do/public_content/me-object-modeling/-/tree/master/app/src/main/java/com/moviebooking/entities}
 */
public class Songdata implements IData{
    private final ISongrepo songrepository;
    public Songdata( ISongrepo songrepository){
        this.songrepository=songrepository;
    }

    @Override
    public void loadData(String dataPath, String delimiter) {
        // TODO Auto-generated method stub
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(dataPath));
            String line = reader.readLine();
            Boolean firstrow = true;
           
       
            while (line != null ) {
                
               if(firstrow){
                firstrow= false;
               }else{
                List<String> tokens = Arrays.asList(line.split(delimiter));
                String id= tokens.get(0);
                if(id.equals("=======")){
                    break;
                }
                String name = tokens.get(1);
                Genre genre = new Genre(tokens.get(2));
                Album album = new Album(tokens.get(3));
                Artist songowner= new Artist(tokens.get(4));
               String[] artisttoken = tokens.get(5).split("#");
               List<Artist> artiss= new ArrayList<>();
               for(String artistname : artisttoken){
                artiss.add(new Artist(artistname));
               }
               addSong(id,name,genre,album,songowner,artiss);
             }
               line = reader.readLine();
            }
            reader.close();



        }catch(IOException e){
            System.out.print(e.getMessage());
        }
        
    }
    private void addSong(String id, String name,Genre genre,Album album,Artist songowner,List<Artist> artiss){
        this.songrepository.save(new Song(id, name, genre, album, songowner, artiss));
    }

    
}
