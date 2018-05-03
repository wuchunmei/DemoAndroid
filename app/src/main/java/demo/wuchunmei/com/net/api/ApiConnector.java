package demo.wuchunmei.com.net.api;

import android.content.Context;

import java.util.List;

import demo.wuchunmei.com.bean.Travel;
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

    /**
     * 获取猫途鹰游记
     * @param context
     * @param id
     * @return
     */
    public static Observable<ResponseResultData<List<Travel>>> getTripadvisor(Context context, String id, String apikey){
        return create(context).getTripadvisor(id,apikey);
    }

}
