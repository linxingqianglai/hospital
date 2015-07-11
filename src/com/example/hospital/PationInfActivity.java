package com.example.hospital;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class PationInfActivity extends ActionBarActivity {
	TextView  back = null;
	TextView title = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pation_inf);
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
		title.setText("个人信息查询");
	}

}
