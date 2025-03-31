package com.example.week11exercise;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TeamIterator implements Iterator<Team> {
    private final List<Team> teams;
    private int position = 0;

    public TeamIterator(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public boolean hasNext() {
        return position < teams.size();
    }

    @Override
    public Team next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return teams.get(position++);
    }
}