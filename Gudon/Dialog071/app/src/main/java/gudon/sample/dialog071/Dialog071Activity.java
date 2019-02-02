package gudon.sample.dialog071;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Dialog071Activity extends Activity {
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
               	
            	//LayoutInflater inflater = LayoutInflater.from(Dialog071Activity.this);
               	//上を以下に変更
            	LayoutInflater inflater = (LayoutInflater) getApplicationContext()
               			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

               	View layout = inflater.inflate(R.layout.custom_dialog,
               	                (ViewGroup) findViewById(R.id.layout_root));
               	TextView text = (TextView) layout.findViewById(R.id.text);
               	text.setText("Hello, this is a custom dialog!");
               	ImageView image = (ImageView) layout.findViewById(R.id.image);
               	image.setImageResource(R.drawable.ic_launcher);
               	new AlertDialog.Builder(Dialog071Activity.this)
               		.setView(layout)
        .show();
            }
        });
    	layout.addView(button);
    }
}


