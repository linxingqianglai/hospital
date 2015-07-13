package com.example.Database;

import java.io.File;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
	private final static String TAG="DataseSQLiteOpenHelper";
	//private final static String 	DATEBASE_NAME = "mnt"
	//+File.separator+"sdcard"+File.separator+"hospital"+File.separator+"mydb.db";
	public final static String DATEBASE_NAME="hospital"+File.separator+"mydb.db";
	private final static int     DATEBASE_VERSION = 1;
	public Database(Context context,String path) {
		super(context, path+File.separator+DATEBASE_NAME, null, DATEBASE_VERSION);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method SQLiteDatabase dbstub
		db.execSQL(SQLiteConstants.CREATE_TABLE_LOGIN);
		db.execSQL(SQLiteConstants.CREATE_TABLE_PATIENT);
		db.execSQL(SQLiteConstants.CREATE_TABLE_LEAVEHOSPITAL);
		db.execSQL(SQLiteConstants.CREATE_TABLE_LOOKUPCASE);
		db.execSQL(SQLiteConstants.CREATE_TABLE_OWNEXPENSE);
		insert(db);
		Log.e(TAG,"mydb is onCreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	public void insert(SQLiteDatabase db)
	{
		ContentValues values1 = new ContentValues();
		ContentValues values2 = new ContentValues();
		ContentValues values3 = new ContentValues();
		ContentValues values_patient1 = new ContentValues();
		ContentValues values_patient2 = new ContentValues();
		ContentValues values_patient3 = new ContentValues();
		
		ContentValues values_lookupcase1 = new ContentValues();
		ContentValues values_lookupcase2 = new ContentValues();
		ContentValues values_lookupcase3 = new ContentValues();
		
		values1.put(SQLiteConstants.account, "2012301200207");
		values1.put(SQLiteConstants.password, "2012301200207");
		values2.put(SQLiteConstants.account, "2013310200226");
		values2.put(SQLiteConstants.password, "2013310200226");
		values3.put(SQLiteConstants.account, "2013310200126");
		values3.put(SQLiteConstants.password, "2013310200126");
		
		values_patient1.put(Patient.account,"2012301200207");
		values_patient2.put(Patient.account, "2013310200126");
		values_patient3.put(Patient.account, "2013310200226");
		
		values_lookupcase1.put(Patient.account,"2012301200207");
		values_lookupcase2.put(Patient.account, "2013310200126");
		values_lookupcase3.put(Patient.account, "2013310200226");
		
		db.insert(SQLiteConstants.table_login, null, values1);
		db.insert(SQLiteConstants.table_login, null, values2);
		db.insert(SQLiteConstants.table_login, null, values3);
		
		db.insert(SQLiteConstants.table_patient, null, values_patient1);
		db.insert(SQLiteConstants.table_patient, null, values_patient2);
		db.insert(SQLiteConstants.table_patient, null, values_patient3);
		
		db.insert(LookupCase.table_name, null, values_lookupcase1);
		db.insert(LookupCase.table_name, null, values_lookupcase2);
		db.insert(LookupCase.table_name, null, values_lookupcase3);
		
	}

}
