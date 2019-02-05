package ya.sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.webkit.*;
import android.widget.*;

public class Sample2 extends Activity
{
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
        bt[2].setText("+");
        bt[3].setText("-");

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
                wv.zoomIn();
            }
            else if(v == bt[3])
            {
                wv.zoomOut();
            }
        }
    }
}
