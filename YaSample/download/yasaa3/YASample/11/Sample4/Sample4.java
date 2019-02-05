package ya.sample;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.xmlpull.v1.*;
import android.app.*;
import android.graphics.Color;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample4 extends Activity
{
    EditText et;
    Button bt;
    ListView lv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        et = new EditText(this);
        bt = new Button(this);
        lv = new ListView(this);
        lv.setBackgroundColor(Color.BLACK);

        bt.setText("読込");

        ll.addView(et);
        ll.addView(bt);
        ll.addView(lv);

        bt.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            new SampleAsyncTask().execute();
        }
    }
    class SampleAsyncTask extends AsyncTask<Void, Void, ArrayList<String>>
    {
        ArrayList<String> ar = null;

        protected ArrayList<String> doInBackground(Void... params)
        {
            HttpResponse hr = null;
            try{
                String uri = et.getText().toString();
                HttpClient hc = new DefaultHttpClient();
                HttpGet hg = new HttpGet();
                hg.setURI(new URI(uri));
                hr = hc.execute(hg);

                InputStream is = hr.getEntity().getContent();
                BufferedReader br = new  BufferedReader(new InputStreamReader(is));

                XmlPullParserFactory xpf = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = xpf.newPullParser();
                xpp.setInput(br);

                int type = 0;
                type = xpp.getEventType();
                boolean isTitle = false;
                ar = new ArrayList<String>();

                while (type != XmlPullParser.END_DOCUMENT)
                {
                    if(type == XmlPullParser.START_TAG)
                    {
                        if(xpp.getName().equals("title"))
                        {
                            isTitle = true;
                        }
                    }
                    else if(type == XmlPullParser.TEXT)
                    {
                        if(isTitle == true)
                        {
                            ar.add(xpp.getText());
                        }
                    }
                    else if(type == XmlPullParser.END_TAG)
                    {
                        if(xpp.getName().equals("title"))
                        {
                            isTitle = false;
                        }
                    }
                    type = xpp.next();
                }
            }
            catch(Exception e){}

            return ar;
        }
        protected void onPostExecute(ArrayList<String> ar)
        {
            if(ar != null){
                ArrayAdapter<String> ad = new ArrayAdapter<String>
                        (getApplicationContext(), android.R.layout.simple_list_item_1, ar);
                lv.setAdapter(ad);
            }
            else{
                Toast.makeText(getBaseContext(), "URLを確認してください。", Toast.LENGTH_LONG).show();
            }
        }
    }
}
