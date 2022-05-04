package com.example.project3;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    View view;
    public Holder(@NonNull View itemView) {
        super(itemView);

        view = itemView;

    }

    public void setView(Context context, String question){

        TextView question_tv = view.findViewById(R.id.question_tv);

        question_tv.setText(question);

    }

}
