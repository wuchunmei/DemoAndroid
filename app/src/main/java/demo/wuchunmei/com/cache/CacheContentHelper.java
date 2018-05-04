package demo.wuchunmei.com.cache;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.net.Uri;
import android.text.format.DateUtils;

import java.util.ArrayList;
import java.util.Date;

import demo.wuchunmei.com.demoandroid.R;


public class CacheContentHelper {
	public static final String DB_NAME = "cache.db";
    private static String getAuthority(Context context){
    	return context.getString(R.id.authority_cache);
    }
    public static Uri getCacheContentUri(Context context){
    	String authority=getAuthority(context);
    	return Uri.parse("content://" + authority + "/" + CacheContentProvider.CACHE_PATH);
    }
    public static Uri getNoteContentUri(Context context){
    	String authority=getAuthority(context);
    	return Uri.parse("content://" + authority + "/" + CacheContentProvider.NOTE_PATH);
    }
    public static Uri getBookContentUri(Context context){
    	String authority=getAuthority(context);
    	return Uri.parse("content://" + authority + "/" + CacheContentProvider.BOOK_PATH);
    }
    public static Uri getBlogContentUri(Context context){
    	String authority=getAuthority(context);
    	return Uri.parse("content://" + authority + "/" + CacheContentProvider.BLOG_PATH);
    }

	/**
	 * 清除缓存和临时数据，包括Blog,Note,Book等数据
	 * @param context
	 */
	public static void clearAllCache(Context context){
		try{
			
			//CacheContentHelper.getBlogContentUri(context)
			ArrayList<ContentProviderOperation> operations=new ArrayList<ContentProviderOperation>();
			operations.add(ContentProviderOperation.newDelete(getBlogContentUri(context)).build());
			operations.add(ContentProviderOperation.newDelete(getBookContentUri(context)).build());
			operations.add(ContentProviderOperation.newDelete(getNoteContentUri(context)).build());
			operations.add(ContentProviderOperation.newDelete(getCacheContentUri(context)).build());
			
			context.getContentResolver().applyBatch(getAuthority(context), operations);
								
		}catch(Throwable ex){
			ex.printStackTrace();
		}
	}
	/**
	 * 清除过期的缓存和临时数据，包括Blog,Note,Book等数据
	 * @param context
	 */
	public static void clearAxpiredCache(Context context){
		try{
			Date date=new Date();
			long time=date.getTime()-20*DateUtils.DAY_IN_MILLIS;//20天前的数据
			//CacheContentHelper.getBlogContentUri(context)
			String[] args=new String[]{String.valueOf(time)};
			ArrayList<ContentProviderOperation> operations=new ArrayList<ContentProviderOperation>();
			operations.add(ContentProviderOperation.newDelete(getBlogContentUri(context))
					.withSelection("TIME_STAMP<?", args).build());
			operations.add(ContentProviderOperation.newDelete(getBookContentUri(context))
					.withSelection("TIME_STAMP<?", args).build());
			operations.add(ContentProviderOperation.newDelete(getNoteContentUri(context))
					.withSelection("TIME_STAMP<?", args).build());
			operations.add(ContentProviderOperation.newDelete(getCacheContentUri(context))
					.withSelection("TIME_STAMP<?", args).build());
			context.getContentResolver().applyBatch(getAuthority(context), operations);
		}catch(Throwable ex){
			ex.printStackTrace();
		}
	}
}
