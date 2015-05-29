package com.example.mygame;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class AdventureGameActivity extends ActionBarActivity {

    ImageView circle;
    ImageView original;
    TextView score;
    Handler handler;

    // ImageView original;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circle = (ImageView) findViewById(R.id.circle);
        original = (ImageView) findViewById(R.id.original);
        score = (TextView) findViewById(R.id.score);

        final ViewGroup.MarginLayoutParams margin9 = new ViewGroup.MarginLayoutParams(
                circle.getLayoutParams());
        margin9.setMargins(300, 300, 0, 0);// ����߾�400���أ����߾�10���ص�λ����ʾͼƬ
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(
                margin9);
        layoutParams9.height = 0;// ����ͼƬ�ĸ߶�
        layoutParams9.width = 0; // ����ͼƬ�Ŀ��
        circle.setLayoutParams(layoutParams9);

        final ViewGroup.MarginLayoutParams margin10 = new ViewGroup.MarginLayoutParams(
                original.getLayoutParams());
        margin10.setMargins(0, 0, 0, 0);// ����߾�400���أ����߾�10���ص�λ����ʾͼƬ
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(
                margin10);
        layoutParams10.height = 600;// ����ͼƬ�ĸ߶�
        layoutParams10.width = 600; // ����ͼƬ�Ŀ��
        original.setLayoutParams(layoutParams10);

        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 0x1233) {
                    if (x <= 600) {
                        margin9.setMargins(300 - x / 2, 300 - x / 2, 0, 0);
                        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(
                                margin9);
                        layoutParams9.height = (x);// ����ͼƬ�ĸ߶�
                        layoutParams9.width = (x); // ����ͼƬ�Ŀ��
                        circle.setLayoutParams(layoutParams9);
                    }
                } else if (msg.what == 0x1234) {
                    score.setText(x + " ");
                }
            }
        };

        // ʱ����
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                Message msg = new Message();
                msg.what = 0x1233;
                // ������Ϣ,֪ͨӦ���޸�ClipDrawable�����levelֵ
                handler.sendMessage(msg);
            }
        }, 0, 3);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (x <= 600)
                    x += 15;
//			Toast.makeText(getApplicationContext(), x + " ", Toast.LENGTH_SHORT)
//					.show();
                break;
            case MotionEvent.ACTION_UP:
                Message msg = new Message();
                msg.arg1 = x;
                msg.what = 0x1234;
                handler.sendMessage(msg);
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

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
