package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Breating_bij_bewustzijn extends MoederClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breating_bij_bewustzijn);
    }


   public void knopVolgende(View v){
       Intent intent = new Intent(this, Circulatie.class);
       Volgende(intent);

   }

   public void knopStabieleZijligging(View v){
       Intent intent = new Intent(this,Stabiele_zijligging.class);
       Volgende(intent);

   }

   public void knopHyperventilatie(View v){
       Intent intent = new Intent(this, Hyperventilatie.class);
       Volgende(intent);

   }
}
