package ya.sample;

import android.app.*;
import android.os.*;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class Sample6 extends Activity
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

        GoogleMap gm = mf.getMap();
        gm.moveCamera(CameraUpdateFactory.zoomTo(5));
        LatLng ltn = new LatLng(40, 135);
        gm.moveCamera(CameraUpdateFactory.newLatLng(ltn));
    }
}
