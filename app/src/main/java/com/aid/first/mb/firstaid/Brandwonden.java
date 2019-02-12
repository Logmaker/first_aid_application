package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Brandwonden extends MoederClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brandwonden);
    }


   public void brandwondT(View v){
       onBackPressed();
   }
}
