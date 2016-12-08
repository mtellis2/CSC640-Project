/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewPlayerGUI;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author fbbigger
 */
public class PlayerStatsList {
//    these next three strings allow for centralized management of the file paths.
//    eventually, the sourcePath and destinationPath will be the same.
//    the first one just refers to the fact that the files are contained in the root directory of the project
    //private final String fileDirectory = ".\\";
    private final String sourcePath = "playerStats.csv";
//    private final String destinationPath = "statsOutput.csv";
    private final String destinationPath = sourcePath;
    private ArrayList<int[]> StatsArrayList;
//    int array has 5 elements:
//    0 playerID
//    1 eventID
//    2 ptsQuaffle
//    3 ptsSnitch
//    4 gameFouls
    
    public PlayerStatsList() throws FileNotFoundException, IOException{
        this.StatsArrayList = new ArrayList<int[]>();
        CSVReader reader = new CSVReader(new FileReader(sourcePath));//fileDirectory + sourcePath));
        String [] nextLine;
        reader.readNext(); //skip the header line.
        while ((nextLine = reader.readNext()) != null) {
            int playerID = Integer.parseInt(nextLine[0]);
            int eventID = Integer.parseInt(nextLine[1]);
            int ptsQuaffle = Integer.parseInt(nextLine[2]);
            int ptsSnitch = Integer.parseInt(nextLine[3]);
            int gameFouls = Integer.parseInt(nextLine[4]);
            this.addPlayerEventStats(playerID,eventID,ptsQuaffle,ptsSnitch,gameFouls);       

        }
        reader.close();
    }
    
    public PlayerStatsList(ArrayList<int[]> StatsArrayList) {
        this.StatsArrayList = StatsArrayList;
    }
    
    
   public boolean addPlayerEventStats(int playerID, int eventID, int ptsQuaffle, int ptsSnitch, int gameFouls){
       int[] playerStatsArray = new int[5];
       playerStatsArray[0] = playerID;
       playerStatsArray[1] = eventID;
       playerStatsArray[2] = ptsQuaffle;
       playerStatsArray[3] = ptsSnitch;
       playerStatsArray[4] = gameFouls;
       if(this.getPlayerEventStats(playerID, eventID) == null){
           this.StatsArrayList.add(playerStatsArray);
           return true;
       }
            
       return false;
   }
   public int[] getPlayerEventStats(int playerID, int eventID){
       for (int i = 0; i < this.StatsArrayList.size(); i++) {
           if (this.StatsArrayList.get(i)[0] == playerID && this.StatsArrayList.get(i)[1] == eventID) {
               return this.StatsArrayList.get(i);
           }
       }
   return null;
   }
   
   public boolean setPlayerEventStats(int playerID, int eventID, int ptsQuaffle, int ptsSnitch, int gameFouls){
    if (this.getPlayerEventIndex(playerID, eventID) != -1){
        int[] setStats = new int[5];
        setStats[0] = playerID;
        setStats[1] = eventID;
        setStats[2] = ptsQuaffle;
        setStats[3] = ptsSnitch;
        setStats[4] = gameFouls;

        this.StatsArrayList.set(this.getPlayerEventIndex(playerID, eventID), setStats);
        return true;
    }
    return false;
   }
   public int getPlayerEventIndex(int playerID, int eventID){
       for (int i = 0; i < this.StatsArrayList.size(); i++) {
           if (this.StatsArrayList.get(i)[0] == playerID && this.StatsArrayList.get(i)[1] == eventID){
               return i;
           }
       }
       return -1;
   
   }
   public ArrayList<Integer> getPlayerEvents(int playerID){
       ArrayList<Integer> playerEvents = new ArrayList<>();
       for (int i = 0; i < this.StatsArrayList.size(); i++) {
           if (this.StatsArrayList.get(i)[0] == playerID) {
               playerEvents.add(this.StatsArrayList.get(i)[1]);
           }
       }
       return playerEvents;
   }
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.StatsArrayList.size(); i++) {
            result += Integer.toString(this.StatsArrayList.get(i)[0]);
            result += "\t";
            result += Integer.toString(this.StatsArrayList.get(i)[1]);
            result += "\t";
            result += Integer.toString(this.StatsArrayList.get(i)[2]);
            result += "\t";
            result += Integer.toString(this.StatsArrayList.get(i)[3]);
            result += "\t";
            result += Integer.toString(this.StatsArrayList.get(i)[4]);
            result += "\n";
        }
        return result;
    }
public boolean writePlayerStatsListToCSV() throws FileNotFoundException, IOException{
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileDirectory + destinationPath))) {
            String [] firstLine = "playerID,eventID,ptsQuaffle,ptsSnitch,gameFouls".split(",");
            writer.writeNext(firstLine);
            String statsValues[] = new String[5];
            for (int i = 0; i < this.StatsArrayList.size(); i++)
            {
                statsValues[0] = String.valueOf(this.StatsArrayList.get(i)[0]);
                statsValues[1] = String.valueOf(this.StatsArrayList.get(i)[1]);
                statsValues[2] = String.valueOf(this.StatsArrayList.get(i)[2]);
                statsValues[3] = String.valueOf(this.StatsArrayList.get(i)[3]);
                statsValues[4] = String.valueOf(this.StatsArrayList.get(i)[4]);
                writer.writeNext(statsValues);
            }
            return true;
        }
        
    }
}
