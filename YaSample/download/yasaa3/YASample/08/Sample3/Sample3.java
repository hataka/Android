package ya.sample;

import java.util.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.speech.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample3 extends Activity
{
    public static int SAMPLE_APP = 1;
    Button bt;
    TextView tv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        tv = new TextView(this);

        bt = new Button(this);
        bt.setText("入力");

        ll.addView(tv);
        ll.addView(bt);

        bt.setOnClickListener(new SampleClickListener());
    }
    public void onActivityResult(int reqcode, int result, Intent it)
    {
        if(reqcode == SAMPLE_APP && result == RESULT_OK)
        {
            ArrayList<String> list =
                    it.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            tv.setText(list.get(0));
        }
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            try
            {
                Intent it = new Intent();
                it.setAction(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                it.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                it.putExtra(RecognizerIntent.EXTRA_PROMPT,"入力してください。");

                startActivityForResult(it,SAMPLE_APP);
            }
            catch(Exception e)
            {
               Toast.makeText(getApplicationContext(), "音声認識は利用できません。", Toast.LENGTH_LONG).show();
            }
        }
    }
}
