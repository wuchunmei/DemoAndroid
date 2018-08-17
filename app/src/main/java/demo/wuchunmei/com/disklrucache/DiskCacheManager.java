package demo.wuchunmei.com.disklrucache;

import android.content.Context;
import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import demo.wuchunmei.com.constant.Constant;
import demo.wuchunmei.com.demoandroid.BaseApplication;
import demo.wuchunmei.com.util.EncryptUtils;
import demo.wuchunmei.com.util.Utils;


/**
 * 功能描述：磁盘缓存工具类
 * <p>
 * DiskLruCache 使用时需要注意：
 * <p>
 * 1.每一条缓存都有一个 String 类型的 key 与之对应，每一个 key 中的值都必须满足 [a-z0-9_-]{1,120}的规则即数字大小写字母长度在1-120之间，<br>
 * 所以推荐将字符串譬如图片的 url 等进行 MD5 加密后作为 key。
 * <p>
 * 2.DiskLruCache 的数据是缓存在文件系统的某一目录中的，这个目录必须是唯一对应某一条缓存的，缓存可能会重写和删除目录中的文件。多个进程同一时间使用同一个缓存目录会出错。
 * <p>
 * 3.DiskLruCache 遵从 LRU 算法，当缓存数据达到设定的极限值时将会后台自动按照 LRU 算法移除缓存直到满足存下新的缓存不超过极限值。
 * <p>
 * 4.一条缓存记录一次只能有一个 editor ，如果值不可编辑将会返回一个空值。
 * <p>
 * 5.当一条缓存创建时，应该提供完整的值，如果是空值的话使用占位符代替。
 * <p>
 * 6.如果文件从文件系统中丢失，相应的条目将从缓存中删除。如果写入缓存值时出错，编辑将失败。
 *
 * @author: chenLiangDuo
 * @date: 2017/6/12 18:06
 * version 1.0
 */
public class DiskCacheManager {

    private static DiskLruCache mDiskLruCache = null;
    private DiskLruCache.Editor mEditor = null;
    private DiskLruCache.Snapshot mSnapshot = null;

