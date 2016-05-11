package com.travel.torest.model.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.travel.torest.model.HotelCategory;
import com.travel.torest.model.HotelSupply;

/**
 * Created by Antony on 09.05.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "STDude";
    private static final String LOG = "DatabaseHelper";

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "local_storage";

    private static final String TABLE_SEARCH_DATA = "search_data"; //ПОВРЕМЕНЮ
    private static final String TABLE_TOURIST = "tourist";
    private static final String TABLE_HISTORY = "history";
    private static final String TABLE_HOTEL_CATEGORY = "hotel_category";
    private static final String TABLE_HOTEL_SUPPLY = "hotel_supply";

    private static final String KEY_ID = "id";

    private static final String KEY_HISTORY_CITY_ID = "city_id";
    private static final String KEY_HISTORY_CITY = "city";
    private static final String KEY_HISTORY_COUNTRY_ID = "country_id";
    private static final String KEY_HISTORY_COUNTRY = "country";
    private static final String KEY_HISTORY_RESORTS = "resorts";
    private static final String KEY_HISTORY_HOTELS = "hotels";
    private static final String KEY_HISTORY_BEGIN_DATE = "begin_date";
    private static final String KEY_HISTORY_END_DATE = "end_date";
    private static final String KEY_HISTORY_MAN_COUNT = "man_count";
    private static final String KEY_HISTORY_KID_COUNT = "kid_count";
    private static final String KEY_HISTORY_SEARCH_DATE = "search_date";

    private static final String KEY_TOURIST_FIRST_NAME = "first_name";
    private static final String KEY_TOURIST_LAST_NAME = "last_name";
    private static final String KEY_TOURIST_AGE_CATEGORY = "age_category";
    private static final String KEY_TOURIST_B_DATE = "bdate";
    private static final String KEY_TOURIST_GENDER = "gender";
    private static final String KEY_TOURIST_NATIONALITY = "nationality";
    private static final String KEY_TOURIST_SERIA = "searia";
    private static final String KEY_TOURIST_NUMBER = "number";
    private static final String KEY_TOURIST_ISSUED_BY = "issued_by";
    private static final String KEY_TOURIST_BEGIN_DATE = "begin_date";
    private static final String KEY_TOURIST_END_DATE = "end_date";

    private static final String KEY_CATEGORY = "category";
    private static final String KEY_SUPPLY = "supply";

    private static final String CREATE_TABLE_HISTORY = "CREATE TABLE IF NOT EXISTS "
            + TABLE_HISTORY
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_HISTORY_CITY_ID + " INTEGER,"
            + KEY_HISTORY_CITY + " TEXT,"
            + KEY_HISTORY_COUNTRY_ID + " INTEGER,"
            + KEY_HISTORY_COUNTRY + " TEXT,"
            + KEY_HISTORY_RESORTS + " TEXT,"
            + KEY_HISTORY_HOTELS + " TEXT,"
            + KEY_HISTORY_BEGIN_DATE + " DATE,"
            + KEY_HISTORY_END_DATE + " DATE,"
            + KEY_HISTORY_MAN_COUNT + " INTEGER,"
            + KEY_HISTORY_KID_COUNT + " INTEGER,"
            + KEY_HISTORY_SEARCH_DATE + " DATE"
            + ")";

    private static final String CREATE_TABLE_TOURIST = "CREATE TABLE IF NOT EXISTS "
            + TABLE_TOURIST
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_TOURIST_FIRST_NAME + " TEXT,"
            + KEY_TOURIST_LAST_NAME + " TEXT,"
            + KEY_TOURIST_AGE_CATEGORY + " TEXT,"
            + KEY_TOURIST_B_DATE + " DATE,"
            + KEY_TOURIST_GENDER + " INTEGER,"
            + KEY_TOURIST_NATIONALITY + " TEXT,"
            + KEY_TOURIST_SERIA + " TEXT,"
            + KEY_TOURIST_NUMBER + " TEXT,"
            + KEY_TOURIST_ISSUED_BY + " TEXT,"
            + KEY_TOURIST_BEGIN_DATE + " DATE,"
            + KEY_TOURIST_END_DATE + " DATE,"
            + KEY_TOURIST_END_DATE + " DATE"
            + ")";

    private static final String CREATE_TABLE_HOTEL_CATEGORY = "CREATE TABLE IF NOT EXISTS "
            + TABLE_HOTEL_CATEGORY
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CATEGORY + " TEXT"
            + ")";

    private static final String CREATE_TABLE_HOTEL_SUPPLY = "CREATE TABLE IF NOT EXISTS "
            + TABLE_HOTEL_SUPPLY
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_SUPPLY + " TEXT"
            + ")";

    String selection = null;
    String[] selectionArgs = null;
    String[] columns = null;

    int id_category[] = { 0, 1, 2, 3, 4, 5 };
    String category[] = { "Любая", "1", "2", "3", "4", "5" };

    Cursor c = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HISTORY);
        db.execSQL(CREATE_TABLE_TOURIST);
        db.execSQL(CREATE_TABLE_HOTEL_CATEGORY);
        db.execSQL(CREATE_TABLE_HOTEL_SUPPLY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean isExists(){
        SQLiteDatabase db = this.getWritableDatabase();
        final String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='+ TABLE_HOTEL_CATEGORY +'";
        selection = "type = ? AND name = ?";
        selectionArgs = new String[] { "table", TABLE_HOTEL_CATEGORY };
        columns = new String[] { "name" };
        Cursor c = db.query("sqlite_master", columns, selection, selectionArgs, null, null, null);
        return c.getCount() != 0;
    }

    public boolean isHotelCategoriesEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_HOTEL_CATEGORY, null, null, null, null, null, null);
        return c.getCount() == 0;
    }

    public boolean isHotelSupplyEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_HOTEL_SUPPLY, null, null, null, null, null, null);
        return c.getCount() == 0;
    }

    public void setHotelCategories(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        for (int i = 0; i < id_category.length; i++) {
            cv.put("id", id_category[i]);
            cv.put("category", category[i]);
            Log.d(LOG, "id = " + db.insert(TABLE_HOTEL_CATEGORY, null, cv));
        }
    }

    public void setHotelSupply(int id[], String supply[]){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        for (int i = 0; i < id_category.length; i++) {
            cv.put("id", id[i]);
            cv.put("supply", supply[i]);
            Log.d(LOG, "id = " + db.insert(TABLE_HOTEL_SUPPLY, null, cv));
        }
    }

    public HotelCategory getHotelCategory(int id){
        return null;
    }

    public HotelSupply getHotelSupply(int id){
        return null;
    }
}
