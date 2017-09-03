package com.adgvit.iosfusion2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Speaker extends android.support.v4.app.Fragment implements View.OnClickListener{

    private ImageButton fb, git, linkedIn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.speaker_details, container, false);
        git = (ImageButton) rootView.findViewById(R.id.git);
        fb = (ImageButton) rootView.findViewById(R.id.fb);
        linkedIn = (ImageButton) rootView.findViewById(R.id.link);
        git.setOnClickListener(this);
        fb.setOnClickListener(this);
        linkedIn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.git:  Intent in = new Intent(Intent.ACTION_VIEW);
                            in.setData(Uri.parse("github.com/rishabh19038"));
                            startActivity(in);
                            break;
            case R.id.fb:   Intent in2 = new Intent(Intent.ACTION_VIEW);
                            in2.setData(Uri.parse("fb.com/rhmittal"));
                            startActivity(in2);
                            break;
            case R.id.link: Intent in3 = new Intent(Intent.ACTION_VIEW);
                            in3.setData(Uri.parse("https://www.linkedin.com/in/rishabh-mittal-492227114"));
                            startActivity(in3);
                            break;
        }
    }
}
