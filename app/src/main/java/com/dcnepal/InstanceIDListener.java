package com.dcnepal;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by Aayush on 3/1/2016.
 */
public class InstanceIDListener extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        InstanceID instanceID = InstanceID.getInstance(this);

        //TODO Get valid sender id
        String sender_id = "default_sender_id";

        String token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
                GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
    }
}
