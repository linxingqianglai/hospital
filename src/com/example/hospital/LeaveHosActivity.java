package com.example.hospital;

import com.example.Database.Database;
import com.example.Database.Leavehospital;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.SyncStateContract.Constants;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class LeaveHosActivity extends ActionBarActivity {
	TextView title = null;
	TextView back = null;
	int is_certification = 0;
	int is_payment = 0;
	CheckBox cb_certification = null;
	CheckBox cb_payment = null;
	Button bn_ok = null;
	Database database = null;
	Handler handler = new Handler()
	{
		public void handleMessage(android.os.Message msg) 
		{
			if(msg.what==0x123)
			{
				Toast.makeText(LeaveHosActivity.this, "添加数据成功", Toast.LENGTH_LONG).show();
				finish();
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leave_hos);
		database = new Database(LeaveHosActivity.this, Environment.getExternalStorageDirectory().toString());
		cb_certification = (CheckBox)findViewById(R.id.doctor);
		cb_payment = (CheckBox)findViewById(R.id.cost);
		bn_ok = (Button)findViewById(R.id.ok);
		title = (TextView)findViewById(R.id.tv_top_title);
		back = (TextView)findViewById(R.id.btn_title_back);
		
		title.setText("出院手续");
		back.setVisibility(View.VISIBLE);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		bn_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(cb_certification.isChecked())
				{
					is_certification=1;
				}
				if(cb_payment.isChecked())
				{
					is_payment=1;
				}
				new Thread()
				{
					public void run() 
					{
						SQLiteDatabase db =  database.getReadableDatabase();
						ContentValues values = new ContentValues();
						values.put(Leavehospital.doctor_certification, is_certification);
						values.put(Leavehospital.s_payment, is_payment);
						db.update(Leavehospital.table_name, values, Leavehospital.account+"=?", new String[]{com.example.Database.Constants.account});
						handler.sendEmptyMessage(0x123);
					};
				}.start();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leave_hos, menu);
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
