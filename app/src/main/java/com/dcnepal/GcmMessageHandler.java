package com.dcnepal;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

public class GCMMessageHandler extends IntentService {

    private LocalBroadcastManager mBroadcaster;

    public GCMMessageHandler() {
        super("GCMMessageHandler");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBroadcaster = LocalBroadcastManager.getInstance(this);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();

        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

        try{
            String messageType = (String) extras.get("TYPE");

        switch (messageType){
            case "MESSAGE":

                mBroadcaster.sendBroadcast(intent);
                break;
            case "CHAT_BEGIN":
                break;
            case "CHAT_END":
                break;
            default:
                break;
        }
        } catch (Exception e){
            Log.e("GCM Exception", e.toString());
        }

        GCMReceiver.completeWakefulIntent(intent);

    }
}