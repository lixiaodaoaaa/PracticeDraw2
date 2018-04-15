package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01LinearGradientView extends View{
    
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    
    public Practice01LinearGradientView(Context context){
        super(context);
    }
    
    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
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
        
        
        Shader shader=new LinearGradient(startX, startY, endX, endY, 0xffCC3079, 0xff4084DD, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        
        canvas.drawCircle(300, 300, 200, paint);
        
    }
}
