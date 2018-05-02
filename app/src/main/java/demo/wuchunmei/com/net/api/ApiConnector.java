package demo.wuchunmei.com.net.api;

import android.content.Context;

import demo.wuchunmei.com.net.ResponseResultData;
import demo.wuchunmei.com.net.RetrofitWrapper;
import io.reactivex.Observable;

/**
 * 接口Ｃonnector
 */
public class ApiConnector {
    private static ApiService create(Context context){
        return RetrofitWrapper.INSTANCE.getInstance(context.getApplicationContext()).create(ApiService.class);
    }


    public static Observable<ResponseResultData> getHomeBanners(Context context){
        return create(context).getHomeBanners();
    }
}
