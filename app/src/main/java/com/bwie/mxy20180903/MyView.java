package com.bwie.mxy20180903;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    private int hmode;
    private int wmode;
    private int wsize;
    private int hsize;
    private Paint paint;
    private Paint mpain;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        wmode=MeasureSpec.getMode(widthMeasureSpec);
        hmode=MeasureSpec.getMode(heightMeasureSpec);

        wsize=MeasureSpec.getSize(widthMeasureSpec);
        hsize=MeasureSpec.getSize(heightMeasureSpec);

        if (wmode == MeasureSpec.AT_MOST && hmode == MeasureSpec.AT_MOST){
            setMeasuredDimension(wsize,hsize);
        }else if(wsize == MeasureSpec.AT_MOST){
            setMeasuredDimension(wsize,450);
        }else if (hmode == MeasureSpec.AT_MOST){
            setMeasuredDimension(450,hsize);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //创建画笔
        mpain = new Paint();
        paint = new Paint();

        paint.setColor(Color.BLUE);
        mpain.setColor(Color.BLACK);

        paint.setTextSize(80);
        canvas.drawText("成本费用占比",150,500,paint);

        //计算高度
        int u = 400  /50;
        for(int i=0; i<u; i++){

        }
        for (int i=0; i<6; i++){
            canvas.drawLine(20,80 * i,wsize,80 * i,mpain);
        }
        for (int i=0; i<9; i++){
            canvas.drawLine(20+(100*i),0,20+(100*i),400,mpain);
        }
        canvas.drawRect(40,120,100,400,paint);
        canvas.drawRect(140,100,200,400,paint);
        canvas.drawRect(240,200,300,400,paint);
        canvas.drawRect(340,160,400,400,paint);


        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        paint.setTextSize(20);
        canvas.drawText("27.64%",40,300,paint);
        canvas.drawText("28.17%",140,100,paint);
        canvas.drawText("21.48%",240,110,paint);
        canvas.drawText("22.70%",340,170,paint);


        canvas.drawText("管理成本",40,420,paint);
        canvas.drawText("劳务成本",140,420,paint);
        canvas.drawText("销售成本",240,420,paint);
        canvas.drawText("资产盘亏",340,420,paint);

        canvas.drawText("0.00%",0,320,paint);
        canvas.drawText("5.00%",0,240,paint);
        canvas.drawText("10.00%",0,160,paint);
        canvas.drawText("15.00%",0,80,paint);
        canvas.drawText("20.00%",0,0,paint);
        canvas.drawText("25.00%",0,-80,paint);
        canvas.drawText("30.00%",0,-160,paint);

    }
}
