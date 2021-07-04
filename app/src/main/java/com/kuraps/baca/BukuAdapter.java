package com.kuraps.baca;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.viewHolder> {

    Context context;
    ArrayList<BukuModel> arrayList;
    private final int limit = 100;

    public BukuAdapter(Context context, ArrayList<BukuModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public  BukuAdapter.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.buku_adapter, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public  void onBindViewHolder(BukuAdapter.viewHolder viewHolder,int position) {
        viewHolder.img_cover.setImageResource(arrayList.get(position).getImageCover());
        viewHolder.img_fav.setImageResource(arrayList.get(position).getImageFav());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                Intent intent = new Intent(context, DetailBuku.class);
                intent.putExtra("cover", arrayList.get(position).getImageCover()); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });
    }

    @Override
    public int getItemCount() {
        if(arrayList.size() > limit){
            return limit;
        }
        else
        {
            return arrayList.size();
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView img_cover;
        ImageView img_fav;

        public viewHolder(View itemView) {
            super(itemView);
            img_cover = (ImageView) itemView.findViewById(R.id.cover_buku);
            img_fav = (ImageView) itemView.findViewById(R.id.cover_fav);

        }
    }

}
