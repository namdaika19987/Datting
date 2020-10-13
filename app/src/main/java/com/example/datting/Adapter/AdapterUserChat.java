package com.example.datting.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datting.Model.UserChat;
import com.example.datting.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterUserChat extends RecyclerView.Adapter<AdapterUserChat.ViewHolder> {

    ArrayList<UserChat> userChats;
    Context c;

    public AdapterUserChat (ArrayList<UserChat> userChats, Context c){
        this.userChats = userChats;
        this.c = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycker_framechat_user_chat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final UserChat people = userChats.get(position);
        holder.tv_name.setText(userChats.get(position).getNameUserChat());
        holder.tv_text.setText(userChats.get(position).getTextUserChat());
        holder.tv_time.setText(userChats.get(position).getTimeUserChat());
        holder.tv_number.setText(userChats.get(position).getNumberUserChat());

//        holder.civ_image.setImageResource(userChats.get(position).getImgUserChat());
//        holder.cim_chamXanh.setImageResource(userChats.get(position).getImgChamXanh());

        //Xử dụng Glide để hiển thị ảnh do ảnh nặng
        //Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);
        Glide.with(c).load(userChats.get(position).getImgUserChat()).into(holder.civ_image);
        Glide.with(c).load(userChats.get(position).getImgChamXanh()).into(holder.cim_chamXanh);

        //tạo sự kiện click để chat
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c, MessChat.class);
                intent.putExtra("image", people.getImgUserChat());
                intent.putExtra("name", people.getNameUserChat());
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userChats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView civ_image, cim_chamXanh;
        TextView tv_name, tv_text, tv_time, tv_number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            civ_image = itemView.findViewById(R.id.civ_image);
            cim_chamXanh = itemView.findViewById(R.id.cim_chamXanh);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_text = itemView.findViewById(R.id.tv_text);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_number = itemView.findViewById(R.id.tv_number);
        }
    }
}
