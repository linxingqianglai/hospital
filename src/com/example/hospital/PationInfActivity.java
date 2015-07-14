package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class PationInfActivity extends ActionBarActivity {
	TextView  back = null;
	TextView title = null;
	Button bn_record_medium=null;
	Button bn_others=null;
	Button bn_money=null;
	Button bn_doctor=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pation_inf);
		bn_record_medium=(Button)findViewById(R.id.record_medium);
        bn_record_medium.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PationInfActivity.this,CaselookuptableActivity.class);
				startActivity(intent);
			}
		
		});
        bn_others = (Button)findViewById(R.id.others);
        bn_others.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PationInfActivity.this,CheckthelookuptableActivity.class);
				startActivity(intent);
			}
		});
		back = (TextView)findViewById(R.id.btn_title_back);
		title = (TextView)findViewById(R.id.tv_top_title);
		back.setVisibility(View.VISIBLE);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		back = (TextView)findViewById(R.id.btn_title_back);
		title = (TextView)findViewById(R.id.tv_top_title);
		back.setVisibility(View.VISIBLE);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		bn_money=(Button)findViewById(R.id.money); //费用查询界面连接
        bn_money.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PationInfActivity.this, CostQueryActivity.class);
				startActivity(intent);
			}
		
		});
        
        bn_doctor=(Button)findViewById(R.id.doctor);  //医嘱查询界面连接
        bn_doctor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PationInfActivity.this, CheckofdoctorsadviceActivity.class);
				startActivity(intent);
			}
		
		});
		title.setText("个人信息查询");
	}

}
