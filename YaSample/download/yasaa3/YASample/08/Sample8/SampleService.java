package ya.sample;

import java.util.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;

public class SampleService extends Service
{
    NotificationManager nm;
    Random r;
    String[] str = {"こんにちは", "ありがとう", "さようなら", "またね",
            "ごちそうさま", "元気でね", "よろしくね", "たのしいね"};

    public IBinder onBind(Intent it)
    {
        return null;
    }
    public void onCreate()
    {
        nm = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);

        r = new Random();
    }
    public void onStart(Intent it, int id)
    {
        Intent i = new Intent(this, Sample8.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
        Notification nf = new Notification.Builder(this)
                .setContentTitle("サンプル")
                .setContentText("設定画面に移動します。")
                .setContentIntent(pi)
                .setSmallIcon(R.drawable.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .build();

        nm.notify(0, nf);

        int m  = r.nextInt(str.length);

        Toast.makeText(this, str[m], Toast.LENGTH_LONG).show();
    }
    public void onDestroy()
    {
        nm.cancel(0);
    }
}
