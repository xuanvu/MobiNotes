package edu.umn.csci5115.mobinotes;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import proxymusic.ScorePartwise;
import proxymusic.util.Marshalling;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		
        setContentView(R.layout.activity_main);    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /**
     * Example of how to import a score. -Bobby
     */
    public void ScoreExample() {
    	
        //try to import a score
	    //  Unmarshal the proxy
		File xmlFile = new File("scores/score.xml");
		try
		{
			System.out.println("Trying to import a score");
			InputStream is = new FileInputStream(xmlFile);
			long start = System.currentTimeMillis();
	
			ScorePartwise scorePartwise = Marshalling.unmarshal(is);
	
			System.out.println("Unmarshalling done in " + (System.currentTimeMillis() - start) + " ms");
	
			System.out.println("Score imported from " + xmlFile);
	
			is.close();
		}
		catch(Exception e)
		{
			
		}
		
    }
}
