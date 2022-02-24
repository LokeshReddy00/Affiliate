package com.buddies.affiliate.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buddies.affiliate.Model.SliderModel;
import com.buddies.affiliate.R;
import com.buddies.affiliate.WebActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapters extends RecyclerView.Adapter<Adapters.ViewHoldre> {

    Context context;
    ArrayList<SliderModel> arrayList;

    public Adapters(Context context, ArrayList<SliderModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHoldre onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slider_item,parent,false);
        return new ViewHoldre(view);
    }

    @Override
    public void onBindViewHolder(ViewHoldre viewHolder, int position) {

        SliderModel model = arrayList.get(position);

        Picasso.get().load(arrayList.get(position).getPoster()).into(viewHolder.imageView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("url",model.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class ViewHoldre extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHoldre(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);

        }
    }
}
