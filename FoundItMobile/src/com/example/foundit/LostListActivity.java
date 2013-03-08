package com.example.foundit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LostListActivity extends ListActivity {

	private JSONArray lostItemsJSON;
	//@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	ActionBar actionBar = getActionBar();
	//	actionBar.setIcon(R.drawable.foundit4);
		InfoTask info = new InfoTask();
		info.execute();

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_all_list, menu);
		return true;
	}
	//////
	
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, ItemSelectedActivity.class);
		//String song = l.getItemAtPosition(position).toString();
		try {
			intent.putExtra("ID",lostItemsJSON.getJSONObject(position).getString("id"));
			intent.putExtra("CREATED_AT",lostItemsJSON.getJSONObject(position).getString("created_at"));
			intent.putExtra("UPDATED_AT",lostItemsJSON.getJSONObject(position).getString("updated_at"));
			intent.putExtra("DESCRIPTION",lostItemsJSON.getJSONObject(position).getString("description"));
			intent.putExtra("POSTING_TYPE",lostItemsJSON.getJSONObject(position).getString("posting_type"));
			intent.putExtra("NAME",lostItemsJSON.getJSONObject(position).getString("name"));
			intent.putExtra("IMAGE",lostItemsJSON.getJSONObject(position).getString("image"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Do something when a list item is clicked
		startActivity(intent);
    }
	
	
	private class InfoTask extends AsyncTask<Void, Void, String[]> {
		ProgressDialog progress;
	     @Override
         protected void onPostExecute(String[] result) {
	    	 	progress.dismiss();
	    	 	if(result == null)
	    	 	{
	    	 		AlertDialog.Builder builder = new AlertDialog.Builder(LostListActivity.this);
	    	 		builder.setMessage("Your network is Broken :(");
	    	 		builder.setCancelable(false);
	    	 		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	    	 		public void onClick(DialogInterface dialog, int id) {
	    	 			//do things
	    	 		    finish();
	    	 		  }
	    	 		});
	    	 		AlertDialog alert = builder.create();
	    	 		alert.show();
	    	 	}
	    	 	else{
	    	 	String[] List = result;
		    	setListAdapter(new ArrayAdapter<String>(LostListActivity.this, R.layout.activity_lost_list,List));
		    	ListView listView = getListView();
		    	
				listView.setTextFilterEnabled(true);
	    	 	}
         }
	     @Override
         protected void onPreExecute() {
	    	 progress = ProgressDialog.show(LostListActivity.this, "","Loading...");
         }
		@Override
		protected String[] doInBackground(Void... params) {
			// TODO Auto-generated method stub
			 lostItemsJSON = getJSONList();
			 if(lostItemsJSON == null)
			 {
				 return null;
			 }
	 		 String[] list = new String[lostItemsJSON.length()];
	 		 try {
	 			//generate the listview to be displayed
	 			for(int i=0; i< lostItemsJSON.length();i++){
	 				JSONObject jsonObject = lostItemsJSON.getJSONObject(i);
	 				if(jsonObject.getString("description").length() < 100){
	 					list[i] = jsonObject.getString("name") +":  "+ jsonObject.getString("description");
	 				}
	 				else{
	 					list[i] = jsonObject.getString("name") +":  "+ jsonObject.getString("description").substring(0, 96) + "...";
	 				}
	 			}
	 		} catch (JSONException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
			return list;
		}
	 }

	public JSONArray getJSONList(){
		JSONArray jsonArray = null;
		///////////////////////////////
		HttpClient httpClient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		//http://foundit.andrewl.ca/postings_show_lost
		HttpGet httpGet = new HttpGet("http://foundit.andrewl.ca/postings_show_lost.json");
		HttpResponse response;
		try {
			response = httpClient.execute(httpGet, localContext);
			HttpEntity entity = response.getEntity();

			InputStream	inputStream = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 1000);
			StringBuilder sb = new StringBuilder();

			String line = null;
			String finalString = null;
			while ((line = reader.readLine()) != null)
			{
				 sb.append(line + "\n");
			}

			finalString = sb.toString();
			jsonArray = new JSONArray(finalString);
			
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			//this is thrown when network is not working
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	}
}
