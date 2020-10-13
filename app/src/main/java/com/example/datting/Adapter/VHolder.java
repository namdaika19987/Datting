package com.example.datting.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.datting.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class VHolder extends RecyclerView.ViewHolder {
    CircleImageView civ_image, cim_chamXanh;
    TextView tv_name, tv_text, tv_time, tv_number;


    public VHolder(@NonNull View itemView) {
        super(itemView);
        civ_image = itemView.findViewById(R.id.civ_image);
        cim_chamXanh = itemView.findViewById(R.id.cim_chamXanh);
        tv_name = itemView.findViewById(R.id.tv_name);
        tv_text = itemView.findViewById(R.id.tv_text);
        tv_time = itemView.findViewById(R.id.tv_time);
        tv_number = itemView.findViewById(R.id.tv_number);
    }

    public class ViewHolder {
    }
}
