package gudon.sample.menu05;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Menu05Activity extends Activity {
	private static final String TAG = "MenuSample5";

	private Button button;

	private static final int MENU_ITEM1 = Menu.FIRST;
	private static final int MENU_ITEM2 = Menu.FIRST + 1;
	private static final int MENU_ITEM_WEBSITE = Menu.FIRST+2;

	private static final OnMenuItemClickListener menuItemClickListener = new OnMenuItemClickListener() {

		//@Override
		public boolean onMenuItemClick(MenuItem item) {
			Log.v(TAG, String.format("* onMenuItemClick - %s", item.getTitle()
					.toString()));

			return false;
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		button = new Button(this);
		button.setText("初期状態");
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// openOptionsMenu();
				// openContextMenu(button);
				// unregisterForContextMenu(button);
			}
		});

		layout.addView(button);

		registerForContextMenu(button);
	}

	// ------------------- メニュー共通のイベントメソッド

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Log.v(TAG, String.format("--- onMenuItemSelected --- - %s", item
				.getTitle().toString()));

		return super.onMenuItemSelected(featureId, item);
	}

	// ------------------- オプションメニューに関するイベントメソッド

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.v(TAG, "onCreateOptionsMenu");

		menu.add(Menu.NONE, MENU_ITEM1, Menu.NONE, "menuItem1");
		menu.add(Menu.NONE, MENU_ITEM2, Menu.NONE, "menuItem2")
				.setOnMenuItemClickListener(menuItemClickListener);
        menu.add(Menu.NONE, MENU_ITEM_WEBSITE, Menu.NONE, "Web Site");

		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		Log.v(TAG, "onPrepareOptionsMenu");

		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.v(TAG, String.format("onOptionsItemSelected - %s", item.getTitle()
				.toString()));
		Uri uri;
		Intent i;
		// 選択されたIDを確認
		switch (item.getItemId()) {
			case MENU_ITEM_WEBSITE:
				// 指定したURLをWebviewに読み込む
				uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=56");
				i = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(i);
				Toast.makeText(this,
						"Menu0", Toast.LENGTH_SHORT).show();
				break;
		}
		//return true;
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		Log.v(TAG, "--- onMenuOpened ---");

		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		Log.v(TAG, "onOptionsMenuClosed");

		super.onOptionsMenuClosed(menu);
	}

	// ------------------- コンテキストメニューに関するイベントメソッド

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.v(TAG, "onCreateContextMenu");

		menu.add(Menu.NONE, MENU_ITEM1, Menu.NONE, "menuItem1");
		menu.add(Menu.NONE, MENU_ITEM2, Menu.NONE, "menuItem2")
				.setOnMenuItemClickListener(menuItemClickListener);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Log.v(TAG, String.format("onContextItemSelected - %s", item.getTitle()
				.toString()));

		return super.onContextItemSelected(item);
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		Log.v(TAG, "onContextMenuClosed");

		super.onContextMenuClosed(menu);
	}
}

