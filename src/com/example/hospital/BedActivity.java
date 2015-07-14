package com.example.hospital;

import java.util.LinkedList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Database.Database;
import com.example.Database.Patient;
import com.example.Database.WardBed;

public class BedActivity extends ActionBarActivity {
	Handler handler = new Handler()
	{
		public void handleMessage(android.os.Message msg) 
		{
			if(msg.what==0x123)
			{
				adapter.notifyDataSetChanged();
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
	ArrayAdapter<String> adapter  = null;
	LinkedList<String> list  = new LinkedList<String>();
	int position = 0;
	String choose= "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		list.clear();
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
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
		sp_ward_no.setAdapter(adapter);
		new Thread()
		{
			public void run() 
			{
				SQLiteDatabase db=database.getReadableDatabase();
				c = db.rawQuery("select*from "+WardBed.table_name, null);
				c.moveToFirst();
				/*c = getContentResolver().query(People.CONTENT_URI, null, null, null, null);
		        startManagingCursor(c);
		        adapter = new SimpleCursorAdapter(PersonActivity.this, android.R.layout.simple_expandable_list_item_1, c
		        		, new String[]{People.NAME}, new int[]{android.R.id.text1});*/
				if(db!=null&&c!=null)
				{
					while(!c.isLast())
					{
						
						list.add(c.getString(c.getColumnIndex(WardBed.ward_no)));
						/*Log.e("ward_no=",c.getString(c.getColumnIndex(WardBed.ward_no)));
						Log.e("doctor=",c.getString(c.getColumnIndex(WardBed.doctor)));
						Log.e("nurse=",c.getString(c.getColumnIndex(WardBed.nurse)));
						Log.e("bed_price_list=",c.getString(c.getColumnIndex(WardBed.bed_price_list)));*/
						c.moveToNext();
					}
					
				    handler.sendEmptyMessage(0x123);
				}
				else
				{
					Toast.makeText(BedActivity.this, "数据库出错或者Cursor出错", Toast.LENGTH_LONG).show();
				}
			};
		}.start();
		sp_ward_no.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				position = arg2;
				choose = sp_ward_no.getAdapter().getItem(arg2).toString();
				handler.sendEmptyMessage(0x222);
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
						handler.sendEmptyMessage(0x111);
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
				c = db.rawQuery("select*from "+WardBed.table_name+"  where  "+WardBed.ward_no+"=?",new String[]{se});
				c.moveToFirst();//这里没有添加就会出现cursor溢出的问题，所以特别小心
				if(c!=null&&c.getCount()>0)
				{
					/*if(!c.isLast())
					{
						
						
						Log.e("ward_no=",c.getString(c.getColumnIndex(WardBed.ward_no)));
						Log.e("doctor=",c.getString(c.getColumnIndex(WardBed.doctor)));
						Log.e("nurse=",c.getString(c.getColumnIndex(WardBed.nurse)));
						Log.e("bed_price_list=",c.getString(c.getColumnIndex(WardBed.bed_price_list)));
						
					}*/
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
