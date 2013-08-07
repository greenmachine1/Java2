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

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        String content = "Java isnt that great";
        
        // calling my writeDataToStorage method
        writeDataToStorage(content);
        
    }
    
    
    // writeDataToStorage does exactly what It says 
    private void writeDataToStorage(String data){
    	// all of this is to put the string content into storage
        try {
			FileOutputStream fos = openFileOutput("MyFile", Context.MODE_PRIVATE);
			fos.write(data.getBytes());
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private StringBuffer returnDataFromStorage(String fileName){
    	FileInputStream fileInputStream;
		try {
			fileInputStream = openFileInput(fileName);
		
    	BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
    	byte[] contentBytes = new byte[1024];
    	int bytesRead = 0;
    	String content;
    	StringBuffer contentBuffer = new StringBuffer();
  
		while((bytesRead = bufferedInputStream.read(contentBytes)) != -1){
			content = new String(contentBytes,0,bytesRead);
			contentBuffer.append(content);
			}
		return contentBuffer;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
