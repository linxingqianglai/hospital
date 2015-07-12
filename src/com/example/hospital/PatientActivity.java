package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class PatientActivity extends ActionBarActivity {
	TextView title = null;
	TextView bn_back = null;
	Button information = null;
	Button tv_procedure = null;
	Button tv_leave = null;
	Button tv_appointment = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient);
		title = (TextView)findViewById(R.id.tv_top_title);
		bn_back = (TextView)findViewById(R.id.btn_title_back);
		information = (Button)findViewById(R.id.information);
		tv_procedure = (Button)findViewById(R.id.procedure);
		tv_leave = (Button)findViewById(R.id.leave_hospital);
		tv_appointment = (Button)findViewById(R.id.appointment);
		
		title.setText("患者管理模块");
		bn_back.setVisibility(View.VISIBLE);
		bn_back.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			finish();	
			}
		});
		information.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PatientActivity.this,PationInfActivity.class);
				startActivity(intent);
				
			}
		});
		tv_procedure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PatientActivity.this,HospitalizationActivity.class);
				startActivity(intent);
			}
		});
		tv_leave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PatientActivity.this,LeaveHosActivity.class);
				startActivity(intent);
			}
		});
		tv_appointment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e("tv_appointment","tv--------------------");
				Intent intent = new Intent(PatientActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient, menu);
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
