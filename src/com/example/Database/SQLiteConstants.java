package com.example.Database;

public class SQLiteConstants {
	/**
	 * סԺ�ǼǱ�
	 */
	public final static String CREATE_TABLE_PATIENT="create table if no exists patient(_id integer primary key autoincrement,"+
	 "account varchar(20),name varchar(20),age integer,sex integer,role varchar(20),ward varchar(20),ward_no varchar(20),"
			+"in_date varchar(20),out_date varchar(20),he_name varchar(20),he_tel varchar(20),doctor varchar(20),hospitalized integer,contributions integer"
	 +"medical_certificate varchar(300)"+")";
	
	/**
	 * ��¼ϵͳ
	 */
	public final static  String CREATE_TABLE_LOGIN="CREATE TABLE IF NOT EXISTS login(_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
	 "account varchar(20),password varchar(20),role varchar(20))";
	public final static String account="account";
	public final static String password="password";
	public final static String table_login="login";
	public final static String table_patient="patient";
	
}
