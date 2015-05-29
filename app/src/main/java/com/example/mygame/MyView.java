package com.example.mygame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class MyView extends View {

	public MyView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(final Canvas canvas) {

		super.onDraw(canvas);

		// 设置画布的背景颜色
		canvas.drawColor(Color.WHITE);
		/**
		 * 定义矩形为空心
		 */
		// 定义画笔1
		final Paint paint = new Paint();
		paint.setStyle(Paint.Style.STROKE);
		// 消除锯齿
		paint.setAntiAlias(true);
		// 设置画笔的颜色
		paint.setColor(Color.BLACK);
		// 设置paint的外框宽度
		paint.setStrokeWidth(2);

		// 画一个圆
		canvas.drawCircle(300, 500, 200, paint);
		// // 画一个正放形
		// canvas.drawRect(20, 70, 70, 120, paint);
		// // 画一个长方形
		// canvas.drawRect(20, 170, 90, 130, paint);
		// // 画一个椭圆
		// RectF re = new RectF(20, 230, 100, 190);
		// canvas.drawOval(re, paint);

		// 定义画笔2
		final Paint paint2 = new Paint();
		paint2.setColor(Color.RED);
		paint2.setStyle(Paint.Style.FILL);
		new Thread() {
			public void run() {
				int i = 0;
				int n = 10;
				while (n-- != 0) {
					canvas.drawCircle(300, 500, 100 + (i += 10), paint2);
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.run();

		// /**
		// * 定义矩形为实心
		// */
		// paint.setStyle(Paint.Style.FILL);
		// // 定义画笔2
		// Paint paint2 = new Paint();
		// // 消除锯齿
		// paint2.setAntiAlias(true);
		// // 设置画笔的颜色
		// paint2.setColor(Color.BLUE);
		// // 画一个空心圆
		// canvas.drawCircle(150, 30, 20, paint2);
		// // 画一个正方形
		// canvas.drawRect(185, 70, 130, 120, paint2);
		// // 画一个长方形
		// canvas.drawRect(200, 130, 130, 180, paint2);
		// // 画一个椭圆形
		// RectF re2 = new RectF(200, 230, 130, 190);
		// canvas.drawOval(re2, paint2);
	}
}
