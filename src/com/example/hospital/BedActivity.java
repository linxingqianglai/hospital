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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Database.Database;
import com.example.Database.WardBed;

public class BedActivity extends ActionBarActivity {
	Handler handler = new Handler()
	{
		public void handleMessage(android.os.Message msg) 
		{
			if(msg.what==0x123)
			{
				sp_ward_no.setAdapter(adapter);
			}
			if(msg.what==0x111)
			{
				Toast.makeText(BedActivity.this, "修改数据成功", Toast.LENGTH_LONG).show();
				finish();
			}
			if(msg.what ==0x222)
			{
				update(choose);
			}
			if(msg.what==0x333)
			{
				updateUI();
			}
		};
	};
	TextView title =null;
	TextView back = null;
	Spinner sp_ward_no = null;
	EditText et_doctor = null;
	EditText et_nurse = null;
	EditText et_patient = null;
	EditText et_bed_price_list = null;
	Button bn_ok = null;
	String ward_no="";
	String doctor ="";
	String nurse = "";
	String patient = "";
	String bed_price_list="";
	Database database = null;
	Cursor c = null;
	SimpleCursorAdapter adapter = null;
	int position = 0;
	String choose= "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bed);
		database = new  Database(BedActivity.this, Environment.getExternalStorageDirectory().toString());
		et_doctor = (EditText)findViewById(R.id.doctor);
		et_nurse  = (EditText)findViewById(R.id.nurse);
		et_patient = (EditText)findViewById(R.id.patient);
		et_bed_price_list = (EditText)findViewById(R.id.bed_price_list);
		bn_ok = (Button)findViewById(R.id.ok);
		sp_ward_no = (Spinner)findViewById(R.id.bed_id);
		title = (TextView)findViewById(R.id.tv_top_title);
		back = (TextView)findViewById(R.id.btn_title_back);
		title.setText("床位信息");
		back.setVisibility(View.VISIBLE);

		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		new Thread()
		{
			public void run() 
			{
				SQLiteDatabase db=database.getReadableDatabase();
				c = db.rawQuery("select*from "+WardBed.table_name, null);
				adapter = new SimpleCursorAdapter(BedActivity.this,
						android.R.layout.simple_dropdown_item_1line,
						c,new String[]{WardBed.ward_no},
						new int[]{ android.R.id.text1 });
			    handler.sendEmptyMessage(0x123);
			};
		}.start();
		sp_ward_no.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				position = arg2;
				choose = sp_ward_no.getAdapter().getItem(arg2).toString();
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
					public void run() 
					{
						doctor = et_doctor.getText().toString();
						nurse = et_nurse.getText().toString();
						patient = et_patient.getText().toString();
						bed_price_list = et_bed_price_list.getText().toString();
						
						SQLiteDatabase db=database.getReadableDatabase();
						ContentValues values = new ContentValues();
						values.put(WardBed.doctor, doctor);
						values.put(WardBed.nurse, nurse);
						values.put(WardBed.patient, patient);
						values.put(WardBed.bed_price_list,bed_price_list);
						db.update(WardBed.table_name,values, WardBed.ward_no+"=?",new String[]{sp_ward_no.getAdapter().getItem(position).toString()});
					};
				}.start();
			}
		});
	}
	public void update(String chooose)
	{
		final String se=choose;
		new Thread()
		{
			public void run() 
			{
				SQLiteDatabase db = database.getReadableDatabase();
				c = db.rawQuery("select*from "+WardBed.table_name+"where "+WardBed.ward_no+"=?",new String[]{se});
				if(c.getCount()>0)
				{
					doctor = c.getString(c.getColumnIndex(WardBed.doctor));
					nurse = c.getString(c.getColumnIndex(WardBed.nurse));
					patient = c.getString(c.getColumnIndex(WardBed.patient));
					bed_price_list = c.getString(c.getColumnIndex(WardBed.bed_price_list));
					handler.sendEmptyMessage(0x333);
				}
			};
		}.start();
	}
	public void updateUI()
	{
		et_doctor.setText(doctor);
		et_nurse.setText(nurse);
		et_patient.setText(patient);
		et_bed_price_list.setText(bed_price_list);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bed, menu);
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
