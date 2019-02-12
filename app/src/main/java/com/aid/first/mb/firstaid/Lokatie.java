package com.aid.first.mb.firstaid;


import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class Lokatie extends MoederClass {
    ImageButton belAlarmnummer;
    TextView myLatitude, myLongitude, myAddress;
    Button Terug;
    LocationManager mlocManager;
    LocationListener mlocListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lokatie);

        myLatitude = (TextView)findViewById(R.id.mylatitude);
        myLongitude = (TextView)findViewById(R.id.mylongitude);
        myAddress = (TextView)findViewById(R.id.myaddress);
        Terug = (Button)findViewById(R.id.btTerug);
        Terug.setKeepScreenOn(true);

        belAlarmnummer =(ImageButton)findViewById(R.id.ibLocBelAlarmnummer);


			/* Use the LocationManager class to obtain GPS locations */

        mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        mlocListener = new MyLocationListener();


        mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);


    }
    //ImageView om alarmnummer te bellen
    public void bel112(View v){
       bel112();

    }
    //Button om terug te gaan naar Alarmeren
    public void terug(View v){
        Intent intent = new Intent(Lokatie.this, Alarmeren.class);
        Volgende(intent);

    }

public class MyLocationListener implements LocationListener{

    public void onLocationChanged(Location loc)
    {
        loc.getLatitude();
        loc.getLongitude();

        myLatitude.setText(getResources().getString(R.string.breedtegraad)  + String.valueOf((float)Math.round(loc.getLatitude() * 1000000) / 1000000));
        myLongitude.setText(getResources().getString(R.string.lengtegraad) + String.valueOf((float)Math.round(loc.getLongitude()* 1000000) / 1000000));

        Geocoder geocoder = new Geocoder(Lokatie.this.getApplicationContext(), Locale.getDefault());
        try {  List<Address> addresses = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 2);
            if(addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder(getResources().getString(R.string.adres)+ "\n");
                for(int i=0; i<returnedAddress.getMaxAddressLineIndex();i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                myAddress.setText(strReturnedAddress.toString());
            }
            else{
                myAddress.setText("No Address returned!");
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //dit is fout, onderstaande teks moet worden weergegeven als device offline is.
            myAddress.setText(getResources().getString(R.string.adresOnbekend)+
                    getResources().getString(R.string.breedtegraad) + " " + (float)Math.round(loc.getLatitude() * 1000000) / 1000000 + "\n"
                  + getResources().getString(R.string.lengtegraad) + " "  + (float)Math.round(loc.getLongitude() * 1000000) / 1000000);
        }


    }



    public void onProviderDisabled(String provider)
    {
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.gps_uit), Toast.LENGTH_SHORT).show();
    }


    public void onProviderEnabled(String provider)
    {
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.gps_aan), Toast.LENGTH_SHORT).show();
    }


    public void onStatusChanged(String provider, int status, Bundle extras)
    {
    }

} /* End of Class MyLocationListener */



}
