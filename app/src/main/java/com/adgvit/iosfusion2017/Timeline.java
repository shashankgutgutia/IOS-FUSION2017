package com.adgvit.iosfusion2017;


import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Timeline extends Fragment {

    private String[] day={"Day 1","Day 1","Day 1","Day 1","Day 1","Day 1","Day 1","Day 1",
                          "Day 2","Day 2","Day 2","Day 2","Day 2","Day 2","Day 2","Day 2"};

    private String[] times={"3:15 pm","3:30 pm","4:00 pm","4:15 pm","4:45 pm","7:30 pm","8:30 pm","11:30 pm",
                            "3:15 pm","3:30 pm","4:00 pm","4:15 pm","4:45 pm","7:30 pm","8:30 pm","11:30 pm"};

    private String[] title={"Welcome to Ios Fusion","Reporting Time","Commencement","Inauguration","Speaker takes over","Refreshments","Workshop is Resumed","Wrap Up",
                            "Registration Desk Setup","Reporting Time","Workshop Resumes","Refreshments","Workshop Resumes","Break","Workshop Resumes","Workshop is Concluded"};

    private String[] details={"Registration Desks Setup","Reporting Time for Participants","Commencement of the Workshop","Inaugural address detailing chapter and its highlights","Step by step walk-through for the App Development process","The time arrives for relaxation: Refreshments are provided","Time to get back to Work","Pack your bags and head home",
                              "Registration Desks Setup","Reporting Time for Participants","The workshop resumes as we pick up from where we left off","Refreshments are provided","Get back to work as workshop continues","Take a break","The final session","Thanking you for participation. Hope to see you next year!"};

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    TimelineAdapter tAdaapter;
    ArrayList<TimelineItems> arrayList = new ArrayList<>();
    Bitmap bitmap1,bitmap2;
    public final static int QRcodeWidth = 500 ;
    SharedPreferences sp;
    String value;

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

    @Override
    public void onStart() {
        super.onStart();
        sp= getContext().getSharedPreferences("key", 0);
        value=sp.getString("attendance","");
        if(value.isEmpty()) {
            new ImageLoading().execute();
        }
    }

    class ImageLoading extends AsyncTask<Void,Void,Void> {

        ProgressDialog progressDialog=new ProgressDialog(getActivity());


        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading...Please Wait");
            progressDialog.setTitle("Welcome to iOS Fusion!");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... params) {
            String partreg = sp.getString("Reg_Num", "");
            String attendance, refreshment;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String qrattend = partreg + "_attendance";
            String qrrefresh = partreg + "_refreshment";
            try {
                bitmap1 = TextToImageEncode(qrattend);
                bitmap1.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();
                attendance = Base64.encodeToString(b, Base64.DEFAULT);
                bitmap2 = TextToImageEncode(qrrefresh);
                bitmap2.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] c = baos.toByteArray();
                refreshment = Base64.encodeToString(c, Base64.DEFAULT);
                SharedPreferences.Editor sedt1 = sp.edit();
                sedt1.putString("attendance", attendance);
                sedt1.putString("refreshment", refreshment);
                sedt1.apply();

            } catch (WriterException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ? ContextCompat.getColor(getContext(),R.color.QRCodeBlack):ContextCompat.getColor(getContext(),R.color.colorWhite);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }
}
