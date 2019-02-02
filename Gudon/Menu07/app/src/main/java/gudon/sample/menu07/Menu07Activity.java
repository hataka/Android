package gudon.sample.menu07;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Menu07Activity extends Activity {
	private boolean visible_menu_group = true;
	private boolean enabled_menu_group = true;

	private static final int GROUP_MENU_ = Menu.FIRST + 1;
	private static final int GROUP_MENU_ITEM1 = Menu.FIRST + 1;
	private static final int GROUP_MENU_ITEM2 = Menu.FIRST + 2;
	private static final int MENU_ITEM_WEBSITE = Menu.FIRST+3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		Button button;

		button = new Button(this);
		button.setText("change GroupVisible");
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				visible_menu_group = !visible_menu_group;
			}
		});
		layout.addView(button);
		registerForContextMenu(button);

		button = new Button(this);
		button.setText("change GroupEnabled");
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				enabled_menu_group = !enabled_menu_group;
			}
		});
		layout.addView(button);
		registerForContextMenu(button);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("menuItem1");

		menu.add(GROUP_MENU_, GROUP_MENU_ITEM1, Menu.NONE, "group menuItem1");
		menu.add(GROUP_MENU_, GROUP_MENU_ITEM2, Menu.NONE, "group menuItem2");
        menu.add(Menu.NONE, MENU_ITEM_WEBSITE, Menu.NONE, "Web Site");

		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.setGroupEnabled(GROUP_MENU_, enabled_menu_group);
		menu.setGroupVisible(GROUP_MENU_, visible_menu_group);

		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add("menuItem1");

		menu.add(GROUP_MENU_, GROUP_MENU_ITEM1, Menu.NONE, "group menuItem1");
		menu.add(GROUP_MENU_, GROUP_MENU_ITEM2, Menu.NONE, "group menuItem2");

		menu.setGroupEnabled(GROUP_MENU_, enabled_menu_group);
		menu.setGroupVisible(GROUP_MENU_, visible_menu_group);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Uri uri;
		Intent i;
		// 選択されたIDを確認
		switch (item.getItemId()) {
			case MENU_ITEM_WEBSITE:
				// 指定したURLをWebviewに読み込む
				uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=58");
				i = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(i);
				Toast.makeText(this,
						"Menu0", Toast.LENGTH_SHORT).show();
				break;
		}
		//return true;
		return super.onOptionsItemSelected(item);
	}

}
