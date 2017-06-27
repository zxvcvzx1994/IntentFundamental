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

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyActivity extends AppCompatActivity {
    @BindView(R.id.txtText)
    TextView txtTExt;
    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtDate)
    TextView txtDate;
    @BindView(R.id.txtOld)
    TextView txtOld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String a = intent.getStringExtra("vo");
//        Person p  = (Person) intent.getParcelableExtra("person");
//        txtOld.setText(""+p.getOld());
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        String date = df.format(p.getDate());

      Person p = getIntent().getParcelableExtra("person");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      String date=  df.format(p.getDate());
          txtDate.setText(""+date);
        txtName.setText(""+p.getName());
        txtTExt.setText(""+a);
        txtOld.setText(""+p.getOld());
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
