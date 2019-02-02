package gudon.sample.table_layout09;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Table_layout09Activity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		TableLayout tableLayout = new TableLayout(this);
		setContentView(tableLayout);

		TableRow tableRow;
		EditText editText;
		LayoutParams layoutParams;

		tableRow = new TableRow(this);

		editText = new EditText(this);
		editText.setText("[0,0]");
		tableRow.addView(editText);

		editText = new EditText(this);
		editText.setText("[0,1]");
		tableRow.addView(editText);

		tableLayout.addView(tableRow);

		// layout_column属性の設定の例
		tableRow = new TableRow(this);
		editText = new EditText(this);
		editText.setText("[1,1]");
		layoutParams=new LayoutParams();
        layoutParams.column=1;
		tableRow.addView(editText,layoutParams);
		tableLayout.addView(tableRow);

		// layout_span属性の設定の例
		tableRow = new TableRow(this);
		editText = new EditText(this);
		editText.setText("[2,0]");
		layoutParams=new LayoutParams();
        layoutParams.span=2;
		tableRow.addView(editText,layoutParams);
		tableLayout.addView(tableRow);
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
