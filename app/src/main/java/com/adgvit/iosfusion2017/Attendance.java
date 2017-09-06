package com.adgvit.iosfusion2017;


import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Attendance extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attendancelayout, container, false);
        SharedPreferences sp = getContext().getSharedPreferences("key", 0);

        String partname = sp.getString("Name", "");
        String partreg = sp.getString("Reg_Num", "");
        TextView textView= (TextView) rootView.findViewById(R.id.qrpname);
        textView.setText(partname);
        TextView textView2= (TextView) rootView.findViewById(R.id.qrpreg);
        textView2.setText(partreg);
        Animation anim= AnimationUtils.loadAnimation(getContext(),R.anim.move);
        rootView.startAnimation(anim);

        ImageView imageView= (ImageView) rootView.findViewById(R.id.qr1);
        String prevEncodedImage=sp.getString("attendance","");
        if(!prevEncodedImage.equalsIgnoreCase("")){
            byte[] b= Base64.decode(prevEncodedImage,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(b,0,b.length);
            imageView.setImageBitmap(bitmap);
        }
        return rootView;
    }
}
