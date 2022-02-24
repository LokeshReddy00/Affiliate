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

import com.buddies.affiliate.Model.IconModel;
import com.buddies.affiliate.R;
import com.buddies.affiliate.WebActivity;
import com.google.android.material.transition.Hold;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.Holder> {


    Context context;
    ArrayList<IconModel> models;

    public IconAdapter(Context context, ArrayList<IconModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_row, parent, false);

        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.icon_txt.setText(models.get(position).getName());
        try {
            Picasso.get().load(models.get(position).getIcon()).placeholder(R.drawable.logo).into(holder.icon);
        }catch (Exception e){
            holder.icon.setImageResource(R.drawable.logo);

        }

        String cat = models.get(position).getUrl();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("cat",cat);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView icon_txt;

        public Holder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            icon_txt = itemView.findViewById(R.id.icon_txt);

        }
    }
}
