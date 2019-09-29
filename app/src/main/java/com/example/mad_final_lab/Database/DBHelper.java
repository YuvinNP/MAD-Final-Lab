package com.example.mad_final_lab.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserInfo.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_ENTRIES_USER =
                "CREATE TABLE " + UserMaster.Users.TABLE_NAME + " (" +
                        UserMaster.Users._ID + " INTEGER PRIMARY KEY," +
                        UserMaster.Users.COLUMN_NAME_NAME + " TEXT," +
                        UserMaster.Users.COLUMN_NAME_PASSWORD + " TEXT," +
                        UserMaster.Users.COLUMN_NAME_TYPE + " TEXT)";

        String SQL_CREATE_ENTRIES_MESSAGE =
                "CREATE TABLE " + UserMaster.Message.TABLE_NAME + " (" +
                        UserMaster.Message._ID + "INTEGER PRIMARY KEY, " +
                        UserMaster.Message.COLUMN_NAME_USER + " TEXT, " +
                        UserMaster.Message.COLUMN_NAME_SUBJECT + " TEXT," +
                        UserMaster.Message.COLUMN_NAME_MESSAGE + " TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES_USER);
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES_MESSAGE);
        System.out.println("HERE");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long registerUser(String name, String password, String type){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserMaster.Users.COLUMN_NAME_NAME, name);
        values.put(UserMaster.Users.COLUMN_NAME_PASSWORD, password);
        values.put(UserMaster.Users.COLUMN_NAME_TYPE, type);

        long rowid =  db.insert(UserMaster.Users.TABLE_NAME, null, values);

       return rowid;
    }

    public boolean login(String username, String password){

        SQLiteDatabase db = getReadableDatabase();


        String[] projection = {
                UserMaster.Users._ID

        };

        String selection = UserMaster.Users.COLUMN_NAME_NAME + " = ? and " + UserMaster.Users.COLUMN_NAME_PASSWORD + " = ?";

        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(
                UserMaster.Users.TABLE_NAME,
                projection,
               selection,
                selectionArgs,
                null,
                null,
                null
        );
        int cursorCnt = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCnt > 0){
            return true;
        }
        else return false;

    }

    public String getType(String username){

        String type = null;

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UserMaster.Users.COLUMN_NAME_TYPE
        };

        String selection = UserMaster.Users.COLUMN_NAME_NAME + " = ?";

        String[] selectionArgs = {username};

        Cursor cursor = db.query(
                UserMaster.Users.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        while (cursor.moveToNext()){

            type = cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Users.COLUMN_NAME_TYPE));
        }

        return type;

    }
}
