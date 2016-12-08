package ViewPlayerGUI;

import java.io.IOException;


public class testRegistry{
    public static void main(String[] args) throws IOException {
        TeamRegistry newTeamRegistry = new TeamRegistry();
        UserList newUserList = new UserList();
        TeamList newTeamList = new TeamList();
//        newTeamRegistry.addToTeamRegistry(1, 1);
//        newTeamRegistry.addToTeamRegistry(1, 2);
//        newTeamRegistry.addToTeamRegistry(2, 1);
//        newTeamRegistry.addToTeamRegistry(2, 2);
//        newTeamRegistry.addToTeamRegistry(1, 1);
//        
//        System.out.println("newTeamRegistry =\n" + newTeamRegistry);
//        System.out.println("approving user 1 for team 2");
//        newTeamRegistry.approveUser(1, 2);
//        System.out.println("adding user 3 for team 5");
//        newTeamRegistry.addToTeamRegistry(3, 5);
//        
//        System.out.println("newTeamRegistry =\n" + newTeamRegistry);
//        System.out.println("approving user 2 for team 2");
//        newTeamRegistry.approveUser(2, 2);
//        
//        System.out.println("newTeamRegistry =\n" + newTeamRegistry);
//        System.out.println("denying user 1 for team 2");
//        newTeamRegistry.denyUser(1, 2);
//        
//        System.out.println("newTeamRegistry =\n" + newTeamRegistry);
//        System.out.println("removing user 1/team 2 pair");
//        newTeamRegistry.removeFromTeamRegistry(1, 2);
        
//        System.out.println("newTeamRegistry =\n" + newTeamRegistry);
//        
//        newTeamRegistry.writeListToCSV();
        int userID = 2;
        System.out.print("Teams for user:\t");
        System.out.println(newUserList.getUserFromID(userID).getUserFullName());
        for (int i = 0; i < newTeamRegistry.getTeamsFromUserID(userID).length; i++) {
            System.out.println(newTeamList.getTeamFromID(newTeamRegistry.getTeamsFromUserID(userID)[i]).getTeamName());
        }
        
        int teamID = 1;
        System.out.print("Users for team:\t");
        System.out.println(newTeamList.getTeamFromID(teamID).getTeamName());
        for (int i = 0; i < newTeamRegistry.getUsersFromTeamID(teamID).length; i++) {
            System.out.println(newUserList.getUserFromID(newTeamRegistry.getUsersFromTeamID(teamID)[i]).getUserFullName());
        }
    }

}