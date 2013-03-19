package com.example.foundit;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*ActionBar actionBar = getActionBar();*/
		ImageView clouds = (ImageView) findViewById(R.id.clouds);
		
		TranslateAnimation animation = new TranslateAnimation(0, 0, 0, -875);
		animation.setDuration(1600);
		animation.setFillAfter(true);
		clouds.setScaleY((float) 1.5);
		clouds.setScaleX((float) 1.1);
		clouds.startAnimation(animation);
		
		//actionBar.setIcon(R.drawable.founditsmall);
		//actionBar.setIcon(R.drawable.founditnowhite);

		/*		
		actionBar.setIcon(R.drawable.foundit_final_android);
		//actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(51, 51, 51)));
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(111, 186, 240)));
		actionBar.setTitle("");*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	public void listIt(View view){
		
		//Intent intent = new Intent(this, FoundListActivity.class);
		Intent intent = new Intent(this, ListTabberActivity.class);
		startActivity(intent);
	}
	
	public void foundIt(View view){
		Intent intent = new Intent(this, FoundItActivity.class);
		startActivity(intent);
	}
	
	public void lostIt(View view){
		Intent intent = new Intent(this, LostItActivity.class);
		startActivity(intent);
	}

}
