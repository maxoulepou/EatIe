package com.example.eatit.Fragment;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import com.example.eatit.Model.Objectifs;

public class ObjectifAtteintsViewHolder extends RecyclerView.ViewHolder {

    private TextView intitule;
    private ImageButton reiterer;


    public ObjectifAtteintsViewHolder(View itemView) {
        super(itemView);
        intitule = (TextView) itemView.findViewById(R.id.intitule);
        //reiterer = (ImageButton) itemView.findViewById(R.id.recommencerobj);

    }

    public void display(Objectifs pds) {
        intitule.setText(pds.getIntitule());
        //reiterer.setOnClickListener();
    }
}
