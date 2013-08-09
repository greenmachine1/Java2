package com.Cory.week1;


// this class will pull json data from apple api
public class Json extends MainActivity{

	
	public String returnJsonData(String thingy){
		return "Hello" + thingy;
		
		
	}
}

	/*
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
	*/
	
	

