package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Nek extends MoederClass {
    TextView Nek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nek);
        Nek = (TextView)findViewById(R.id.tvNekKlachten);
        Nek.setText(getResources().getString(R.string.nek));
    }




    public void knopVolgende(View v){
        Intent intent = new Intent(this, NoodTransport.class);
        Volgende(intent);

    }


}
