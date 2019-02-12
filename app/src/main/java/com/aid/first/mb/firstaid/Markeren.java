package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by M.B on 24-11-2014.
 */
public class Markeren extends MoederClass {TextView tekst;
    ImageButton knop;
    Intent intent;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.andermans_veiligheidxml);

        tekst = (TextView)findViewById(R.id.text);
        knop =(ImageButton)findViewById(R.id.knop_pijl_rechts);

        string = getResources().getString(R.string.markeren);
        tekst.setText(string);
        intent = new Intent(Markeren.this,Alarmeren.class );


    }

    public void knopVolgende(View v) {
        Volgende(intent);

    }
    public void schrijfString(String string){
        tekst.setText(string);



    }

    public void Volgende(Intent intent){

        startActivity(intent);

    }
}