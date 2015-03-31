package com.androidexample.accelerometerexample;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

public class MainAccelerometer extends Activity implements AccelerometerListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accelerometer_example_main);
		
		// Check onResume Method to start accelerometer listener
	}
   
	public void onAccelerationChanged(float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}

	public void onShake(float force) {
		
		// Called when Motion Detected
		Toast.makeText(getBaseContext(), "Motion detected", 
				Toast.LENGTH_LONG).show();
		
	}

	@Override
    public void onResume() {
            super.onResume();
            Toast.makeText(getBaseContext(), "onResume Accelerometer Started", 
            		Toast.LENGTH_LONG).show();
            
            //Check device supported Accelerometer senssor or not
            if (AccelerometerManager.isSupported(this)) {
            	
            	//Start Accelerometer Listening
    			AccelerometerManager.startListening(this);
            }
    }
	
	@Override
    public void onStop() {
            super.onStop();
            
            //Check device supported Accelerometer senssor or not
            if (AccelerometerManager.isListening()) {
            	
            	//Start Accelerometer Listening
    			AccelerometerManager.stopListening();
    			
    			Toast.makeText(getBaseContext(), "onStop Accelerometer Stoped", 
    					Toast.LENGTH_LONG).show();
            }
           
    }
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("Sensor", "Service  distroy");
		
		//Check device supported Accelerometer senssor or not
		if (AccelerometerManager.isListening()) {
			
			//Start Accelerometer Listening
			AccelerometerManager.stopListening();
			
			Toast.makeText(getBaseContext(), "onDestroy Accelerometer Stoped", 
					Toast.LENGTH_LONG).show();
        }
			
	}

}
