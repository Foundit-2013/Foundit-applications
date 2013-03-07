package com.example.foundit;


import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ItemSelectedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_selected);
		TextView text = (TextView) findViewById(R.id.text);
		ActionBar actionBar = getActionBar();
		actionBar.setIcon(R.drawable.foundit_final_android);
		Intent intent = getIntent();
		intent.getStringExtra("");
		text.setText("Id:" +intent.getStringExtra("ID") + "\n"
			+ "Name:" + intent.getStringExtra("NAME") + "\n"
			+ "Image:" + intent.getStringExtra("IMAGE") + "\n"
			+ "Updated_at:" + intent.getStringExtra("UPDATED_AT") + "\n"
			+ "Created at:" + intent.getStringExtra("CREATED_AT") + "\n"
			+ "Description:" + intent.getStringExtra("DESCRIPTION") + "\n"
			+ "Posting_type:" + intent.getStringExtra("POSTING_TYPE") 	);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_item_selected, menu);
		return true;
	}

}
