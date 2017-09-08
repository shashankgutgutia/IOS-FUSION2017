package com.adgvit.iosfusion2017;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class TrendingFragment extends android.support.v4.app.Fragment {

    public RecyclerView recyclerView;
    public ForumRecyclerAdapter adapter;
    public SwipeRefreshLayout mSwipeRefreshLayout;
//    public String count;
    public String parname,parreg;
    public int counter = 0;
    public List<ForumItem> list1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_trending, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.trendingRecycler);
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.trending_swipe);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Send new GET request to server
            }
        });
        SharedPreferences sp = getContext().getSharedPreferences("key", 0);
        parname = sp.getString("Name", "");
        parreg = sp.getString("Reg_Num", "");
        list1=new ArrayList<>();
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(getActivity());
            }

        });
        return rootView;
    }
    private void showPopup(FragmentActivity context) {
        LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.forum_question);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.forum_question, viewGroup);

        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        int OFFSET_X = 30;
        int OFFSET_Y = 30;
        popup.setWidth(600);
        popup.setHeight(600);
        popup.setFocusable(true);
        popup.showAtLocation(layout, Gravity.CENTER ,50, 50);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Forum");

        final EditText question = (EditText) layout.findViewById(R.id.question);
        Button button = (Button) layout.findViewById(R.id.forum_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ques = question.getText().toString();
                String regno=parreg,name = parname,verified;
                verified = "no";
                final String[] count = new String[1];
                final ForumModel forum = new ForumModel(name,regno,verified,ques); // count to be added


                myRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                        count = String.valueOf(dataSnapshot.getChildrenCount());
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                myRef.push().setValue(forum);
                ForumItem fitem=new ForumItem(ques);
                list1.add(fitem);
                adapter = new ForumRecyclerAdapter(getActivity(),list1);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                popup.dismiss();
            }

        });
    }

}
