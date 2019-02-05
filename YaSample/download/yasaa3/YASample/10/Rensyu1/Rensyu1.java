
package ya.sample;

import java.io.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Rensyu1 extends Activity
{
    Button[] bt = new Button[2] ;
    EditText et;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        for(int i=0; i<bt.length; i++)
        {
            bt[i] = new Button(this);
        }

        bt[0].setText("読込");
        bt[1].setText("保存");

        et = new EditText(this);
        et.setLines(3);

        ll.addView(et);

        for(int i=0; i<bt.length; i++)
        {
            ll.addView(bt[i]);
            bt[i].setOnClickListener(new SampleClickListener());
        }
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            if(v == bt[0])
            {
                try
                {
                    File dir = Environment.getExternalStorageDirectory();
                    File f = new File(dir, "Sample.txt");
                    FileInputStream fis = new FileInputStream(f);
                    BufferedReader br = new  BufferedReader(new InputStreamReader(fis));
                    StringBuffer sb = new StringBuffer();
                    String str;
                    while((str = br.readLine()) != null)
                    {
                        sb.append(str);
                    }
                    et.setText(sb);
                }
                catch(Exception e){}
            }
            else if(v == bt[1])
            {
                try
                {
                    File dir = Environment.getExternalStorageDirectory();
                    File f = new File(dir, "Sample.txt");
                    FileOutputStream fos = new FileOutputStream(f);
                    BufferedWriter bw = new  BufferedWriter(new OutputStreamWriter(fos));
                    bw.write(et.getText().toString());
                    bw.flush();
                    fos.close();
                }
                catch(Exception e){}
            }
        }
    }
}
