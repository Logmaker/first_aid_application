package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by M.B on 24-1-2015.
 */
public class Contact extends MoederClass {

    EditText onderwerp, email;
    String Email, Onderwerp;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        email = (EditText)findViewById(R.id.etEmail);
        onderwerp = (EditText)findViewById(R.id.etOnderwerp);
    }
    public void knopEmail(View v){
        convertEditTextVarsIntoStrings();
        String emailaddress[] = {"firstaidabcd@gmail.com"} ;
        String message = Email;

        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);

        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, Onderwerp);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);

        startActivity(emailIntent);


    }
    private void convertEditTextVarsIntoStrings(){
        Email = email.getText().toString();
        Onderwerp = onderwerp.getText().toString();
    }


}
