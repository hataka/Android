package ya.sample;

import android.app.*;
import android.os.*;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.GoogleMap.*;
import com.google.android.gms.maps.model.*;

public class Sample7 extends Activity
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
        LatLng ltn = new LatLng(40, 135);
        MarkerOptions mo = new MarkerOptions();
        mo.position(ltn);
        gm.addMarker(mo);
        gm.moveCamera(CameraUpdateFactory.newLatLng(ltn));
        gm.moveCamera(CameraUpdateFactory.zoomTo(3));

        gm.setOnMapClickListener(new SampleMapClickListener());

    }
    class SampleMapClickListener implements OnMapClickListener
    {
        public void onMapClick(LatLng ltn)
        {
            MarkerOptions mo = new MarkerOptions();
            mo.position(ltn);
            GoogleMap gm = mf.getMap();
            gm.addMarker(mo);
        }
    }
}
