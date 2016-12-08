package ViewPlayerGUI;

import java.io.IOException;
import java.util.HashMap;

public class TestRoster{
    public static void main(String[] args) throws IOException {
        //HashMap<Integer,Player> Roster = new HashMap<Integer,Player>();
        //HashMap<Integer,Team> Teams = new HashMap<Integer,Team>();
        QuidditchTeams RavenClaw = new QuidditchTeams();
        Team team = new Team(); 
        
        System.out.println(team.TeamID);
        
        
        String userName = "mfreeman0";
        String userName2 = "arobertson1";
        String userName3 = "ckelly2";
        String userName4 = "egibson3";        
        String userName5 = "astevens4";      
        String userName6 = "rwells5";   
        String userName7 = "mhudson6";    
        String position2 = "Beater";
        String position3 = "Chaser";
        String position4 = "Keeper";
        String userName20 = "mtellis";
        
        //System.out.println("userName20 = " + userName20);
        //Player mfreeman0
        RavenClaw.createRoster(team.TeamID, userName);
        
//        System.out.println(RavenClaw.TeamsMap.isEmpty());
        
        RavenClaw.addMorePlayers(1, userName2, position2);
        RavenClaw.addMorePlayers(1, userName3, position2);
        RavenClaw.addMorePlayers(1, userName4, position3);
        RavenClaw.addMorePlayers(1, userName5, position3);
        RavenClaw.addMorePlayers(1, userName6, position3);
        RavenClaw.addMorePlayers(1, userName7, position4);
        
        //RavenClaw.createRoster(team.TeamID , userName20);
        //System.out.println(RavenClaw.RosterMap.values().toString());
        
        RavenClaw.writeListToCSV();
    }

}