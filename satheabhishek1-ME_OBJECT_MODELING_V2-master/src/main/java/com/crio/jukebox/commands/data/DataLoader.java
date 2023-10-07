package com.crio.jukebox.commands.data;

import java.util.HashMap;
import java.util.Map;

public class DataLoader {
    private static final Map<String, IData> dataMap = new HashMap<>();

    // Register the data into the HashMap
    public void register(String dataName, IData data){
        dataMap.put(dataName,data);
    }

    // Get the registered Data
    private IData get(String dataName){
        return dataMap.get(dataName);
    }

    // Execute the registered Data
    public void executeData(String dataName, String dataPath ) {
        IData data = get(dataName);

       
        data.loadData(dataPath,",");
    }

    
}
