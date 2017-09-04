package com.adgvit.iosfusion2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Wifi extends Fragment {

    public TextView WifiUserName, WifiPassWord, info, user, pass;
    public Button getDetails;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wifilayout, container, false);
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
                WifiUserName.setVisibility(View.VISIBLE);
                WifiPassWord.setVisibility(View.VISIBLE);
                info.setVisibility(View.VISIBLE);
                user.setVisibility(View.VISIBLE);
                pass.setVisibility(View.VISIBLE);
                getDetails.setVisibility(View.INVISIBLE);
            }
        });

        //GET function
        //Replace both UserName and PassWord using Retrofit
        return rootView;
    }
}
