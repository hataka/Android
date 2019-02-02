package com.moonlight_aska.android.tablelayout03;



import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

//テーブルレイアウト
public class TableLayout03 extends Activity {
    private final static int WC=TableLayout.LayoutParams.WRAP_CONTENT;
    private final static int FP=TableLayout.LayoutParams.FILL_PARENT;

    //アプリの初期化
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウトの生成
        TableLayout layout=new TableLayout(this);
        //layout.setBackgroundColor(Color.WHITE);
        layout.setGravity(Gravity.CENTER);//中央寄せ
        setContentView(layout);
        
        for (int j=0;j<5;j++) {
            //行の生成
            TableRow row=new TableRow(this);
            row.setLayoutParams(new TableLayout.LayoutParams(FP,WC));
            row.setGravity(Gravity.CENTER);//中央寄せ
            layout.addView(row);
            
            //要素の追加
            for (int i=0;i<5;i++) {
                Button button=new Button(this);
                button.setText("("+i+","+j+")");
                row.addView(button);	
            }
        }
    } 
}
/*


import android.app.Activity;
import android.os.Bundle;

public class TableLayout03 extends Activity {
    / ** Called when the activity is first created. * /
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
*/