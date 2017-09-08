package com.adgvit.iosfusion2017;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.Viewholder> {

    LayoutInflater inflater;
    List<ForumModel> data = new ArrayList<>();

    public MessageAdapter(Context context, List<ForumModel> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MessageAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.forum_row_layout, parent, false);
        Viewholder viewholder=new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(MessageAdapter.Viewholder holder, int position) {
        ForumModel forumModel=data.get(position);
        holder.parques.setText(forumModel.getQuestion());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView parques;

        public Viewholder(View itemView) {
            super(itemView);
            parques = (TextView) itemView.findViewById(R.id.ques);
        }
    }
}
