package com.adgvit.iosfusion2017;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

public class Refreshments extends Fragment {

    private RecyclerView recyclerView;
    private RefreshmentsRecyclerAdapter adapter;
    Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.refreshments, container, false);
        SharedPreferences sp = getContext().getSharedPreferences("key", 0);
        String prevEncodedImage=sp.getString("refreshment","");
        if(!prevEncodedImage.equalsIgnoreCase("")){
            byte[] b= Base64.decode(prevEncodedImage,Base64.DEFAULT);
            bitmap= BitmapFactory.decodeByteArray(b,0,b.length);
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.refreshments_recycler);
        adapter = new RefreshmentsRecyclerAdapter(getContext(), getData(),bitmap);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        Animation anim= AnimationUtils.loadAnimation(getContext(),R.anim.move);
        view.startAnimation(anim);

        return view;
    }

    public List<RefreshmentItem> getData() {
        List<RefreshmentItem> data = new ArrayList<>();
        String[] ref = {"Refreshments 1", "Refreshments 2"};
        for(int i = 0; i < ref.length; i++) {
            RefreshmentItem current = new RefreshmentItem();
            current.refreshmentType = ref[i];
            data.add(current);
        }
        return data;
    }
}
