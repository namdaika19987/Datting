package com.example.datting.Meet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datting.Model.Meet;
import com.example.datting.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MeetAdapter extends RecyclerView.Adapter<MeetAdapter.ViewHolder> {

    private ArrayList<Meet> meets;
    Context c;

    public ArrayList<Meet> getMeets() {
        return meets;
    }

    public void setMeets(ArrayList<Meet> meets){
        this.meets = meets;
    }

    public MeetAdapter(ArrayList<Meet> meets, Context c) {
        this.meets = meets;
        this.c = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.setData(meets.get(position));

        //Chế độ xem setVisibility (GONE) trở nên vô hình
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.layout.setVisibility(View.GONE);
            }
        });
        //========================================================
    }


    @Override
    public int getItemCount() {
        return meets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        CardView cardView;
        LinearLayout layout;
        TextView name, usia, kota;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.item_name);
            usia = itemView.findViewById(R.id.item_age);
            kota = itemView.findViewById(R.id.item_city);
            cardView = itemView.findViewById(R.id.item_card);
            layout = itemView.findViewById(R.id.layout);
        }

        public void setData(Meet meet){
            Glide.with(c).load(meet.getImage()).into(img);
//            Picasso.get()
//                    .load(meet.getImage())
//                    .fit()
//                    .centerCrop()
//                    .into(img);
            name.setText(meet.getName());
            usia.setText(meet.getAge());
            kota.setText(meet.getAdress());
        }
    }
}
