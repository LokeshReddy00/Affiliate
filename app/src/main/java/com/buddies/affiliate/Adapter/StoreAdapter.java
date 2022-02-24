package com.buddies.affiliate.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buddies.affiliate.Model.StoreModel;
import com.buddies.affiliate.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.Holder> {

    Context context;
    ArrayList<StoreModel> arrayList;

    public StoreAdapter(Context context, ArrayList<StoreModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_row, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        StoreModel model = arrayList.get(position);

        holder.name.setText(model.getStore());
        holder.shop_name.setText(model.getLocation());

        Picasso.get().load(model.getImg()).into(holder.image);

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: " + model.getCall()));
                context.startActivity(callIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView image,call;
        TextView name, shop_name;

        public Holder(@NonNull View itemView) {
            super(itemView);

            shop_name = itemView.findViewById(R.id.shop_name);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            call = itemView.findViewById(R.id.call);
        }
    }
}
