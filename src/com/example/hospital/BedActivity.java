package com.example.hospital;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class BedActivity extends ActionBarActivity {
	TextView title =null;
	TextView back = null;
	Spinner spinner = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bed);
		spinner = (Spinner)findViewById(R.id.bed_id);
		title = (TextView)findViewById(R.id.tv_top_title);
		back = (TextView)findViewById(R.id.btn_title_back);
		title.setText("¥≤Œª–≈œ¢");
		back.setVisibility(View.VISIBLE);

		String[] items=getResources().getStringArray(R.array.spinner_bed_ids);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(BedActivity.this,android.R.layout.simple_spinner_item,items);
		spinner.setAdapter(adapter);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bed, menu);
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
