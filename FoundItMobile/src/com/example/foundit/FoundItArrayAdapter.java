package com.example.foundit;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class FoundItArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	int count;
	Bitmap[] pics;
 
	public FoundItArrayAdapter(Context context, String[] values, Bitmap[] pics) {
		super(context, R.layout.activity_all_list, values);
		this.context = context;
		this.values = values;
		count = 0;
		this.pics = pics;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.activity_all_list, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.text);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
		textView.setText(values[position]);
 
		// Change icon based on name
		String s = values[position];
 
		//System.out.println(s);
 
	    imageView.setImageBitmap(pics[count++]);
 
		return rowView;
	}
}
