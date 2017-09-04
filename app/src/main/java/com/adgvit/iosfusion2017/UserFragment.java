package com.adgvit.iosfusion2017;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment {

    private RecyclerView recyclerView;
    private ForumRecyclerAdapter adapter;
    private EditText doubt;
    private Button Send;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.user_swipe);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Send new GET request to server
            }
        });
        recyclerView = (RecyclerView) rootView.findViewById(R.id.userRecycler);
        doubt = (EditText) rootView.findViewById(R.id.doubt);
        adapter = new ForumRecyclerAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Send = (Button) rootView.findViewById(R.id.send);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ques = doubt.getText().toString();
                //POST ques to server
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

    public List<ForumItem> getData(){
        List<ForumItem> data = new ArrayList<>();
        String[] questions = {"Yes this is a valid doubt", "Yes this module is working", "Hopefully it is working"};
        for (int i = 0; i < questions.length; i++) {
            ForumItem current = new ForumItem();
            current.question = questions[i];
            data.add(current);
        }
        return data;
    }

}
