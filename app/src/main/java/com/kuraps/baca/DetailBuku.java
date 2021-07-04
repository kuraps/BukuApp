package com.kuraps.baca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetailBuku extends AppCompatActivity {
    int Click = 0;
    ImageView back,fav;
    ImageView cover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        back=findViewById(R.id.back);
        fav=findViewById(R.id.fav);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cover = (ImageView) findViewById(R.id.imageView2); // init a ImageView
        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        cover.setImageResource(intent.getIntExtra("cover", 0)); // get image from Intent and set it in ImageView

    }
}