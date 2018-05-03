package demo.wuchunmei.com.demoandroid;

import android.annotation.SuppressLint;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

import demo.wuchunmei.com.base.BaseActivity;
import demo.wuchunmei.com.bean.Travel;
import demo.wuchunmei.com.constant.Constant;
import demo.wuchunmei.com.net.ResponseResultData;
import demo.wuchunmei.com.net.api.ApiConnector;
import demo.wuchunmei.com.net.util.DefaultDisposableObserver;
import demo.wuchunmei.com.net.util.LoadingTransformer;
import demo.wuchunmei.com.net.util.SchedulersCompat;
import demo.wuchunmei.com.util.ToastUtils;


/**
 * 作者：wuchunmei on 5/3/18 00:51
 * <p>
 * 邮箱：646812329@qq.com
 */

public class MainActivity extends BaseActivity {
    private Button mButton;
    private Context mContext;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mContext = this;
        mButton = (Button)findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View v) {
                ApiConnector.getTripadvisor(mContext, Constant.TRIPADVISOR_ID,Constant.APIKEY)
                        .compose(LoadingTransformer.<ResponseResultData<List<Travel>>>applyLoading(mContext,getString(R.string.loading)))
                        .compose(SchedulersCompat.<ResponseResultData<List<Travel>>>applyIoSchedulers())
                        .subscribeWith(new DefaultDisposableObserver<ResponseResultData<List<Travel>>>(){
                            @Override
                            public void onNext(ResponseResultData<List<Travel>> travelResponseResultData) {
                                super.onNext(travelResponseResultData);
                                List<Travel> list = travelResponseResultData.getData();
                                ToastUtils.showLong("成功");
                            }

                            @Override
                            public void onError(Throwable e) {
                                super.onError(e);
                                ToastUtils.showLong("失败");
                            }
                        });
            }
        });
    }

}
