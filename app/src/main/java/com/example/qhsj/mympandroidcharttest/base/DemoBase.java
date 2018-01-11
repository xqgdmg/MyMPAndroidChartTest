
package com.example.qhsj.mympandroidcharttest.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Type;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.example.qhsj.mympandroidcharttest.R;


/**
 * Baseclass of all Activities of the Demo Application.
 * 
 * @author Philipp Jahoda
 */
public abstract class DemoBase extends FragmentActivity {

    /*
     * 返回的时候的 动画，显得不name生硬，地图回退会闪一下应该就是这个动画的原因
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }
}
