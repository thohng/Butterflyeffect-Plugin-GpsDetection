package com.butterflyeffect.plugins;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import org.apache.cordova.CordovaActivity;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;




public class GPSDetectionPlugin extends CordovaPlugin {

	@Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) {
    	
		
		PluginResult result = new PluginResult(Status.OK);
        
		boolean gpsEnabled = false;
		boolean npEnabled = false;
		
        String GPSDetectionAction = "gpsDetection";
		String NWSettingDialogAction = "npDetection";
		String GPSSettingDialogAction = "gpsSettingDialog";
		String ServiceLocationAction = "serviceLocationAction";
        	
        if (action.equals(ServiceLocationAction)) {
        	android.content.ContentResolver contentResolver = cordova.getActivity().getApplicationContext().getContentResolver();
			gpsEnabled = Settings.Secure.isLocationProviderEnabled(contentResolver, LocationManager.GPS_PROVIDER);
			npEnabled = Settings.Secure.isLocationProviderEnabled(contentResolver, LocationManager.NETWORK_PROVIDER);
			
        	result = new PluginResult(Status.OK, gpsEnabled || npEnabled);
        }
		else if (action.equals(GPSDetectionAction)){
			android.content.ContentResolver contentResolver = cordova.getActivity().getApplicationContext().getContentResolver();
            gpsEnabled = Settings.Secure.isLocationProviderEnabled(contentResolver, LocationManager.GPS_PROVIDER);
            result = new PluginResult(Status.OK, gpsEnabled);
		}
		else if (action.equals(NWSettingDialogAction)){
			android.content.ContentResolver contentResolver = cordova.getActivity().getApplicationContext().getContentResolver();
            npEnabled = Settings.Secure.isLocationProviderEnabled(contentResolver, LocationManager.NETWORK_PROVIDER);
            result = new PluginResult(Status.OK, npEnabled);
		}
        else if (action.equals(GPSSettingDialogAction)){
			Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			((CordovaActivity) this.cordova.getActivity()).startActivity(intent);
		}
		else
		{
            result = new PluginResult(Status.INVALID_ACTION);
        }
        
        callbackContext.sendPluginResult(result);
        
        return true;
    }
}