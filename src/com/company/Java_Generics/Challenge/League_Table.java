package com.company.Java_Generics.Challenge;

import com.company.Java_Generics.Player;
import com.company.Java_Generics.Team;

import java.util.ArrayList;
import java.util.Collections;


public class League_Table<T extends Team> {
    public String name;
    private ArrayList<T> league = new ArrayList<>();

    public League_Table(String name) {
        this.name = name;
    }

    public boolean addTeam(T team) {
        if(league.contains(team)) {
            return false;
        }
        league.add(team);
        return true;
    }

    public void showLeagueTable() {
        Collections.sort(league);
        for (T t : league) {
            System.out.println(t.getName() + "  : " + t.ranking());
        }
    }


//    public int sortRankings(T t) {
//        Collections.sort(t.ranking());
//        Collections.reverse
//    }

}
