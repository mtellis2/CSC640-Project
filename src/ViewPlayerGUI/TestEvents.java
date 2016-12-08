package ViewPlayerGUI;

import java.io.FileReader;
import java.io.FileWriter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class TestEvents{

    public static void main(String[] args) throws IOException {
        HashMap<Integer, Event> EventList = new HashMap<Integer, Event>();
        
        CSVReader reader = new CSVReader(new FileReader("eventList.csv"));
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
            EventList.put(newEventID,AddEvent);
         }
        
        System.out.println("EventList.get(2).getEventName() = " + EventList.get(2).getEventName());

        System.out.println("EventList.get(2).getEventType() = " + EventList.get(2).getEventType());
        System.out.println("EventList.get(2).getDateOfEvent() = " + EventList.get(2).getDateOfEvent());

//        String csv = ".\\output.csv";
//        CSVWriter writer = new CSVWriter(new FileWriter(csv));
//
//        String [] fruits= "Apple,Orange,PineApple".split(",");
//        writer.writeNext(fruits);
//        writer.close();
    }

}