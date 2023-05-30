package sg.edu.rp.c346.id22013080.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;

    String wordClick = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.bank1);
        ocbc = findViewById(R.id.bank2);
        uob = findViewById(R.id.bank3);


        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_options,menu);


        if(v == dbs){
            wordClick = "dbs";
        }
        else if(v == ocbc){
            wordClick = "ocbc";
        }
        else if (v == uob) {
            wordClick = "uob";
        }


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_languagexml, menu);

        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        if(wordClick.equalsIgnoreCase("dbs")){
            if(id == R.id.websiteSelection){
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse( getString(R.string.dbsWeb)));
                startActivity(intentWeb);
                return true;
            }
            else if(id == R.id.phoneSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbsNum)));
                startActivity(intentCall);
                return true;
            }
            else if(id == R.id.fav){


                    dbs.setTextColor(Color.RED);
                    ocbc.setTextColor(Color.BLACK);
                    uob.setTextColor(Color.BLACK);

            }

        }
        else if(wordClick.equalsIgnoreCase("ocbc")) {
            if (id == R.id.websiteSelection) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
                startActivity(intentWeb);
                return true;
            } else if (id == R.id.phoneSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +getString(R.string.ocbcNum)));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.fav) {
                dbs.setTextColor(Color.BLACK);
                ocbc.setTextColor(Color.RED);
                uob.setTextColor(Color.BLACK);
            }
        }


        else if(wordClick.equalsIgnoreCase("uob")){
            if(id == R.id.websiteSelection){
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse( getString(R.string.uobWeb)));
                startActivity(intentWeb);
                return true;
            }
            else if(id == R.id.phoneSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uobNum)));
                startActivity(intentCall);
                return true;
            }
            else if(id == R.id.fav){
                dbs.setTextColor(Color.BLACK);
                ocbc.setTextColor(Color.BLACK);
                uob.setTextColor(Color.RED);

            }
        }

        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.EnglishSelection){
            dbs.setText(getString(R.string.dbsEn));
            ocbc.setText(getString(R.string.ocbcEn));
            uob.setText(getString(R.string.uobEn));
            return true;
        }
        else if(id == R.id.chineseSelection){
            dbs.setText(getString(R.string.dbsCn));
            ocbc.setText(getString(R.string.ocbcCn));
            uob.setText(getString(R.string.uobCn));
            return true;
        }
        else if(id == R.id.clearFav){
            dbs.setTextColor(Color.BLACK);
            ocbc.setTextColor(Color.BLACK);
            uob.setTextColor(Color.BLACK);
        }

        return super.onOptionsItemSelected(item);
    }


}