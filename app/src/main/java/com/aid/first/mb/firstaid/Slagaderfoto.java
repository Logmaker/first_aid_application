package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Slagaderfoto extends MoederClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slagaderfoto);
    }

public void terug(View v){
    onBackPressed();
}

}
