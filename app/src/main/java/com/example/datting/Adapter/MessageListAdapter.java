package com.example.datting.Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.Model.BaseMessage;
import com.example.datting.R;

import java.util.ArrayList;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.ViewHolder> {

    private ArrayList<BaseMessage> mMessageList;
    Context c;

    public MessageListAdapter(ArrayList<BaseMessage> mMessageList, Context c) {
        this.mMessageList = mMessageList;
        this.c = c;
    }

    //xử lí chat gửi đi gửi về
    @Override
    public int getItemViewType(int position) {
        BaseMessage message = mMessageList.get(position);
        String user_name = message.getMessage();
        String deviceBuild = Build.USER;

        if (message.getMessage().contains(deviceBuild)) {
            // If the current user is the sender of the message
            return 0;
        } else {
            // If some other user sent the message
            return 1;
        }
    }

    //xử lí chat gửi đi và chat gửi về
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seft,parent, false);
            return new ViewHolder(view);
        } else
            if (viewType == 1){
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friends,parent, false);
                return new ViewHolder(view);
        }
            return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.messageText.setText(mMessageList.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView messageText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            messageText = (TextView) itemView.findViewById(R.id.message);
        }
    }
}
