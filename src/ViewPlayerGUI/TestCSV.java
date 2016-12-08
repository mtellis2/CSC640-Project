package ViewPlayerGUI;

import ViewPlayerGUI.User;
import java.io.FileReader;
import java.io.FileWriter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class TestCSV{

    public static void main(String[] args) throws IOException {
        HashMap<Integer, User> PlayerList = new HashMap<Integer, User>();
        
        CSVReader reader = new CSVReader(new FileReader("playerListSmall.csv"));
        String [] nextLine;
        reader.readNext(); //skip the header line.
        while ((nextLine = reader.readNext()) != null) {
            int newID = Integer.parseInt(nextLine[0]);
            User AddPlayer = new User(nextLine[1]);
            AddPlayer.setID(newID);
            AddPlayer.setUserFirstName(nextLine[2]);
            AddPlayer.setUserLastName(nextLine[3]);
            AddPlayer.setUserGender(nextLine[4]);
            AddPlayer.setUserEmail(nextLine[5]);
            AddPlayer.setUserPhoneNumber(nextLine[6]);
            AddPlayer.setUserAddressLine1(nextLine[7]);
            AddPlayer.setUserAddressLine2(nextLine[8]);
            AddPlayer.setUserCity(nextLine[9]);
            AddPlayer.setUserState(nextLine[10]);
            AddPlayer.setUserZip(nextLine[11]);
            AddPlayer.setIsPlayer(Boolean.parseBoolean(nextLine[12]));
            AddPlayer.setIsCoach(Boolean.parseBoolean(nextLine[13]));
            AddPlayer.setIsMgmt(Boolean.parseBoolean(nextLine[14]));
            
            PlayerList.put(newID,AddPlayer);
         }
        System.out.println("PlayerList.get(2).getUserName() = " + PlayerList.get(2).getUserName());
        
//        String csv = ".\\output.csv";
//        CSVWriter writer = new CSVWriter(new FileWriter(csv));
//
//        String [] fruits= "Apple,Orange,PineApple".split(",");
//        writer.writeNext(fruits);
//        writer.close();
    }

}