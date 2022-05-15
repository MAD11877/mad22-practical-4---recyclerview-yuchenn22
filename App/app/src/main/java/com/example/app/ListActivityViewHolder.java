package com.example.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListActivityViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView description;
    ImageView image;
    public ListActivityViewHolder(View viewItem){
        super(viewItem);
        name=viewItem.findViewById(R.id.NameLayout);
        description=viewItem.findViewById(R.id.DescriptionLayout);
        image=viewItem.findViewById(R.id.LogoLayout);
    }
}
