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
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	FileOutputStream fos;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        String content = "Java isnt that great";
        
        // my file storage
        try {
			fos = openFileOutput("Myfile", Context.MODE_PRIVATE);
			fos.write(content.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    String readTextFile(){
    	try{
    		FileInputStream fin = openFileInput(fos);
    		BufferedInputStream bin = new BufferedInputStream(fin);
    		byte[] contentBytes = new byte[1024];
    		int bytesRead = 0;
    		String content;
    		StringBuffer contentBuffer = new StringBuffer();
    		
    		while((bytesRead = bin.read(contentBytes)) != -1){
    			content = new String(contentBytes,0,bytesRead);
    			contentBuffer.append(content);
    		}
    		
    		return contentBuffer;
    	}catch(FileNotFoundException e){
    		return "";
    	}catch(IOException e){
    		return "";
    	}
    	
		return null;
    	
    }

    
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
