package gudon.sample.dialog05;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Dialog05Activity extends Activity {
    /** Called when the activity is first created. */
	public static String result = "";
	public static int resultcode =0;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    	final LinearLayout layout = new LinearLayout(this);
    	layout.setOrientation(LinearLayout.VERTICAL);
    	setContentView(layout);

    	final Button button = new Button(this);
    	button.setText("ダイアログの表示");
    	button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 final CharSequence[] items = {"Red", "Green", "Blue"};
                new AlertDialog.Builder(Dialog05Activity.this)
                .setTitle("Pick a color")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                    	button.setText(String.format("%sが選択されました。",items[item]));
                    	Dialog05Activity.result = String.format("%sが選択されました。",items[item]);
                    	Dialog05Activity.resultcode = item;
                    }
                })
                .show();
            }
        });
    	layout.addView(button);
    
    	Button button2 = new Button(this);
    	button2.setText("resultcodeの結果を適用");
    	button2.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View v) {
    	    	CommonLibrary.showDialog(Dialog05Activity.this, 
    	    			"結果",String.format("%d", Dialog05Activity.resultcode));
    			switch (Dialog05Activity.resultcode)
    			{    			
    			case 0: button.setBackgroundColor(Color.RED);break;	
    			case 1: button.setBackgroundColor(Color.GREEN);break;	
    			case 2: button.setBackgroundColor(Color.BLUE);break;	
    			}
    		}
    	});
    	layout.addView(button2);
	}
}
