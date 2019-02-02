//http://d.hatena.ne.jp/t-kado/20101212

package kahata.ColorPickerDialog;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

//import android.content.Intent;
//import android.net.Uri;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ColorPickerDialogActivity extends Activity {
	LinearLayout ll;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ll = (LinearLayout)findViewById(R.id.ll);
				
		ColorPickerDialog cpd=new ColorPickerDialog(this, new ColorPickerDialog.OnColorChangedListener() {
			
			@Override
			public void colorChanged(int color) {
				// 色が選択されるとcolorに値が入る
				int R=Color.red(color);
				int G=Color.green(color);
				int B=Color.blue(color);
				String msg = String.format("ColorPickerDialog (R,G,B)=(%d,%d,%d)",R,G,B);
				ll.setBackgroundColor(color);
				Toast.makeText(ColorPickerDialogActivity.this,msg, Toast.LENGTH_SHORT).show();
				//android.util.Log.d("ColorPickerDialog", "(R,G,B)=("+R+","+G+","+B+")");
			}
		},Color.BLACK);
		
		cpd.show();
	}
}
	   
	   


