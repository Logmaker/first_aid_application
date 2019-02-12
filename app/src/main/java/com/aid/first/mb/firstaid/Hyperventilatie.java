package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Hyperventilatie extends MoederClass {
    Intent gintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hyperventilatie);
        gintent = getIntent();
    }


   public void knopVolgende(View v){
       Intent intent = new Intent(Hyperventilatie.this, Circulatie.class);
       startActivity(intent);

   }

   public void knopBreating(View v){
       Intent inte = new Intent(Hyperventilatie.this, Breating.class);
       startActivity(inte);
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
}
