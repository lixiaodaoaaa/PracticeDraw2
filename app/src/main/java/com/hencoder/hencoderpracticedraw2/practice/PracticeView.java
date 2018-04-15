package com.hencoder.hencoderpracticedraw2.practice;
/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/4/15
       Time     :  16:54
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PracticeView extends View{
    
    
    public float mWidth;
    public float mHeight;
    
    public float centX;
    public float centY;
    
    public Paint paint;
    
    public PracticeView(Context context){
        super(context);
        init();
    }
    
    private void init(){
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    }
    
    public PracticeView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init();
    }
    
    public PracticeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }
    
    {
        setLayerType(LAYER_TYPE_SOFTWARE, null); // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader
        
        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
    }
    
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        
        mWidth=canvas.getWidth();
        mHeight=canvas.getHeight();
        
        centX=mWidth / 2;
        centY=mHeight / 2;
        
        
    }
    
    protected Bitmap getBitmapByResourceId(int id){
        return BitmapFactory.decodeResource(getResources(), id);
    }
}
