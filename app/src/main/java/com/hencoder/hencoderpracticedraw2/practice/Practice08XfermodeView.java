package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice08XfermodeView extends PracticeView{
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap1;
    Bitmap bitmap2;
    
    public Practice08XfermodeView(Context context){
        super(context);
    }
    
    public Practice08XfermodeView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice08XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    {
        bitmap1=BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        bitmap2=BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
    }
    
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        
        // 使用 paint.setXfermode() 设置不同的结合绘制效果
        
        // 别忘了用 canvas.saveLayer() 开启 off-screen buffer
        
        
        canvas.drawBitmap(bitmap1, 0, 0, paint);
        paint.setXfermode(getFirstMode()); // 设置 Xfermode
        canvas.drawBitmap(bitmap2, 0, 0, paint);
        paint.setXfermode(null); // 设置 Xfermode
        
        
        canvas.drawBitmap(bitmap1, bitmap1.getWidth() + 100, 0, paint);
        paint.setXfermode(getSecondMode()); // 设置 Xfermode
        canvas.drawBitmap(bitmap2, bitmap1.getWidth() + 100, 0, paint);
        paint.setXfermode(null); // 设置 Xfermode
        
        canvas.drawBitmap(bitmap1, 0, bitmap1.getHeight() + 20, paint);
        paint.setXfermode(getThirdMode()); // 设置 Xfermode
        canvas.drawBitmap(bitmap2, 0, bitmap1.getHeight() + 20, paint);
        paint.setXfermode(null); // 设置 Xfermode
        
    }
    
    
    private Xfermode getFirstMode(){
        return new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }
    
    private Xfermode getSecondMode(){
        return new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
    
    private Xfermode getThirdMode(){
        return new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }
    
}
