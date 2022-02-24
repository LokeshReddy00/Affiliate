package com.buddies.affiliate.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buddies.affiliate.Model.AppsModel;
import com.buddies.affiliate.R;
import com.buddies.affiliate.WebActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.Holder> {

    Context context;
    ArrayList<AppsModel> arrayList;

    public AppAdapter(Context context, ArrayList<AppsModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.apps_row,parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        AppsModel model = arrayList.get(position);

        Picasso.get().load(model.getIcon()).into(holder.aps);
        holder.name.setText(model.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(context, WebActivity.class);
                i.putExtra("url","model.getUrl()");
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView aps;
        TextView name;

        public Holder(@NonNull View itemView) {
            super(itemView);

            aps = itemView.findViewById(R.id.aps);
            name = itemView.findViewById(R.id.name);
        }
    }
}
