package com.example.week11exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MatchFragment extends Fragment {
    private static final String ARG_REPO = "repo";
    private static final String ARG_FILTER = "filter";

    private Repository<Match> repository;
    private String currentFilter;
    private RecyclerView recyclerView;
    private MatchAdapter adapter;

    public static MatchFragment newInstance(Repository<Match> repo, String filter) {
        MatchFragment fragment = new MatchFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_REPO, repo);
        args.putString(ARG_FILTER, filter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            repository = (Repository<Match>) getArguments().getSerializable(ARG_REPO);
            currentFilter = getArguments().getString(ARG_FILTER);
        } else {
            currentFilter = "";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MatchAdapter();
        recyclerView.setAdapter(adapter);

        updateData();

        return view;
    }

    private void updateData() {
        if (currentFilter == null || currentFilter.isEmpty()) {
            adapter.setData(repository.get());
        } else {
            adapter.setData(repository.filter(
                    match -> match.getName().toLowerCase().contains(currentFilter.toLowerCase())
            ));
        }
    }
}