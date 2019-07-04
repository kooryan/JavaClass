package company.Java_Generics.Challenge;

import company.Java_Generics.Baseball_Player;
import company.Java_Generics.Football_Player;
import company.Java_Generics.Team;

public class Generics_Challenge {

    public static void main(String[] args) {
//         ArrayList<Team> teams;
//         Collections.sort(teams);

        League_Table<Team<Football_Player>> footballLeague = new League_Table<>("NFL");
        Team<Football_Player> vikings = new Team<>("Vikings");
        Team<Football_Player> packers = new Team<>("Green Bay Packers");
        Team<Football_Player> jets = new Team<>("Jets");

        Team<Baseball_Player> cubs = new Team<>("Chicago Cubs");

        footballLeague.addTeam(vikings);
        footballLeague.addTeam(packers);
        footballLeague.addTeam(jets);

      //  footballLeague.addTeam(cubs);

    }
}
