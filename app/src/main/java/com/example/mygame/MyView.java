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

		// ���û����ı�����ɫ
		canvas.drawColor(Color.WHITE);
		/**
		 * �������Ϊ����
		 */
		// ���廭��1
		final Paint paint = new Paint();
		paint.setStyle(Paint.Style.STROKE);
		// �������
		paint.setAntiAlias(true);
		// ���û��ʵ���ɫ
		paint.setColor(Color.BLACK);
		// ����paint�������
		paint.setStrokeWidth(2);

		// ��һ��Բ
		canvas.drawCircle(300, 500, 200, paint);
		// // ��һ��������
		// canvas.drawRect(20, 70, 70, 120, paint);
		// // ��һ��������
		// canvas.drawRect(20, 170, 90, 130, paint);
		// // ��һ����Բ
		// RectF re = new RectF(20, 230, 100, 190);
		// canvas.drawOval(re, paint);

		// ���廭��2
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
		// * �������Ϊʵ��
		// */
		// paint.setStyle(Paint.Style.FILL);
		// // ���廭��2
		// Paint paint2 = new Paint();
		// // �������
		// paint2.setAntiAlias(true);
		// // ���û��ʵ���ɫ
		// paint2.setColor(Color.BLUE);
		// // ��һ������Բ
		// canvas.drawCircle(150, 30, 20, paint2);
		// // ��һ��������
		// canvas.drawRect(185, 70, 130, 120, paint2);
		// // ��һ��������
		// canvas.drawRect(200, 130, 130, 180, paint2);
		// // ��һ����Բ��
		// RectF re2 = new RectF(200, 230, 130, 190);
		// canvas.drawOval(re2, paint2);
	}
}
