package com.example.datting.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datting.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class PeopleAdapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<People> p;
    Context c;

    public PeopleAdapter(ArrayList<People> p, Context c) {
        this.c = c ;
        this.p = p;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.custom_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final People people = p.get(position);

//        holder.img1.setImageResource(people.getImage());
        Glide.with(c).load(people.getImage()).into(holder.img1);
        holder.name1.setText(people.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(c, R.style.BottomSheetDialogTheme);
                View botton = LayoutInflater.from(c).inflate(R.layout.items_sheets_dialog, (LinearLayout) view.findViewById(R.id.bottonSheets));

                RoundedImageView itemImage;
                TextView itemName, itemCity, itemAge;

                itemCity = botton.findViewById(R.id.item_city);
                itemAge = botton.findViewById(R.id.item_age);
                itemImage = botton.findViewById(R.id.item_image);
                itemName = botton.findViewById(R.id.item_name);

                itemAge.setText(String.valueOf(people.getAge()));
                itemCity.setText(people.getAdress());
                itemImage.setImageResource(people.getImage());
                itemName.setText(people.getName());
                bottomSheetDialog.setContentView(botton);
                bottomSheetDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return p.size();
    }
}
