package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice06LightingColorFilterView extends PracticeView{
    
    public Practice06LightingColorFilterView(Context context){
        super(context);
    }
    
    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        
        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        
        // 第一个 LightingColorFilter：去掉红色部分
    
         Bitmap bitmap=getBitmapByResourceId(R.drawable.batman);
    
    
        paint.setColorFilter(getDeleteRedColorFilter());
        
        canvas.drawBitmap(getBitmapByResourceId(R.drawable.batman), 0, 0, paint);
        
        
        paint.setColorFilter(getEnchanceGreeColorFilter());
        
        // 第二个 LightingColorFilter：增强绿色部分
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
    
    
    private ColorFilter getDeleteRedColorFilter(){
        return new LightingColorFilter(0x00ffff, 0x000000);
    }
    
    private ColorFilter getEnchanceGreeColorFilter(){
        return new LightingColorFilter(0xFFFFFF, 0x004000);
    }
}
