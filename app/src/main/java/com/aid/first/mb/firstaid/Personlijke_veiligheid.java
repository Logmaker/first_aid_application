package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Personlijke_veiligheid extends MoederClass {

    TextView tekst;
    ImageButton knop;
    Intent intent,getintent;
    String string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personlijke_veiligheid);
        xmlInt();
        getintent = getIntent();
        if(getintent.getIntExtra("sluiten",0) == 1){
            onBackPressed();
        }
        //string = getResources().getString(R.string.eigen_veiligheid);
        tekst.setText(getResources().getString(R.string.eigen_veiligheid));
        intent = new Intent(this,AnderMans_Veiligheid.class );


    }



    public void xmlInt(){
        //TextView tekst;
        tekst = (TextView)findViewById(R.id.text);
        knop =(ImageButton)findViewById(R.id.knop_pijl_rechts);

    }
    public void knopVolgende(View v){
        Volgende(intent);

    }


}
