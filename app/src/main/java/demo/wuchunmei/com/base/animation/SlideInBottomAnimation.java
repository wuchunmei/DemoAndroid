package demo.wuchunmei.com.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import demo.wuchunmei.com.base.BaseAnimation;


/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SlideInBottomAnimation implements BaseAnimation {
    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0)
        };
    }
}
