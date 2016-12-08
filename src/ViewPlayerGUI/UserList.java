package ViewPlayerGUI;

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


public class UserList{
    private HashMap<Integer,User> UserListMap;
//    these next three strings allow for centralized management of the file paths.
//    eventually, the sourcePath and destinationPath will be the same.
//    the first one just refers to the fact that the files are contained in the root directory of the project
    //private final String fileDirectory = ".\\";
    private final String sourcePath = "userList.csv";
//    private final String destinationPath = "output.csv";
    private final String destinationPath = sourcePath;
    
    
    public UserList() throws FileNotFoundException, IOException{
        this.UserListMap = new HashMap<>();
        CSVReader reader = new CSVReader(new FileReader(sourcePath));//fileDirectory* + sourcePath));
        String [] nextLine;
        reader.readNext(); //skip the header line.
        while ((nextLine = reader.readNext()) != null) {
            int newID = Integer.parseInt(nextLine[0]);
            User AddUser = new User(nextLine[1]);
            AddUser.setID(newID);
            AddUser.setUserFirstName(nextLine[2]);
            AddUser.setUserLastName(nextLine[3]);
            AddUser.setUserGender(nextLine[4]);
            AddUser.setUserEmail(nextLine[5]);
            AddUser.setUserPhoneNumber(nextLine[6]);
            AddUser.setUserAddressLine1(nextLine[7]);
            AddUser.setUserAddressLine2(nextLine[8]);
            AddUser.setUserCity(nextLine[9]);
            AddUser.setUserState(nextLine[10]);
            AddUser.setUserZip(nextLine[11]);
            AddUser.setIsPlayer(Boolean.parseBoolean(nextLine[12]));
            AddUser.setIsCoach(Boolean.parseBoolean(nextLine[13]));
            AddUser.setIsMgmt(Boolean.parseBoolean(nextLine[14]));
            
            UserListMap.put(newID,AddUser);
    
        }
        reader.close();
    }
    
    
    public String getUsernameFromID(int userID){
        if (this.UserListMap.get(userID) != null) {
           return this.UserListMap.get(userID).getUserName(); 
        }
        else{
            return "";
        }
    }
    
    public int getIDFromUsername(String username){
        for (Map.Entry<Integer,User> entry : this.UserListMap.entrySet()){
            if(Objects.equals(username.toUpperCase(), entry.getValue().getUserName().toUpperCase())){
                return entry.getKey();
            }        
        }
    return -1; 
    }
    
    public int getIDFromFullName(String fullname){
        for (Map.Entry<Integer,User> entry : this.UserListMap.entrySet()){
            if(Objects.equals(fullname.toUpperCase(), entry.getValue().getUserFullName().toUpperCase())){
                return entry.getKey();
            }        
        }
    return -1; 
    }
    
    public int getNewMaxID(){
        int maxKey = 1;
        while(this.UserListMap.containsKey(maxKey)){
            maxKey++;
        }
        return maxKey;
        
    }
    public boolean addNewUser(String username){
//        this checks first to verify that a username is not being used before adding one.
        if(this.getIDFromUsername(username) == -1){
            User newUser = new User(username);
            int newUserID = this.getNewMaxID();
            newUser.setID(newUserID);

            this.UserListMap.put(newUserID,newUser);

            return true;
        }
//        if a username is found, it returns false
        else{
            return false;
        }
    }
    public User getUserFromID(int userID){
//        returns an entire user object via the ID, as opposed to the above methods
//        who only return a username or an id.
//        this gives public access to the hashMap values.
        return this.UserListMap.get(userID);
    }
    
    public HashMap<Integer, User> getUserMap(){
//        this is necessary to allow access to the HashMap iterators, etc.
        return this.UserListMap;
    }
    
    public boolean writeListToCSV() throws FileNotFoundException, IOException{
        try (CSVWriter writer = new CSVWriter(new FileWriter(destinationPath))) {//fileDirectory + destinationPath))) {
            String [] firstLine = "id,userName,userFirstName,userLastName,userGender,userEmail,userPhoneNumber,userAddressLine1,userAddressLine2,userCity,userState,userZip,isPlayer,isCoach,isMgmt".split(",");
            writer.writeNext(firstLine);
            for (Map.Entry<Integer, User> userEntry : this.getUserMap().entrySet())
            {
                writer.writeNext(userEntry.getValue().toStringArray());
            }
            return true;
        }
        
    }
}
