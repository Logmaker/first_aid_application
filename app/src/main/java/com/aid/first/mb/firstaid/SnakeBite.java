package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by M.B on 24-1-2015.
 */
public class SnakeBite extends MoederClass {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snakebite);
    }
    public void knopSlangTerug(View v){
        onBackPressed();
    }
}
