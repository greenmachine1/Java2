package com.Cory.week1;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.Cory.lib.WebInfo;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;


// this class will pull json data from apple api
public class Json extends MainActivity{

	String artistName ="";
	String primaryGenre = "";
	String artistLinkUrl = "";
	
	public void returnJsonData(String passedInUserInput){
		
		// outputting what the user inputted
		//Log.i("Clicked", passedInUserInput);
		
		// creation of url
		String baseURL = "https://itunes.apple.com/search?term=";
		String completeURL = baseURL + passedInUserInput + "&entity=musicArtist&limit=1";
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
	public class infoRequest extends AsyncTask<URL, Void, String>{

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
					
					//EditText artistNameField = (EditText)findViewById(R.id.Name);
					
					
					
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.e("Nope", "No such file");
			}
			
		}
	}
}
	