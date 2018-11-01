package com.revtwo.revtwo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import com.revtwo.revtwolib.core.NotificationBroadcastReceiver;

import static android.content.Context.NOTIFICATION_SERVICE;

/*
 *  CustomNotificationReceiver.java
 *  RevTwo-Sample-App
 *
 *  Created on 3/21/17.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
 */
public class CustomNotificationReceiver extends NotificationBroadcastReceiver {
    @Override
    protected void onNotificationReceived(Context context, String ticketId, String message, int unreadMessages, boolean inForeground) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String CHANNEL_ID = "R2Channel";
            final Notification.Builder mBuilder = new Notification.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher_revtwo)
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher_revtwo))
                    .setColor(Color.TRANSPARENT)
                    .setContentTitle("New message")
                    .setContentText(message);

            Intent intent = new Intent(context, RevTwoSplashActivity.class);
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);
            mBuilder.setContentIntent(pendingIntent);

            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(Integer.parseInt(ticketId), mBuilder.build());

            return;
        }

        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setContentTitle("New message")
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_launcher_revtwo)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher_revtwo))
                .setColor(Color.TRANSPARENT)
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setPriority(2);

                Intent intent = new Intent(context, RevTwoSplashActivity.class);
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        notificationBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(Integer.parseInt(ticketId), notificationBuilder.build());

    }
}
