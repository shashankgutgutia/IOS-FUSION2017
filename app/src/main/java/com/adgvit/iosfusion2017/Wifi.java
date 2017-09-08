package com.adgvit.iosfusion2017;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Wifi extends Fragment {

    public TextView WifiUserName, WifiPassWord, info, user, pass;
    public Button getDetails;
    public SharedPreferences sp;
    public String attendance, Reg_Num;
    public FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mDatabaseReference, myRef;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wifilayout, container, false);

        sp = getContext().getSharedPreferences("key", 0);
        SharedPreferences.Editor sedt = sp.edit();
        Reg_Num = sp.getString("Reg_Num", "");
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("Wifi").child(Reg_Num);
        myRef = mFirebaseDatabase.getReference().child("Attendance").child(Reg_Num);

        WifiUserName = (TextView) rootView.findViewById(R.id.id);
        WifiPassWord = (TextView) rootView.findViewById(R.id.password);
        info = (TextView) rootView.findViewById(R.id.info);
        user = (TextView) rootView.findViewById(R.id.user);
        pass = (TextView) rootView.findViewById(R.id.pass);
        getDetails = (Button) rootView.findViewById(R.id.getWifi);
        getDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* check if attendance has been noted
                    if done, show all text views, else keep invisible and show error
                 */
                attendance = sp.getString("attendance_status", "");

                if(attendance.equals("Yes")) {
                WifiUserName.setText(mDatabaseReference.child("PIN").getKey());
                WifiPassWord.setText(mDatabaseReference.child("User").getKey());
                WifiUserName.setVisibility(View.VISIBLE);
                WifiPassWord.setVisibility(View.VISIBLE);
                info.setVisibility(View.VISIBLE);
                user.setVisibility(View.VISIBLE);
                pass.setVisibility(View.VISIBLE);
                getDetails.setVisibility(View.INVISIBLE); }
                else {
                    Toast.makeText(getContext(), "Attendance has not been marked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //GET function
        //Replace both UserName and PassWord using Retrofit



        return rootView;
    }
}
