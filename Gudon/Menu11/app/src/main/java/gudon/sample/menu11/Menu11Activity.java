package gudon.sample.menu11;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Menu11Activity extends Activity {
	private static final int STYLE_BOLD_ID = Menu.FIRST;
	private static final int STYLE_ITALIC_ID = Menu.FIRST + 1;
	private static final int MENU_ITEM_WEBSITE = Menu.FIRST+2;

	private boolean cecked_bold = false;
	private boolean cecked_italic = true;

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
		SubMenu subMenuStyle = menu.addSubMenu("FontStyle");
        menu.add(Menu.NONE, MENU_ITEM_WEBSITE, Menu.NONE, "Web Site");
        subMenuStyle.add(Menu.NONE, STYLE_BOLD_ID, Menu.NONE, "Bold")
				.setCheckable(true).setChecked(cecked_bold);
		subMenuStyle.add(Menu.NONE, STYLE_ITALIC_ID, Menu.NONE, "Italic")
				.setCheckable(true).setChecked(cecked_italic);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Uri uri;
		Intent i;
		
		switch (item.getItemId()) {
		case MENU_ITEM_WEBSITE:
        	// ここにHelpが押された時の処理を記述する。
			// 指定したURLをWebviewに読み込む
			uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=55");
			i = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(i);
			Toast.makeText(this,
					"Menu0", Toast.LENGTH_SHORT).show();
			return true;
		case STYLE_BOLD_ID:
			cecked_bold = !cecked_bold;
			item.setChecked(!item.isChecked());
			// ここにBoldが選択された時の処理を記述する。
			return true;
		case STYLE_ITALIC_ID:
			cecked_italic = !cecked_italic;
			item.setChecked(!item.isChecked());
			// ここにItalicが選択された時の処理を記述する。
			return true;
		}
		return false;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add(Menu.NONE, STYLE_BOLD_ID, Menu.NONE, "Bold")
				.setCheckable(true).setChecked(cecked_bold);
		menu.add(Menu.NONE, STYLE_ITALIC_ID, Menu.NONE, "Italic")
				.setCheckable(true).setChecked(cecked_italic);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
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
