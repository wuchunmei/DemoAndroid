package demo.wuchunmei.com.cache;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;

import java.util.Map;

import demo.wuchunmei.com.util.ContentProviderUtil;


/**
 * 缓存ContentProvider
 *
 */
public class CacheContentProvider extends ContentProvider {
    private static final String TAG = "CacheContentProvider";
	private static final String SDCARD_DBPATH = "data";

    public static final String CACHE_PATH = "caches";
    public static final String NOTE_PATH = "notes";
    public static final String BOOK_PATH = "books";
    public static final String BLOG_PATH = "blogs";
        
    private static final int CACHES = 1;
    private static final int CACHE_ID = 2;
    
    private static final int NOTES = 3;
    private static final int NOTE_ID = 4;

    private static final int BOOKS = 5;
    private static final int BOOK_ID = 6;

    private static final int BLOGS = 7;
    private static final int BLOG_ID = 8;
    
    protected SQLiteOpenHelper mOpenHelper;

    public static final String[] ID_PROJECTION=new String[]{
    	BaseColumns._ID};
    public static final String[] ROWID_PROJECTION=new String[]{
    	"ROWID"};
    
    private static final String DEFAULT_ODEDER=BaseColumns._ID + " DESC";
    

    private static Map<String, String> sCacheColumnItemsProjectionMap;
    private static UriMatcher sUriMatcher;
    static{
    	sCacheColumnItemsProjectionMap=CacheDataManager.createCacheColumnItems();
    }
    @Override
    public boolean onCreate() {
        mOpenHelper = new SQLiteCacheDataBaseHelper(getContext());
        return true;
    }
    @Override
    public void attachInfo (Context context, ProviderInfo info) {
    	super.attachInfo(context, info);
  
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        
        sUriMatcher.addURI(info.authority, CACHE_PATH, CACHES);
        sUriMatcher.addURI(info.authority, CACHE_PATH + "/#", CACHE_ID);
        sUriMatcher.addURI(info.authority, NOTE_PATH, NOTES);
        sUriMatcher.addURI(info.authority, NOTE_PATH + "/#", NOTE_ID);
        sUriMatcher.addURI(info.authority, BOOK_PATH, BOOKS);
        sUriMatcher.addURI(info.authority, BOOK_PATH + "/#", BOOK_ID);

        sUriMatcher.addURI(info.authority, BLOG_PATH, BLOGS);
        sUriMatcher.addURI(info.authority, BLOG_PATH + "/#", BLOG_ID);
        
    }
    protected int matchType(Uri uri){
    	if (sUriMatcher!=null){
    		return sUriMatcher.match(uri);
    	}
    	String urlText=uri.toString();
    	if (urlText.endsWith(CACHE_PATH)){
    		return CACHES;
    	}
    	if (urlText.endsWith(NOTE_PATH)){
    		return NOTES;
    	}
    	if (urlText.endsWith(BOOK_PATH)){
    		return BOOKS;
    	}
    	if (urlText.endsWith(BLOG_PATH)){
    		return BLOGS;
    	}
    	if (urlText.contains(CACHE_PATH + "/")){
    		return CACHE_ID;
    	}
    	if (urlText.contains(NOTE_PATH + "/")){
    		return NOTE_ID;
    	}
    	if (urlText.contains(BOOK_PATH + "/")){
    		return BOOK_ID;
    	}
    	if (urlText.contains(BLOG_PATH + "/")){
    		return BLOG_ID;
    	}
        throw new IllegalArgumentException("Unknown URI " + uri);
    }
	@Override
	public int delete(Uri uri, String where, String[] whereArgs) {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int count;
        switch (matchType(uri)) {
            case CACHES:{
                count = db.delete(SQLiteCacheDataBaseHelper.DATABASE_TABLE_CACHE, where, whereArgs);
                break;
            }
            case CACHE_ID:{
                String rowId = uri.getPathSegments().get(1);
                count = db.delete(SQLiteCacheDataBaseHelper.DATABASE_TABLE_CACHE, "ROWID="
                        + rowId
                        + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
                break;
            }
            case NOTES:{
                count = db.delete(SQLiteCacheDataBaseHelper.DATABASE_TABLE_NOTE, where, whereArgs);
                break;
            }
            case NOTE_ID:{
                String rowId = uri.getPathSegments().get(1);
                count = db.delete(SQLiteCacheDataBaseHelper.DATABASE_TABLE_NOTE, "ROWID="
                        + rowId
                        + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
                break;
            }
            case BOOKS:{
                count = db.delete(SQLiteCacheDataBaseHelper.DATABASE_TABLE_BOOK, where, whereArgs);
                break;
            }
            case BOOK_ID:{
                String rowId = uri.getPathSegments().get(1);
                count = db.delete(SQLiteCacheDataBaseHelper.DATABASE_TABLE_BOOK, "ROWID="
                        + rowId
                        + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
                break;
            }
            case BLOGS:{
                count = db.delete(SQLiteCacheDataBaseHelper.DATABASE_TABLE_BLOG, where, whereArgs);
                break;
            }
            case BLOG_ID:{
                String rowId = uri.getPathSegments().get(1);
                count = db.delete(SQLiteCacheDataBaseHelper.DATABASE_TABLE_BLOG, "ROWID="
                        + rowId
                        + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
	}

	@Override
	public String getType(Uri uri) {
        switch (matchType(uri)) {
	        case CACHES:
	        case NOTES:
	        case BOOKS:
	        case BLOGS:
	            return ContentProviderUtil.CONTENT_TYPE;
	
	        case CACHE_ID:
	        case NOTE_ID:
	        case BOOK_ID:
	        case BLOG_ID:
	            return ContentProviderUtil.CONTENT_ITEM_TYPE;
	        default:
	            throw new IllegalArgumentException("Unknown URI " + uri);
        }
	}

	@Override
	public Uri insert(Uri uri, ContentValues initialValues) {
		// Validate the requested uri
        if (initialValues==null){
        	throw new IllegalArgumentException("initialValues can not be null");
        }         
        int matchType = matchType(uri);
        if (matchType != CACHES&&matchType != NOTES&&matchType != BOOKS&&matchType != BLOGS) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        // Long now = Long.valueOf(System.currentTimeMillis());
    	ContentValues values= new ContentValues(initialValues);
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        long rowId =0;
        if (matchType == CACHES){
	        rowId = db.insert(SQLiteCacheDataBaseHelper.DATABASE_TABLE_CACHE, null, values);
	        if (rowId > 0) {
	            Uri noteUri = ContentUris.withAppendedId(uri, rowId);
	            getContext().getContentResolver().notifyChange(noteUri, null);
	            return noteUri;
	        }
        }else if (matchType == BLOGS){
	        rowId = db.insert(SQLiteCacheDataBaseHelper.DATABASE_TABLE_BLOG, null, values);
	        if (rowId > 0) {
	            Uri noteUri = ContentUris.withAppendedId(uri, rowId);
	            getContext().getContentResolver().notifyChange(noteUri, null);
	            return noteUri;
	        }
        }else if (matchType == BOOKS){
	        rowId = db.insert(SQLiteCacheDataBaseHelper.DATABASE_TABLE_BOOK, null, values);
	        if (rowId > 0) {
	            Uri noteUri = ContentUris.withAppendedId(uri, rowId);
	            getContext().getContentResolver().notifyChange(noteUri, null);
	            return noteUri;
	        }
        }else if (matchType == NOTES){        	
	        rowId = db.insert(SQLiteCacheDataBaseHelper.DATABASE_TABLE_NOTE, null, values);
	        if (rowId > 0) {
	            Uri noteUri = ContentUris.withAppendedId(uri, rowId);
	            getContext().getContentResolver().notifyChange(noteUri, null);
	            
	            
	            return noteUri;
	        }
        }
        throw new SQLException("Failed to insert row into " + uri);
	}


	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String having=null;
        boolean isConfig = false;
        switch (matchType(uri)) {
            case CACHES:
                qb.setTables(SQLiteCacheDataBaseHelper.DATABASE_TABLE_CACHE);
                qb.setProjectionMap(sCacheColumnItemsProjectionMap);
                isConfig = true;
                break;
            case CACHE_ID:
                qb.setTables(SQLiteCacheDataBaseHelper.DATABASE_TABLE_CACHE);
                qb.setProjectionMap(sCacheColumnItemsProjectionMap);
                isConfig = true;
                qb.appendWhere("ROWID=" + uri.getPathSegments().get(1));
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        // If no sort order is specified use the default
        String orderBy = null;
        if (isConfig) {
            if (TextUtils.isEmpty(sortOrder)) {
                orderBy = DEFAULT_ODEDER;
            } else {
                orderBy = sortOrder;
            }
        }
        // Get the database and run the query
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, having, orderBy);

        // Tell the cursor what uri to watch, so it knows when its source data
        // changes
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int count;
        switch (matchType(uri)) {
            case CACHES:{
                count = db.update(SQLiteCacheDataBaseHelper.DATABASE_TABLE_CACHE, values, where, whereArgs);
                break;
            }
            case CACHE_ID:{
                String noteId = uri.getPathSegments().get(1);
                count = db.update(SQLiteCacheDataBaseHelper.DATABASE_TABLE_CACHE, values,"ROWID=" + noteId
                        + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
                break;
            }
            case NOTES:{
                count = db.update(SQLiteCacheDataBaseHelper.DATABASE_TABLE_NOTE, values, where, whereArgs);
                break;
            }
            case NOTE_ID:{
                String rowId = uri.getPathSegments().get(1);
                count = db.update(SQLiteCacheDataBaseHelper.DATABASE_TABLE_NOTE, values, "ROWID=" + rowId
                        + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
                break;
            }
            case BOOKS:{
                count = db.update(SQLiteCacheDataBaseHelper.DATABASE_TABLE_BOOK, values, where, whereArgs);
                break;
            }
            case BOOK_ID:{
                String rowId = uri.getPathSegments().get(1);
                count = db.update(SQLiteCacheDataBaseHelper.DATABASE_TABLE_BOOK, values, "ROWID=" + rowId
                        + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
                break;
            }
            case BLOGS:{
                count = db.update(SQLiteCacheDataBaseHelper.DATABASE_TABLE_BLOG, values, where, whereArgs);
                break;
            }
            case BLOG_ID:{
                String rowId = uri.getPathSegments().get(1);
                count = db.update(SQLiteCacheDataBaseHelper.DATABASE_TABLE_BLOG, values, "ROWID=" + rowId
                        + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
	}

}
