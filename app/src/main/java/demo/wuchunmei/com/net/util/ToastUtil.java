package demo.wuchunmei.com.net.util;

import android.widget.Toast;

import demo.wuchunmei.com.demoandroid.DemoApplication;

public class ToastUtil {

    private static Toast toast;

    public static void show(String content) {
        if (toast == null) {
            toast = Toast.makeText(DemoApplication.applicationContext, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

}