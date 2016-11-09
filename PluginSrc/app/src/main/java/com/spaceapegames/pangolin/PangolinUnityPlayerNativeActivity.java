package com.spaceapegames.pangolin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.unity3d.player.UnityPlayerActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Set;

/**
 * Created by bill on 09/11/2016.
 */

public class PangolinUnityPlayerNativeActivity extends UnityPlayerActivity {

    String launchBundleParametersJson;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        Intent intent = getIntent();
        if (intent != null) {
            Log.d("Pangolin", "onCreate: intent=" + intent);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Log.d("Pangolin", "onCreate: extras=" + extras);
                JSONObject json = new JSONObject();
                Set<String> keys = extras.keySet();
                for (String key : keys) {
                    try {
                        Object value = extras.get(key);
                        Log.d("Pangolin", "onCreate: key=" + key + " value=" + value);
                        json.put(key, JSONObject.wrap(value));
                    } catch (JSONException e) {
                        //Handle exception here
                    }
                }
                launchBundleParametersJson = json.toString();
            }
        }
    }



    public String getLaunchBundleParametersJson()
    {
        return launchBundleParametersJson;
    }
}
