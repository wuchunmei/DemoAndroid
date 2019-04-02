package demo.wuchunmei.com.code;


import android.content.Context;
import android.util.Log;



import java.util.List;

import demo.wuchunmei.com.net.RxBasePresenter;


/**
 * Created by wuchunmei
 * on 2019/3/28
 */
public class CodePresenter extends RxBasePresenter<CodeContract.View> implements CodeContract.Presenter<CodeContract.View> {

    private Context mContext;

    public CodePresenter(Context context) {
        mContext = context;
    }

    @Override
    public void getCode(String mobileNo, String remarkInfo) {
//        addSubscrebe(TourServiceConnetor.sendCode(mobileNo, remarkInfo)
//                .compose(LoadingTransformer.applyLoading(mContext, "正在加载..."))
//                .compose(SchedulersCompat.applyIoSchedulers())
//                .subscribeWith(new DefaultDisposableObserver<ResponseResult<CaptchaResult>>() {
//                    @Override
//                    public void onNext(ResponseResult<CaptchaResult> captchaResultResponseResult) {
//                        if (captchaResultResponseResult != null) {
//                            CaptchaResult captchaResult = captchaResultResponseResult.data;
//                            if (captchaResult != null) {
//                                mView.showmes();
//                                Log.d("wu", captchaResult.getMsgInfo());
//                            } else {
//                                Log.d("wu", "hfhfhhf");
//                            }
//                        }
//                        super.onNext(captchaResultResponseResult);
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        super.onError(throwable);
//                    }
//                }));

    }

    @Override
    public void advertisementList(Context context, String pageIndex, String pageSize, String type) {

//        addSubscrebe(TourServiceConnetor.advertisementList(context,pageIndex,pageSize,type)
//                .compose(LoadingTransformer.applyLoading(mContext, "正在加载..."))
//                .compose(SchedulersCompat.applyIoSchedulers())
//                .subscribeWith(new DefaultDisposableObserver<ResponseResult<HotRecommendationResult>>(){
//                    @Override
//                    public void onNext(ResponseResult<HotRecommendationResult> hotRecommendationResultResponseResult) {
//                        super.onNext(hotRecommendationResultResponseResult);
//                        if(hotRecommendationResultResponseResult != null){
//                            HotRecommendationResult hotRecommendationResult = hotRecommendationResultResponseResult.data;
//                            if(hotRecommendationResult != null){
//                                List<ListBean> listBeans = hotRecommendationResult.getList();
//                                Log.d("wu","实体》》"+listBeans.size());
//                            }
//                        }else {
//                            Log.d("wu","错误》》"+hotRecommendationResultResponseResult.msg);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        super.onError(throwable);
//                        Log.d("wu","e>>"+throwable.getMessage());
//                    }
//                })
//        );
    }


}
