package com.example.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
	private final static String TAG="DataseSQLiteOpenHelper";
	private final static String 	DATEBASE_NAME = "mydb.db";
	private final static int     DATEBASE_VERSION = 1;
	public Database(Context context) {
		super(context, DATEBASE_NAME, null, DATEBASE_VERSION);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.w(TAG,"mydb is onCreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
