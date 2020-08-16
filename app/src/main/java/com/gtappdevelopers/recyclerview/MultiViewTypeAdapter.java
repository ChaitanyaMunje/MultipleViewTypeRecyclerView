package com.gtappdevelopers.recyclerview;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MultiViewTypeAdapter extends RecyclerView.Adapter {

    private ArrayList<Model> dataSet;
    Context mContext;
    int total_types;
    MediaPlayer mPlayer;
    private boolean fabStateVolume = false;

    public MultiViewTypeAdapter(ArrayList<Model>data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_type, parent, false);
                return new TextTypeViewHolder(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_type, parent, false);
                return new ImageTypeViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Model object = dataSet.get(position);
        if (object != null) {
            switch (object.type) {
                case 1:
                    ((TextTypeViewHolder) holder).txtType.setText(object.getMessage());

                    break;
                case 2:
                    ((ImageTypeViewHolder) holder).txtType.setText(object.getName());
                    Picasso.get().load(object.getUrl()).into(((ImageTypeViewHolder) holder).image);
                    //((ImageTypeViewHolder) holder).image.setImageResource(object.getImg());
                   // ((ImageTypeViewHolder)holder).image
                    break;


            }
        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();

    }

    @Override
    public int getItemViewType(int position) {
        switch (dataSet.get(position).type) {
            case 1:
                return 1;
            case 2:
                return 2;

            default:
                return -1;
        }
    }
    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {

        TextView txtType;
        CardView cardView;

        public TextTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {

        TextView txtType;
        ImageView image;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.image = (ImageView) itemView.findViewById(R.id.background);
        }
    }


}
