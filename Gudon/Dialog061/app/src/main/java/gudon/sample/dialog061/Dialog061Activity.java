package gudon.sample.dialog061;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Dialog061Activity extends Activity {
    /** Called when the activity is first created. */
	public static String result = "";
	public static int resultcode =0;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    	final LinearLayout layout = new LinearLayout(this);
    	layout.setOrientation(LinearLayout.VERTICAL);
    	setContentView(layout);

    	final CharSequence[] items = {"Red", "Green", "Blue"};
    	final Button button = new Button(this);
    	button.setText("ダイアログの表示");
    	button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	resultcode = CommonLibrary.showRadioDialog(
            			Dialog061Activity.this,
            			"色の選択", items);
            }
        });
    	layout.addView(button);
    
    	Button button2 = new Button(this);
    	button2.setText("resultcodeの結果を適用");
    	button2.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View v) {
    	    	CommonLibrary.showDialog(Dialog061Activity.this, 
    	    			"結果",String.format("%d", Dialog061Activity.resultcode));
    			switch (Dialog061Activity.resultcode)
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
