package net.buildbox.pokeri.ui_notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RemoteViews;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
    // PendingIntent用ID
    private static final int SAMPLE_REQUEST = 1;
    // 通知用ID
    private static final int NOTIFICATION_ID = 100;

    private static final String CHANNEL_ID = "SAMPLE_CHANNEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                "Pokeri Notification", NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.enableVibration(true);

            NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

    // 標準的な通知の送信
    public void sendNotification(View v) {
        // 1. Notificationインスタンスの生成
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        // 2.(ア) ステータスバーに表示する設定を行う
        builder.setSmallIcon(android.R.drawable.star_big_on); // アイコンの設定
        builder.setTicker("ステータスバー上の表示テキスト"); // ステータスバー上のテキストの設定

        // 2.(イ) 通知領域に表示する設定を行う
        builder.setContentTitle("通知領域のタイトル");
        builder.setContentText("通知領域のテキスト");
        builder.setContentInfo("通知情報");
        // Intentの生成(技術評論社のサイトを開くIntentの生成）
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gihyo.co.jp/"));
        PendingIntent contentIntent = PendingIntent.getActivity(
            this, SAMPLE_REQUEST, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        //　3.(ウ) プロパティの設定を行う
        builder.setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6"));
        builder.setLights(Color.BLUE, 1000, 400);

        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_SHOW_LIGHTS;

        // 4. 通知の実行
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, notification);
        }
    }

    // 実行状態の通知の送信
    public void sendOnGoingNotification(View v) {
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        builder.setSmallIcon(android.R.drawable.star_big_on);    // アイコンの設定
        builder.setContentTitle("実行状態の通知");
        builder.setContentText("消せません");
        builder.setWhen(System.currentTimeMillis());

        // 実行中の状態フラグを付与する
        Notification notification = builder.build();
        notification.flags += Notification.FLAG_ONGOING_EVENT;

        // 通知の実行
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, notification);
        }
    }

    // 大きい画像を表示するスタイルの通知を送信
    public void sendBigPictureStyleNotification(View v) {
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        builder.setSmallIcon(android.R.drawable.star_big_on);    // アイコンの設定
        builder.setContentTitle("大きい画像の通知");
        builder.setContentText("通知します。");
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);

        // 大きいテキストのスタイルを設定
        NotificationCompat.BigPictureStyle bigPictureNotification =
            new NotificationCompat.BigPictureStyle(builder);
        Bitmap bigPicture = BitmapFactory.decodeResource(getResources(), android.R.drawable.sym_def_app_icon);
        bigPictureNotification.bigPicture(bigPicture);
        bigPictureNotification.setSummaryText("スタイルがBigPictureStyle");

        // 通知の実行
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, bigPictureNotification.build());
        }
    }

    // 大きいテキストを表示するスタイルの通知を送信
    public void sendBigTextStyleNotification(View v) {
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        builder.setSmallIcon(android.R.drawable.star_big_on);    // アイコンの設定
        builder.setContentTitle("大きいテキストの通知");
        builder.setContentText("通知します。");
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);

        // 大きいテキストのスタイルを設定
        NotificationCompat.BigTextStyle bigTextNotification =
            new NotificationCompat.BigTextStyle(builder);
        bigTextNotification.bigText("文字が大きいです");
        bigTextNotification.setSummaryText("スタイルがBigTextStyle");

        // 通知の実行
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, bigTextNotification.build());
        }
    }

    // 複数行のテキストを表示するスタイルの通知を送信
    public void sendInboxStyleNotification(View v) {
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        builder.setSmallIcon(android.R.drawable.star_big_on);    // アイコンの設定
        builder.setContentTitle("複数行のテキストの通知");
        builder.setContentText("通知します。");
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);

        // 複数行のテキストのスタイルを設定
        NotificationCompat.InboxStyle inboxStyleNotification =
            new NotificationCompat.InboxStyle(builder);
        inboxStyleNotification.addLine("1行目です。");
        inboxStyleNotification.addLine("2行目です。");
        inboxStyleNotification.addLine("3行目です。");
        inboxStyleNotification.setSummaryText("スタイルがInboxStyle");

        // 通知の実行
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, inboxStyleNotification.build());
        }
    }

    // カスタマイズした通知を送信
    public void sendCustomNotification(View v) {
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        // 通知のカスタマイズ
        RemoteViews remoteView = new RemoteViews(getPackageName(), R.layout.notification_layout);
        remoteView.setImageViewResource(R.id.icon1, android.R.drawable.sym_def_app_icon);
        remoteView.setImageViewResource(R.id.icon2, android.R.drawable.sym_action_chat);
        remoteView.setTextViewText(R.id.title, "タイトルです。");
        remoteView.setTextViewText(R.id.message, "テキストメッセージ！");
        builder.setContent(remoteView);

        builder.setSmallIcon(android.R.drawable.star_big_on);    // アイコンの設定
        builder.setAutoCancel(true);

        // 通知の実行
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }

    // ボタンを追加した通知を送信
    public void sendButtonNotification(View v) {
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        builder.setSmallIcon(android.R.drawable.star_big_on); // アイコンの設定
        builder.setTicker("ステータスバー上の表示テキスト"); // ステータスバー上のテキストの設定
        builder.setContentTitle("タイトル");
        builder.setContentText("テキスト");
        builder.setContentInfo("通知情報");
        // Intentの生成
        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.co.jp/"));
        PendingIntent contentIntent1 = PendingIntent.getActivity(
            this, SAMPLE_REQUEST, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.addAction(android.R.drawable.star_off, "Google", contentIntent1);
        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gihyo.co.jp/"));
        PendingIntent contentIntent2 = PendingIntent.getActivity(
            this, SAMPLE_REQUEST, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.addAction(android.R.drawable.star_off, "技術評論社", contentIntent2);
        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://buildbox.net/"));
        PendingIntent contentIntent3 = PendingIntent.getActivity(
            this, SAMPLE_REQUEST, intent3, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.addAction(android.R.drawable.star_off, "buildbox.net", contentIntent3);


        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }
}
