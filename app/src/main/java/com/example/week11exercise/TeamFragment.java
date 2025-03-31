package com.example.week11exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Comparator;
import java.util.List;

public class TeamFragment extends Fragment {
    private static final String ARG_FILTER = "filter";

    // 不将 Repository 放入 Bundle 中，而是使用一个静态变量进行传递
    private static Repository<Team> sRepository;

    private Repository<Team> repository;
    private String currentFilter;
    private RecyclerView recyclerView;
    private TeamAdapter adapter;

    /**
     * 创建 fragment 实例时传递 Repository 和 filter 参数
     */
    public static TeamFragment newInstance(Repository<Team> repo, String filter) {
        TeamFragment fragment = new TeamFragment();
        sRepository = repo; // 通过静态变量传递
        Bundle args = new Bundle();
        args.putString(ARG_FILTER, filter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = sRepository;

        if (getArguments() != null) {
            currentFilter = getArguments().getString(ARG_FILTER);
        } else {
            currentFilter = "";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TeamAdapter();
        recyclerView.setAdapter(adapter);

        // 更新初始数据
        updateData();

        Button btnSortName = view.findViewById(R.id.btn_sort_name);
        btnSortName.setOnClickListener(v -> {
            List<Team> sortedData = repository.sort(Comparator.comparing(Team::getName));
            updateAdapter(sortedData);
        });

        Button btnSortFounded = view.findViewById(R.id.btn_sort_founded);
        btnSortFounded.setOnClickListener(v -> {
            List<Team> sortedData = repository.sort(Comparator.comparingInt(Team::getFoundedYear));
            updateAdapter(sortedData);
        });

        return view;
    }

    private void updateData() {
        if (currentFilter == null || currentFilter.isEmpty()) {
            updateAdapter(repository.get());
        } else {
            updateAdapter(repository.filter(
                    team -> team.getName().toLowerCase().contains(currentFilter.toLowerCase())
            ));
        }
    }

    private void updateAdapter(List<Team> data) {
        adapter.setData(data);
    }
}