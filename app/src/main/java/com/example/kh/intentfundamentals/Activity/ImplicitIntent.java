package com.example.kh.intentfundamentals.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.kh.intentfundamentals.Module.Person;
import com.example.kh.intentfundamentals.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImplicitIntent extends AppCompatActivity {
    @BindView(R.id.txtImplicitIntent)
    TextView txtImplicitIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
       ArrayList<Person> arrayList= intent.getParcelableArrayListExtra("list");
        txtImplicitIntent.setText(arrayList.get(0).getName());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
