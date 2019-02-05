package ya.sample;

import android.app.*;
import android.os.*;
import com.google.android.gms.maps.*;

public class Sample4 extends Activity
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
    public void onResume()
    {
        super.onResume();

        GoogleMap gm;
        gm = mf.getMap();
        gm.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
