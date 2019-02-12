package com.aid.first.mb.firstaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Menu1 extends Activity implements AdapterView.OnItemClickListener{
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

            listView = (ListView) findViewById(R.id.menu1);
            listView.setOnItemClickListener(this);
        }

    /*
     * Parameters:
		adapter - The AdapterView where the click happened.
		view - The view within the AdapterView that was clicked
		position - The position of the view in the adapter.
		id - The row id of the item that was clicked.
     */
        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
           // Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                //    Toast.LENGTH_SHORT).show();
            int idd = (int) id;
            switch (idd){
                case 0:
               Intent intent = new Intent(Menu1.this, NoodTransport.class);
                    intent.putExtra("VanafExposure",1); // als Noodtransport een 1 ontvangt in de intent dan lanceert hij gelijk een dialog.
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
               startActivity(intent);
                    break;
                case 1:
                    Intent intent1 = new Intent(Menu1.this, Benauwt.class);

                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(Menu1.this, Hyperventilatie.class);
                    startActivity(intent2);
                    break;
                case 3:
                    Intent intent3 = new Intent(Menu1.this, Reanimatie.class);
                    startActivity(intent3);
                    break;
                case 4:
                    Intent intent4 = new Intent(Menu1.this, Reanimatie_baby.class);
                    startActivity(intent4);
                    break;
                case 5:
                    Intent intent5 = new Intent(Menu1.this, Slagaderfoto.class);
                    startActivity(intent5);
                    break;
                case 6:
                    Intent intent6 = new Intent(Menu1.this, Brandwonden.class);
                    startActivity(intent6);
                    break;
                case 7:
                    Intent intent6a = new Intent(Menu1.this, SnakeBite.class);
                    startActivity(intent6a);
                    break;
                case 8:
                    Intent intent7 = new Intent(Menu1.this, Stabiele_zijligging.class);
                    startActivity(intent7);
                    break;
                case 9:
                    Intent intent8 = new Intent(Menu1.this, Lokatie.class);
                    startActivity(intent8);
                    break;
                case 10:
                    Intent intent9 = new Intent(Menu1.this, Disclamer.class);
                    startActivity(intent9);
                    break;
                case 11:
                    Intent intent10 = new Intent(Menu1.this, Contact.class);
                    startActivity(intent10);
                    break;
                case 12:
                    Intent intent11 = new Intent(Menu1.this, Personlijke_veiligheid.class);
                    intent11.putExtra("sluiten",1);
                    intent11.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent11.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent11);
                    break;
                case 13:
                    Intent intent12 = new Intent(Menu1.this, Personlijke_veiligheid.class);

                    intent12.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent12.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent12);
                    break;

            }
        }
    }