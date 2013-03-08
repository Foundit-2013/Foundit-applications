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
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ItemSelectedActivity extends Activity {
String photoPath; 
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
			+ "Updated_at:" + intent.getStringExtra("UPDATED_AT") + "\n"
			+ "Created at:" + intent.getStringExtra("CREATED_AT") + "\n"
			+ "Description:" + intent.getStringExtra("DESCRIPTION") + "\n"
			+ "Posting_type:" + intent.getStringExtra("POSTING_TYPE")
			+ "Photo_path:" + intent.getStringExtra("LARGE_PHOTO_PATH"));
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
		Bitmap pic;
	     @Override
         protected void onPostExecute(String[] result) {
	    	 	progress.dismiss();
	    	 	ImageView img = (ImageView) findViewById(R.id.imageView1);
				img.setImageBitmap(pic);
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
}
