package demo.wuchunmei.com.net.api;


import demo.wuchunmei.com.net.ResponseResultData;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 服务接口
 */
public interface ApiService {


    /**
     * 首页Banner
     *
     * @return BannerResponse
     */
    @GET("/banner/json")
    Observable<ResponseResultData> getHomeBanners();
}
