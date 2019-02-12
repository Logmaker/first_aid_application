package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Airway extends MoederClass {
    TextView airway, mond;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airway);
        mond = (TextView)findViewById(R.id.tvkijk_in_de_mond);
        airway=(TextView)findViewById(R.id.tvairway);
        mond.setText(getResources().getString(R.string.mond));
        airway.setText(getResources().getString(R.string.airway));
        intent = new Intent(this,Breating.class);

    }
    public void knopVolgende(View v){
        Volgende(intent);

    }



}
