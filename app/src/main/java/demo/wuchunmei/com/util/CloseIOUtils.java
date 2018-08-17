package demo.wuchunmei.com.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 功能描述：关闭相关工具类
 * <p></p>
 *
 * @author: chenLiangDuo
 * @date: 2017/6/12 17:02
 * version 1.0
 */
public class CloseIOUtils {

    private CloseIOUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 关闭IO
     *
     * @param closeables closeable
     */
    public static void closeIO(Closeable... closeables) {
        if (closeables == null)
            return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 安静关闭IO
     *
     * @param closeables closeable
     */
    public static void closeIOQuietly(Closeable... closeables) {
        if (closeables == null)
            return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
    
}
