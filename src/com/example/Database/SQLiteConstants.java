package com.example.Database;

public class SQLiteConstants {
	/**
	 * 住院登记表
	 */
	public final static String CREATE_TABLE_PATIENT_REGISTRATION="CREATE TABLE IF NOT EXISTS patient(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
			"name TEXT,age INTEGER,sex TEXT,divide TEXT,ward TEXT,number NUMERIC,doctor TEXT)";
	/**
	 * 
	 */
	
}