    private DiskCacheManager() {
        try {
            //先关闭已有的缓存
            if (mDiskLruCache != null) {
                mDiskLruCache.close();
                mDiskLruCache = null;
            }
            File cacheFile = getCacheFile(Utils.getApp(), Constant.UNIQUE_NAME);
            mDiskLruCache = DiskLruCache.open(cacheFile,
                    BaseApplication.getVersionCode(Utils.getApp()), 1, Constant.CACHE_MAXSIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SingletonInstance {
        private static final DiskCacheManager INSTANCE = new DiskCacheManager();
    }

    public static DiskCacheManager getInstance() {
        return SingletonInstance.INSTANCE;
    }

    /**
     * 获取缓存的路径 两个路径在卸载程序时都会删除，因此不会在卸载后还保留乱七八糟的缓存
     * 有SD卡时获取  /sdcard/Android/data/<application package>/cache
     * 无SD卡时获取  /data/data/<application package>/cache
     *
     * @param context    上下文
     * @param uniqueName 缓存目录下的细分目录，用于存放不同类型的缓存
     * @return 缓存目录 File
     */
    private File getCacheFile(Context context, String uniqueName) {
        String cachePath = null;
        if ((Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable())
                && context.getExternalCacheDir() != null) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }

    /**
     * 获取缓存 editor
     *
     * @param key 缓存的key
     * @return editor
     * @throws IOException
     */
    private DiskLruCache.Editor edit(String key) throws IOException {
        key = EncryptUtils.encryptMD5ToString(key); //存取的 key
        if (mDiskLruCache != null) {
            mEditor = mDiskLruCache.edit(key);
        }
        return mEditor;
    }

    /**
     * 根据 key 获取缓存缩略
     *
     * @param key 缓存的key
     * @return Snapshot
     */
    private DiskLruCache.Snapshot snapshot(String key) {
        if (mDiskLruCache != null) {
            try {
                mSnapshot = mDiskLruCache.get(key);
                System.out.println(mDiskLruCache);
                System.out.println(mSnapshot);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        return mSnapshot;
    }

    /*************************
     * 字符串读写
     *************************/
    /**
     * 缓存 String
     *
     * @param key   缓存文件键值（MD5加密结果作为缓存文件名）
     * @param value 缓存内容
     */
    public void put(String key, String value) {
        DiskLruCache.Editor editor = null;
        BufferedWriter writer = null;
        try {
            editor = edit(key);
            if (editor == null) {
                return;
            }
            OutputStream os = editor.newOutputStream(0);
            writer = new BufferedWriter(new OutputStreamWriter(os));
            writer.write(value);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (editor != null)
                    editor.abort();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取字符串缓存
     *
     * @param key cache'key
     * @return string
     */
    public String getString(String key) {
        InputStream inputStream = getCacheInputStream(key);
        if (inputStream == null) {
            return null;
        }
        try {
            return inputStream2String(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /*************************
     * Json对象读写
     *************************/
    //Json 数据转换成 String 存储
    public void put(String key, JSONObject value) {
        put(key, value.toString());
    }

    //取得 json 字符串再转为 Json对象
    public JSONObject getJsonObject(String key) {
        String json = getString(key);
        try {
            return new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*************************
     * Json数组对象读写
     *************************/

    public void put(String key, JSONArray array) {
        put(key, array.toString());
    }

    public JSONArray getJsonArray(String key) {
        try {
            return new JSONArray(getString(key));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*************************
     * byte 数据读写
     *************************/
    /**
     * 存入byte数组
     *
     * @param key   cache'key
     * @param bytes bytes to save
     */
    public void put(String key, byte[] bytes) {
        OutputStream out = null;
        DiskLruCache.Editor editor = null;
        try {
            editor = edit(key);
            if (editor == null) {
                return;
            }
            out = editor.newOutputStream(0);
            out.write(bytes);
            out.flush();
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                if (editor != null) {
                    editor.abort();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取缓存的 byte 数组
     *
     * @param key cache'key
     * @return bytes
     */
    public byte[] getBytes(String key) {
        byte[] bytes = null;
        InputStream inputStream = getCacheInputStream(key);
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[256];
        int len = 0;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /*************************
     * 序列化对象数据读写
     *************************/

    /**
     * 序列化对象写入
     *
     * @param key    cache'key
     * @param object 待缓存的序列化对象
     */
    public void put(String key, Object object) {
        ObjectOutputStream oos = null;
        DiskLruCache.Editor editor = null;
        try {
            editor = edit(key);
            if (editor == null) {
                return;
            }
            oos = new ObjectOutputStream(editor.newOutputStream(0));
            oos.writeObject(object);
            oos.flush();
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                if (editor != null)
                    editor.abort();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取 序列化对象
     *
     * @param key cache'key
     * @param <T> 对象类型
     * @return 读取到的序列化对象
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        T object = null;
        ObjectInputStream ois = null;
        InputStream in = getCacheInputStream(key);
        if (in == null) {
            return null;
        }
        try {
            ois = new ObjectInputStream(in);
            object = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }


    /************************************************************************
     **********************  辅助工具方法 分割线  ****************************
     ************************************************************************/
    /**
     * inputStream 转 String
     *
     * @param is 输入流
     * @return 结果字符串
     */
    private String inputStream2String(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        StringBuilder buffer = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

    /**
     * 获取 缓存数据的 InputStream
     *
     * @param key cache'key
     * @return InputStream
     */
    private InputStream getCacheInputStream(String key) {
        key = EncryptUtils.encryptMD5ToString(key);
        InputStream in;
        DiskLruCache.Snapshot snapshot = snapshot(key);
        if (snapshot == null) {
            return null;
        }
        in = snapshot.getInputStream(0);
        return in;
    }

    /**
     * 同步记录文件
     */
    public void flush() {
        if (mDiskLruCache != null) {
            try {
                mDiskLruCache.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete() {
        if (mDiskLruCache != null) {
            try {
                mDiskLruCache.deleteNotClose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
