package com.slipquack.taxiuser.recycler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.slipquack.taxiuser.R;
import com.slipquack.taxiuser.model.Artist;
import com.slipquack.taxiuser.rent.FullActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by Alex on 13.12.2017.
 */

//адаптер для RecyclerView
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {



    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView genres;
        //TextView tracks;
        ImageView small;
        TextView price;

        PersonViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            genres = (TextView)itemView.findViewById(R.id.genres);
            //tracks = (TextView)itemView.findViewById(R.id.tracks);
            small = (ImageView)itemView.findViewById(R.id.imgSmall);
            price = (TextView)itemView.findViewById(R.id.price);
        }


    }

    Artist[] persons;
    Activity main;
    Context context;
    Intent intent;

    public RVAdapter(Activity main,Context context, Artist[] persons){
        this.persons = persons;
        this.main = main;
        this.context = context;
        intent = new Intent(context, FullActivity.class);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        return new PersonViewHolder(v);
    }



    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.name.setText(persons[i].getName());
        personViewHolder.genres.setText(persons[i].style());
        personViewHolder.price.setText(persons[i].getPrice());
        //personViewHolder.tracks.setText(persons[i].music());
        Picasso.with(context)
                .load(persons[i].getCover().getSmall())
                .into(personViewHolder.small);
    }

    @Override
    public int getItemCount() {
        return persons.length;
    }


}