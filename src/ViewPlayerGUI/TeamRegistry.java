package ViewPlayerGUI;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeamRegistry{
    //private final String fileDirectory = ".\\";
    private final String sourcePath = "teamRegistry.csv";
//    private final String destinationPath = "output.csv";
    private final String destinationPath = sourcePath;
    private ArrayList<TeamReg> TeamRegList;
    private class TeamReg{
        private int userID;
        private int teamID;
        private boolean statusApproved;

        public TeamReg(int userID, int teamID) {
            this.userID = userID;
            this.teamID = teamID;
            this.statusApproved = false;
        }

        public TeamReg(int userID, int teamID, boolean statusApproved) {
            this.userID = userID;
            this.teamID = teamID;
            this.statusApproved = statusApproved;
        }
        
        public int getUserID() {
            return userID;
        }

        public int getTeamID() {
            return teamID;
        }

        public boolean isStatusApproved() {
            return statusApproved;
        }

        public void setStatusApproved(boolean statusApproved) {
            this.statusApproved = statusApproved;
        }
        
        public String [] toStringArray(){
            String [] result = new String[3];
            result[0] = Integer.toString(this.getUserID());
            result[1] = Integer.toString(this.getTeamID());
            result[2] = Boolean.toString(this.isStatusApproved());
            
            return result;
        
        }
        
    }

    
    
    public TeamRegistry() throws FileNotFoundException, IOException{
        this.TeamRegList = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(destinationPath));//fileDirectory + destinationPath));
        String [] nextLine;
        reader.readNext(); //skip the header line.
        while ((nextLine = reader.readNext()) != null) {
            
            int addUserID = Integer.parseInt(nextLine[0]);
            int addTeamID = Integer.parseInt(nextLine[1]);
            Boolean addTeamStatus = Boolean.parseBoolean(nextLine[1]);
            
            TeamReg addUserTeamPair = new TeamReg(addUserID,addTeamID,addTeamStatus);
            
            this.TeamRegList.add(addUserTeamPair);
    
        }
        reader.close();
    }
    
    
    public boolean addToTeamRegistry(int userID, int teamID){
        TeamReg newTeamReg = new TeamReg(userID, teamID);
        if (this.getRegistryIndex(userID, teamID) == -1) {
            this.TeamRegList.add(newTeamReg);
            return true;
        }
        return false;
    }
    
    public boolean removeFromTeamRegistry(int userID, int teamID){
        int index = this.getRegistryIndex(userID, teamID);
        if (this.getRegistryIndex(userID, teamID) != -1) {
            this.TeamRegList.remove(index);
            return true;
        }
        return false;
    }
    
    public int getRegistryIndex(int userID, int teamID){
        int result = -1;
        for (int i = 0; i < this.TeamRegList.size(); i++) {
            if (this.TeamRegList.get(i).getUserID() == userID && this.TeamRegList.get(i).getTeamID() == teamID) {
                result = i;
            }
        }
        return result;
    }
    public boolean approveUser(int userID, int teamID){
        int index = this.getRegistryIndex(userID, teamID);
        if (index != -1) {
            this.TeamRegList.get(index).setStatusApproved(true);
            return true;
        }
        return false;    
    }
    
    public boolean denyUser(int userID, int teamID){
        int index = this.getRegistryIndex(userID, teamID);
        if (index != -1) {
            this.TeamRegList.get(index).setStatusApproved(false);
            return true;
        }
        return false;    
    }
    public boolean getUserTeamStatus(int userID, int teamID){
        int index = this.getRegistryIndex(userID, teamID);
        if (index != -1) {
           return this.TeamRegList.get(index).isStatusApproved(); 
        }
        
    return false;
    
    }
    @Override
    public String toString() {
        String result = "USERID\tTEAMID\tSTATUS\n";
        for (int i = 0; i < this.TeamRegList.size(); i++) {
            result += Integer.toString(this.TeamRegList.get(i).getUserID());
            result += "\t";
            result += Integer.toString(this.TeamRegList.get(i).getTeamID());
            result += "\t";
            result += Boolean.toString(this.TeamRegList.get(i).isStatusApproved());
            result += "\n";
       }
        return result;
    }
    public boolean writeListToCSV() throws FileNotFoundException, IOException{
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileDirectory + destinationPath))) {
            String [] firstLine = "userID,teamID,statusApproved".split(",");
            writer.writeNext(firstLine);
            for (int i = 0; i < this.TeamRegList.size(); i++)
            {
                writer.writeNext(this.TeamRegList.get(i).toStringArray());
            }
            return true;
        }
        
    }
    
    public int [] getTeamsFromUserID(int userID){
        ArrayList<Integer> teamIDs = new ArrayList<>();
        for (int i = 0; i < this.TeamRegList.size(); i++) {
            if (this.TeamRegList.get(i).getUserID() == userID) {
                teamIDs.add(this.TeamRegList.get(i).getTeamID());
            }
        }
        int [] intTeamIDs = new int [teamIDs.size()];
        for (int j = 0; j < teamIDs.size(); j++) {
            intTeamIDs[j] = teamIDs.get(j);
        }
        return intTeamIDs;
    }
    
    public int [] getUsersFromTeamID(int teamID){
        ArrayList<Integer> userIDs = new ArrayList<>();
        for (int i = 0; i < this.TeamRegList.size(); i++) {
            if (this.TeamRegList.get(i).getTeamID() == teamID) {
                userIDs.add(this.TeamRegList.get(i).getUserID());
            }
        }
        int [] intUserIDs = new int [userIDs.size()];
        for (int j = 0; j < userIDs.size(); j++) {
            intUserIDs[j] = userIDs.get(j);
        }
        return intUserIDs;
    }
}