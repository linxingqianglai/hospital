package com.example.hospital;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.Database.Constants;
import com.example.Database.Database;
import com.example.Database.OwnExpense;
import com.example.Database.Patient;

public class LogCostActivity extends ActionBarActivity {
	SimpleCursorAdapter adapter = null;
	String choose = null;
	Handler handler = new Handler()
	{
		public void handleMessage(android.os.Message msg) 
		{
			if(msg.what==0x123)
			{
				sp_name.setAdapter(adapter);
			}
			if(msg.what==0x111)
			{
				Toast.makeText(LogCostActivity.this, "�޸����ݳɹ�", Toast.LENGTH_LONG).show();
				finish();
				
			}
			if(msg.what==0x222)
			{
				update(choose);
			}
			if(msg.what==0x333)
			{
				updateUI();
			}
		};
	};
	TextView title = null;
	TextView back = null;
	Spinner sp_name = null;
	EditText et_age  = null;
	EditText et_sex = null;
	EditText et_hosphouse = null;
	EditText et_hospbed = null;
	EditText et_chargenumber = null;
	EditText et_chargeproject = null;
	EditText et_chargename = null;
	EditText et_price = null;
	EditText et_measureunits = null;
	EditText et_allincost = null;
	Button bn_ok = null;
	String name = "";
	String age = "0";
	String sex ="��";
	String hosphouse = "";
	String hospbed = "";
	String chargenumber = "";
	String chargeproject="";
	String chargename = "";
	String price = "";
	String measureunits = "";
	String allincost = "";
	Database database = null;
	Cursor c=null;
	int position = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_cost);
		bn_ok = (Button)findViewById(R.id.ok);
		database = new Database(LogCostActivity.this,Environment.getExternalStorageDirectory().toString());;
		sp_name = (Spinner)findViewById(R.id.name);
		et_age = (EditText)findViewById(R.id.age);
		et_sex = (EditText)findViewById(R.id.sex);
		et_hosphouse = (EditText)findViewById(R.id.hosphouse);
		et_hospbed = (EditText)findViewById(R.id.hospbed);
		et_chargename = (EditText)findViewById(R.id.chargename);
		et_chargeproject = (EditText)findViewById(R.id.chargeproject);
		et_chargenumber = (EditText)findViewById(R.id.chargenumber);
		et_price = (EditText)findViewById(R.id.price);
		et_measureunits = (EditText)findViewById(R.id.measureunits);
		et_allincost = (EditText)findViewById(R.id.allincost);
		title = (EditText)findViewById(R.id.tv_top_title);
		back = (EditText)findViewById(R.id.btn_title_back);
		title.setText("�����շ��ü��˱�");
		back.setVisibility(View.VISIBLE);
		new Thread()
		{
			public void run() 
			{
				SQLiteDatabase db = database.getReadableDatabase();
				c = db.rawQuery("select * from "+OwnExpense.table_name, null);
			    adapter = new SimpleCursorAdapter(LogCostActivity.this,
						android.R.layout.simple_dropdown_item_1line,
						c,new String[]{OwnExpense.name},
						new int[]{ android.R.id.text1 });
			    handler.sendEmptyMessage(0x123);
			};
		}.start();
		sp_name.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				position = arg2;
				choose = sp_name.getAdapter().getItem(arg2).toString(); 
				
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
bn_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new Thread()
				{
					@Override
					public void run() {
						// TODO Auto-generated method stub
						super.run();
						/**
						 * 		String name = "";
								String age = "0";
								String sex ="��";
								String hosphouse = "";
								String hospbed = "";
								String chargenumber = "";
								String chargeproject="";
								String chargename = "";
								String price = "";
								String measureunits = "";
								String allincost = "";
						 */
						age=et_age.getText().toString();
						sex=et_sex.getText().toString();
						hosphouse=et_hosphouse.getText().toString();
						hospbed=et_hospbed.getText().toString();
						chargenumber = et_chargenumber.getText().toString();
						chargeproject = et_chargeproject.getText().toString();
						chargename = et_chargename.getText().toString();
						price=et_price.getText().toString();
						measureunits= et_measureunits.getText().toString();
						allincost = et_allincost.getText().toString();
						
						
						SQLiteDatabase db=database.getReadableDatabase();
						ContentValues values = new ContentValues();
						values.put(Patient.age, age);
						values.put(Patient.sex, sex);
						values.put(OwnExpense.ward,hosphouse);
						values.put(OwnExpense.ward_no,hospbed);
						values.put(OwnExpense.expense_item,chargenumber);
						values.put(OwnExpense.expense_code, chargeproject);
						values.put(OwnExpense.expense_name,chargename);
						values.put(OwnExpense.unit_price,price);
						values.put(OwnExpense.gauge_unit,measureunits);
						values.put(OwnExpense.total_money,allincost);
						db.update(OwnExpense.table_name, values, OwnExpense.name+"=?",new String[]{sp_name.getAdapter().getItem(position).toString()});
						
					}
				}.start();
				
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
	}
	public void update(String choose)
	{
		final String se=choose;
		new Thread()
		{
			public void run() 
			{
				
				SQLiteDatabase db = database.getReadableDatabase();
				c = db.rawQuery("select * from patient where name=?", new String[]{se});
				if(c.getCount()>0)
				{   
					age = c.getString(c.getColumnIndex(OwnExpense.age));
					sex = c.getString(c.getColumnIndex(OwnExpense.sex));
					hosphouse = c.getString(c.getColumnIndex(OwnExpense.ward));
					hospbed = c.getString(c.getColumnIndex(OwnExpense.ward_no));
					chargenumber = c.getString(c.getColumnIndex(OwnExpense.expense_item));
					chargeproject = c.getString(c.getColumnIndex(OwnExpense.expense_code));
					chargename = c.getString(c.getColumnIndex(OwnExpense.expense_name));
					price = c.getString(c.getColumnIndex(OwnExpense.unit_price));
					measureunits = c.getString(c.getColumnIndex(OwnExpense.gauge_unit));
					allincost = c.getString(c.getColumnIndex(OwnExpense.total_money));
					handler.sendEmptyMessage(0x333);
				}
			};
		}.start();
	}
	public void  updateUI()
	{
		/**
		 * 		age=et_age.getText().toString();
				sex=et_sex.getText().toString();
				hosphouse=et_hosphouse.getText().toString();
				hospbed=et_hospbed.getText().toString();
				chargenumber = et_chargenumber.getText().toString();
				chargeproject = et_chargeproject.getText().toString();
				chargename = et_chargename.getText().toString();
				price=et_price.getText().toString();
				measureunits= et_measureunits.getText().toString();
				allincost = et_allincost.getText().toString();
		 */
		et_age.setText(age);
		et_sex.setText(sex);
		et_hosphouse.setText(hosphouse);
		et_hospbed.setText(hospbed);
		et_chargenumber.setText(chargenumber);
		et_chargeproject.setText(chargeproject);
		et_price.setText(price); 
		et_measureunits.setText(measureunits);
		et_allincost.setText(allincost);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log_cost, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
