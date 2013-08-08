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
import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // sets the xml file layout to be the view
        setContentView(R.layout.layout);
        
        Button goButton = (Button) findViewById(R.id.goButton);
        goButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
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
/*
//global variables
	Context _context;
	
	String userDropDownSelection;
	String InputString;
	
	String returnedJsonResult;
	
	String artistName;
	String primaryGenre;
	String artistLinkUrl;
	String collectionName;
	String trackCount;
	String collectionPrice;
	
	Boolean _connected = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		_context = this;	
		
		// takes the XML file created and presents it to the contentView
		setContentView(R.layout.main_layout);

		
		// setting the spinner
		Spinner spinner = (Spinner) findViewById(R.id.dropDown);
		
		// when a selection has been made in the spinner drop down, do this...
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// TODO Auto-generated method stub
				
				Log.i("Clicked", (parent.getItemAtPosition(pos).toString()));
				
				// putting the user selection into a string
				userDropDownSelection = (parent.getItemAtPosition(pos).toString());
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				userDropDownSelection = "musicArtist";
			}
		});
		
		
		
		// create an array adapter
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dropDownMenuArray, android.R.layout.simple_spinner_item);
		
		// specify the layout to use
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinner.setAdapter(adapter);

		// getting the go button to do something
		Button goButton = (Button) findViewById(R.id.goButton);
		
		goButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				@SuppressWarnings("unused")
				String tempString = "";
				if(userDropDownSelection != null){
					tempString = userDropDownSelection;
				
				
					//Log.i("Clicked Go", tempString);
				
					// gathering the user input
					EditText editTextBox = (EditText) findViewById(R.id.searchField);
					String inputString = editTextBox.getText().toString();
				
					getInfoFromApple(inputString, tempString);
					
					if(returnedJsonResult != null)
					{
						Log.i("yup", returnedJsonResult);
					}
				}
			}
		});
		
		// Detect network connection
		_connected = WebInfo.getConnectionStatus(_context);
		if(_connected)
		{
			Log.i("Network Connection", WebInfo.getConnectionType(_context));
		}
		
		//GridLayout gridLayout = (GridLayout) findViewById(R.id.gridView);
				

	}
	public void getInfoFromApple(String enteredSearchText, String searchType){
		Log.i("Clicked", enteredSearchText);
		
		// creation of my URL
		String baseURL = "https://itunes.apple.com/search?term=";
		String withEnteredSearchText = baseURL + enteredSearchText + "&entity=" +searchType+"&limit=1";
		@SuppressWarnings("unused")
		String qs;
		
		//setting up the UTF-8 based encoding
		try{
			qs = URLEncoder.encode(baseURL, "UTF-8");
		}catch(Exception e){
			Log.e("Bad Url", "Encoding problem");
			qs = "";
		}
		
		URL finalURL;
		try{
			
			// dont actually need my UTF-8 involved in the url
			finalURL = new URL(withEnteredSearchText);
			infoRequest newRequest = new infoRequest();
			newRequest.execute(finalURL);
			
		}catch(MalformedURLException e){
			Log.e("Bad Url", "malformed URL");
			finalURL = null;
		}
		
		
	}
	// this actually sends out the request
	private class infoRequest extends AsyncTask<URL, Void, String>{

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
				String newResultsString;
				
				JSONObject json = new JSONObject(result);
				JSONArray results = json.getJSONArray("results");
				
					artistName = results.getJSONObject(0).getString("artistName").toString();
					primaryGenre = results.getJSONObject(0).getString("primaryGenreName").toString();
					artistLinkUrl = results.getJSONObject(0).getString("artistLinkUrl").toString();
					
					/*
						collectionName = results.getJSONObject(0).getString("collectionName").toString();
						trackCount = results.getJSONObject(0).getString("trackCount").toString();
						collectionPrice = results.getJSONObject(0).getString("collectionPrice").toString();
					*/
					
					//Log.i("yes", artistName);
					//Log.i("Yes", primaryGenre);
					//Log.i("yes", artistLinkUrl);
					//Log.i("yes", collectionName);
					//Log.i("yes", trackCount);
					//Log.i("yes", collectionPrice);
				
				//Log.i("yes", artistName);
				//Log.i("Yes", primaryGenre);
				//Log.i("yes", artistLinkUrl);
				//Log.i("Yes", result);
				/*
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.e("Nope", "No such file");
			}
		
			returnedJsonResult = result;
		}

		private JSONObject newJSONObject(JSONArray results) {
			// TODO Auto-generated method stub
			return null;
		}
	}*/
