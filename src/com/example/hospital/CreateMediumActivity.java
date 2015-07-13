package com.example.hospital;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CreateMediumActivity extends ActionBarActivity {
	TextView title = null;
	TextView back = null;
	EditText et_date = null;
	EditText et_name = null;
	RadioGroup rg_sex = null;
	EditText et_age = null;
	EditText et_doctor = null;
	EditText et_illness = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_medium);
		et_date = (EditText)findViewById(R.id.date);
		et_name = (EditText)findViewById(R.id.name);
		rg_sex = (RadioGroup)findViewById(R.id.sex);
		et_age = (EditText)findViewById(R.id.age);
		et_doctor = (EditText)findViewById(R.id.doctor);
		et_illness = (EditText)findViewById(R.id.illness);
		title = (TextView)findViewById(R.id.tv_top_title);
		back = (TextView)findViewById(R.id.btn_title_back);
		back.setVisibility(View.VISIBLE);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		title.setText("²¡Àú½¨Á¢");
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
