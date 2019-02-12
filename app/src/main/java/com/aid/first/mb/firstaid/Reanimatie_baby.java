package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class Reanimatie_baby extends Activity {


    ProgressBar bar;
    MediaPlayer mp;
    Boolean aan = false;
    Boolean control = true;
    Boolean adem_boolean30 = false;
    Boolean reanimeer = true;
    TextView secondeTeGaan;
    long test;
    int aftel = 0;
    AlertDialog ad;
    Intent gintent;
    Button knopAan, knopUit, knopLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.reanimatie_baby);
        secondeTeGaan = (TextView) findViewById(R.id.tvBeademen_baby);
        bar = (ProgressBar)findViewById(R.id.progressBar);
        gintent = getIntent();
        knopAan = (Button)findViewById(R.id.btStartFlowReanimatie_baby);
        knopUit = (Button)findViewById(R.id.btStopFlowReanimatie_baby);
        knopUit.setVisibility(View.INVISIBLE);
        knopLoop = (Button)findViewById(R.id.btRitmeReanimatie_baby);

    }


    public void knopTerugNaarBreating_baby(View view){
        if(knopUit.getVisibility() == View.VISIBLE ||aan == true) {
            mp.stop();
        }
        Intent intent = new Intent(Reanimatie_baby.this, Breating.class);
        startActivity(intent);

    }

    public void knopStartFlowReanimatie_baby(View view){
        mp = MediaPlayer.create(this, R.raw.btd);
        mp.setLooping(true);
        mp.setVolume(5,5);
        mp.start();
        // maak zichzelf onzichtbaar en de beademloop onzichtbaar
        knopAan.setVisibility(View.INVISIBLE);
        knopLoop.setVisibility(View.INVISIBLE);
        // maak knopStopFlowReanimatie zichtbaar.
        knopUit.setVisibility(View.VISIBLE);

    }

    public void knopstartReanimatie_en_beademings_Loop_baby(View view){
        // ze knop van constante ritme uit om te voorkomen dat ze door elkaar gaan.

        ReanimatieLoop();
    }

    public void knopStopFlowReanimatie_baby(View view){
        mp.stop();
        //maat zichzelf onzichtbaar
        knopUit.setVisibility(View.INVISIBLE);
        // maak knopStartFlowReanimatie zichtbaar en de beademloop zichtbaar
        knopAan.setVisibility(View.VISIBLE);
        knopLoop.setVisibility(View.VISIBLE);

    }


    public void Dialog(Boolean control, boolean eind){
        ad = new AlertDialog.Builder(this).create();
        ad.setCancelable(true); // This blocks the 'BACK' button
        if (control==false) {
            ad.setMessage(getResources().getString(R.string.dialoogLoopBeademen_baby));
        }if(control==true){
            ad.setMessage(getResources().getString(R.string.dialoogLoopReanimatie_baby));
        }if(control==true && eind == true ){
            ad.setMessage(getResources().getText(R.string.dialoogReanimatieTitel));
            ad.setButton(getResources().getText(R.string.controleerAdemhaling), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent = new Intent(Reanimatie_baby.this, Breating.class);
                    startActivity(intent);
                }
            });
            ad.setButton2(getResources().getText(R.string.herhaalReanimatie), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Intent intent = new Intent(Reanimatie.this, Reanimatie.class);
                    // startActivity(intent);
                    //  dialog.dismiss();
                    aftel = 0;
                    adem_boolean30 = false;
                    ReanimatieLoop();
                }
            });

        }
        ad.show();

        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                ad.dismiss(); // when the task active then close the dialog
                t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
            }
        }, 7000); // after 2 second (or 2000 miliseconds), the task will be active.
    }
    public void ReanimatieLoop(){
        // maak de knop onzichtbaar zodat hij maar 1 keer kan worden gebruikt.
        aan = true;
        mp = MediaPlayer.create(this, R.raw.btd);
        control = true;
        int i = 0;
        aftel = 0;
        adem_boolean30 = false;
        if(control == true && i == 0) {
            knopLoop.setVisibility(View.INVISIBLE);
            knopAan.setVisibility(View.INVISIBLE);
            mp.setLooping(true);
            //  mp.start();
            // control = false;
            // for(;control = true;){
            mp.setVolume(5,5);
            mp.start();

            final int totalMsecs = 69 *1000;
            int callInterval = 100;
            new CountDownTimer(totalMsecs, callInterval) {
                public void onTick(long millisUntilFinished) {
                    int secondsRemaining = (int) millisUntilFinished / 1000;
                    float fraction = millisUntilFinished
                            / (float) totalMsecs;
                    // progress bar is based on scale of 1 to 100;
                    bar.setProgress((int) (fraction * 100));
                    secondeTeGaan.setText("nog te gaan" + millisUntilFinished / 1000);
                    test = (millisUntilFinished / 1000);
                    /*aftel in de onderstaande if statements zorgt er voor dat de dialoog die er binnen in dit statment wordt gemaakt maar een keer wordt gemaakt.
                     * het if statement staat namelijk in een countdownloop en wordt wordt op de seconden (variable test) gemaakt. Maar omdat de processor meerde
                      * keren per seconden de loop kan berekenen wordt de dialoog vaak gemaakt. Door aftel iedere keer te veranderen voorkom je dat.
                      * */
                    if(test==59 && adem_boolean30 == false && aftel == 0) {
                        // Toast.makeText(Sound.this, "beadem 2 keer", Toast.LENGTH_LONG).show();
                        mp.pause();
                        // adem_boolean30 = true;
                        reanimeer=false;
                        Dialog(reanimeer,adem_boolean30);
                        aftel = 1;


                    }
                    if(test==51 && adem_boolean30 == false&& aftel == 1) {
                        reanimeer=true;
                        //  Toast.makeText(Sound.this, "Reanimeer", Toast.LENGTH_LONG).show();
                        mp.start();
                        Dialog(reanimeer,adem_boolean30);
                        aftel = 2;

                        //adem_boolean30 = true;
                    }if(test==42 && adem_boolean30 == false && aftel == 2) {
                        //  Toast.makeText(Sound.this, "beadem 2 keer", Toast.LENGTH_LONG).show();
                        mp.pause();
                        // adem_boolean30 = true;
                        reanimeer=false;
                        Dialog(reanimeer,adem_boolean30);
                        aftel = 3;
                    }if(test==34 && adem_boolean30 == false && aftel == 3) {
                        //  Toast.makeText(Sound.this, "Reanimeer", Toast.LENGTH_LONG).show();
                        mp.start();
                        //adem_boolean30 = true;
                        reanimeer=true;
                        Dialog(reanimeer,adem_boolean30);
                        aftel = 4;
                    }if(test==25 && adem_boolean30 == false && aftel == 4) {
                        //  Toast.makeText(Reanimatie.this, "beadem 2 keer", Toast.LENGTH_LONG).show();
                        mp.pause();
                        // adem_boolean30 = true;
                        reanimeer=false;
                        Dialog(reanimeer, adem_boolean30);
                        aftel = 5;
                    }if(test==17 && adem_boolean30 == false && aftel == 5) {
                        //  Toast.makeText(Sound.this, "Reanimeer", Toast.LENGTH_LONG).show();
                        mp.start();
                        //adem_boolean30 = true;
                        reanimeer=true;
                        Dialog(reanimeer,adem_boolean30);
                        aftel = 6;
                    }if(test==9 && adem_boolean30 == false && aftel == 6) {
                        //  Toast.makeText(Reanimatie.this, "beadem 2 keer", Toast.LENGTH_LONG).show();
                        aan = false;
                        mp.release();
                        // adem_boolean30 = true;
                        reanimeer=false;
                        Dialog(reanimeer, adem_boolean30);
                        aftel = 7;
                    }if(test==0 && aftel == 7){
                        //zet de constanteloop knop weer op zichtbaar, zodat hij mogelijk de volgende ronden gebruikt kan worden.
                        knopAan.setVisibility(View.VISIBLE);
                        knopLoop.setVisibility(View.VISIBLE);
                        adem_boolean30 = true;
                        reanimeer = true;
                        aftel = 0;
                        Dialog(reanimeer, adem_boolean30);
                    }
                }



                @Override
                public void onFinish() {
                    // TODO Auto-generated method stub

                }


            }.start();
        }

    }



   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && gintent.getIntExtra("int",0) == 1) { //&& intentextra is 1;
            Intent a = new Intent(this,Breating.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            mp.stop();
            startActivity(a);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/

    @Override
    public void onBackPressed() {
        Toast.makeText(Reanimatie_baby.this, getResources().getString(R.string.terugKnop), Toast.LENGTH_LONG).show();
    }
}
