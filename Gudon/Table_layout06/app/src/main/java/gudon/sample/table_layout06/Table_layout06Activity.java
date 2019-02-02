package gudon.sample.table_layout06;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class Table_layout06Activity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final TableLayout tableLayout = new TableLayout(this);
		setContentView(tableLayout, new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));

		TableRow tableRow;

		tableRow = new TableRow(this);
		for (int iCol = 0; iCol < 3; iCol++) {
			Button button = new Button(this);
			button.setText("stretch");
			button.setTag(iCol);
			button.setOnClickListener(new View.OnClickListener() {

				//@Override
				public void onClick(View v) {
					int iCol = (Integer) v.getTag();
					tableLayout.setColumnStretchable(iCol,
							!tableLayout.isColumnStretchable(iCol));
				}
			});

			tableRow.addView(button);
		}
		tableLayout.addView(tableRow);

		tableRow = new TableRow(this);
		for (int iCol = 0; iCol < 3; iCol++) {
			Button button = new Button(this);
			button.setText("shrink");
			//button.setText("______shrink_____");
			button.setTag(iCol);
			button.setOnClickListener(new View.OnClickListener() {

				//@Override
				public void onClick(View v) {
					int iCol = (Integer) v.getTag();
					tableLayout.setColumnShrinkable(iCol,
							!tableLayout.isColumnShrinkable(iCol));
				}
			});

			tableRow.addView(button);
		}
		tableLayout.addView(tableRow);

		tableRow = new TableRow(this);
		for (int iCol = 0; iCol < 3; iCol++) {
			Button button = new Button(this);
			button.setText("collapse");
			button.setTag(iCol);
			button.setOnClickListener(new View.OnClickListener() {

				//@Override
				public void onClick(View v) {
					int iCol = (Integer) v.getTag();
					tableLayout.setColumnCollapsed(iCol, true);
				}
			});

			tableRow.addView(button);
		}
		tableLayout.addView(tableRow);

		tableLayout.setOnClickListener(new View.OnClickListener() {

			//@Override
			public void onClick(View v) {
				for (int iCol = 0; iCol < 3; iCol++) {
					tableLayout.setColumnCollapsed(iCol, false);
				}
			}
		});
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
