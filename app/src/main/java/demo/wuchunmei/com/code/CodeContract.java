package demo.wuchunmei.com.code;


import android.content.Context;

import demo.wuchunmei.com.net.BaseContract;


/**
 * Created by Administrator on 2017/11/30 0030.
 */
public interface CodeContract {

    interface View extends BaseContract.BaseView {
        void showmes();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getCode(String mobileNo, String remarkInfo);
        void advertisementList(Context context, String pageIndex, String pageSize, String type);
    }
}
