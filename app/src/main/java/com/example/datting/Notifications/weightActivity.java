package com.example.datting.Notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.datting.R;

public class weightActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView tvSeekBar;
    ImageView imgAccumulate, close;
    Button btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        initView();
        seekBar.setMax(100);
        seekBar.setProgress(50);
        tvSeekBar.setText(seekBar.getProgress() + " kg");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //get value when progress change(nhận giá trị khi tiến độ thay đổi)
                progressChangedValue = progress;
                tvSeekBar.setText(progressChangedValue + " kg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //handle when stop tracking touch
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initView()
    {
        seekBar.findViewById(R.id.seekBar);
        tvSeekBar.findViewById(R.id.tv_seekbar);
        imgAccumulate.findViewById(R.id.img_tichVe);
        btnSkip.findViewById(R.id.bt_skip);
        close = findViewById(R.id.img_close);
    }
}