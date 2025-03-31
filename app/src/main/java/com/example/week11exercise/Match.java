package com.example.week11exercise;

import java.time.LocalDate;

public class Match implements SoccerEntity {
    private static int idCounter = 1;
    private int id;
    private String homeTeam;
    private String awayTeam;
    private String score;
    private String competition;
    private LocalDate date;
    private String venue;

    public Match(String homeTeam, String awayTeam, String score, String competition, String date, String venue) {
        this.id = idCounter++;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.competition = competition;
        this.date = LocalDate.parse(date);
        this.venue = venue;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return homeTeam + " vs " + awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getScore() {
        return score;
    }

    public String getCompetition() {
        return competition;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public void setScore(String score) {
        if (!score.matches("\\d+-\\d+")) {
            throw new IllegalArgumentException("Invalid score format");
        }
        this.score = score;
    }
}