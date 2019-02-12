package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Exposure extends MoederClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exposure);
    }
 public void knopABCD(View v){
     Intent intent = new Intent(this, NoodTransport.class);
     intent.putExtra("VanafExposure",1); // als Noodtransport een 1 ontvangt in de intent dan lanceert hij gelijk een dialog.
     Volgende(intent);

 }
public void knopMenu(View v){
    Intent intent = new Intent(this, Menu1.class);
    Volgende(intent);

}


}
