package demo.wuchunmei.com.net;

/**
 * Created by wuchunmei
 * on 2019/3/28
 */

public interface BaseContract {
    interface BaseView {

    }

    interface BasePresenter<T> {

        void attachView(T view);

        void detachView();

    }

}