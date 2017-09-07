package com.adgvit.iosfusion2017;


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<ForumModel> {
    public MessageAdapter(Context context, int resource, List<ForumModel> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.forum_row_layout, parent, false);
        }
        TextView messageTextView = (TextView) convertView.findViewById(R.id.ques);

        ForumModel message = getItem(position);
        messageTextView.setText(message.getQuestion());
        return convertView;
    }
}
