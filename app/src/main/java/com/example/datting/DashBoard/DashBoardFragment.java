package com.example.datting.DashBoard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.datting.Home.CustomItemDecorator;
import com.example.datting.Home.People;
import com.example.datting.Home.PeopleAdapter;
import com.example.datting.R;

import java.util.ArrayList;

public class DashBoardFragment extends Fragment {

    ArrayList<People> p;
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ganday, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        data();

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.addItemDecoration(new CustomItemDecorator(16, 90));
        recyclerView.setLayoutManager(manager);

        PeopleAdapter ppAdapter = new PeopleAdapter(p, getContext());
        recyclerView.setAdapter(ppAdapter);
    }

    public void data(){
        p = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            p.add(new People("Hoài Nam", R.drawable.avt32, 18, "Hà Nội"));
            p.add(new People("Hồng Nhung", R.drawable.avt22, 18, "Thanh Xuân"));
            p.add(new People("Hiếu Thành", R.drawable.avt30, 18, "Đông Anh"));
            p.add(new People("Nam Anh", R.drawable.avt12, 18, "Hà Đông"));
            p.add(new People("Hoài Nam", R.drawable.avt32, 18, "Hà Nội"));
            p.add(new People("Hồng Nhung", R.drawable.avt22, 18, "Thanh Xuân"));
            p.add(new People("Hiếu Thành", R.drawable.avt30, 18, "Đông Anh"));
            p.add(new People("Nam Anh", R.drawable.avt12, 18, "Hà Đông"));
        }
    }
}
