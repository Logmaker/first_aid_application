package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MoederClass extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moeder_class);
    }




    // begin telefoon methoden
    public void displayAlert() {
        // TODO Auto-generated method stub
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("This is not a phone")
                .setMessage("This device can not call")
                .setPositiveButton("OK", new myDialogListener()).show();
    }

    class myDialogListener implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int whichButton) {

        }

    }

    public boolean deviceIsAPhone() {
        // TODO Auto-generated method stub
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        return manager.getPhoneType() != TelephonyManager.PHONE_TYPE_NONE;
    }

    //bel methoden

    public void bel112(){
        boolean isOk = true;
        Intent intent = new Intent();

        if (!deviceIsAPhone()) {
            displayAlert();
            isOk = false;
        }
        if (isOk) {
            intent.setAction(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(getResources().getString(R.string.telefoonnummer)));
            startActivity(intent);
        }

    }

    // einde telefoon methoden

    //begin knopjes methoden

    public void Volgende(Intent intent){

        startActivity(intent);

    }




    //einde knopjes methoden;

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_moeder_class, menu);

        return true;
    } */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_moeder_class, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        switch(item.getItemId()){

            case R.id.menu_BelAlarmnummer:
                //bel 112
                boolean isOk = true;
                Intent intent = new Intent();

                if(!deviceIsAPhone()){
                    displayAlert();
                    isOk = false;
                }
                if (isOk){
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(getResources().getString(R.string.telefoonnummer)));
                    startActivity(intent);
                }

                break;

            case R.id.menu_naarMenu:
                //naar Activity startMenu
                Class ourClass1;
                try {
                    ourClass1 = Class.forName("com.aid.first.mb.firstaid.Menu1");
                    Intent intentDrie = new Intent(MoederClass.this, ourClass1);
                    startActivity(intentDrie);

                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;
            case R.id.menu_sluitAf:
                Class ourClass3;
                try {
                    ourClass3 = Class.forName("com.aid.first.mb.firstaid.Personlijke_veiligheid");
                    Intent intentDrie = new Intent(MoederClass.this, ourClass3);
                    intentDrie.putExtra("sluiten",1);
                    intentDrie.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intentDrie.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intentDrie);

                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                finish();
                break;

            case R.id.menu_WaarBenIk:
                //naar activity Locatie
                Class ourClass4;
                try {
                    ourClass4 = Class.forName("com.aid.first.mb.firstaid.Lokatie");
                    Intent intentVier = new Intent(MoederClass.this, ourClass4);
                    startActivity(intentVier);

                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


                break;

        }

        return super.onOptionsItemSelected(item);
    }

}
