package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Breating extends MoederClass {
    TextView klv, secondeTeGaan;
    TextView  uitlegInvoer, uitlegTeller;
    Button  knop10seconden, knop30seconden;
    int uitkomstaantalademhalingen = 1000;


    ProgressBar Tiensec, Dertigsec;
    float test = 5;
    final CharSequence text = "Hello toast!";

   // private SoundPool soundPool;
    boolean plays = false, loaded = false;
   // private int soundID;
    int i = 0;
    final Context context = this;
    Boolean adem_boolean10= false;
    Boolean adem_boolean30  = false;
    MediaPlayer mp;



    AlertDialog levelDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breating);
        klv = (TextView)findViewById(R.id.tvAdemhaling);
        secondeTeGaan = (TextView)findViewById(R.id.tvSecondenTeGaan);
        klv.setText(getResources().getString(R.string.klv));
        secondeTeGaan.setText(getResources().getString(R.string.uitleg_teller));
        Tiensec = (ProgressBar)findViewById(R.id.progressBar10sec);
        Dertigsec = (ProgressBar)findViewById(R.id.progressBar30sec);
        //onderstaande worden zichtbaar als de progresbar is uitgeteld.
      //  result = (EditText) findViewById(R.id.editTextResult);
        knop10seconden = (Button)findViewById(R.id.knop10seconden);
        knop30seconden = (Button)findViewById(R.id.knop30seconden);
        uitlegInvoer = (TextView)findViewById(R.id.tvUitlegInvoer);
        uitlegTeller = (TextView)findViewById(R.id.tvAdemhaling_teller_uitleg);

    }



   public void knop10seconden(View v){
       knop10seconden.setVisibility(View.INVISIBLE);
       final int totalMsecs = 15 *1000;
       int callInterval = 100;
     /*  soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
       soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
          	            @Override
          	            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
               	        loaded = true;
               	            }
           	        });
       	        soundID = soundPool.load(this, R.raw.piep, 1);
       soundPool.play(soundID, 1f, 1f, 1, 0, 1f);*/
       mp = MediaPlayer.create(this, R.raw.piep);
       mp.setVolume(5,5);
       mp.start();

       new CountDownTimer(totalMsecs, callInterval) {
           public void onTick(long millisUntilFinished) {

               int secondsRemaining = (int) millisUntilFinished / 1000;
               float fraction = millisUntilFinished
                       / (float) totalMsecs;
               // progress bar is based on scale of 1 to 100;
               Tiensec.setProgress((int) (fraction * 100));
               secondeTeGaan.setText(getResources().getString(R.string.secondenTeGaan)
                       + millisUntilFinished / 1000);
               test = (millisUntilFinished / 1000);
               if(test==0 && adem_boolean10 == false) {
                   //  Toast.makeText(Breating.this, text, Toast.LENGTH_LONG).show();


                   uitlegInvoer.setVisibility(View.VISIBLE);
                  // soundID = soundPool.load(Breating.this, R.raw.piep, 1);
                 //  soundPool.play(soundID, 1f, 1f, 1, 0, 1f);
                 //  mp = MediaPlayer.create(this, R.raw.piep);
                   mp.setVolume(5,5);
                   mp.start();


                   Intent intent = new Intent(Breating.this, Dialog_aantal_adem.class);
                   adem_boolean10 = true;
                   Tiensec.setVisibility(View.INVISIBLE);
                   uitlegTeller.setVisibility(View.INVISIBLE);
                   startActivityForResult(intent,2);


               }
           }

           @Override
           public void onFinish() {
               // TODO Auto-generated method stub

           }


       }.start();

   }



    public void knop30seconden(View v){

        Context context;
        knop30seconden.setVisibility(View.INVISIBLE);
        final int totalMsecs = 30 *1000;
        int callInterval = 100;
        mp = MediaPlayer.create(this, R.raw.piep);
        mp.setVolume(5,5);
        mp.start();
      /*  soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });
        soundID = soundPool.load(this, R.raw.piep, 1);
        soundPool.play(soundID, 1f, 1f, 1, 0, 1f);*/
        new CountDownTimer(totalMsecs, callInterval) {
            public void onTick(long millisUntilFinished) {
                int secondsRemaining = (int) millisUntilFinished / 1000;
                float fraction = millisUntilFinished
                        / (float) totalMsecs;
                // progress bar is based on scale of 1 to 100;
                Dertigsec.setProgress((int) (fraction * 100));
                secondeTeGaan.setText(getResources().getString(R.string.secondenTeGaan)
                        + millisUntilFinished / 1000);
                test = (millisUntilFinished / 1000);
                if(test==0 && adem_boolean30 == false) {
                    //Toast.makeText(Breating.this, text, Toast.LENGTH_LONG).show();
                    mp.start();
                   // soundID = soundPool.load(Breating.this, R.raw.piep, 1);
                  //  soundPool.play(soundID, 1f, 1f, 1, 0, 1f);
                    Intent intent = new Intent(Breating.this, Dialog_aantal_adem.class);
                    adem_boolean30 = true;
                    startActivityForResult(intent,3);

                }
            }

            @Override
            public void onFinish() {
                // TODO Auto-generated method stub

            }


        }.start();
    }
