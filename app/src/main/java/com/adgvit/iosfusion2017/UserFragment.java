package com.adgvit.iosfusion2017;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment {

    private RecyclerView recyclerView;
    private ForumRecyclerAdapter adapter;
    private EditText doubt;
    private ImageButton Send;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.userRecycler);
        doubt = (EditText) rootView.findViewById(R.id.doubt);
        adapter = new ForumRecyclerAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Send = (ImageButton) rootView.findViewById(R.id.send);
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
        String[] questions = {"Yes this is a valid doubt if multiple lines are being supported or not if u can read this then it is being supported else it would not have been possible", "Yes this module is working", "Hopefully it is working"};
        for (int i = 0; i < questions.length; i++) {
            ForumItem current = new ForumItem();
            current.question = questions[i];
            data.add(current);
        }
        return data;
    }

}
