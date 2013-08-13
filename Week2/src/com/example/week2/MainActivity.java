package com.example.week2;

import com.example.week2.WebInfo;
import com.example.week2.R;

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
            // created my xml layout
            setContentView(R.layout.layout);
            
            _context = this;
            
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
    			
    				// gathering user input
    		        EditText userEnteredField = (EditText) findViewById(R.id.userEnteredText);
    		        inputString = userEnteredField.getText().toString();
    				
    				
    				
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
