package ViewPlayerGUI;


public class Team{
    private int TeamID;
    private String TeamName;
    private int Coach;
    private int BeaterOne;
    private int BeaterTwo;
    private int ChaserOne;
    private int ChaserTwo;
    private int ChaserThree;
    private int Seeker;
    private int Keeper;
    
    public Team(String teamName){
        this.TeamName = teamName;
        this.BeaterOne = 0;
        this.BeaterTwo = 0;
        this.ChaserOne = 0;
        this.ChaserTwo = 0;
        this.ChaserThree = 0;
        this.Seeker = 0;
        this.Keeper = 0;
        this.Coach = 0;
    
    }
    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getCoach() {
        return Coach;
    }

    public int getBeaterOne() {
        return BeaterOne;
    }

    public int getBeaterTwo() {
        return BeaterTwo;
    }

    public int getChaserOne() {
        return ChaserOne;
    }

    public int getChaserTwo() {
        return ChaserTwo;
    }

    public int getChaserThree() {
        return ChaserThree;
    }

    public int getSeeker() {
        return Seeker;
    }

    public int getKeeper() {
        return Keeper;
    }

    public void setTeamID(int TeamID) {
        this.TeamID = TeamID;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }

    public void setCoach(int Coach) {
        this.Coach = Coach;
    }

    public void setBeaterOne(int BeaterOne) {
        this.BeaterOne = BeaterOne;
    }

    public void setBeaterTwo(int BeaterTwo) {
        this.BeaterTwo = BeaterTwo;
    }

    public void setChaserOne(int ChaserOne) {
        this.ChaserOne = ChaserOne;
    }

    public void setChaserTwo(int ChaserTwo) {
        this.ChaserTwo = ChaserTwo;
    }

    public void setChaserThree(int ChaserThree) {
        this.ChaserThree = ChaserThree;
    }

    public void setSeeker(int Seeker) {
        this.Seeker = Seeker;
    }

    public void setKeeper(int Keeper) {
        this.Keeper = Keeper;
    }

    
    
    

    
    public boolean addPlayer(User Player, String Position){
        String casePosition = Position.toUpperCase();
        switch(Position){
            case "BEATER":
                if(this.getBeaterOne() == 0){
                   this.setBeaterOne(Player.getID());
                   return true;
                }
                else if(this.getBeaterTwo() == 0){
                    this.setBeaterTwo(Player.getID());
                    return true;
                }
                else{
                    return false;
                }
            case "CHASER":
                if(this.getChaserOne() == 0){
                   this.setChaserOne(Player.getID());
                   return true;
                }
                else if(this.getChaserTwo() == 0){
                    this.setChaserTwo(Player.getID());
                    return true;
                }
                else if(this.getChaserThree() == 0){
                    this.setChaserThree(Player.getID());
                    return true;
                }
                else{
                    return false;
                }
            case "SEEKER":
                if(this.getSeeker() == 0){
                   this.setSeeker(Player.getID());
                   return true;
                }
                else return false;
            case "KEEPER":
                if(this.getKeeper() == 0){
                   this.setKeeper(Player.getID());
                   return true;
                }
                else return false;
            case "COACH":
                if(this.getCoach() == 0){
                   this.setCoach(Player.getID());
                   return true;
                }
                else return false;
            default:
                return false;
        }
    }
    public String [] toStringArray(){
        int teamMembers = 10;
            String [] TeamInfoArray = new String[teamMembers];
            TeamInfoArray[0] = String.valueOf(this.getTeamID());
            TeamInfoArray[1] = this.getTeamName();
            TeamInfoArray[2] = String.valueOf(this.getCoach());
            TeamInfoArray[3] = String.valueOf(this.getBeaterOne());
            TeamInfoArray[4] = String.valueOf(this.getBeaterTwo());
            TeamInfoArray[5] = String.valueOf(this.getChaserOne());
            TeamInfoArray[6] = String.valueOf(this.getChaserTwo());
            TeamInfoArray[7] = String.valueOf(this.getChaserThree());
            TeamInfoArray[8] = String.valueOf(this.getSeeker());
            TeamInfoArray[9] = String.valueOf(this.getKeeper());
        
        return TeamInfoArray;
    
    }
}