package demo.wuchunmei.com.code;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import demo.wuchunmei.com.net.BaseContract;
import demo.wuchunmei.com.net.RxBasePresenter;


/**
 * Created by wuchunmei
 * on 2018/10/24
 */
public abstract class SimpleBaseActivity<T extends RxBasePresenter> extends AppCompatActivity implements BaseContract.BaseView {

    protected T mPresenter;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mContext = this;
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract int getLayout();

    protected abstract void initEventAndData();

    protected abstract T createPresenter();

    protected abstract void initView();

}
