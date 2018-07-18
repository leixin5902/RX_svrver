package com.rx.cdhk.rx_svrver;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by cdhk on 2017/12/21.
 */

public class ContentWriter extends ContentProvider
{
    SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        database=getContext().openOrCreateDatabase("mycp.db3", Context.MODE_PRIVATE,null);
      database.execSQL("create table tab(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL)");


        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
      Cursor cursor=database.query("tab",null,null,null,null,null,null);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        database.insert("tab","_id",contentValues);

        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        database.delete("tab",s,null);
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
