package com.adgvit.iosfusion2017;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView arrow;
    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
        arrow = (ImageView) findViewById(R.id.arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* add if case
                if authenticated, intent should go to NavDraActivity rather than QrActivity */
                Intent intent = new Intent(MainActivity.this, QrActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public class LearnGesture extends GestureDetector.SimpleOnGestureListener {

        //SimpleGestureListener is the listener for what type of swipe we want

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
            if(event2.getY() < event1.getY()) {
                //down to up swipe
                Intent in = new Intent(MainActivity.this, QrActivity.class);
                startActivity(in);
            }
            else if(event2.getY() > event1.getY()) {
                //up to down swipe
            }
            return true;
        }
    }
}
