package gudon.sample.dialog04;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Dialog04Activity extends Activity {
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

            	new AlertDialog.Builder(Dialog04Activity.this)
            	.setMessage("Are you sure you want to exit?")
            	.setCancelable(false)
            	.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            		public void onClick(DialogInterface dialog, int id) {
            			Dialog04Activity.this.finish();
            	      }
            	  })
            	  .setNegativeButton("No", new DialogInterface.OnClickListener() {
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

