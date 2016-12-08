package ViewPlayerGUI;


public class Roster {
   private final int BeaterNum = 2;
   private final int ChaserNum = 3;
   private int RosterID;
   private int EventID;
   private int CoachID;
   private int TeamSize;
   private User[] BeaterList = new User[BeaterNum];
   private User[] ChaserList = new User[ChaserNum];
   private User Seeker;
   private User Keeper;
   
   public Roster(int EventIDNum){
       this.RosterID = 0;
       this.EventID = EventIDNum;
       this.CoachID = 0;
       this.TeamSize = 0;
       for (int i = 0; i < BeaterNum; i++) {
           this.BeaterList[i] = null;
       }
       for (int i = 0; i < ChaserNum; i++) {
           this.ChaserList[i] = null;
       }
       this.Seeker = null;
       this.Keeper = null;
   
   }
   public int getTeamSize() {
        return TeamSize;
   }

    public int getRosterID() {
        return RosterID;
    }

    public void setRosterID(int RosterID) {
        this.RosterID = RosterID;
    }

    public int getEventID() {
        return EventID;
    }

    public int getCoachID() {
        return CoachID;
    }

    public void setCoachID(int CoachID) {
        this.CoachID = CoachID;
    }

    public boolean addUser(User NewPlayer, String PlayerPosition){
       PlayerPosition = PlayerPosition.toUpperCase();
       switch (PlayerPosition) {
            case "BEATER":
               for (int i = 0; i < BeaterNum; i++) {
                   if(this.BeaterList[i] == null){
                       this.BeaterList[i] = NewPlayer;
                       this.TeamSize++;
                       return true;
                   }
               }
               return false;
           case "CHASER":
               for (int i = 0; i < ChaserNum; i++) {
                   if(this.ChaserList[i] == null){
                       this.ChaserList[i] = NewPlayer;
                       this.TeamSize++;
                       return true;
                   }
               }
               return false;
           case "SEEKER":
               if(this.Seeker == null){
                   this.Seeker = NewPlayer;
                   this.TeamSize++;
                   return true;}
               return false;
           case "KEEPER":
               if(this.Keeper == null){
                   this.Keeper = NewPlayer;
                   this.TeamSize++;
                   return true;}
               return false;
           default:
               return false;
       }
    }
   @Override
    public String toString(){
    String result = "";
    for (int i = 0; i < BeaterNum; i++) {
        result += "BEATER" + (i+1) + ":\t";
        if(this.BeaterList[i] == null){
            result += "<empty>\n";
        }
        else{
            result += this.BeaterList[i].getUserName() + "\n";
        }
    }
    for (int i = 0; i < ChaserNum; i++) {
        result += "CHASER" + (i+1) + ":\t";
        if(this.ChaserList[i] == null){
            result += "<empty>\n";
        }
        else{
            result += this.ChaserList[i].getUserName() + "\n";
        }
    }
    result += "SEEKER:\t";
    if(this.Seeker == null){
            result += "<empty>\n";
        }
        else{
            result += this.Seeker.getUserName() + " \n";
        }
    result += "KEEPER:\t";
    if(this.Keeper == null){
            result += "<empty>\n";
        }
        else{
            result += this.Keeper.getUserName() + "\n";
        }
    
    return result;
    }
}
