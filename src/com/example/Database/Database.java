package com.example.Database;

import java.io.File;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
	private final static String TAG="DataseSQLiteOpenHelper";
	private final static String 	DATEBASE_NAME = File.separator+"mnt"
	+File.separator+"sdcard"+File.separator+"hospital"+File.separator+"mydb.db";
	private final static int     DATEBASE_VERSION = 1;
	public Database(Context context) {
		super(context, DATEBASE_NAME, null, DATEBASE_VERSION);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method SQLiteDatabase dbstub
		db.execSQL(SQLiteConstants.CREATE_TABLE_LOGIN);
		insert(db);
		Log.w(TAG,"mydb is onCreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	public void insert(SQLiteDatabase db)
	{
		ContentValues values1 = new ContentValues();
		ContentValues values2 = new ContentValues();
		values1.put(SQLiteConstants.account, "2012301200207");
		values1.put(SQLiteConstants.password, "2012301200207");
		values2.put(SQLiteConstants.account, "2013310200226");
		values2.put(SQLiteConstants.password, "2013310200226");
		db.insert(SQLiteConstants.table_login, null, values1);
		db.insert(SQLiteConstants.table_login, null, values2);
	}

}
