package com.example.week2;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.week2.WebInfo;
import com.example.week2.R;

import android.os.AsyncTask;
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
    	
    	String artistName = "";
		String primaryGenre = "";
		String artistLinkUrl = "";
    	
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
    				
    		        if(artistName != ""){
    	            	Log.i("After the button Press", artistName);
    	            }
    				
    		        
    		        
    				// creation of url
    				String baseURL = "https://itunes.apple.com/search?term=";
    				String completeURL = baseURL + inputString + "&entity=musicArtist&limit=1";
    				String as = "";
    				
    				try{
    					as = URLEncoder.encode(completeURL, "UTF-8");
    				}catch(Exception e){
    					Log.e("Bad URL", "Encoding problem");
    					as = "";
    				}
    				
    				URL finalURL;
    				try{
    					// dont actually need my UTF-8 involved in the url
    					finalURL = new URL(completeURL);
    					infoRequest newRequest = new infoRequest();
    					newRequest.execute(finalURL);
    				
    				}catch(MalformedURLException e){
    					Log.e("Bad Url", "malformed URL");
    					finalURL = null;
    				}
    				
    				
    			}
    			
    			
    			// this actually sends out the request
    			class infoRequest extends AsyncTask<URL, Void, String>{

    				//String artistName = "";
    				//String primaryGenre = "";
    				//String artistLinkUrl = "";
    				
    				@Override
    				protected String doInBackground(URL... urls) {
    					String response = "";
    					for(URL url: urls){
    						response = WebInfo.getURLStringResponse(url);
    					}
    						
    					return response;
    				}
    				// this is what comes back!
    				protected void onPostExecute(String result){
    					//Log.i("URL Response", result);
    					try {
    						
    						JSONObject json = new JSONObject(result);
    						JSONArray results = json.getJSONArray("results");
    						
    							artistName = results.getJSONObject(0).getString("artistName").toString();
    							primaryGenre = results.getJSONObject(0).getString("primaryGenreName").toString();
    							artistLinkUrl = results.getJSONObject(0).getString("artistLinkUrl").toString();

    							Log.i("name", artistName);
    							Log.i("name", primaryGenre);
    							Log.i("name", artistLinkUrl);
    							
    					} catch (JSONException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    						Log.e("Nope", "No such file");
    					}
    					
    					//Log.i("Yes", artistName);
    					
    			}
            	
            }
    	});
            
    }
        
        
    public String returnedJsonString(String userInput){
        
		// creation of url
		String baseURL = "https://itunes.apple.com/search?term=";
		String completeURL = baseURL + inputString + "&entity=musicArtist&limit=1";
		String as = "";
		
		try{
			as = URLEncoder.encode(completeURL, "UTF-8");
		}catch(Exception e){
			Log.e("Bad URL", "Encoding problem");
			as = "";
		}
		
		URL finalURL;
		try{
			// dont actually need my UTF-8 involved in the url
			finalURL = new URL(completeURL);
			infoRequest newRequest = new infoRequest();
			newRequest.execute(finalURL);
		
		}catch(MalformedURLException e){
			Log.e("Bad Url", "malformed URL");
			finalURL = null;
		}
		return null;
		
		
	}
	
	
	// this actually sends out the request
	class infoRequest extends AsyncTask<URL, Void, String>{

		//String artistName = "";
		//String primaryGenre = "";
		//String artistLinkUrl = "";
		
		@Override
		protected String doInBackground(URL... urls) {
			String response = "";
			for(URL url: urls){
				response = WebInfo.getURLStringResponse(url);
			}
				
			return response;
		}
		// this is what comes back!
		protected void onPostExecute(String result){
			//Log.i("URL Response", result);
			try {
				
				JSONObject json = new JSONObject(result);
				JSONArray results = json.getJSONArray("results");
				
					artistName = results.getJSONObject(0).getString("artistName").toString();
					primaryGenre = results.getJSONObject(0).getString("primaryGenreName").toString();
					artistLinkUrl = results.getJSONObject(0).getString("artistLinkUrl").toString();

					Log.i("name", artistName);
					Log.i("name", primaryGenre);
					Log.i("name", artistLinkUrl);
					
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.e("Nope", "No such file");
			}
			
			//Log.i("Yes", artistName);
    }
}
    
       
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
