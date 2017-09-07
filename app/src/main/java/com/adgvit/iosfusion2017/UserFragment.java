package com.adgvit.iosfusion2017;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment {

    private RecyclerView recyclerView;
    private MessageAdapter mMessageAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    public FirebaseDatabase mFirebaseDatabse;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListener;

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
//        // Inflate the layout for this fragment
        mFirebaseDatabse=FirebaseDatabase.getInstance();
        mMessagesDatabaseReference=mFirebaseDatabse.getReference().child("Forum");
        List<ForumModel> friendlyMessages = new ArrayList<>();
//        mMessageAdapter = new MessageAdapter(getContext(), R.layout.forum_row_layout, friendlyMessages);
//        recyclerView.setAdapter(mMessageAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

//    private void attachDatabaseReadListener(){
//        if(mChildEventListener == null) {
//            mChildEventListener = new ChildEventListener() {
//                @Override
//                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                    FriendlyMessage friendlyMessage = dataSnapshot.getValue(FriendlyMessage.class);
//                    mMessageAdapter.add(friendlyMessage);
//                }
//
//                @Override
//                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                }
//
//                @Override
//                public void onChildRemoved(DataSnapshot dataSnapshot) {
//                }
//
//                @Override
//                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//                }
//            };
//            mMessagesDatabaseReference.addChildEventListener(mChildEventListener);
//        }
//    }
//
//    public void detachDatabaseReadListener(){
//        if(mChildEventListener!=null) {
//            mMessagesDatabaseReference.removeEventListener(mChildEventListener);
//            mChildEventListener = null;
//        }
//    }

}
