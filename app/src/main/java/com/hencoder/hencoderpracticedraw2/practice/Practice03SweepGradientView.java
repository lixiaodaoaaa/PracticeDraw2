package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice03SweepGradientView extends View{
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    
    public Practice03SweepGradientView(Context context){
        super(context);
    }
    
    public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    {
        // 用 Paint.setShader(shader) 设置一个 SweepGradient
        // SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3
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
        
        Shader shader=new SweepGradient(300, 300, 0xFFE91E63, 0xff2196F3);
        paint.setShader(shader);
        
        canvas.drawCircle(300, 300, 200, paint);
    }
}
