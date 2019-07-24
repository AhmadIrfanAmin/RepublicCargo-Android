package com.logixcess.republiccargo.customer.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.logixcess.republiccargo.R;
import com.logixcess.republiccargo.customer.adapters.BoxAdapter;
import com.logixcess.republiccargo.customer.dialogs.box_add_dialog;
import com.logixcess.republiccargo.interfaces.SaveNewBox;
import com.logixcess.republiccargo.models.Box;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BoxesActivity extends AppCompatActivity implements SaveNewBox {
    FloatingActionButton fab_add_box;
    RecyclerView rv_boxes;
    ArrayList<Box> boxArrayList;
    BoxAdapter adapter;
    SaveNewBox snb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxes);
        fab_add_box = findViewById(R.id.fab_add_box);
        rv_boxes = findViewById(R.id.rv_boxes);
        boxArrayList = new ArrayList<>();
        snb = this;
        fab_add_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                box_add_dialog cdd = new box_add_dialog(BoxesActivity.this,snb);
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
            }
        });
        adapter = new BoxAdapter(BoxesActivity.this,boxArrayList);//flights);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(BoxesActivity.this);
        rv_boxes.setLayoutManager(mLayoutManager);
        rv_boxes.setItemAnimator(new DefaultItemAnimator());
        rv_boxes.setAdapter(adapter);
    }

    @Override
    public void addNewBox(Box box) {
        boxArrayList.add(box);
        adapter.notifyDataSetChanged();
    }
}

