package com.example.hospital;

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
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Database.Database;
import com.example.Database.LookupCase;

public class CreateMediumActivity extends ActionBarActivity {
	TextView title = null;
	TextView back = null;
	EditText et_date = null;
	EditText et_name = null;
	RadioGroup rg_sex = null;
	EditText et_age = null;
	EditText et_doctor = null;
	EditText et_illness = null;
	Button bn_create = null;
	String str_date = null;
	String str_name = null;
	String str_sex = "男";
	int age = 0;
	String str_doctor = null;
	String  str_illness = null;
	Database database = null;
	Handler handler = new Handler()
	{
		public void handleMessage(android.os.Message msg) 
		{
			if(msg.what==0x123)
			{
				Toast.makeText(CreateMediumActivity.this, "数据添加成功", Toast.LENGTH_LONG).show();
				finish();
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_medium);
		database = new Database(CreateMediumActivity.this, Environment.getExternalStorageDirectory().toString());
		et_date = (EditText)findViewById(R.id.date);
		et_name = (EditText)findViewById(R.id.name);
		rg_sex = (RadioGroup)findViewById(R.id.sex);
		et_age = (EditText)findViewById(R.id.age);
		et_doctor = (EditText)findViewById(R.id.doctor);
		et_illness = (EditText)findViewById(R.id.illness);
		title = (TextView)findViewById(R.id.tv_top_title);
		back = (TextView)findViewById(R.id.btn_title_back);
		bn_create = (Button)findViewById(R.id.create);
		rg_sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if(arg1==0)
				{
					str_sex="男";
				}
				else
				{
					str_sex="女";
				}
			}
		});
		bn_create.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				str_date=et_date.getText().toString();
				str_doctor=et_doctor.getText().toString();
				str_name=et_name.getText().toString();
				str_illness=et_illness.getText().toString();
				age=Integer.parseInt(et_age.getText().toString());
				if(str_date==null||str_doctor==null||str_sex==null||str_illness==null||str_name==null||age==0)
				{
					Toast.makeText(CreateMediumActivity.this, "内容不能为空", Toast.LENGTH_LONG).show();
					return ;
				}
				else
				{
					new Thread()
					{
						@Override
						public void run() {
							// TODO Auto-generated method stub
							SQLiteDatabase db = database.getReadableDatabase();
							ContentValues values = new ContentValues();
							values.put(LookupCase.account, com.example.Database.Constants.account);
							values.put(LookupCase.name, str_name);
							values.put(LookupCase.age, age);
							values.put(LookupCase.date, str_date);
							values.put(LookupCase.m_information, str_illness);
							values.put(LookupCase.sex, str_sex);
							values.put(LookupCase.doctor, str_doctor);
							db.insert(LookupCase.account, null, values);
							handler.sendEmptyMessage(0x123);
						}
					}.start();
				}
				
			}
		});
		back.setVisibility(View.VISIBLE);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		title.setText("病历建立");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_medium, menu);
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
