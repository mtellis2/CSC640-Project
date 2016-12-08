package ViewPlayerGUI;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mayur
 */
import java.io.FileReader;
import java.io.FileWriter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import java.util.Iterator;
import java.util.Objects;
//import java.util.Set;


public class EventList{
    private HashMap<Integer,Event> EventListMap;
//    these next three strings allow for centralized management of the file paths.
//    eventually, the sourcePath and destinationPath will be the same.
//    the first one just refers to the fact that the files are contained in the root directory of the project
    //private final String fileDirectory = ".\\";
    private final String sourcePath = "eventList.csv";
//    private final String destinationPath = "output.csv";
    private final String destinationPath = sourcePath;
    
    
    public EventList() throws FileNotFoundException, IOException{
       
        this.EventListMap = new HashMap<>();
        CSVReader reader = new CSVReader(new FileReader(sourcePath));//fileDirectory + sourcePath));
        String [] nextLine;
        reader.readNext(); //skip the header line.
        while ((nextLine = reader.readNext()) != null) {
            int newEventID = Integer.parseInt(nextLine[0]);
            Event AddEvent = new Event(nextLine[1]);
            AddEvent.SetEventID(newEventID);
            AddEvent.setEventType(nextLine[2]);
            AddEvent.setDateOfEvent(nextLine[3]);
            AddEvent.setVenue(nextLine[4]);
            AddEvent.setMember1(nextLine[5]);
            AddEvent.setMember2(nextLine[6]);
            AddEvent.setMember3(nextLine[7]);
            AddEvent.setMember4(nextLine[8]);
            AddEvent.setMember5(nextLine[9]);
            AddEvent.setMember6(nextLine[10]);
            
            EventListMap.put(newEventID,AddEvent);
    
        }
        reader.close();
         
    }
    
    
    public String getEventNameFromEventID(int EventID){
        if (this.EventListMap.get(EventID) != null) {
           return this.EventListMap.get(EventID).getEventName(); 
        }
        else{
            return "";
        }
    }
    
    public int getEventIDFromEventname(String EventName){
        for (Map.Entry<Integer,Event> entry : this.EventListMap.entrySet()){
            if(Objects.equals(EventName.toUpperCase(), entry.getValue().getEventName().toUpperCase())){
                return entry.getKey();
            }        
        }
    return -1; 
    }
    
    public int getNewMaxID(){
        int maxKey = 1;
        while(this.EventListMap.containsKey(maxKey)){
            maxKey++;
        }
        return maxKey;
        
    }
    public boolean addNewEvent(String EventName){
//        this checks first to verify that a username is not being used before adding one.
        if(this.getEventIDFromEventname(EventName) == -1){
            Event newEvent = new Event(EventName);
            int newEventID = this.getNewMaxID();
            newEvent.SetEventID(newEventID);

            this.EventListMap.put(newEventID,newEvent);

            return true;
        }
//        if a eventname is found, it returns false
        else{
            return false;
        }
    }
    public Event getEventFromEventID(int EventID){
//        returns an entire user object via the ID, as opposed to the above methods
//        who only return a username or an id.
//        this gives public access to the hashMap values.
        return this.EventListMap.get(EventID);
    }
    
    public HashMap<Integer, Event> getEventMap(){
//        this is necessary to allow access to the HashMap iterators, etc.
        return this.EventListMap;
    }
    
    public boolean writeListToCSV() throws FileNotFoundException, IOException{
        try (CSVWriter writer = new CSVWriter(new FileWriter(destinationPath))) {//fileDirectory + destinationPath))) {
            String [] firstLine = "eventid,event_name,event_type,date,venue,member1,member2,member3,member4,member5,member6".split(",");
            writer.writeNext(firstLine);
            for (Map.Entry<Integer, Event> EventEntry : this.getEventMap().entrySet())
            {
                writer.writeNext(EventEntry.getValue().toStringArray());
            }
            return true;
        }
        
    }
}

