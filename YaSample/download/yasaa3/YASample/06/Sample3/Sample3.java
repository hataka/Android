package ya.sample;

import java.util.*;
import android.app.*;
import android.os.*;
import android.speech.tts.*;
import android.speech.tts.TextToSpeech.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample3 extends Activity
{
    EditText et;
    Button bt;
    TextToSpeech tts;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        et = new EditText(this);

        bt = new Button(this);
        bt.setText("開始");

        ll.addView(et);
        ll.addView(bt);

        tts = new TextToSpeech(getApplicationContext(), new SampleInitListener());
        tts.setLanguage(Locale.ENGLISH);

        bt.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            String str  = et.getText().toString();
            if(str != null)
            {
                tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
            }
        }
    }
    class SampleInitListener implements OnInitListener
    {
        public void onInit(int status){}
    }
}
