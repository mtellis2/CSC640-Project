package ViewPlayerGUI;

public class User {

// CSV values as array:
// 0 id - int
// 1 userName - String
// 2 userFirstName - String
// 3 userLastName - String
// 4 userGender - String
// 5 userEmail - String
// 6 userPhoneNumber - String
// 7 userAddressLine1 - String
// 8 userAddressLine2 - String
// 9 userCity - String
// 10 userState - String
// 11 userZip - String
// 12 isPlayer - Boolean
// 13 isCoach - Boolean
// 14 isMgmt - Boolean
     public User(String newUsername){
        // 0 id - int
        // should be set by the PlayerList.
        // 1 userName - String
        this.setUserName(newUsername);
        // 2 userFirstName - String
        this.setUserFirstName("");
        // 3 userLastName - String
        this.setUserLastName("");
        // 4 userGender - String
        this.setUserGender("");
        // 5 userEmail - String
        this.setUserEmail("");
        // 6 userPhoneNumber - String
        this.setUserPhoneNumber("");
        // 7 userAddressLine1 - String
        this.setUserAddressLine1("");
        // 8 userAddressLine2 - String
        this.setUserAddressLine2("");
        // 9 userCity - String
        this.setUserCity("");
        // 10 userState - String
        this.setUserState("");
        // 11 userZip - String
        this.setUserZip("");
        // 12 isPlayer - Boolean
        this.setIsPlayer(Boolean.FALSE);
        // 13 isCoach - Boolean
        this.setIsCoach(Boolean.FALSE);
        // 14 isMgmt - Boolean
        this.setIsMgmt(Boolean.FALSE);
    }

//  ID
    private int ID;

//  userName
    private String userName;

//  userFirstName
    private String userFirstName;

//  userLastName
    private String userLastName;

//  userGender
    private String userGender;

//  userEmail
    private String userEmail;

//  userPhoneNumber
    private String userPhoneNumber;

//  userAddressLine1
    private String userAddressLine1;

//  userAddressLine2
    private String userAddressLine2;

//  userCity
    private String userCity;

//  userState
    private String userState;

//  Zip
    private String userZip;

//  isPlayer
    private Boolean isPlayer;

//  isCoach
    private Boolean isCoach;

//  isMgmt
    private Boolean isMgmt;

    public int getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }
    
    public String getUserGender(){
        return userGender;
    }
    
    public String getUserEmail(){
        return userEmail;
    }
    public String getUserFullName(){
        return this.userFirstName + " " + this.userLastName;
        
    }
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserAddressLine1() {
        return userAddressLine1;
    }

    public String getUserAddressLine2() {
        return userAddressLine2;
    }

    public String getUserCity() {
        return userCity;
    }

    public String getUserState() {
        return userState;
    }

    public String getUserZip() {
        return userZip;
    }
    

    public Boolean getIsPlayer() {
        return isPlayer;
    }

    public Boolean getIsCoach() {
        return isCoach;
    }

    public Boolean getIsMgmt() {
        return isMgmt;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setUserAddressLine1(String userAddressLine1) {
        this.userAddressLine1 = userAddressLine1;
    }

    public void setUserAddressLine2(String userAddressLine2) {
        this.userAddressLine2 = userAddressLine2;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }

    public void setIsPlayer(Boolean isPlayer) {
        this.isPlayer = isPlayer;
    }

    public void setIsCoach(Boolean isCoach) {
        this.isCoach = isCoach;
    }

    public void setIsMgmt(Boolean isMgmt) {
        this.isMgmt = isMgmt;
    }

    public String [] toStringArray(){
//        this array converts the User/Player class back into a string array for export to CSV.
        int userAttributes = 15;
        String [] userInfoArray = new String[userAttributes];
        // 0 id
        userInfoArray[0] = Integer.toString(this.getID());
        // 1 userName
        userInfoArray[1] = this.getUserName();
        // 2 userFirstName
        userInfoArray[2] = this.getUserFirstName();
        // 3 userLastName
        userInfoArray[3] = this.getUserLastName();
        // 4 userGender
        userInfoArray[4] = this.getUserGender();
        // 5 userEmail
        userInfoArray[5] = this.getUserEmail();
        // 6 userPhoneNumber
        userInfoArray[6] = this.getUserPhoneNumber();
        // 7 userAddressLine1
        userInfoArray[7] = this.getUserAddressLine1();
        // 8 userAddressLine2
        userInfoArray[8] = this.getUserAddressLine2();
        // 9 userCity
        userInfoArray[9] = this.getUserCity();
        // 10 userState
        userInfoArray[10] = this.getUserState();
        // 11 userZip
        userInfoArray[11] = this.getUserZip();
        // 12 isPlayer
        userInfoArray[12] = Boolean.toString(this.getIsPlayer());
        // 13 isCoach
        userInfoArray[13] = Boolean.toString(this.getIsCoach());
        // 14 isMgmt
        userInfoArray[14] = Boolean.toString(this.getIsMgmt());
        
       return userInfoArray; 
    
    }

    Object ToString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         
}
