package demo.wuchunmei.com.demoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import demo.wuchunmei.com.Util.DefaultDisposableObserver;
import demo.wuchunmei.com.Util.SchedulersCompat;
import demo.wuchunmei.com.Util.ToastUtil;
import demo.wuchunmei.com.net.ResponseResultData;
import demo.wuchunmei.com.net.api.ApiConnector;

public class MainActivity extends AppCompatActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiConnector.getHomeBanners(MainActivity.this)
                        .compose(SchedulersCompat.<ResponseResultData>applyIoSchedulers())
                        .subscribeWith(new DefaultDisposableObserver<ResponseResultData>(){
                            @Override
                            public void onNext(ResponseResultData responseResultData) {
                                super.onNext(responseResultData);
                                if(responseResultData.success()){
                                    ToastUtil.show("成功");
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                super.onError(e);
                                ToastUtil.show("失败");
                            }
                        });
            }
        });

    }
}
