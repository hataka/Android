package gudon.sample.Menu01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
		private static final int MENU_ITEM1 = Menu.FIRST;
    private static final int MENU_ITEM2 = Menu.FIRST + 1;
    private static final int MENU_ITEM3 = Menu.FIRST + 2;
    Intent i;
    Uri uri;
    
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    	LinearLayout layout = new LinearLayout(this);
    	layout.setOrientation(LinearLayout.VERTICAL);
    	setContentView(layout);

    	button = new Button(this);
    	button.setText("初期状態");
    	layout.addView(button);
    }

    // Creates the menu items
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MENU_ITEM1, Menu.NONE, "menuItem1");
        menu.add(Menu.NONE, MENU_ITEM2, Menu.NONE, "menuItem2");
        menu.add(Menu.NONE, MENU_ITEM3, Menu.NONE, "Web Site");
        return true;
    }

    // Handles item selections */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	    	button.setText(String.format("menuTitle=%s",item.getTitle()));
        switch (item.getItemId()) {
        case MENU_ITEM1:
        	// ここにMENU_ITEM1が押された時の処理を記述する。
            return true;
        case MENU_ITEM2:
        	// ここにMENU_ITEM2が押された時の処理を記述する。
            return true;
        case MENU_ITEM3:
        	// ここにMENU_ITEM2が押された時の処理を記述する。
			// 指定したURLをWebviewに読み込む
			uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=54");
			i = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(i);
			Toast.makeText(this,"Web Site", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
