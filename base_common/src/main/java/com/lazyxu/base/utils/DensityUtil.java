
package com.lazyxu.base.utils;

import android.content.res.Resources;

public class DensityUtil {

    /**
     * 根据手机的分辨率从dp 的单位 转成为px(像素)
     */
    public static int dp2px(Resources resources, float dpValue) {
        final float scale = resources.getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public static float sp2px(Resources resources, float sp){
        final float scale = resources.getDisplayMetrics().scaledDensity;
        return sp * scale;
    }
}