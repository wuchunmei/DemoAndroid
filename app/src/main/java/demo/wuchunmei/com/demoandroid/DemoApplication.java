package demo.wuchunmei.com.demoandroid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import demo.wuchunmei.com.util.Utils;


//								 _ooOoo_
//								o8888888o
//								88" . "88
//								(| -_- |)
//								 O\ = /O
//							 ____/`---'\____
//							.   ' \\| |// `.
//							/ \\||| : |||// \
//						  / _||||| -:- |||||- \
//							| | \\\ - /// | |
//						  | \_| ''\---/'' | |
//						   \ .-\__ `-` ___/-. /
//						___`. .' /--.--\ `. . __
//					 ."" '< `.___\_<|>_/___.' >'"".
//					| | : `- \`.;`\ _ /`;.`/ - ` : | |
//					  \ \ `-. \_ __\ /__ _/ .-` / /
//			======`-.____`-.___\_____/___.-`____.-'======
//								 `=---='
//			
//			.............................................
//						        佛祖镇楼                  BUG辟易
//				佛曰:
//						写字楼里写字间，写字间里程序员；
//						程序人员写程序，又拿程序换酒钱。
//						酒醒只在网上坐，酒醉还来网下眠；
//						酒醉酒醒日复日，网上网下年复年。
//						但愿老死电脑间，不愿鞠躬老板前；
//						奔驰宝马贵者趣，公交自行程序员。
//						别人笑我忒疯癫，我笑自己命太贱；
//						不见满街漂亮妹，哪个归得程序员？

/**
 * 作者：wuchunmei on 5/3/18 00:51
 * <p>
 * 邮箱：646812329@qq.com
 */
public class DemoApplication extends Application {

    public static volatile Context applicationContext;

    private static volatile boolean applicationInited = false;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
        Utils.init(this);
        init();
    }

    private void init() {
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}