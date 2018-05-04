package demo.wuchunmei.com.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteCacheDataBaseHelper extends SQLiteOpenHelper {
	private final static String TAG = "SQLiteCacheDataBaseHelpter";
	
	private static final int DB_VERSION = 1; // 数据库版本
	
	public static final String DATABASE_TABLE_CACHE="TB_CACHE";
	public static final String DATABASE_TABLE_NOTE="TB_NOTECACHE";
	public static final String DATABASE_TABLE_BOOK="TB_BOOKCACHE";
	public static final String DATABASE_TABLE_BLOG="TB_BLOGCACHE";
	public SQLiteCacheDataBaseHelper(Context context) {
		this(context, CacheContentHelper.DB_NAME, null);
	}

	public SQLiteCacheDataBaseHelper(Context context, String name,
                                     CursorFactory factory) {
		super(context, name, factory, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		createDB1(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion == 0) {
			onCreate(db);
		}
//		else if (oldVersion == 1) {
//		}
	}

	private void createDB1(SQLiteDatabase db) {
		final String sqlCache = "CREATE TABLE IF NOT EXISTS TB_CACHE (_id integer primary key autoincrement, KEY nvarchar(200),CACHEDATA blob,TIME_STAMP int64)";
		db.execSQL(sqlCache);

		final String sqlNote = "CREATE TABLE IF NOT EXISTS TB_NOTECACHE (_id integer primary key autoincrement, CATEGORYID nvarchar(50),NOTEID int,PAGEINDEX int,NOTEDATA blob,TIME_STAMP int64)";
		db.execSQL(sqlNote);

		final String sqlBook = "CREATE TABLE IF NOT EXISTS TB_BOOKCACHE (_id integer primary key autoincrement, BOOKID int,CHAPTERID int,FIRSTCHAPTER int,BOOKDATA blob,TIME_STAMP int64)";
		db.execSQL(sqlBook);

		final String sqlBlog = "CREATE TABLE IF NOT EXISTS TB_BLOGCACHE (_id integer primary key autoincrement, BLOGID int,ARTICLEID int,BLOGDATA blob,TIME_STAMP int64)";
		db.execSQL(sqlBlog);
	}
}
