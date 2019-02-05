package ya.sample;

import java.io.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.webkit.*;
import android.widget.*;

public class Sample3 extends Activity
{
    public static int SAMPLE_APP = 1;

    Button[] bt = new Button[4];
    WebView wv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TableLayout tl = new TableLayout(this);
        setContentView(tl);

        wv = new WebView(this);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://www.google.com");

        TableRow tr = new TableRow(this);

        for(int i=0; i<bt.length; i++)
        {
            bt[i] = new Button(this);
            tr.addView(bt[i]);
        }

        bt[0].setText("←");
        bt[1].setText("→");
        bt[2].setText("○");
        bt[3].setText("=");

        for(int i=0; i<bt.length; i++)
        {
            bt[i].setOnClickListener(new SampleClickListener());
        }

        tl.addView(tr);
        tl.addView(wv);

    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            if(v == bt[0])
            {
                if(wv.canGoBack())
                {
                    wv.goBack();
                }
            }
            else if(v == bt[1])
            {
                if(wv.canGoForward())
                {
                    wv. goForward();
                }
            }
            else if(v == bt[2])
            {
                try
                {
                    FileOutputStream fos = openFileOutput("SampleRSS.txt", Context.MODE_APPEND);
                    BufferedWriter bw = new  BufferedWriter(new OutputStreamWriter(fos));
                    bw.write(wv.getUrl() + "\n");
                    bw.flush();
                    fos.close();
                }
                catch(Exception e){}
            }
            else if(v == bt[3])
            {
                Intent it = new Intent(getApplicationContext(), SampleRSS.class);
                startActivityForResult(it, SAMPLE_APP);
            }
        }
    }
    public void onActivityResult(int reqcode, int result, Intent it)
    {
        if(reqcode == SAMPLE_APP && result == RESULT_OK)
        {
            String rss = it.getStringExtra("URL");
            wv.loadUrl(rss);
        }
    }
}
