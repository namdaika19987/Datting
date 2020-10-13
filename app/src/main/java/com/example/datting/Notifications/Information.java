package com.example.datting.Notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datting.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Information extends AppCompatActivity {
    ImageView cancel;
    TextView buttonShow, buttonShow1, textView, name_info;
    LinearLayout height, weight, drink, smoke, language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_information);

        cancel = findViewById(R.id.cancel);
        buttonShow1 = findViewById(R.id.cong_viec);
        textView = findViewById(R.id.ve_ban);
        name_info = findViewById(R.id.name_info);
        height = findViewById(R.id.chieucao);
        weight = findViewById(R.id.cannang);
        drink = findViewById(R.id.ruoubia);
        smoke = findViewById(R.id.hutthuoc);
        language = findViewById(R.id.ngonngu);


        comback();

//      sử dụng bottomSheetDialog để xử lí màn hình ấn sự kiện kéo lên
        buttonShow = findViewById(R.id.buttonShow1);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Information.this);
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(R.layout.add_bottom_sheet_dialog, (LinearLayout) findViewById(R.id.bottomSheetContainer));
                bottomSheetView.findViewById(R.id.checkbox).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Information.this, "Thank you...", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
    }

    private void comback() {
        name_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information.this, AccountActivity.class));
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonShow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information.this, Academic_Work_Activity.class));
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information.this, About_You_Activity.class));
            }
        });

      height.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(Information.this, HeightActivity.class);
              startActivity(intent);
          }
      });

        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information.this, weightActivity.class));
            }
        });

        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information.this, DrinkActivity.class));
            }
        });

        smoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information.this, SmokingActivity.class));
            }
        });

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Information.this, LanguageActivity.class));
            }
        });
    }
}