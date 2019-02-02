package gudon.sample.menu08;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Menu08Activity extends Activity {
	private static final int COLOR_MENU_GROUP = Menu.FIRST + 1;
	private static final int COLOR_RED_ID = Menu.FIRST + 1;
	private static final int COLOR_BLUE_ID = Menu.FIRST + 2;
	private static final int MENU_ITEM_WEBSITE = Menu.FIRST+5;
	private static final int STYLE_MENU_GROUP = Menu.FIRST + 2;
	private static final int STYLE_BOLD_ID = Menu.FIRST + 3;
	private static final int STYLE_ITALIC_ID = Menu.FIRST + 4;

	private boolean cecked_bold = false;
	private boolean cecked_italic = true;
	private int selected_color_id = COLOR_BLUE_ID;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		Button button = new Button(this);
		button.setText("ボタン");
		layout.addView(button);
		registerForContextMenu(button);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		SubMenu subMenuColor = menu.addSubMenu("FontColor");
		subMenuColor.add(COLOR_MENU_GROUP, COLOR_RED_ID, 0, "Red");
		subMenuColor.add(COLOR_MENU_GROUP, COLOR_BLUE_ID, 0, "Blue");
		subMenuColor.setGroupCheckable(COLOR_MENU_GROUP, true, true);

		SubMenu subMenuStyle = menu.addSubMenu("FontStyle");
		subMenuStyle.add(STYLE_MENU_GROUP, STYLE_BOLD_ID, 0, "Bold");
		subMenuStyle.add(STYLE_MENU_GROUP, STYLE_ITALIC_ID, 0, "Italic");
		subMenuStyle.setGroupCheckable(STYLE_MENU_GROUP, true, false);
	    menu.add(Menu.NONE, MENU_ITEM_WEBSITE, Menu.NONE, "Web Site");
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.findItem(selected_color_id).setChecked(true);
		menu.findItem(STYLE_BOLD_ID).setChecked(cecked_bold);
		menu.findItem(STYLE_ITALIC_ID).setChecked(cecked_italic);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Uri uri;
		Intent i;
		switch (item.getItemId()) {
		case COLOR_RED_ID:
			selected_color_id = COLOR_RED_ID;
			// ここにRedが選択された時の処理を記述する。
			return true;
		case COLOR_BLUE_ID:
			selected_color_id = COLOR_BLUE_ID;
			// ここにBlueが選択された時の処理を記述する。
			return true;
		case STYLE_BOLD_ID:
			cecked_bold = !cecked_bold;
			// ここにBoldが選択された時の処理を記述する。
			return true;
		case STYLE_ITALIC_ID:
			cecked_italic = !cecked_italic;
			// ここにItalicが選択された時の処理を記述する。
			return true;
		case MENU_ITEM_WEBSITE:
			// 指定したURLをWebviewに読み込む
			uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=58");
			i = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(i);
			Toast.makeText(this,
				"Menu0", Toast.LENGTH_SHORT).show();
			return true;
		}
		
		return false;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add(COLOR_MENU_GROUP, COLOR_RED_ID, 0, "Red");
		menu.add(COLOR_MENU_GROUP, COLOR_BLUE_ID, 0, "Blue");
		menu.setGroupCheckable(COLOR_MENU_GROUP, true, true);
		menu.findItem(selected_color_id).setChecked(true);

		menu.add(STYLE_MENU_GROUP, STYLE_BOLD_ID, 0, "Bold").setChecked(cecked_bold);
		menu.add(STYLE_MENU_GROUP, STYLE_ITALIC_ID, 0, "Italic").setChecked(cecked_italic);
		menu.setGroupCheckable(STYLE_MENU_GROUP, true, false);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case COLOR_RED_ID:
			selected_color_id = COLOR_RED_ID;
			// ここにRedが選択された時の処理を記述する。
			return true;
		case COLOR_BLUE_ID:
			selected_color_id = COLOR_BLUE_ID;
			// ここにBlueが選択された時の処理を記述する。
			return true;
		case STYLE_BOLD_ID:
			cecked_bold = !cecked_bold;
			// ここにBoldが選択された時の処理を記述する。
			return true;
		case STYLE_ITALIC_ID:
			cecked_italic = !cecked_italic;
			// ここにItalicが選択された時の処理を記述する。
			return true;
		}
		return false;
	}
}
