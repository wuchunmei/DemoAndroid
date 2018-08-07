package demo.wuchunmei.com.demoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.widget.TextView;



import demo.wuchunmei.com.util.CountdownUtils;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * 作者：wuchunmei on 8/7/18 03:59
 */
public class CountDownActivity extends Activity{
    private TextView mTextView;
    private Disposable mDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        mTextView = (TextView)findViewById(R.id.count_tv);
        setCountDown(604616);
    }

    private void setCountDown( long time){
        mDisposable = CountdownUtils.countDown(time).subscribeWith(new DisposableObserver<Long>() {
            @Override
            public void onNext(Long aLong) {
                String time = getTime(aLong);
                mTextView.setText(time);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }



    private String getTime (long time){
        String DateTimes = null;
        long days = time / ( 60 * 60 * 24);
        long hours = (time % ( 60 * 60 * 24)) / (60 * 60);
        long minutes = (time % ( 60 * 60)) /60;
        long seconds = time % 60;
        if(days>0){
            DateTimes= days + "天" + hours + "小时" + minutes + "分钟"
                    + seconds + "秒";
        }else if(hours>0){
            DateTimes=hours + "小时" + minutes + "分钟"
                    + seconds + "秒";
        }else if(minutes>0){
            DateTimes=minutes + "分钟"
                    + seconds + "秒";
        }else{
            DateTimes=seconds + "秒";
        }

        return DateTimes;
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mDisposable != null && !mDisposable.isDisposed()){
            mDisposable.dispose();
        }
    }
}
