package gudon.sample.table_layout05;

import android.app.Activity;
import android.os.Bundle;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.EditText;
//import android.widget.TableLayout;
//import android.widget.TableRow;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Table_layout05Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
				uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=113");
				i = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(i);
				Toast.makeText(this,
						"Menu0", Toast.LENGTH_SHORT).show();
				break;
		}
		return true;
	}	

}