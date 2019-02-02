package gudon.sample.menu10;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Menu10Activity extends Activity {
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
		registerForContextMenu(button);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Uri uri;
		Intent i;
		
		button.setText(String.format("menuTitle=%s",item.getTitle()));
        switch (item.getItemId()) {
        case R.id.menuItem1:
        	// ここにMENU_ITEM1が押された時の処理を記述する。
            return true;
        case R.id.menuItem2:
        	// ここにMENU_ITEM2が押された時の処理を記述する。
            return true;
        case R.id.website:
        	// ここにMENU_ITEM2が押された時の処理を記述する。
			// 指定したURLをWebviewに読み込む
			uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=59");
			i = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(i);
			Toast.makeText(this,
				"Web Site", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
	}
}
