package ViewPlayerGUI;

import java.io.IOException;

public class test{
    public static void main(String[] args) throws IOException {
        TeamList newTeamList = new TeamList();
        UserList newUserList = new UserList();
//        int newID = newTeamList.getNewMaxID();
//        newTeamList.addNewTeam("Cool");
//        newTeamList.getTeamFromID(newID).addPlayer(newUserList.getUserFromID(20), "BEATER");
//        newTeamList.getTeamFromID(newID).addPlayer(newUserList.getUserFromID(2), "BEATER");
//        newTeamList.getTeamFromID(newID).addPlayer(newUserList.getUserFromID(99), "CHASER");
//        newTeamList.getTeamFromID(newID).addPlayer(newUserList.getUserFromID(78), "CHASER");
//        newTeamList.getTeamFromID(newID).addPlayer(newUserList.getUserFromID(26), "CHASER");
//        newTeamList.getTeamFromID(newID).addPlayer(newUserList.getUserFromID(29), "SEEKER");
//        newTeamList.getTeamFromID(newID).addPlayer(newUserList.getUserFromID(16), "KEEPER");
//        newTeamList.getTeamFromID(newID).addPlayer(newUserList.getUserFromID(11), "COACH");
        System.out.println("blahablah");
        System.out.println("newTeamList.getNewMaxID() = " + newTeamList.getNewMaxID());
        newTeamList.writeListToCSV();
        //System.out.println("newTeamList.getTeamFromID(4) = " + newUserList.getUserFromID(newTeamList.getTeamFromID(4).getSeeker()).getUserFullName());
        System.out.println("newTeamList.getIDFromCoach(6) = " + newTeamList.getIDFromCoach(6));
    }



}