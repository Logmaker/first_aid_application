package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.aid.first.mb.firstaid.R;

/**
 * Created by M.B on 20-11-2014.
 */
public class AnderMans_Veiligheid extends MoederClass{

    TextView tekst;
    ImageButton knop;
    Intent intent;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    setContentView(R.layout.andermans_veiligheidxml);

        tekst = (TextView)findViewById(R.id.text);
        knop =(ImageButton)findViewById(R.id.knop_pijl_rechts);

        string = getResources().getString(R.string.andermans_veiligheid);
        tekst.setText(string);
        intent = new Intent(AnderMans_Veiligheid.this,Markeren.class );


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



