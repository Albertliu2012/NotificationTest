package com.androidbook.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotifice = findViewById(R.id.send_notice);
        sendNotifice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title LLLLLLLLLLLLL")

                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.mipmap.ic_launcher))
                        .setAutoCancel(true)
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
                        .setContentIntent(pi)
                        .setVibrate(new long[] {0,1000,1000,1000})
                        .setLights(Color.GREEN,1000,1000)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("This is content text Learn how to build notification, send" +
                                "and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."+
                                "This is content text Learn how to build notification, send" +
                                        "and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."+
                                "This is content text Learn how to build notification, send" +
                                        "and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
                        //.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background)))
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();
                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }
}
