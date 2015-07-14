package com.example.hospital;

import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
//费用查询
public class CostQueryActivity extends ActionBarActivity {
	TextView title = null;
	TextView back = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_costquery);
		title = (TextView)findViewById(R.id.tv_top_title);
		title.setText("费用查询");
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
