package com.example.foundit;

import com.example.foundit.AllListActivity;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		//actionBar.setIcon(R.drawable.founditsmall);
		actionBar.setIcon(R.drawable.founditnowhite);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(51, 51, 51)));
		actionBar.setTitle("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	public void listIt(View view){
		
		//Intent intent = new Intent(this, AllListActivity.class);
		Intent intent = new Intent(this, ListTabberActivity.class);
		startActivity(intent);
	}
	
	public void foundIt(View view){
		Intent intent = new Intent(this, FoundItActivity.class);
		startActivity(intent);
	}

}
