package com.example.hospital;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
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

import com.example.Database.Database;
import com.example.Database.SQLiteConstants;

public class MainActivity extends Activity {
	EditText et_account = null;
	EditText et_password = null;
	Spinner  spinner=null;
	TextView title=null;
	Button bn_login = null;
	Database database = null;
	
	int position=0;
	Handler handler=new Handler()
	{
		public void handleMessage(android.os.Message msg) 
		{
			if(msg.what==1)
			{
				if(position==0)
				{
					Intent intent = new Intent(MainActivity.this,PatientActivity.class);
					startActivity(intent);
				}
				if(position==2)
				{
					Intent intent = new Intent(MainActivity.this,DoctorActivity.class);
					startActivity(intent);
				}
				if(position==3)
				{
					Intent intent = new Intent(MainActivity.this,ManagerActivity.class);
					startActivity(intent);
				}
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_account = (EditText)findViewById(R.id.account_id);
		et_password = (EditText)findViewById(R.id.account_password);
		spinner=(Spinner)findViewById(R.id.spinner);
		title = (TextView)findViewById(R.id.tv_top_title);
		bn_login = (Button)findViewById(R.id.login);
		database = new Database(MainActivity.this);
		String[] items = getResources().getStringArray(R.array.spinner_names);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				position=arg2;
				switch(arg2)
				{
				 	
				}
				
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		title.setText("µÇÂ¼");
		bn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final String account=et_account.getText().toString();
				final String password=et_password.getText().toString();
				new Thread()
				{
					public void run() 
					{
						SQLiteDatabase db=database.getReadableDatabase();
						Cursor cursor = db.query(SQLiteConstants.table_login, new String[]{SQLiteConstants.account
								,SQLiteConstants.password},
						"("+SQLiteConstants.account+"=? AND "+SQLiteConstants.password+"=?)"
						, new String[]{account,password}, null,null,null,null);
						if(cursor.getCount()>0)
						handler.sendEmptyMessage(1);
					};
				}.start();
				
				
				
			}
		});
	}

}
