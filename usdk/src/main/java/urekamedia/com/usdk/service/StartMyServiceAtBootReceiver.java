package urekamedia.com.usdk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import urekamedia.com.usdk.UrekaSdk;

public class StartMyServiceAtBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent serviceIntent = new Intent(context, UrekaSdk.class);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startService(serviceIntent);
        }
    }
}
