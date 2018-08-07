package demo.wuchunmei.com.util;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：wuchunmei on 8/7/18 04:08
 */
public class CountdownUtils {

    public static Observable<Long>countDown(long time){
        if (time < 0) time = 0;
        final long countTime = time;
        return Observable.interval(0,1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        Log.d("wu","aLong"+aLong);
                        return countTime - aLong.intValue();
                    }
                }).take(countTime + 1);
    }

}
