package com.example.andoridtoolbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.example.andoridtoolbox.R;

public class SurfaceViewL extends SurfaceView implements SurfaceHolder.Callback, Runnable {

//    private SurfaceHolder mHolder;
//    private Canvas mCanvas;
//    private boolean mIsDrawing;
//
//    public SurfaceViewL(Context context) {
//        super(context);
//        initView();
//    }
//
//    public SurfaceViewL(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        initView();
//    }
//
//    public SurfaceViewL(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        initView();
//    }
//
//    private void initView() {
//        mHolder = getHolder(); //获取SurfaceHolder对象
//        mHolder.addCallback(this);
//        setFocusable(true);
//        setFocusableInTouchMode(true);
//        this.setKeepScreenOn(true);
//    }
//
//    @Override
//    public void surfaceCreated(SurfaceHolder holder) {
//        mIsDrawing = true;
//        new Thread(this).start();
//    }
//
//    @Override
//    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder) {
//        while(mIsDrawing){
//            draw();
//        }
//    }
//
//    private void draw() {
//        try {
//            mCanvas = mHolder.lockCanvas();
//        }catch (Exception e){
//
//        }finally {
//            if (mCanvas != null)
//                mHolder.unlockCanvasAndPost(mCanvas);
//        }
//
//
//    }
//
//    @Override
//    public void run() {
//
//    }
//}


    private SurfaceHolder mSurfaceHolder;    // 画布
    private Canvas mCanvas;    // 子线程标志位
    private boolean isDrawing;    // 画笔
    Paint mPaint;    // 路径
    Path mPath;
    private float mLastX, mLastY;//上次的坐标

    public SurfaceViewL(Context context) {
        super(context);
        init();
    }

    public SurfaceViewL(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化
     */
    private void init() {        //初始化 SurfaceHolder mSurfaceHolder
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);

        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);        //画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setStrokeWidth(10f);
        mPaint.setColor(Color.parseColor(getContext().getString(R.string.PainColor)));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);        //路径
        mPath = new Path();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {//创建
        isDrawing = true;
        Log.e("surfaceCreated","--"+isDrawing);        //绘制线程
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {//改变

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {//销毁
        isDrawing = false;
        Log.e("surfaceDestroyed","--"+isDrawing);
    }

    public static final int TIME_IN_FRAME = 30;
    @Override
    public void run() {
        long startTime ;

        while (isDrawing){
            startTime = System.currentTimeMillis();

            drawing();

            /**取得更新结束的时间**/
            long endTime = System.currentTimeMillis();

            /**计算出一次更新的毫秒数**/
            int diffTime  = (int)(endTime - startTime);

            Log.d("TAG", "run: ");
            /**确保每次更新时间为30帧**/
            while(diffTime <=TIME_IN_FRAME) {
                diffTime = (int)(System.currentTimeMillis() - startTime);
                /**线程等待**/
                Thread.yield();
            }
        }


    }

    /**
     * 绘制
     */
    private void drawing() {
        try{
            mCanvas=mSurfaceHolder.lockCanvas();//获取Canvas对象进行绘制
            //SurfaceView背景
            mCanvas.drawColor(Color.WHITE);
            mCanvas.drawPath(mPath,mPaint);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (mCanvas!=null){
                mSurfaceHolder.unlockCanvasAndPost(mCanvas);//保证绘制的画布内容提交
            }
        }
    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        float x = event.getX();
//        float y = event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                mLastX = x;
//                mLastY = y;
//                mPath.moveTo(mLastX, mLastY);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                float dx = Math.abs(x - mLastX);
//                float dy = Math.abs(y - mLastY);
//                if (dx >= 3 || dy >= 3) {
//                    mPath.quadTo(mLastX, mLastY, (mLastX + x) / 2, (mLastY + y) / 2);
//                }
//                mLastX = x;
//                mLastY = y;
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }        return true;
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x=(int)event.getX();
        int y=(int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;//表示此View拦截处理触摸事件
    }

    /**
     * 测量
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int wSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (wSpecMode == MeasureSpec.AT_MOST && hSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(300, 300);
        } else if (wSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(300, hSpecSize);
        } else if (hSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(wSpecSize, 300);
        }
    }
}
