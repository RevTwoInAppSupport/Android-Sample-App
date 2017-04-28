package com.revtwo.revtwo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

import com.revtwo.revtwolibcore.NotificationBroadcastReceiver;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by harisk on 3/21/17.
 */

public class CustomNotificationReceiver extends NotificationBroadcastReceiver {
    @Override
    protected void onNotificationReceived(Context context, String ticketId, String message, int unreadMessages, boolean inForeground) {
        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setContentTitle("New message")
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_launcher_revtwo)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher_revtwo))
                .setColor(Color.TRANSPARENT)
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setPriority(2);

                 //Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());

                Intent intent = new Intent(context, RevTwoSplashActivity.class);
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                //Long ticketIdArgValue = Long.valueOf(ticketId);
                //intent.putExtra("ticketId",ticketIdArgValue);
                //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        notificationBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(Integer.parseInt(ticketId), notificationBuilder.build());

    }
}
