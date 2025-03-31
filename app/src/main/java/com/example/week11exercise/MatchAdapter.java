package com.example.week11exercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    private List<Match> data = new ArrayList<>();

    public void setData(List<Match> newData) {
        data = newData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_match, parent, false);
        return new MatchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchAdapter.ViewHolder holder, int position) {
        Match match = data.get(position);
        holder.homeTeamTextView.setText(match.getHomeTeam());
        holder.awayTeamTextView.setText(match.getAwayTeam());
        holder.scoreTextView.setText(match.getScore());
        holder.competitionTextView.setText(match.getCompetition());
        holder.dateTextView.setText(match.getDate().toString());
        holder.venueTextView.setText(match.getVenue());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView homeTeamTextView;
        TextView awayTeamTextView;
        TextView scoreTextView;
        TextView competitionTextView;
        TextView dateTextView;
        TextView venueTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            homeTeamTextView = itemView.findViewById(R.id.tv_home_team);
            awayTeamTextView = itemView.findViewById(R.id.tv_away_team);
            scoreTextView = itemView.findViewById(R.id.tv_score);
            competitionTextView = itemView.findViewById(R.id.tv_competition);
            dateTextView = itemView.findViewById(R.id.tv_date);
            venueTextView = itemView.findViewById(R.id.tv_venue);
        }
    }
}