package gudon.sample.menu04;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Menu04Activity extends Activity {
	private static final int MENU_ITEM_FILE = Menu.FIRST;
	private static final int MENU_ITEM_EDIT = Menu.FIRST+10;
	private static final int MENU_ITEM_HELP = Menu.FIRST+20;
	private static final int MENU_ITEM_WEBSITE = Menu.FIRST+30;
	
	private static final int MENU_ITEM_FILE_NEW = MENU_ITEM_FILE+1;
	private static final int MENU_ITEM_FILE_OPEN = MENU_ITEM_FILE+2;
	private static final int MENU_ITEM_FILE_SAVE = MENU_ITEM_FILE+3;;
	
	private static final int MENU_ITEM_EDIT_UNDO = MENU_ITEM_EDIT+1;
	private static final int MENU_ITEM_EDIT_REDO = MENU_ITEM_EDIT+2;

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
    	  boolean result = super.onCreateOptionsMenu(menu);

    	  SubMenu fileMenu = menu.addSubMenu(Menu.NONE, MENU_ITEM_FILE, Menu.NONE, "File");
    	  SubMenu editMenu = menu.addSubMenu(Menu.NONE, MENU_ITEM_EDIT, Menu.NONE, "Edit");
          menu.add(Menu.NONE, MENU_ITEM_HELP, Menu.NONE, "Help");
          menu.add(Menu.NONE, MENU_ITEM_WEBSITE, Menu.NONE, "Web Site");

          fileMenu.add(Menu.NONE, MENU_ITEM_FILE_NEW, Menu.NONE, "new");
    	  fileMenu.add(Menu.NONE, MENU_ITEM_FILE_OPEN, Menu.NONE, "open");
    	  fileMenu.add(Menu.NONE, MENU_ITEM_FILE_SAVE, Menu.NONE, "save");
    	  
    	  editMenu.add(Menu.NONE, MENU_ITEM_EDIT_UNDO, Menu.NONE, "undo");
    	  editMenu.add(Menu.NONE, MENU_ITEM_EDIT_REDO, Menu.NONE, "redo");

    	  return result;
    }

    // Handles item selections */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
		Uri uri;
		Intent i;

    	button.setText(String.format("menuTitle=%s",item.getTitle()));
    	
        switch (item.getItemId()) {
        case MENU_ITEM_FILE:
        	// ここにFileが押された時の処理を記述する。
            return true;
        case MENU_ITEM_EDIT:
        	// ここにEditが押された時の処理を記述する。
            return true;
        case MENU_ITEM_HELP:
        	// ここにHelpが押された時の処理を記述する。
            return true;
        case MENU_ITEM_WEBSITE:
        	// ここにHelpが押された時の処理を記述する。
			// 指定したURLをWebviewに読み込む
			uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=55");
			i = new Intent(Intent.ACTION_VIEW,uri);
		startActivity(i);
			Toast.makeText(this,
					"Menu0", Toast.LENGTH_SHORT).show();
			return true;
        case MENU_ITEM_FILE_NEW:
        	// ここにnewが押された時の処理を記述する。
            return true;
        case MENU_ITEM_FILE_OPEN:
        	// ここにopenが押された時の処理を記述する。
            return true;
        case MENU_ITEM_FILE_SAVE:
        	// ここにsaveが押された時の処理を記述する。
            return true;
        case MENU_ITEM_EDIT_UNDO:
        	// ここにundoが押された時の処理を記述する。
            return true;
        case MENU_ITEM_EDIT_REDO:
        	// ここにredoが押された時の処理を記述する。
            return true;
        }
        return false;
    }
}
