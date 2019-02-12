package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Benauwt extends MoederClass{
    TextView benauwd, benauwd_baby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benauwt);
        benauwd = (TextView)findViewById(R.id.tvbenauwd);
        benauwd_baby=(TextView)findViewById(R.id.tvbenauwd_baby);
        benauwd.setText(getResources().getString(R.string.benauwd));
        benauwd_baby.setText(getResources().getString(R.string.benauwd_baby));
    }


   
    public void knopVolgende(View v){
        Intent intent = new Intent(this, Breating_bij_bewustzijn.class);
        Volgende(intent);

    }
}
