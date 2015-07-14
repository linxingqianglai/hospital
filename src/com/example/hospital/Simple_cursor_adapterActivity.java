package com.example.hospital;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
public class Simple_cursor_adapterActivity extends Activity {
 private ListView listView;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
        
        listView = (ListView)findViewById(R.id.listview);
        Cursor c = getContentResolver().query(People.CONTENT_URI, null, null, null, null);
        startManagingCursor(c);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1, c, new String[]{People.NAME}, new int[]{android.R.id.text1});
        listView.setAdapter(adapter);
        
    }
}