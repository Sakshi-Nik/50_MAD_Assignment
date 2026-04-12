package com.example.notification;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> showNotification());
    }

    private void showNotification() {

        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // 🔊 Default sound
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // Channel (Android 8+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "ch1", "MyChannel", NotificationManager.IMPORTANCE_HIGH);
            channel.setSound(sound, null);
            manager.createNotificationChannel(channel);
        }


        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "ch1")
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Coffee Shop ☕")
                        .setContentText("Your order is ready!")
                        .setSound(sound)
                        .setPriority(NotificationCompat.PRIORITY_HIGH);


        manager.notify(1, builder.build());
    }
}
