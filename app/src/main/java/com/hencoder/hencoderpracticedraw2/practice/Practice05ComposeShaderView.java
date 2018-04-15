package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice05ComposeShaderView extends View{
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    
    public Practice05ComposeShaderView(Context context){
        super(context);
    }
    
    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
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
        
        Shader shaderBatman=new BitmapShader(getBatmanBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        
        Shader shaderLogo=new BitmapShader(getSecondBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        setLayerType(LAYER_TYPE_SOFTWARE, null); // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader
        
        
        /**
         * Create a new compose shader, given shaders A, B, and a combining PorterDuff mode.
         When the mode is applied, it will be given the result from shader A as its
         "dst", and the result from shader B as its "src".
         @param shaderA  The colors from this shader are seen as the "dst" by the mode
         @param shaderB  The colors from this shader are seen as the "src" by the mode
         @param mode     The PorterDuff mode that combines the colors from the two shaders.
         */
        Shader shaderPaint=new ComposeShader(shaderBatman, shaderLogo, PorterDuff.Mode.DST_IN);
        paint.setShader(shaderPaint);
        
        
        canvas.drawCircle(200, 200, 200, paint);
    }
    
    
    private Bitmap getBatmanBitmap(){
        return BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }
    
    private Bitmap getSecondBitmap(){
        return BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
    }
}
