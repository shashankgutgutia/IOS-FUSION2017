package com.adgvit.iosfusion2017;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RefreshmentsRecyclerAdapter extends RecyclerView.Adapter<RefreshmentsRecyclerAdapter.MyViewHolder> {

    LayoutInflater inflater;
    List<RefreshmentItem> data = new ArrayList<>();
    Bitmap bitmap;

    public RefreshmentsRecyclerAdapter(Context context, List<RefreshmentItem> data, Bitmap bitmap1) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.bitmap=bitmap1;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.refreshment_row_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RefreshmentItem current = data.get(position);
        holder.img.setImageBitmap(bitmap);
        holder.txt.setText(current.refreshmentType);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txt;

        public MyViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.refreshment_qr);
            txt = (TextView) itemView.findViewById(R.id.refreshment_type);
        }
    }
}
