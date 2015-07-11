package com.example.Database;

public class SQLiteConstants {
	/**
	 * 住院登记表
	 */
	public final static String CREATE_TABLE_PATIENT_REGISTRATION="CREATE TABLE IF NOT EXISTS patient(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
			"name TEXT,age INTEGER,sex TEXT,divide TEXT,ward TEXT,number NUMERIC,doctor TEXT)";
	
	/**
	 * 登录系统
	 */
	public final static  String CREATE_TABLE_LOGIN="CREATE TABLE IF NOT EXISTS login(_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
	 "account varchar(20),password varchar(20),role varchar(20))";
	public final static String account="account";
	public final static String password="password";
	public final static String table_login="login";
	
}
