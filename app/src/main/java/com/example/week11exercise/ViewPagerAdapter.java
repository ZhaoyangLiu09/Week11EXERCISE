package com.example.week11exercise;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private String currentFilter = "";
    private Repository<Team> teamRepo = new Repository<>();
    private Repository<Player> playerRepo = new Repository<>();
    private Repository<Match> matchRepo = new Repository<>();

    public ViewPagerAdapter(FragmentActivity fa) {
        super(fa);
        // 初始化仓库数据
        teamRepo.add(DataProvider.getTeams());
        playerRepo.add(DataProvider.getPlayers());
        matchRepo.add(DataProvider.getMatches());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return TeamFragment.newInstance(teamRepo, currentFilter);
            case 1:
                return PlayerFragment.newInstance(playerRepo, currentFilter);
            case 2:
                return MatchFragment.newInstance(matchRepo, currentFilter);
            default:
                throw new IllegalArgumentException("Invalid position");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    /**
     * 当搜索文本改变时调用，用于三种实体的过滤
     */
    public void filter(String query) {
        currentFilter = query;
        notifyDataSetChanged();
    }
}