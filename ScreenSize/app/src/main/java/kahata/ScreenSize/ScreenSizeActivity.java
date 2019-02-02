// -*- mode: java -*-  Time-stamp: <2017-06-03 14:53:27 kahata>
/*================================================================
 * title: 
 * file: ScreenSizeActivity.java
 * path: C:\AndroidStudio\AndroidStudioProjects\ScreenSize\app\src\main\java\kahata\ScreenSize\ScreenSizeActivity.java
 * url:  C:/AndroidStudio/AndroidStudioProjects/ScreenSize/app/src/main/java/kahata/ScreenSize/ScreenSizeActivity.java
 * created: Time-stamp: <2017-06-03 14:53:27 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: http://seesaawiki.jp/w/moonlight_aska/d/%B2%E8%CC%CC%A5%B5%A5%A4%A5%BA%A4%F2%BC%E8%C6%C0%A4%B9%A4%EB
 * description: 画面サイズを取得する
 *================================================================*/
package kahata.ScreenSize;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScreenSizeActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager windowmanager = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display disp = windowmanager.getDefaultDisplay();
        int width = disp.getWidth();
        int height = disp.getHeight();     

        LinearLayout ll = new LinearLayout(this);
        setContentView(ll);
        
        TextView tv = new TextView(this);
        tv.setWidth(width);
        tv.setHeight(height);
        tv.setBackgroundColor(Color.BLUE);
        tv.setBackgroundColor(Color.rgb(0, 0, 64));
        tv.setTextSize(24.0f);
        tv.setTextColor(Color.rgb(0, 255, 255));


        tv.setText(String.format("画面サイズ width:%d   height:%d" ,width,height)); //"ようこそアンドロイドへ!");
        //setContentView(R.layout.main);
        ll.addView(tv);
        
    }
}