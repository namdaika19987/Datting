package com.example.datting.Home;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public CircleImageView img1;
    public TextView name1;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        img1 = itemView.findViewById(R.id.image_home);
        name1 = itemView.findViewById(R.id.name_home);
    }
}
