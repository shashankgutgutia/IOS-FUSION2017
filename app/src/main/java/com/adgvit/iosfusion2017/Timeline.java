package com.adgvit.iosfusion2017;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class Timeline extends Fragment {

    private String[] day={"Day 1","Day 1","Day 1","Day 1","Day 1","Day 1","Day 1","Day 1",
                          "Day 2","Day 2","Day 2","Day 2","Day 2","Day 2","Day 2","Day 2"};

    private String[] times={"3:15 pm","3:30 pm","4:00 pm","4:15 pm","4:45 pm","7:30 pm","8:30 pm","11:30 pm",
                            "11:15 am","11:30 am","12:00 pm","3:00 pm","3:30 pm","5:30 pm","6:00 pm","8:00 pm"};

    private String[] title={"Welcome to Ios Fusion","Reporting Time","Commencement","Inauguration","Speaker takes over","Refreshments","Workshop is Resumed","Wrap Up",
                            "Registration Desk Setup","Reporting Time","Workshop Resumes","Refreshments","Workshop Resumes","Break","Workshop Resumes","Workshop is Concluded"};

    private String[] details={"Registration Desks Setup","Reporting Time for Participants","Commencement of the Workshop","Inaugural address detailing chapter and its highlights","Step by step walk-through for the App Development process","The time arrives for relaxation: Refreshments are provided","Time to get back to Work","Pack your bags and head home",
                              "Registration Desks Setup","Reporting Time for Participants","The workshop resumes as we pick up from where we left off","Refreshments are provided","Get back to work as workshop continues","Take a break","The final session","Thanking you for participation. Hope to see you next year!"};

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    TimelineAdapter tAdaapter;
    ArrayList<TimelineItems> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.timelinelayout, container, false);
        recyclerView= (RecyclerView) rootView.findViewById(R.id.recycle);
        int count = 0;
        for(String Name: title)
        {
            arrayList.add(new TimelineItems(day[count],times[count],Name,details[count]));
            count++;
        }
        layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        tAdaapter=new TimelineAdapter(arrayList,getActivity());
        recyclerView.setAdapter(tAdaapter);
        Animation anim= AnimationUtils.loadAnimation(getContext(),R.anim.move2);
        rootView.startAnimation(anim);
        return rootView;
    }
}
