package com.adgvit.iosfusion2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Refreshments extends Fragment {

    private RecyclerView recyclerView;
    private RefreshmentsRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.refreshments, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.refreshments_recycler);
        adapter = new RefreshmentsRecyclerAdapter(getContext(), getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    public List<RefreshmentItem> getData() {
        List<RefreshmentItem> data = new ArrayList<>();
        String[] ref = {"coffee", "lunch"};
        for(int i = 0; i < ref.length; i++) {
            RefreshmentItem current = new RefreshmentItem();
            current.refreshmentType = ref[i];
            data.add(current);
        }
        return data;
    }
}
