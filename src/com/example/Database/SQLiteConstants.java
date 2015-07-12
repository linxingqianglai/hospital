package com.example.Database;

public class SQLiteConstants {
	/**
	 * 住院登记表
	 * 
	 */
	public final static String CREATE_TABLE_PATIENT="create table if not exists patient(_id integer primary key autoincrement,"+
	 "account varchar(20),name varchar(20),age integer,sex integer,role varchar(20),ward varchar(20),certificate integer,ward_no varchar(20),"
			+"in_date varchar(20),out_date varchar(20),he_name varchar(20),he_tel varchar(20),doctor varchar(20),hospitalized integer,contributions integer"
	 +" "+")";
	
	/**
	 * 登录系统
	 */
	public final static  String CREATE_TABLE_LOGIN="CREATE TABLE IF NOT EXISTS login(_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
	 "account varchar(20),password varchar(20),role varchar(20))";
	/**
	 * 出院登记表
	 */
	public final static String CREATE_TABLE_LEAVEHOSPITAL="CREATE TABLE IF NOT EXISTS leavehospital(_id integer primary key autoincrement," +
			"account varchar(20),name varchar(20),age integer,sex integer,division varchar(20),ward varchar(20),ward_no varchar(20),out_date varchar(20),doctor varchar(20)," +
			"doctor_certification integer,s_payment integer"+")";
	
	public final static String account="account";
	public final static String password="password";
	public final static String table_login="login";
	public final static String table_patient="patient";
	
}
