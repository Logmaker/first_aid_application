package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Dialog_aantal_adem extends Activity {
    EditText adem;
    int i=0;
    int b = 0;
    TextView tekst;
    Intent getIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.adem_dialog);
       // InputMethodManager imm = (InputMethodManager)this.getSystemService(Service.INPUT_METHOD_SERVICE);

        adem = (EditText)findViewById(R.id.editTextDialogUserInput);
      //  imm.showSoftInput(adem, 0);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        adem.requestFocus();
        setFinishOnTouchOutside(false);
        tekst = (TextView)findViewById(R.id.tvOproepDialoog);
        getIntent = getIntent();
        b = getIntent.getIntExtra("hartslag",0);
        if(b ==1){
            tekst.setText(getResources().getString(R.string.hoeveelHartslagen));
        }



    }



    public void knop_Adem(View v){
        String string;
        string = adem.getText().toString();


        if(string.equals("")){
            Toast.makeText(Dialog_aantal_adem.this,getResources().getString(R.string.InvoerDialoogLeeg),Toast.LENGTH_LONG).show();
        }else if(Integer.parseInt(string) > 50){
            Toast.makeText(this, getResources().getString(R.string.InvoerDialoogOngeldigeWaarden),Toast.LENGTH_LONG).show();
        }else {

            i= Integer.parseInt(string);
            Intent intent=new Intent();
            intent.putExtra("MESSAGE",i);
            setResult(RESULT_OK,intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, getResources().getString(R.string.terugKnop),Toast.LENGTH_LONG).show();
    }
}
