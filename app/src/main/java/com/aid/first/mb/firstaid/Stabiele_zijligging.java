package com.aid.first.mb.firstaid;


import android.os.Bundle;

import android.view.View;


public class Stabiele_zijligging extends MoederClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stabiele_zijligging);
    }


   public void terug(View v){
       onBackPressed();

   }
}
