package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
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


public class Hartslag extends Activity {
    Intent gintent;
    Button knop15seconden;
   // private SoundPool soundPool;
    Boolean loaded;
    private int soundID;
    ProgressBar VijftienSec;
    float test = 5;
    TextView secondeTeGaan;
    Boolean adem_boolean10 = false;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Hartslag.this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        Hartslag.this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       setContentView(R.layout.hartslag);
        gintent = getIntent();
        knop15seconden = (Button)findViewById(R.id.knopHartslagTeller);
        secondeTeGaan = (TextView)findViewById(R.id.tvHartslag_teller_uitleg);
        VijftienSec = (ProgressBar)findViewById(R.id.progressBar15sec);
    }

//start het aftellen.
   public void knopHartslag(View v){
       knop15seconden.setVisibility(View.INVISIBLE);
       // Tiensec.layout
       final int totalMsecs = 15 *1000; // moet 15 worden
       int callInterval = 100;
       mp = MediaPlayer.create(this, R.raw.piep);
       mp.setVolume(5,5);
       mp.start();
       /*
       soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
       soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
           @Override
           public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
               loaded = true;
           }
       });
       soundID = soundPool.load(this, R.raw.piep, 1);
         soundPool.play(soundID, 1f, 1f, 1, 0, 1f); */

       new CountDownTimer(totalMsecs, callInterval) {
           public void onTick(long millisUntilFinished) {

               int secondsRemaining = (int) millisUntilFinished / 1000;
               float fraction = millisUntilFinished
                       / (float) totalMsecs;
               // progress bar is based on scale of 1 to 100;
               VijftienSec.setProgress((int) (fraction * 100));
               secondeTeGaan.setText(getResources().getString(R.string.secondenTeGaan)
                       + millisUntilFinished / 1000);
               test = (millisUntilFinished / 1000);
               if(test==0 && adem_boolean10 == false) {
                   //  Toast.makeText(Breating.this, text, Toast.LENGTH_LONG).show();

                    mp.start();
                   //   uitlegInvoer.setVisibility(View.VISIBLE);
                   // soundID = soundPool.load(Hartslag.this, R.raw.piep, 1);
                   //  soundPool.play(soundID, 1f, 1f, 1, 0, 1f);

                   Intent intent = new Intent(Hartslag.this, Dialog_aantal_adem.class);
                   intent.putExtra("hartslag",1);
                   adem_boolean10 = true;
                   VijftienSec.setVisibility(View.INVISIBLE);
                   //uitlegTeller.setVisibility(View.INVISIBLE);
                   startActivityForResult(intent,2);


               }
           }

           @Override
           public void onFinish() {
               // TODO Auto-generated method stub

           }


       }.start();

   }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && gintent.getIntExtra("int",0) == 1) { //&& intentextra is 1;
            Intent a = new Intent(this,Breating.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(a);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2 )
        {
            int a =data.getIntExtra("MESSAGE", 0);
            Log.i("ADEM", "adf" + a);
            a = a * 4;
            adem_boolean10 = false;
            Toast.makeText(this, "Hartslag + " + a, Toast.LENGTH_LONG).show();

            if(a < 45){
                showDialog(Hartslag.this, getResources().getString(R.string.adviesCPRbabyHartslag),"",
                        getResources().getString(R.string.advies_reanimeren_Volwassen,a));
            }
            if(a > 44){
                showDialog(Hartslag.this,getResources().getString(R.string.adviesZoekHetUit),
                        getResources().getString(R.string.adviesZoekHetUitVolwassen),getResources().getString(R.string.zoekHetZelfUitVolwassen,a));
            }



        }

    }
    public void showDialog(Activity activity, String title, String titleVerder, CharSequence message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        if (title != null) builder.setTitle(title);
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setPositiveButton(getResources().getString(R.string.adviesOpniew), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(Hartslag.this, Hartslag.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.adviesCPRbabyHartslag), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
                //  Toast.makeText(Breating.this, "advies", Toast.LENGTH_LONG).show();
                int i =2;
                Intent intent = new Intent(Hartslag.this, Reanimatie.class);
                intent.putExtra("int",i);
                startActivity(intent);
            }
        });
        builder.show();
        if(titleVerder.equals(getResources().getString(R.string.adviesZoekHetUitVolwassen)))     //als hartslag zwak is dan komt er een knop bij in de dialoog.
            builder.setNeutralButton(titleVerder, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //do things
                    //  Toast.makeText(Breating.this, "advies", Toast.LENGTH_LONG).show();
                    int i = 2;
                    Intent intent2 = new Intent(Hartslag.this, Circulatie.class);
                    intent2.putExtra("int",i);
                    startActivity(intent2);
                }
            });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(Hartslag.this, getResources().getString(R.string.terugKnop), Toast.LENGTH_SHORT).show();
    }
}


