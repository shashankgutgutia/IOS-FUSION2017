package com.adgvit.iosfusion2017;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Attendance extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attendancelayout, container, false);
        String partname=MainActivity.name;
        String partreg=MainActivity.regno;
        TextView textView= (TextView) rootView.findViewById(R.id.qrpname);
        textView.setText(partname);
        TextView textView2= (TextView) rootView.findViewById(R.id.qrpreg);
        textView2.setText(partreg);
        return rootView;
    }

}
