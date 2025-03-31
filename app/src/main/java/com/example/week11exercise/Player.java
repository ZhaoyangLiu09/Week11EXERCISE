package com.example.week11exercise;

public class Player implements SoccerEntity {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int age;
    private String nationality;
    private String position;
    private String team;
    private int jerseyNumber;

    public Player(String name, int age, String nationality, String position, String team, int jerseyNumber) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.team = team;
        this.jerseyNumber = jerseyNumber;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setAge(int age) {
        if (age < 16 || age > 50) {
            throw new IllegalArgumentException("Invalid player age");
        }
        this.age = age;
    }
}