package com.example.datting.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.Adapter.AdapterChat;
import com.example.datting.Adapter.AdapterUserChat;
import com.example.datting.Model.User;
import com.example.datting.Model.UserChat;
import com.example.datting.R;

import java.util.ArrayList;

public class ChatFrame extends Fragment {
    private ArrayList<User> users = new ArrayList<>();
    ArrayList<UserChat> userChats = new ArrayList<>();
    RecyclerView recyclerViewUser;
    RecyclerView recyclerViewUserChat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.framechat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewUser = view.findViewById(R.id.rcv_user);
        recyclerViewUserChat = view.findViewById(R.id.rcv_userChat);

        addUser();
        addUserChat();
    }

    private void addUser() {
        users.add(new User(R.drawable.avt, "Crush"));
        users.add(new User(R.drawable.avt1, "Nam Anh"));
        users.add(new User(R.drawable.avt2, "Tuấn Thành"));
        users.add(new User(R.drawable.avt3, "Hương"));
        users.add(new User(R.drawable.avt4, "Tùng"));
        users.add(new User(R.drawable.avt15, "Su"));
        users.add(new User(R.drawable.avt6, "Long"));
        users.add(new User(R.drawable.avt7, "Trường"));
        users.add(new User(R.drawable.avt8, "Kiên"));
        initRecyclerViewUser();
    }

    private void initRecyclerViewUser() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewUser.setLayoutManager(layoutManager);
        AdapterChat adapter = new AdapterChat(users, getContext());
        recyclerViewUser.setAdapter(adapter);
    }

    private void addUserChat() {
        userChats.add(new UserChat(R.drawable.avt, R.drawable.cham_xanh, "Crush", "Su khủng long","30 phút" ,"1"));
        userChats.add(new UserChat(R.drawable.avt1, R.drawable.cham_xanh, "Đặng Thanh", "Hôm nay ăn gì vậy?","3 giờ" ,"1"));
        userChats.add(new UserChat(R.drawable.avt2, R.drawable.cham_xanh, "Thảo", "Thần thánh","5 giờ" ,"1"));
        userChats.add(new UserChat(R.drawable.avt3, R.drawable.cham_xanh, "Tùng", "Su khủng long","30 phút" ,"1"));
        userChats.add(new UserChat(R.drawable.avt4, R.drawable.cham_xanh, "Trường", "Hôm nay ăn gì vậy?","3 giờ" ,"1"));
        userChats.add(new UserChat(R.drawable.avt15, R.drawable.cham_xanh, "Long", "Thần thánh","5 giờ" ,"1"));
        userChats.add(new UserChat(R.drawable.avt6, R.drawable.cham_xanh, "Kiên", "Su khủng long","30 phút" ,"1"));
        userChats.add(new UserChat(R.drawable.avt7, R.drawable.cham_xanh, "Hà", "Hôm nay ăn gì vậy?","3 giờ" ,"1"));
        userChats.add(new UserChat(R.drawable.avt8, R.drawable.cham_xanh, "Cris Phan", "Thần thánh","5 giờ" ,"1"));
        initRecyclerViewUserChat();
    }

    private void initRecyclerViewUserChat() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewUserChat.setLayoutManager(layoutManager);
        AdapterUserChat adapter = new AdapterUserChat(userChats, getContext());
        recyclerViewUserChat.setAdapter(adapter);
    }
}
