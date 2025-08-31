package com.example.paymenttracker;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class NotificationListener extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        String pkg = sbn.getPackageName();
        if (pkg.contains("gpay") || pkg.contains("phonepe") || pkg.contains("paytm") || pkg.contains("bharatpe")) {
            String title = sbn.getNotification().extras.getString("android.title");
            String text = sbn.getNotification().extras.getString("android.text");
            Log.d("PaymentTracker", "Payment Notification: " + title + " - " + text);
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        // Optional: Handle removed notifications
    }
}
