package gudon.sample.menu06;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;

import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.widget.Toast;

public class Menu06Activity extends Activity {
	private int optionsMenuCnt = 1;
	private int contextMenuCnt = 1;

    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    	LinearLayout layout = new LinearLayout(this);
    	layout.setOrientation(LinearLayout.VERTICAL);
    	setContentView(layout);

    	button = new Button(this);
    	button.setText("ボタン");
    	layout.addView(button);

		registerForContextMenu(button);
    }

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
        menu.add(String.format("menuItem%d", optionsMenuCnt++));
		return true;
	}

    @Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
    	contextMenuCnt++;
		for(int i=1;i<contextMenuCnt;i++)
	        menu.add(String.format("menuItem%d", i));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "Web Site");
		return super.onCreateOptionsMenu(menu);
	}
	// メニューが選択されたときに実行される
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Uri uri;
		Intent i;
		// 選択されたIDを確認
		switch (item.getItemId()) {
			case 0:
				// 指定したURLをWebviewに読み込む
				uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=57");
				i = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(i);
				Toast.makeText(this,
						"Menu0", Toast.LENGTH_SHORT).show();
				break;
		}
		return true;
	}
}
