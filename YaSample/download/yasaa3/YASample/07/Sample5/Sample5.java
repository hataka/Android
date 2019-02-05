package ya.sample;

import android.app.*;
import com.google.android.gms.maps.*;
import android.os.*;

public class Sample5 extends Activity
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
        gm.setTrafficEnabled(true);
        gm.setMyLocationEnabled(true);

        UiSettings us = gm.getUiSettings();
        us.setZoomControlsEnabled(true);
     }
}
