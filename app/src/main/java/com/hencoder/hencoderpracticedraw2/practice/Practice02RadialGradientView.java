package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice02RadialGradientView extends View{
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    
    public Practice02RadialGradientView(Context context){
        super(context);
    }
    
    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    {
        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
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
        
        
        /****
         *   /** Create a shader that draws a radial gradient given the center and radius.
         @param centerX     The x-coordinate of the center of the radius
         @param centerY     The y-coordinate of the center of the radius
         @param radius      Must be positive. The radius of the circle for this gradient
         @param centerColor The color at the center of the circle.
         @param edgeColor   The color at the edge of the circle.
         @param tileMode    The Shader tiling mode
         */
        
        Shader shader=new RadialGradient(300, 300, 200, 0xffE91E63, 0xff2196F3, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        
        
        canvas.drawCircle(300, 300, 200, paint);
    }
}
