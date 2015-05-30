package com.example.mygame;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ImageButton imgBtnSingle;
    ImageButton imgBtnDouble;

    ImageButton imgBtnAbout;
    ImageButton imgBtnSettings;
    ImageButton imgBtnRank;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtnSingle = (ImageButton) findViewById(R.id.imgBtn_single);
        imgBtnDouble = (ImageButton) findViewById(R.id.imgBtn_double);

        imgBtnAbout = (ImageButton) findViewById(R.id.imgBtn_about);
        imgBtnSettings = (ImageButton) findViewById(R.id.imgBtn_settings);
        imgBtnRank = (ImageButton) findViewById(R.id.imgBtn_rank);

        imgBtnSingle.setOnClickListener(imgBtnSingleListener);
        imgBtnDouble.setOnClickListener(imgBtnDoubleListener);


    }

    protected View.OnClickListener imgBtnSingleListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SingleActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener imgBtnDoubleListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
