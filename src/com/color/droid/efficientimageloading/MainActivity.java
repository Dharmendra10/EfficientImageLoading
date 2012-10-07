package com.color.droid.efficientimageloading;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

public class MainActivity extends Activity {

	GridView gridView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindComponents();
        init();
        addListeners();
    }
    
    private void bindComponents() {
		// TODO Auto-generated method stub
    	gridView = (GridView) findViewById(R.id.gridView);
	}
    
    private void init() {
		// TODO Auto-generated method stub
    	ImageAdapter mAdapter = new ImageAdapter(this);
    	gridView.setAdapter(mAdapter);
	}
    
    private void addListeners() {
		// TODO Auto-generated method stub

	}
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if(item.getTitle().equals(getString(R.string.menu_clearchche))) {
    		((ImageAdapter)gridView.getAdapter()).getImageDownloader().clearCache();
    		return true;
    	}
    	return super.onOptionsItemSelected(item);
    }
    
}
