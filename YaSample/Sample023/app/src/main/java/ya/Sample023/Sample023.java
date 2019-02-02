// -*- mode: java -*-  Time-stamp: <2012-02-14 9:24:42 kahata>
/*================================================================
 * title: 
 * file: Sample023.java
 * path: F:\android\YASample\Sample023\src\ya\Sample023\Sample023.java
 * url:  http://192.168.24.92/android/YASample/Sample023/src/ya/Sample023/Sample023.java
 * created: Time-stamp: <2012-02-14 9:24:42 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: 
 * description: オブジェクトを複数作成する p.21
 *================================================================*/

package ya.Sample023;

//import android.os.*;
//import android.widget.*;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Sample023 extends Activity
{
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      TextView tv1 = new TextView(this);
      tv1.setText("ようこそアンドロイドへ!");
      TextView tv2 = new TextView(this);
      tv2.setText("アンドロイドをはじめましょう!");

      ll.addView(tv1);
      ll.addView(tv2);
   }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "ソースをブラウザで表示");
		return super.onCreateOptionsMenu(menu);
	}
	// メニューが選択されたときに実行される
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		// 選択されたIDを確認
		switch (item.getItemId()) {
			case 0:
		    	// 指定したURLをWebviewに読み込む
				Uri uri = Uri.parse("http://192.168.24.92/android/YASample/Sample023/src/ya/Sample023/Sample023.java");
				Intent i = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(i);
				Toast.makeText(this,
						"Menu0", Toast.LENGTH_SHORT).show();
				break;
		}
		return true;
	}
}
