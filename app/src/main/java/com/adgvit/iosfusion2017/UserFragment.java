package com.adgvit.iosfusion2017;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment {

    private RecyclerView recyclerView;
    public MessageAdapter adapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    public FirebaseDatabase mFirebaseDatabse;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListener;
    public List<ForumModel> Messages;
    public SharedPreferences sp;
    String partreg;

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
        mFirebaseDatabse=FirebaseDatabase.getInstance();
        mMessagesDatabaseReference=mFirebaseDatabse.getReference().child("Forum");
        Messages = new ArrayList<>();
        sp = getContext().getSharedPreferences("key", 0);
        partreg = sp.getString("Reg_Num", "");
        attachDatabaseReadListener();
        adapter=new MessageAdapter(getActivity(),Messages);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    private void attachDatabaseReadListener(){
        if(mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    ForumModel forumModel = dataSnapshot.getValue(ForumModel.class);
                    //Condition to check which questions to be posted
                    Boolean b1= new String(forumModel.getVerified()).equals("Yes");
                    if(b1) {
                        Messages.add(forumModel);
                    }
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
            };
            mMessagesDatabaseReference.addChildEventListener(mChildEventListener);
        }
    }

    public void detachDatabaseReadListener(){
        if(mChildEventListener!=null) {
            mMessagesDatabaseReference.removeEventListener(mChildEventListener);
            mChildEventListener = null;
        }
    }

}
