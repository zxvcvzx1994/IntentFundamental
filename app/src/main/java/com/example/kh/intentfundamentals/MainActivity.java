package com.example.kh.intentfundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.kh.intentfundamentals.Activity.MyActivity;
import com.example.kh.intentfundamentals.Module.Person;

import java.sql.Date;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Intent intent, intentImplicit;
    private java.util.Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        intent = new Intent(this, MyActivity.class);
        intent.putExtra("vo", "This is my teachs");
       // DateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
       date = Date.valueOf("2017-02-12");
        Log.i(TAG, "onCreate: "+String.valueOf(date));
        Person p  =  new Person("vo",21, date);
        intent.putExtra("person", p );

        intentImplicit = new Intent();
        intentImplicit.setAction("com.example.intent");
        intentImplicit.addCategory(Intent.CATEGORY_DEFAULT);
        ArrayList<Person> arrayList = new ArrayList<Person>();
        arrayList.add(new Person("vo",21, date));
        arrayList.add(new Person("vo1",221, date));
        arrayList.add(new Person("vo2",231, date));
        intentImplicit.putParcelableArrayListExtra("list", arrayList);
    }

    @OnClick(R.id.btnActivity2)
    public void btnActivity2(){
        startActivity(intent);
    }

    @OnClick(R.id.btnIntentImplicit)
    public void btnIntentImplicit(){
        startActivity(intentImplicit);
    }
}
