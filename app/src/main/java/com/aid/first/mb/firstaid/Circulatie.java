package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Circulatie extends MoederClass {
   // int i = 0;
    Intent gintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circulatie);
        gintent = getIntent();

    }


    public void knopVolgende(View v){
        Intent intent  = new Intent(this, Disability.class);
        Volgende(intent);

    }
    public void knopBloeding(View v){
        Intent intent = new Intent(this, Slagaderfoto.class);
        Volgende(intent);

    }
    public void slang(View v){
        Intent intent = new Intent(this, SnakeBite.class);
        Volgende(intent);
    }

    public void brandwond(View v){
        Intent intent = new Intent(this, Brandwonden.class);
        Volgende(intent);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && gintent.getIntExtra("int", 0) == 1) { //&& intentextra is 1;
            Intent a = new Intent(this, Breating.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(a);
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_BACK && gintent.getIntExtra("int", 0) == 2) { //&& intentextra is 1;
            Intent a = new Intent(this, Hartslag.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(a);
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_BACK && gintent.getIntExtra("int", 0) == 3) { //&& intentextra is 1;
            Intent a = new Intent(this, Hartslag_baby.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(a);
            return true;
        }
            return super.onKeyDown(keyCode, event);

    }
}
