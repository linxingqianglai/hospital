package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class HospitalManageActivity extends ActionBarActivity {
	TextView title = null;
	TextView back = null;
	Button bn_information = null;
	Button bn_log = null;
	Button bn_bed = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hospital_manage);
		bn_information = (Button)findViewById(R.id.information);
		bn_log = (Button)findViewById(R.id.log);
		bn_bed = (Button)findViewById(R.id.bedinformation);
		title = (TextView)findViewById(R.id.tv_top_title);
		back = (TextView)findViewById(R.id.btn_title_back);
		title.setText("住院管理");
		back.setVisibility(View.VISIBLE);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		bn_information.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			    Intent intent = new  Intent(HospitalManageActivity.this,PersonActivity.class);
				//Intent intent = new Intent(HospitalManageActivity.this,Simple_cursor_adapterActivity.class);
			    startActivity(intent);
			}
		});
		bn_log.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HospitalManageActivity.this,LogCostActivity.class);
				startActivity(intent);
			}
		});
		bn_bed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(HospitalManageActivity.this,BedActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hospital_manage, menu);
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
