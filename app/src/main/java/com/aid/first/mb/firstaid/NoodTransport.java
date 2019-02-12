package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by M.B on 24-11-2014.
 */
public class NoodTransport extends MoederClass {
    TextView tekst;
    ImageButton knop;
    Intent intent;
    String string;
    AlertDialog dialog;
    View v;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.noodtransport);

        tekst = (TextView)findViewById(R.id.tvNoodtransport);
        knop =(ImageButton)findViewById(R.id.knop_pijl_rechts);

        string = getResources().getString(R.string.noodtransport);
        tekst.setText(string);
        Intent intent;
        intent = getIntent();

        if(intent.getIntExtra("VanafExposure",0) == 1){
            knopVolgende(v);
        }



    }

    public void knopVolgende(View v) {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle(getResources().getString(R.string.controleer_of_slachtoffer_bij_kennis_is));
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        dialog.setMessage(getResources().getString(R.string.bij_kennis));


        dialog.setCancelable(false);



        dialog.setButton(DialogInterface.BUTTON_POSITIVE, getResources().getString(R.string.alert),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Intent intent = new Intent(getApplicationContext(), Benauwt.class);
                        Volgende(intent);

                    }
                });
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, getResources().getString(R.string.bewustloos),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        intent = new Intent(NoodTransport.this,Airway.class );
                        Volgende(intent);

                    }
                });


        dialog.show();
        //terugknop();


    }
    public void schrijfString(String string){
        tekst.setText(string);



    }

    public void Volgende(Intent intent){

        startActivity(intent);

    }

}

