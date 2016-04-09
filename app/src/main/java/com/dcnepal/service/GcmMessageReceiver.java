package com.dcnepal.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.dcnepal.R;
import com.google.android.gms.gcm.GcmListenerService;

import java.util.ArrayList;
import java.util.List;

public class GcmMessageReceiver extends GcmListenerService {

    private static final String TAG = "MyGcmListenerService";

    /**
     * Called when message is received.
     *
     * @param from SenderID of the sender.
     * @param data Data bundle containing message data as key/value pairs.
     *             For Set of keys use data.keySet().
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(String from, Bundle data) {
        String gcmMessage = data.getString("message");
        Log.d(TAG, "From: " + from);
        Log.d(TAG, "Message: " + gcmMessage);

        String type = "";

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Uri defaultRingtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_tab_call)
                .setAutoCancel(true)
                .setSound(defaultRingtoneUri);

        List<String> details = new ArrayList<>();

        PendingIntent pendingIntent;
        TaskStackBuilder stackBuilder;
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        switch (type) {
            case "EVENT":
                break;
            case "MESSAGE":
                break;
        }

        nm.notify("NOTIFICATION", 0, notificationBuilder.build());

        // [START_EXCLUDE]
        /**
         * Production applications would usually process the message here.
         * Eg: - Syncing with server.
         *     - Store message in local database.
         *     - Update UI.
         */

        /**
         * In some cases it may be useful to show a notification indicating to the user
         * that a message was received.
         */
        // [END_EXCLUDE]
    }
    // [END receive_message]
}