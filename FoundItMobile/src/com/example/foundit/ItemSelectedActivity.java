package com.example.foundit;


import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ItemSelectedActivity extends Activity {
String photoPath; 
Bitmap pic;
int parentActivity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_selected);
		TextView nameView = (TextView) findViewById(R.id.name);
		TextView descView = (TextView) findViewById(R.id.text);
		TextView dateView = (TextView) findViewById(R.id.date);
		ActionBar actionBar = getActionBar();
		actionBar.setIcon(R.drawable.foundit_final_small);
		actionBar.setTitle("");
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(117, 150, 194)));
		Intent intent = getIntent();
		intent.getStringExtra("");
		nameView.setText(intent.getStringExtra("NAME"));
		descView.setText(intent.getStringExtra("DESCRIPTION"));
		
		TextView itemState = (TextView) findViewById(R.id.itemState);
		parentActivity = intent.getIntExtra("type", 0);
		if(parentActivity == 1)
			itemState.setText("Found");
		else
			itemState.setText("Lost");
		String dateString = intent.getStringExtra("CREATED_AT");
		String date = dateString.substring(0, dateString.indexOf("T"));
		String time = dateString.substring(dateString.indexOf("T") + 1, dateString.length()-1);
		dateView.setText(date + " at " + time);
		/*text.setText(intent.getStringExtra("NAME") + "\n"
			+ "Created at:" + intent.getStringExtra("CREATED_AT") + "\n"
			+ "Description:" + intent.getStringExtra("DESCRIPTION") + "\n");*/
		photoPath = intent.getStringExtra("LARGE_PHOTO_PATH");
		PicTask task = new PicTask();
		task.execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_item_selected, menu);
		return true;
	}
	////////////////////////////////////////////////////////////////
	private class PicTask extends AsyncTask<Void, Void, String[]> {
		ProgressDialog progress;
	     @Override
         protected void onPostExecute(String[] result) {
	    	 	progress.dismiss();
	    	 	ImageView img = (ImageView) findViewById(R.id.imageView1);
	    	 	if(pic != null)
	    	 		img.setImageBitmap(pic);
	    	 	else
	    	 		img.setImageResource(R.drawable.questionmark);
         }
	     @Override
         protected void onPreExecute() {
	    	 progress = ProgressDialog.show(ItemSelectedActivity.this, "","Loading...");
         }
		@Override
		protected String[] doInBackground(Void... params) {
			// TODO Auto-generated method stub
			pic = downloadBitmap("http://foundit.andrewl.ca" + photoPath);
			return null;
		}
	 }
	static Bitmap downloadBitmap(String url) {
	    final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
	    final HttpGet getRequest = new HttpGet(url);

	    try {
	        HttpResponse response = client.execute(getRequest);
	        final int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != HttpStatus.SC_OK) { 
	            return null;
	        }
	        
	        final HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            InputStream inputStream = null;
	            try {
	                inputStream = entity.getContent(); 
	                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
	                return bitmap;
	            } finally {
	                if (inputStream != null) {
	                    inputStream.close();  
	                }
	                entity.consumeContent();
	            }
	        }
	    } catch (Exception e) {
	        // Could provide a more explicit error message for IOException or IllegalStateException
	        getRequest.abort();
	    } finally {
	        if (client != null) {
	            client.close();
	        }
	    }
	    return null;
	}
	public void fullPic(View view){
		if(parentActivity == 1)
		{
			Intent intent = new Intent(this, FullscreenImage.class);
	        // Drawable drawable   = imageView.getDrawable();
	       //  Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
			 intent.putExtra("IMAGE", pic);
	         startActivity(intent);
		}
	}
}
