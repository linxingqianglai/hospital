package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	Spinner  spinner=null;
	TextView title=null;
	Button bn_login = null;
	int position=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spinner=(Spinner)findViewById(R.id.spinner);
		title = (TextView)findViewById(R.id.tv_top_title);
		bn_login = (Button)findViewById(R.id.login);
		
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
				if(position==0)
				{
					Intent intent = new Intent(MainActivity.this,PatientActivity.class);
					startActivity(intent);
				}
				
			}
		});
	}

}
