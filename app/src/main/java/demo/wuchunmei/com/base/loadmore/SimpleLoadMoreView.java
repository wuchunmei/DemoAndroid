package demo.wuchunmei.com.base.loadmore;


import demo.wuchunmei.com.demoandroid.R;

/**
 * 作者：wuchunmei on 5/3/18 00:51
 * <p>
 * 邮箱：646812329@qq.com
 */

public final class SimpleLoadMoreView extends LoadMoreView {

    @Override
    public int getLayoutId() {
        return R.layout.quick_view_load_more;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }
}
