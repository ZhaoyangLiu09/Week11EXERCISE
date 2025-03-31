package com.example.week11exercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private List<Team> data = new ArrayList<>();

    public void setData(List<Team> newData) {
        data = newData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new TeamAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder holder, int position) {
        Team team = data.get(position);
        holder.nameTextView.setText(team.getName());
        holder.countryTextView.setText(team.getCountry());
        holder.leagueTextView.setText(team.getLeague());
        holder.stadiumTextView.setText(team.getStadium());
        holder.foundedTextView.setText(String.valueOf(team.getFoundedYear()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView countryTextView;
        TextView leagueTextView;
        TextView stadiumTextView;
        TextView foundedTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_name);
            countryTextView = itemView.findViewById(R.id.tv_country);
            leagueTextView = itemView.findViewById(R.id.tv_league);
            stadiumTextView = itemView.findViewById(R.id.tv_stadium);
            foundedTextView = itemView.findViewById(R.id.tv_founded);
        }
    }
}