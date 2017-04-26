package com.revtwo.revtwo;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.revtwo.revtwolib.RevTwo;
import com.revtwo.revtwolibcore.NotificationBroadcastReceiver;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by harisk on 3/21/17.
 */

public class CustomNotificationReceiver extends NotificationBroadcastReceiver {
    @Override
    protected void onNotificationReceived(Context context, String ticketId, String message, int unreadMessages, boolean inForeground) {
        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setContentTitle(message)
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_attach)
                .setColor(Color.TRANSPARENT)
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setPriority(2);

        Log.d("Unread messages:",""+ RevTwo.getTicketManager().getUnreadMessages(context));

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(Integer.parseInt(ticketId), notificationBuilder.build());

    }
}
