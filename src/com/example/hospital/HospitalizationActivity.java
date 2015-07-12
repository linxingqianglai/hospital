package com.example.hospital;

import com.example.Database.Constants;
import com.example.Database.Database;
import com.example.Database.Patient;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class HospitalizationActivity extends ActionBarActivity {
	TextView title = null;
	TextView back = null;
	CheckBox  cb_hospital = null;
	CheckBox  cb_doctor = null;
	CheckBox  cb_cost = null;
	RadioGroup rg_role = null;
	RadioButton  rb_worker = null;
	RadioButton  rb_workerfamily = null;
	RadioButton rb_stu = null;
	RadioButton rb_others = null;
	Button ok = null;
	Database database = null;
	int medical_cerficate=0;
	int hospital = 0;
	int role_no = 0;
	int cost =0;
	Handler handler = new Handler()
	{
		public void handleMessage(android.os.Message msg) 
		{
			if(msg.what==0x123)
			{
				Toast.makeText(HospitalizationActivity.this, "存入数据库完成", Toast.LENGTH_LONG).show();
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hospitalization);
		database = new Database(HospitalizationActivity.this, Environment.getExternalStorageDirectory().toString());
		rg_role = (RadioGroup)findViewById(R.id.role);
		cb_hospital = (CheckBox)findViewById(R.id.hospital);
		cb_doctor = (CheckBox)findViewById(R.id.doctor);
		cb_cost = (CheckBox)findViewById(R.id.cost);
		rb_worker = (RadioButton)findViewById(R.id.worker);
		rb_workerfamily = (RadioButton)findViewById(R.id.workerfamily);
		rb_stu = (RadioButton)findViewById(R.id.stu);
		rb_others = (RadioButton)findViewById(R.id.others);
		title = (TextView)findViewById(R.id.tv_top_title);
		back = (TextView)findViewById(R.id.btn_title_back);
		ok = (Button)findViewById(R.id.ok);
		rg_role.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				role_no  = arg1;
			}
		});
		title.setText("住院手续");
		back.setVisibility(View.VISIBLE);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		} );
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(cb_hospital.isChecked())
				{
					hospital=1;
				}
				if(cb_doctor.isChecked())
				{
					medical_cerficate = 1;
				}
				if(cb_cost.isChecked())
				{
					cost=1;
				}
				new Thread()
				{
					public void run() 
					{
						ContentValues values = new ContentValues();
						values.put(Patient.role, role_no);
						values.put(Patient.hospitalized,hospital);
						values.put(Patient.contributions, cost);
						values.put(Patient.medical_cerficate,medical_cerficate);
						SQLiteDatabase db = database.getReadableDatabase();
						db.update("patient", values, Patient.account+"=?", new String[]{Constants.account});
						handler.sendEmptyMessage(0x123);
					};
				}.start();
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hospitalization, menu);
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
