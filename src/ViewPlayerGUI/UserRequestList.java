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


public class UserRequestList{
    private HashMap<Integer,UserRequest> UserRequestListMap;
//    these next three strings allow for centralized management of the file paths.
//    eventually, the sourcePath and destinationPath will be the same.
//    the first one just refers to the fact that the files are contained in the root directory of the project
    private final String fileDirectory = ".\\";
    private final String sourcePath = "userRequests.csv";
//    private final String destinationPath = "output.csv";
    private final String destinationPath = sourcePath;
    
    
    public UserRequestList() throws FileNotFoundException, IOException{
        this.UserRequestListMap = new HashMap<>();
        CSVReader reader = new CSVReader(new FileReader(fileDirectory + sourcePath));
        String [] nextLine;
        reader.readNext(); //skip the header line.
        while ((nextLine = reader.readNext()) != null) {
            int newID = Integer.parseInt(nextLine[0]);
            UserRequest AddRequest = new UserRequest(nextLine[1],nextLine[2],nextLine[3],nextL);
//            AddUser.setID(newID);
//            AddUser.setUserFirstName(nextLine[2]);
            
            UserRequestListMap.put(newID,AddRequest);
    
        }
        reader.close();
    }
    
    
    public String getUsernameFromID(int userID){
        if (this.UserRequestListMap.get(userID) != null) {
           return this.UserRequestListMap.get(userID).getUserName(); 
        }
        else{
            return "";
        }
    }
    
    public int getIDFromUsername(String username){
        for (Map.Entry<Integer,UserRequest> entry : this.UserRequestListMap.entrySet()){
            if(Objects.equals(username.toUpperCase(), entry.getValue().getUserName().toUpperCase())){
                return entry.getKey();
            }        
        }
    return -1; 
    }
    public int getNewMaxID(){
        int maxKey = 1;
        while(this.UserRequestListMap.containsKey(maxKey)){
            maxKey++;
        }
        return maxKey;
        
    }
    public boolean addNewUserRequest(String username){
//        this checks first to verify that a username is not being used before adding one.
        if(this.getIDFromUsername(username) == -1){
            UserRequest newUser = new UserRequest(username);
            int newUserID = this.getNewMaxID();
            newUser.setID(newUserID);

            this.UserRequestListMap.put(newUserID,newUser);

            return true;
        }
//        if a username is found, it returns false
        else{
            return false;
        }
    }
    public User getUserFromID(int requestID){
//        returns an entire user object via the ID, as opposed to the above methods
//        who only return a username or an id.
//        this gives public access to the hashMap values.
        return this.UserRequestListMap.get(requestID);
    }
    
    public HashMap<Integer, UserRequest> getRequestMap(){
//        this is necessary to allow access to the HashMap iterators, etc.
        return this.UserRequestListMap;
    }
    
    public boolean writeListToCSV() throws FileNotFoundException, IOException{
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileDirectory + destinationPath))) {
            String [] firstLine = "id,userName,userFirstName,userLastName,userGender,userEmail,userPhoneNumber,userAddressLine1,userAddressLine2,userCity,userState,userZip,isPlayer,isCoach,isMgmt".split(",");
            writer.writeNext(firstLine);
            for (Map.Entry<Integer, UserRequest> userEntry : this.getRequestMap().entrySet())
            {
                writer.writeNext(userEntry.getValue().toStringArray());
            }
            return true;
        }
        
    }
}
