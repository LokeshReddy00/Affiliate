package com.buddies.affiliate.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buddies.affiliate.Model.OfferModel;
import com.buddies.affiliate.Model.SliderModel;
import com.buddies.affiliate.R;
import com.buddies.affiliate.WebActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.Holder> {

    Context context;
    ArrayList<OfferModel> arrayList;

    public OfferAdapter(Context context, ArrayList<OfferModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offerlay,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        OfferModel model = arrayList.get(position);

        try {
            Picasso.get().load(model.getBanner()).placeholder(R.drawable.shopping).into(holder.image);
        }catch (Exception e){
            holder.image.setImageResource(R.drawable.logo);
        }
        holder.code.setText("Code: "+model.getCode());
        holder.info.setText(model.getInfo());
        holder.percent.setText(model.getPercent());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("cat",model.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {

        TextView percent,info,code;
        LinearLayout linearLayout5;
        ImageView image;

        public Holder(@NonNull View itemView) {
            super(itemView);

            percent = itemView.findViewById(R.id.percent);
            info = itemView.findViewById(R.id.info);
            image = itemView.findViewById(R.id.image);
            code = itemView.findViewById(R.id.code);
            linearLayout5 = itemView.findViewById(R.id.linearLayout5);

        }
    }
}
