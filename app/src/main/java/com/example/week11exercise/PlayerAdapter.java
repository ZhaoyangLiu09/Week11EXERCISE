package com.example.week11exercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    private List<Player> data = new ArrayList<>();

    public void setData(List<Player> newData) {
        data = newData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_player, parent, false);
        return new PlayerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.ViewHolder holder, int position) {
        Player player = data.get(position);
        holder.nameTextView.setText(player.getName());
        holder.ageTextView.setText(String.valueOf(player.getAge()));
        holder.nationalityTextView.setText(player.getNationality());
        holder.positionTextView.setText(player.getPosition());
        holder.teamTextView.setText(player.getTeam());
        holder.jerseyNumberTextView.setText(String.valueOf(player.getJerseyNumber()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView ageTextView;
        TextView nationalityTextView;
        TextView positionTextView;
        TextView teamTextView;
        TextView jerseyNumberTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_name);
            ageTextView = itemView.findViewById(R.id.tv_age);
            nationalityTextView = itemView.findViewById(R.id.tv_nationality);
            positionTextView = itemView.findViewById(R.id.tv_position);
            teamTextView = itemView.findViewById(R.id.tv_team);
            jerseyNumberTextView = itemView.findViewById(R.id.tv_jersey_number);
        }
    }
}