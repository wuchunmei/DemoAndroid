package demo.wuchunmei.com.net.api;


import java.util.List;

import demo.wuchunmei.com.bean.Travel;
import demo.wuchunmei.com.net.ResponseResultData;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 服务接口
 */
public interface ApiService {

    /**
     * 猫途鹰游记
     * @param id
     * @return
     */
    @GET("/post/tripadvisor")
    Observable<ResponseResultData<List<Travel>>> getTripadvisor(@Query("id") String id, @Query("apikey") String apikey);

}
