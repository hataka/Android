package gudon.sample.dialog06;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Dialog06Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    	LinearLayout layout = new LinearLayout(this);
    	layout.setOrientation(LinearLayout.VERTICAL);
    	setContentView(layout);

    	final Button button = new Button(this);
    	button.setText("ダイアログの表示");
    	button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	final CharSequence[] items = {"Red", "Green", "Blue"};

            	new AlertDialog.Builder(Dialog06Activity.this)
            	.setTitle("Pick a color")
            	.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            	    public void onClick(DialogInterface dialog, int item) {
            	    	button.setText(String.format("%sが選択されました。",items[item]));
            	    }
            	})
            	.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            		public void onClick(DialogInterface dialog, int id) {
            			dialog.cancel();
            		}
            	})
            	.show();
            }
        });
    	layout.addView(button);
    }
}
