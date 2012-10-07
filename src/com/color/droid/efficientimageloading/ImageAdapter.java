package com.color.droid.efficientimageloading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{

	LayoutInflater mInflater;
	Context mContext;
	final ImageDownloader mImageDownloader = new ImageDownloader();
	
	public ImageAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Global.URLS.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return Global.URLS[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return Global.URLS[position].hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			convertView = mInflater.inflate(R.layout.image_row, null);
		}
		
		ImageView mImageView = (ImageView) convertView.findViewById(R.id.imageView1);
		mImageDownloader.download(Global.URLS[position], mImageView);
		
		return convertView;
		
		/*if (convertView == null) {
            convertView = new ImageView(parent.getContext());
            convertView.setPadding(6, 6, 6, 6);
        }

        mImageDownloader.download(Global.URLS[position], (ImageView) convertView);
        
        return convertView;*/
	}

	public ImageDownloader getImageDownloader() {
		return this.mImageDownloader;
	}
}
