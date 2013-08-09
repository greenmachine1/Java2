/*
 * Project		Week1Project
 * 
 * Package		com.Cory.week1
 * 
 * Author		Cory Green
 * 
 * date			Aug 6, 2013
 */
package com.Cory.week1;
import com.Cory.lib.WebInfo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	String inputString;
	Boolean _connected = false;
	Context _context;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _context = this;
        
        // sets the xml file layout to be the view
        setContentView(R.layout.layout);
        
        // Detect network connection
        _connected = WebInfo.getConnectionStatus(_context);
         if(_connected)
      	{
      		Log.i("Network Connection", WebInfo.getConnectionType(_context));
    	}
        
        
        // setting up my gobutton
        Button goButton = (Button) findViewById(R.id.goButton);
        goButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// this will call my retrieve json methods
				Json newJson = new Json();
				
				// gathering user input
		        EditText userEnteredField = (EditText) findViewById(R.id.userEnteredText);
		        inputString = userEnteredField.getText().toString();
				
				Log.i("Yup",newJson.returnJsonData(inputString));
				
				if(newJson.returnJsonData(inputString) != null)
				{
					Log.i("yes", newJson.returnedLinkUrl());
				}
				
				
			}
        	
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}