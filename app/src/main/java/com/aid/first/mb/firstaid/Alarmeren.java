package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by M.B on 24-11-2014.
 */
public class Alarmeren extends MoederClass {TextView tekst;
    ImageButton knop;
    Intent intent,  lokatie;
    String string;
    AlertDialog dialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.alarmeren);

        tekst = (TextView)findViewById(R.id.text);
        knop =(ImageButton)findViewById(R.id.knop_pijl_rechts);

        string = getResources().getString(R.string.alarmeren);
        tekst.setText(string);
        intent = new Intent(Alarmeren.this,NoodTransport.class );

        lokatie = new Intent(Alarmeren.this, Lokatie.class);


    }

    public void knopVolgende(View v) {
   
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle(getResources().getString(R.string.nektitel));
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        dialog.setMessage(getResources().getString(R.string.wel_of_geen_trauma));


        dialog.setCancelable(false);



        dialog.setButton(DialogInterface.BUTTON_POSITIVE, getResources().getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Intent intent = new Intent(getApplicationContext(), Nek.class);
                        Volgende(intent);

                    }
                });
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, getResources().getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {

                        Volgende(intent);

                    }
                });


        dialog.show();
        //terugknop();


    }

    public void telefoon(View v){
        boolean isOk = true;
        Intent intent = new Intent();

        if (!deviceIsAPhone()) {
            displayAlert();
            isOk = false;
        }
        if (isOk) {
            intent.setAction(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(getResources().getString(R.string.telefoonnummer)));
            startActivity(intent);
        }


    }

    public void waarBenIk(View v){
        Volgende(lokatie);

    }

    public void schrijfString(String string){
        tekst.setText(string);



    }

    public void Volgende(Intent intent){

        startActivity(intent);

    }




}