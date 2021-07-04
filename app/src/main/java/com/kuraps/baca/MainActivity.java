package com.kuraps.baca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<RekomendasiModel> arrayList;
    ArrayList<BukuModel> arrayList2;
    RecyclerView recyclerView,recyclerView2;
    int icon[] = {R.drawable.catatan_juang,R.drawable.five_cm,R.drawable.jalan};
    int icon_fav[] = {R.drawable.ic_baseline_favorite_border_24,R.drawable.ic_baseline_favorite_border_24,R.drawable.ic_baseline_favorite_border_24};

    int icon2[] = {R.drawable.kenali_agamamu,R.drawable.jalan,R.drawable.kuliah_penting,
            R.drawable.sukses,R.drawable.five_cm,R.drawable.catatan_juang};
    int icon_fav2[] = {R.drawable.ic_baseline_favorite_border_24,R.drawable.ic_baseline_favorite_border_24,R.drawable.ic_baseline_favorite_border_24,
            R.drawable.ic_baseline_favorite_border_24,R.drawable.ic_baseline_favorite_border_24,R.drawable.ic_baseline_favorite_border_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rekomendasi);
        arrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        for (int i = 0; i < icon.length; i++) {
            RekomendasiModel rekomendasiModel = new RekomendasiModel();
            rekomendasiModel.setImageCover(icon[i]);
            rekomendasiModel.setImageFav(icon_fav[i]);

            //add in array list
            arrayList.add(rekomendasiModel);
        }
        RekomendasiAdapter adapter = new RekomendasiAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

        recyclerView2 = (RecyclerView) findViewById(R.id.sorting);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        arrayList2 = new ArrayList<>();
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        for (int a = 0; a < icon2.length; a++) {
            BukuModel bukuModel = new BukuModel();
            bukuModel.setImageCover(icon2[a]);
            bukuModel.setImageFav(icon_fav2[a]);
            //add in array list
            arrayList2.add(bukuModel);
        }
        BukuAdapter adapter2 = new BukuAdapter(this, arrayList2);
        recyclerView2.setAdapter(adapter2);
    }

}