package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class ManagerActivity extends ActionBarActivity {
	TextView title = null;
	TextView back = null;
	TextView tv_hostital = null;
	TextView tv_leave = null;
	TextView tv_protect = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager);
		tv_hostital = (TextView)findViewById(R.id.hospital);
		tv_leave = (TextView)findViewById(R.id.leave);
		tv_protect = (TextView)findViewById(R.id.protect);
		tv_hostital.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ManagerActivity.this,HospitalManageActivity.class);
				startActivity(intent);
			}
		});
		tv_leave.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new  Intent(ManagerActivity.this,LeaveManageActivity.class);
				startActivity(intent);
			}
		});
		tv_protect.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new  Intent(ManagerActivity.this,ProtectActivity.class);
				startActivity(intent);
			}
		});
		title = (TextView)findViewById(R.id.tv_top_title);
		title.setText("管理员模块");
		back = (TextView)findViewById(R.id.btn_title_back);
		back.setVisibility(View.VISIBLE);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}


}
