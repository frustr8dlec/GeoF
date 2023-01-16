package com.example.geofence;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;
// On receive doesn't trigger
public class GeofenceBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "Geofencing";


    @Override
    public void onReceive(Context context, Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError()) {
            String errorMessage = GeofenceStatusCodes
                    .getStatusCodeString(geofencingEvent.getErrorCode());
            Log.e(TAG, errorMessage);
            Log.d(TAG, "Transition errored");
            Toast.makeText(context, "Beep Beep Beep", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(context, "Beep", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Transition detected");
    }
}
