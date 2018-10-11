package com.example.samriti.userinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class first extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    public void connectwith(View view){
        Intent intent=new Intent(first.this,connect.class);
        startActivity(intent);
    }
    public void ho(View view){
        Intent intent=new Intent(first.this,home.class);
        startActivity(intent);
    }
    public void steps(View view){
        Intent intent=new Intent(first.this,stepscount.class);
        startActivity(intent);
    }
    public void he(View view){
        Intent i= new Intent(first.this,help.class);
        startActivity(i);
    }
}
