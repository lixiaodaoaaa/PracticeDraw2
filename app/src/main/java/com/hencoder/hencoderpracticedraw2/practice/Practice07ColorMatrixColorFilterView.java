package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice07ColorMatrixColorFilterView extends PracticeView{
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    
    public Practice07ColorMatrixColorFilterView(Context context){
        super(context);
    }
    
    public Practice07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    {
        bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        
        // 使用 setColorFilter() 设置一个 ColorMatrixColorFilter
        // 用 ColorMatrixColorFilter.setSaturation() 把饱和度去掉
    }
    
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        
        
        //去除饱和度 来自 百度  代码 ：
        ColorMatrix mSaturationMatrix=new ColorMatrix();
        mSaturationMatrix.setSaturation(0);
        
        paint.setColorFilter(new ColorMatrixColorFilter(mSaturationMatrix));//设置颜色变换效果
        
        
        canvas.drawBitmap(getBitmapByResourceId(R.drawable.batman), 0, 0, paint);
    }
}
