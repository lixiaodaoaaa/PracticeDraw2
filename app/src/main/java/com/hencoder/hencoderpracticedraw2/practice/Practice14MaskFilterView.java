package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice14MaskFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

    
        paint.setMaskFilter(getNormalMast());
        canvas.drawBitmap(bitmap, 100, 50, paint);

        paint.setMaskFilter(getInnerMask());
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, paint);
    
        paint.setMaskFilter(getOUterMask());
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, paint);
    
        paint.setMaskFilter(getOutMask());
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, paint);
    }
    
    
    private  BlurMaskFilter getNormalMast(){
        return new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL);
    }
    
    
    private BlurMaskFilter getOutMask(){
        return new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID);
    }
    
    
    private BlurMaskFilter getInnerMask(){
        return new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER);
    }
    
    
    private BlurMaskFilter getOUterMask(){
        return new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER);
    }
    
}
