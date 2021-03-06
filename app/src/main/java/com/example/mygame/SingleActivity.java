package com.example.mygame;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SingleActivity extends ActionBarActivity {

    Button btnAdventure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        btnAdventure = (Button) findViewById(R.id.btn_adventure);

        btnAdventure.setOnClickListener(btnAdventureListener);
    }

    View.OnClickListener btnAdventureListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // implemented this way temporarily
            // Interface of selecting level will be added later on
            Intent intent = new Intent(SingleActivity.this, AdventureGameActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
