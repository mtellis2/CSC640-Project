package ViewPlayerGUI;

import java.io.FileReader;
import java.io.FileWriter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



public class TeamList{
    private HashMap<Integer,Team> TeamListMap;
//    these next three strings allow for centralized management of the file paths.
//    eventually, the sourcePath and destinationPath will be the same.
//    the first one just refers to the fact that the files are contained in the root directory of the project
    //private final String fileDirectory = ".\\";
    private final String sourcePath = "teamList.csv";
//    private final String destinationPath = "teamOutput.csv";
    private final String destinationPath = sourcePath;
    
    
    public TeamList() throws FileNotFoundException, IOException{
        this.TeamListMap = new HashMap<>();
        CSVReader reader = new CSVReader(new FileReader(sourcePath));//fileDirectory + sourcePath));
        String [] nextLine;
        reader.readNext(); //skip the header line.
        while ((nextLine = reader.readNext()) != null) {
            int newID = Integer.parseInt(nextLine[0]);
            Team AddTeam = new Team(nextLine[1]);
            AddTeam.setTeamID(newID);
            AddTeam.setCoach(Integer.parseInt(nextLine[2]));
            AddTeam.setBeaterOne(Integer.parseInt(nextLine[3]));
            AddTeam.setBeaterTwo(Integer.parseInt(nextLine[4]));
            AddTeam.setChaserOne(Integer.parseInt(nextLine[5]));
            AddTeam.setChaserTwo(Integer.parseInt(nextLine[6]));
            AddTeam.setChaserThree(Integer.parseInt(nextLine[7]));
            AddTeam.setSeeker(Integer.parseInt(nextLine[8]));
            AddTeam.setKeeper(Integer.parseInt(nextLine[9]));
            
            
            TeamListMap.put(newID,AddTeam);
    
        }
        reader.close();
    }
    
    
    public String getTeamnameFromID(int teamID){
        if (this.TeamListMap.get(teamID) != null) {
           return this.TeamListMap.get(teamID).getTeamName(); 
        }
        else{
            return "";
        }
    }
    
    public int getIDFromTeamname(String teamname){
        for (Map.Entry<Integer,Team> entry : this.TeamListMap.entrySet()){
            if(Objects.equals(teamname.toUpperCase(), entry.getValue().getTeamName().toUpperCase())){
                return entry.getKey();
            }        
        }
    return -1; 
    }
    
    public int getIDFromCoach(int coach){
        for (Map.Entry<Integer,Team> entry : this.TeamListMap.entrySet()){
            if(Objects.equals(coach, entry.getValue().getCoach())){
                return entry.getKey();
            }        
        }
    return -1; 
    } 
    
    public Team getTeamFromTeamname(String teamname){
        for (Map.Entry<Integer,Team> entry : this.TeamListMap.entrySet()){
            if(Objects.equals(teamname.toUpperCase(), entry.getValue().getTeamName().toUpperCase())){
                return entry.getValue();
            }        
        }
    return null; 
    }
    
    public int getNewMaxID(){
        int maxKey = 1;
        while(this.TeamListMap.containsKey(maxKey)){
            maxKey++;
        }
        return maxKey;
        
    }
    public boolean addNewTeam(String teamname){
//        this checks first to verify that a teamname is not being used before adding one.
        if(this.getIDFromTeamname(teamname) == -1){
            Team newTeam = new Team(teamname);
            int newTeamID = this.getNewMaxID();
            newTeam.setTeamID(newTeamID);

            this.TeamListMap.put(newTeamID,newTeam);

            return true;
        }
//        if a teamname is found, it returns false
        else{
            return false;
        }
    }
    public Team getTeamFromID(int teamID){
//        returns an entire team object via the ID, as opposed to the above methods
//        who only return a teamname or an id.
//        this gives public access to the hashMap values.
        return this.TeamListMap.get(teamID);
    }
    
    public HashMap<Integer, Team> getTeamMap(){
//        this is necessary to allow access to the HashMap iterators, etc.
        return this.TeamListMap;
    }
    
    
    
    public boolean writeListToCSV() throws FileNotFoundException, IOException{
        try (CSVWriter writer = new CSVWriter(new FileWriter(destinationPath))) {//fileDirectory + destinationPath))) {
            String [] firstLine = "TeamID,TeamName,Coach,BeaterOne,BeaterTwo,ChaserOne,ChaserTwo,ChaserThree,Seeker,Keeper".split(",");
            writer.writeNext(firstLine);
            for (Map.Entry<Integer, Team> teamEntry : this.getTeamMap().entrySet())
            {
                writer.writeNext(teamEntry.getValue().toStringArray());
            }
            return true;
        }
        
    }
}
