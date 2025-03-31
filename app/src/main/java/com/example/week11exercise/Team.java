package com.example.week11exercise;

public class Team implements SoccerEntity {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String country;
    private String league;
    private String stadium;
    private int foundedYear;

    public Team(String name, String country, String league, String stadium, int foundedYear) {
        this.id = idCounter++;
        this.name = name;
        this.country = country;
        this.league = league;
        this.stadium = stadium;
        this.foundedYear = foundedYear;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }

    public String getStadium() {
        return stadium;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty");
        }
        this.name = name;
    }
}