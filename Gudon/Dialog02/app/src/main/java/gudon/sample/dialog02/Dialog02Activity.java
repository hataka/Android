package gudon.sample.dialog02;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Dialog02Activity extends Activity {
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
                AlertDialog.Builder dlg;
                dlg = new AlertDialog.Builder(Dialog02Activity.this);
                dlg.setTitle("簡単なサンプル");
                dlg.setMessage("Hello, AlertDialog!");
/*
 * あまり使う事は無いが、AlertDialogそのもののインスタンスを取得する時には、
 * 以下のようにAlertDialog.Builderクラスのcreateメソッドを使用する。
 * 強いて、AlertDialogのインスタンスを取得して，これを使ってダイアログを表示するとすると、
 * 最初のサンプルの28行目を以下の2行で置き換える事になる。
 */
                //dlg.show();
                AlertDialog alertDialog=dlg.create();
                alertDialog.show();
               
            }
        });
    	layout.addView(button);
    }
}