//Hieronder komt het ademresultaat binnen, en vervolgens wordt de dialoog
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2 )
        {
            int a =data.getIntExtra("MESSAGE", 0);
            Log.i("ADEM","adf" +  a);
            a = a * 4;
            adem_boolean10 = false;
            //  Toast.makeText(this, a, Toast.LENGTH_LONG).show();
            bepaalLeeftijd(a);


        }
        if(requestCode==3 && resultCode == RESULT_OK)
        {
            int a =data.getIntExtra("MESSAGE", 0);
            Log.i("ADEM","adf" +  a);
            a = a * 2;
            Toast.makeText(this, "zit nu op de 30 seconden return", Toast.LENGTH_LONG).show();
            adem_boolean30 = false;
            bepaalLeeftijd(a);
        }
    }

public void bepaalLeeftijd(final int aantal_adem){

    Toast.makeText(Breating.this," aantal_adem = " + aantal_adem, Toast.LENGTH_LONG).show();

    final CharSequence[] items = {
             getResources().getString(R.string.baby)
            ,getResources().getString(R.string.peuter)
            ,getResources().getString(R.string.kleuter)
            ,getResources().getString(R.string.kind)
            ,getResources().getString(R.string.puber)
            ,getResources().getString(R.string.volwassen)};


    // Creating and Building the Dialog
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(getResources().getString(R.string.Kies_Leeftijd));
   // builder.setCancelable(false);
    builder.setCancelable(false);
    builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int item) {
          //  int i = 0;

            switch(item)
            {
                case 0:
                    // baby
                if(aantal_adem < 12){
                    //    secondeTeGaan.setText(getResources().getString(R.string.advies_cpr));
                    Intent intent = new Intent(Breating.this, Reanimatie_baby.class);
                    showDialog(Breating.this, getResources().getString(R.string.knopReanimatie),
                            getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.baby_gezond ) + getResources().getString(R.string.advies_cpr, aantal_adem), intent);
                    break;
                }else if(aantal_adem >=12 && aantal_adem <= 27){

                  //  secondeTeGaan.setText(getResources().getString(R.string.advies_zwak));
                    Intent intent = new Intent(Breating.this, Hartslag_baby.class);
                    showDialog(Breating.this, getResources().getString(R.string.knopHartslag),
                            getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.baby_gezond) + getResources().getString(R.string.advies_zwak, aantal_adem), intent);
                    break;
                }else if(aantal_adem >27 && aantal_adem <61){
                 //   secondeTeGaan.setText(getResources().getString(R.string.baby_gezond));
                    Intent intent = new Intent(Breating.this, Circulatie.class);
                    showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                            getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.baby_gezond) + getResources().getString(R.string.advies_gezond, aantal_adem), intent);
                    break;
                }else if(aantal_adem>=61){
                  //  secondeTeGaan.setText(getResources().getString(R.string.baby_hoog));
                    Intent intent = new Intent(Breating.this, Hyperventilatie.class);
                    showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                            getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.baby_gezond) + getResources().getString(R.string.advies_hoog, aantal_adem), intent);
                    break;
                }


                    break;
                case 1:
                    // peuter
                    if(aantal_adem < 12){
                      //  secondeTeGaan.setText(getResources().getString(R.string.advies_cpr));
                        Intent intent = new Intent(Breating.this, Reanimatie_baby.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopReanimatie),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem)+ getResources().getString(R.string.peuter_gezond ) + getResources().getString(R.string.advies_cpr, aantal_adem), intent);
                        break;
                    }else if(aantal_adem >=12 && aantal_adem <= 23){

                       // secondeTeGaan.setText(getResources().getString(R.string.advies_zwak));
                        Intent intent = new Intent(Breating.this, Hartslag_baby.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopHartslag),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.peuter_gezond) + getResources().getString(R.string.advies_zwak, aantal_adem), intent);
                        break;
                    }else if(aantal_adem >23 && aantal_adem <41){
                      //  secondeTeGaan.setText(getResources().getString(R.string.peuter_gezond));
                        Intent intent = new Intent(Breating.this, Circulatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.peuter_gezond) + getResources().getString(R.string.advies_gezond,aantal_adem), intent);
                        break;
                    }else if(aantal_adem>40){
                      //  secondeTeGaan.setText(getResources().getString(R.string.peuter_hoog));
                        Intent intent = new Intent(Breating.this, Hyperventilatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.peuter_gezond) + getResources().getString(R.string.advies_hoog, aantal_adem), intent);
                        break;
                    }

                    break;
                case 2:
                    // kleuter
                    if(aantal_adem  < 9){
                      //  secondeTeGaan.setText(getResources().getString(R.string.advies_cpr));
                        Intent intent = new Intent(Breating.this, Reanimatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopReanimatie),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem)   + getResources().getString(R.string.kleuter_gezond ) + getResources().getString(R.string.advies_cpr, aantal_adem), intent);
                        break;
                    }else if(aantal_adem >=9 && aantal_adem <= 20){

                      //  secondeTeGaan.setText(getResources().getString(R.string.advies_zwak));
                        Intent intent = new Intent(Breating.this, Hartslag.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopHartslag),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.kleuter_gezond) + getResources().getString(R.string.advies_zwak, aantal_adem), intent);
                        break;
                    }else if(aantal_adem >20 && aantal_adem <36){
                      //  secondeTeGaan.setText(getResources().getString(R.string.kleuter_gezond));
                        Intent intent = new Intent(Breating.this, Circulatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.kleuter_gezond) + getResources().getString(R.string.advies_gezond,aantal_adem), intent);
                        break;
                    }else if(aantal_adem>35){
                      //  secondeTeGaan.setText(getResources().getString(R.string.kleuter_hoog));
                        Intent intent = new Intent(Breating.this, Hyperventilatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.kleuter_gezond) + getResources().getString(R.string.advies_hoog, aantal_adem), intent);
                        break;
                    }
                case 3:
                    // kind
                    if(aantal_adem < 6){
                       // secondeTeGaan.setText(getResources().getString(R.string.advies_cpr));
                        Intent intent = new Intent(Breating.this, Reanimatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopReanimatie),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) +  getResources().getString(R.string.kind_gezond ) + getResources().getString(R.string.advies_cpr, aantal_adem), intent);
                        break;
                    }else if(aantal_adem >=6 && aantal_adem <= 17){

                       // secondeTeGaan.setText(getResources().getString(R.string.advies_zwak));
                        Intent intent = new Intent(Breating.this, Hartslag.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopHartslag),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.kind_gezond) + getResources().getString(R.string.advies_zwak,aantal_adem), intent);
                        break;
                    }else if(aantal_adem >17 && aantal_adem <33){
                      //  secondeTeGaan.setText(getResources().getString(R.string.kind_gezond));
                        Intent intent = new Intent(Breating.this, Circulatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.kind_gezond) + getResources().getString(R.string.advies_gezond,aantal_adem), intent);
                        break;
                    }else if(aantal_adem>32){
                      // secondeTeGaan.setText(getResources().getString(R.string.kind_hoog));
                        Intent intent = new Intent(Breating.this, Hyperventilatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.kind_gezond) + getResources().getString(R.string.advies_hoog, aantal_adem), intent);
                        break;
                    }
                case 4:
                    // puber
                    if(aantal_adem < 6){
                       // secondeTeGaan.setText(getResources().getString(R.string.advies_cpr));
                        Intent intent = new Intent(Breating.this, Reanimatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopReanimatie),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem)  + getResources().getString(R.string.puber_gezond ) + getResources().getString(R.string.advies_cpr, aantal_adem), intent);
                        break;
                    }else if(aantal_adem >=6 && aantal_adem <= 9){

                       // secondeTeGaan.setText(getResources().getString(R.string.advies_zwak));
                        Intent intent = new Intent(Breating.this, Hartslag.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopHartslag),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.puber_gezond) + getResources().getString(R.string.advies_zwak, aantal_adem), intent);
                        break;
                    }else if(aantal_adem >9 && aantal_adem <21){
                       // secondeTeGaan.setText(getResources().getString(R.string.puber_gezond));
                        Intent intent = new Intent(Breating.this, Circulatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.puber_gezond) + getResources().getString(R.string.advies_gezond, aantal_adem), intent);
                        break;
                    }else if(aantal_adem>20){
                       // secondeTeGaan.setText(getResources().getString(R.string.puber_hoog));
                        Intent intent = new Intent(Breating.this, Hyperventilatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.puber_gezond) + getResources().getString(R.string.advies_hoog, aantal_adem), intent);
                        break;
                    }
                case 5:
                    // volwassen
                    Toast.makeText(Breating.this," volwassen  " + aantal_adem, Toast.LENGTH_LONG).show();

                    if(aantal_adem < 6){
                       // secondeTeGaan.setText(getResources().getString(R.string.advies_cpr));
                        Intent intent = new Intent(Breating.this, Reanimatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopReanimatie),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.volwassen_gezond)  + getResources().getString(R.string.advies_cpr, aantal_adem), intent);

                        break;
                    }else if(aantal_adem >=6 && aantal_adem <= 9){

                       // secondeTeGaan.setText(getResources().getString(R.string.advies_zwak));
                        Intent intent = new Intent(Breating.this, Hartslag.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopHartslag),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem)  + getResources().getString(R.string.volwassen_gezond) + getResources().getString(R.string.advies_zwak, aantal_adem), intent);

                        break;
                    }else if(aantal_adem >9 && aantal_adem <21){
                        //secondeTeGaan.setText(getResources().getString(R.string.volwassen_gezond));
                        Intent intent = new Intent(Breating.this, Circulatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.volwassen_gezond) + getResources().getString(R.string.advies_gezond,aantal_adem), intent);

                        break;
                    }else if(aantal_adem>20){
                        //secondeTeGaan.setText(getResources().getString(R.string.volwassen_hoog));
                        Intent intent = new Intent(Breating.this, Hyperventilatie.class);
                        showDialog(Breating.this, getResources().getString(R.string.knopVolgende),
                                getResources().getString(R.string.aantalPerMinuut, aantal_adem) + getResources().getString(R.string.volwassen_gezond) + getResources().getString(R.string.advies_hoog, aantal_adem), intent);

                        break;
                    }

            }
            levelDialog.dismiss();
        }
    });

    levelDialog = builder.create();
    levelDialog.show();



}



    //dialog met twee knoppen een om nauwkeurig nog eens te meten, en een om het gegeven advies te doen de actieknop.
    public void showDialog(Activity activity, String title, CharSequence message, final Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        if (title != null) builder.setTitle(title);
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setPositiveButton(getResources().getString(R.string.knopOpnieuw), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
                Toast.makeText(Breating.this, "opnieuw 30 seconden.", Toast.LENGTH_LONG).show();
                knop30seconden.setVisibility(View.VISIBLE);
                Dertigsec.setVisibility(View.VISIBLE);
            }
        });
        builder.setNegativeButton(title, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
                Toast.makeText(Breating.this, "advies", Toast.LENGTH_LONG).show();
                int i =1;
                intent.putExtra("int",i);
                startActivity(intent);
            }
        });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,getResources().getString(R.string.terugKnop),Toast.LENGTH_LONG).show();
    }


}



