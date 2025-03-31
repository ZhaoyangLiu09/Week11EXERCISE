package com.example.week11exercise;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public static List<Team> getTeams() {
        return createSampleTeams();
    }

    public static List<Player> getPlayers() {
        return createSamplePlayers();
    }

    public static List<Match> getMatches() {
        return createSampleMatches();
    }

    private static List<Team> createSampleTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("FC Barcelona", "Spain", "La Liga", "Camp Nou", 1899));
        teams.add(new Team("Real Madrid", "Spain", "La Liga", "Santiago Bernabéu", 1902));
        teams.add(new Team("Manchester United", "England", "Premier League", "Old Trafford", 1878));
        teams.add(new Team("Bayern Munich", "Germany", "Bundesliga", "Allianz Arena", 1900));
        return teams;
    }

    private static List<Player> createSamplePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Lionel Messi", 36, "Argentina", "Forward", "Inter Miami", 10));
        players.add(new Player("Cristiano Ronaldo", 38, "Portugal", "Forward", "Al Nassr", 7));
        players.add(new Player("Kylian Mbappé", 24, "France", "Forward", "Paris Saint-Germain", 7));
        players.add(new Player("Robert Lewandowski", 35, "Poland", "Forward", "FC Barcelona", 9));
        return players;
    }

    private static List<Match> createSampleMatches() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("FC Barcelona", "Real Madrid", "2-1", "La Liga", "2023-10-28", "Camp Nou"));
        matches.add(new Match("Manchester United", "Liverpool", "0-0", "Premier League", "2023-10-29", "Old Trafford"));
        matches.add(new Match("Bayern Munich", "Borussia Dortmund", "4-2", "Bundesliga", "2023-11-04", "Allianz Arena"));
        return matches;
    }
}