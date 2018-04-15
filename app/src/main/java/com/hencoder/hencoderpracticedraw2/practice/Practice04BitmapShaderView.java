package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice04BitmapShaderView extends View{
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    
    public Practice04BitmapShaderView(Context context){
        super(context);
    }
    
    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    {
        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman
    }
    
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        
        
        int height=canvas.getHeight();
        int width=canvas.getWidth();
        float radius=200.0f;
        
        
        paint.setStyle(Paint.Style.FILL);
        
        
        float startX=100;
        float startY=100;
        float endX=500;
        float endY=500;
        
        
        /***
         *      * A subclass of Shader that draws a sweep gradient around a center point.
         *
         * @param cx       The x-coordinate of the center
         * @param cy       The y-coordinate of the center
         * @param color0   The color to use at the start of the sweep
         */
        
        Shader shader=new BitmapShader(getBatmanBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        
        canvas.drawCircle(200, 200, 200, paint);
    }
    
    private Bitmap getBatmanBitmap(){
        return BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }
}
