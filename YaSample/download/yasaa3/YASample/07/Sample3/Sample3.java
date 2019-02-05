package ya.sample;

import android.app.*;
import android.os.*;
import com.google.android.gms.maps.*;

public class Sample3 extends Activity
{
    MapFragment mf;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mf = MapFragment.newInstance();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(android.R.id.content, mf);
        ft.commit();
    }
}
