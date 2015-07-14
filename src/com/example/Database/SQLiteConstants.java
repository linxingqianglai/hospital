package com.example.Database;

public class SQLiteConstants {
	/**
	 * סԺ�ǼǱ�
	 * 
	 */
	public final static String CREATE_TABLE_PATIENT="create table if not exists patient(_id integer primary key autoincrement,"+
	 "account varchar(20),name varchar(20),age integer,sex integer,role varchar(20),ward varchar(20),certificate integer,ward_no varchar(20),"
			+"in_date varchar(20),out_date varchar(20),he_name varchar(20),he_tel varchar(20),doctor varchar(20),hospitalized integer,contributions integer"
	 +" "+")";
	
	/**
	 * ��¼ϵͳ
	 */
	public final static  String CREATE_TABLE_LOGIN="CREATE TABLE IF NOT EXISTS login(_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
	 "account varchar(20),password varchar(20),role varchar(20))";
	/**
	 * ��Ժ�ǼǱ�
	 */
	public final static String CREATE_TABLE_LEAVEHOSPITAL="CREATE TABLE IF NOT EXISTS leavehospital(_id integer primary key autoincrement," +
			"account varchar(20),name varchar(20),age integer,sex integer,division varchar(20),ward varchar(20),ward_no varchar(20),out_date varchar(20),doctor varchar(20)," +
			"doctor_certification integer,s_payment integer"+")";
	/*
	 * ����������ѯ��
	 */
	public final static String CREATE_TABLE_LOOKUPCASE="create table if not exists lookupcase(_id integer primary key autoincrement," +
			"account varchar(20),name varchar(20)," +
			"age integer,sex varchar(10),id varchar(20),date varchar(20),m_information varchar(2))";
	/**
	 * �������˷�����ϸ��
	 */
	public final static String CREATE_TABLE_OWNEXPENSE="create table if not exists ownexpense(_id integer primary key autoincrement,date varchar(20)" +
			",account varchar(20),name varchar(20),age varchar(20),sex varchar(20), ward varchar(20),ward_no varchar(20),expense_item varchar(20)," +
			"expense_code varchar(20),expense_name varchar(20),unit_price varchar(20),gauge_unit varchar(20),total_money varchar(20))";
	public final static String account="account";
	/**
	 * ��λ��Ϣͳ�Ʊ�
	 */
	public final static String CREATE_TABLE_WARDBED="create table if not exists ward_bed(_id integer primary key autoincrement,ward_no varchar(20),doctor varchar(20),nurse varchar(20)," +
			"patient varchar(20),bed_price_list varchar(20))";
	public final static String password="password";
	public final static String table_login="login";
	public final static String table_patient="patient";
	
}
