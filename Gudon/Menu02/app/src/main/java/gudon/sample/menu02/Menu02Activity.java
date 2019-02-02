package gudon.sample.menu02;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Menu02Activity extends Activity {
	private static final int BUTTON1_MENU_ITEM1 = Menu.FIRST;
	private static final int BUTTON1_MENU_ITEM2 = Menu.FIRST + 1;

	private static final int BUTTON2_MENU_ITEM1 = Menu.FIRST + 2;;
	private static final int BUTTON2_MENU_ITEM2 = Menu.FIRST + 3;

	private Button button1, button2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		button1 = new Button(this);
		button1.setText("ボタン１");
		layout.addView(button1);
		registerForContextMenu(button1);

		button2 = new Button(this);
		button2.setText("ボタン2");
		layout.addView(button2);
		registerForContextMenu(button2);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		if (v.equals(button1)) {
			menu.add(Menu.NONE, BUTTON1_MENU_ITEM1, Menu.NONE, "button1Menu1");
			menu.add(Menu.NONE, BUTTON1_MENU_ITEM2, Menu.NONE, "button1Menu2");
		} else if (v.equals(button2)) {
			menu.add(Menu.NONE, BUTTON2_MENU_ITEM1, Menu.NONE, "button2Menu1");
			menu.add(Menu.NONE, BUTTON2_MENU_ITEM2, Menu.NONE, "button2Menu2");
		}
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case BUTTON1_MENU_ITEM1:
			// ここにBUTTON1_MENU_ITEM1が押された時の処理を記述する。
			button1.setText(String.format("menuTitle=%s", item.getTitle()));
			return true;
		case BUTTON1_MENU_ITEM2:
			button1.setText(String.format("menuTitle=%s", item.getTitle()));
			// ここにBUTTON1_MENU_ITEM2が押された時の処理を記述する。
			return true;
		case BUTTON2_MENU_ITEM1:
			// ここにBUTTON2_MENU_ITEM1が押された時の処理を記述する。
			button2.setText(String.format("menuTitle=%s", item.getTitle()));
			return true;
		case BUTTON2_MENU_ITEM2:
			button2.setText(String.format("menuTitle=%s", item.getTitle()));
			// ここにBUTTON2_MENU_ITEM2が押された時の処理を記述する。
			return true;
		default:
			return super.onContextItemSelected(item);
		}
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
				uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=54");
				i = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(i);
				Toast.makeText(this,
						"Menu0", Toast.LENGTH_SHORT).show();
				break;
		}
		return true;
	}



}

