package ya.sample;

import android.app.*;
import android.content.*;
import android.location.*;
import android.os.*;
import android.widget.*;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class Sample10 extends Activity
{
    MapFragment mf;
    LocationManager lm;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mf = MapFragment.newInstance();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(android.R.id.content, mf);
        ft.commit();

        lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    }
    public void onResume()
    {
        super.onResume();
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 50, new SampleLocationListener());
        GoogleMap gm;
        gm = mf.getMap();
        gm.setMyLocationEnabled(true);
    }
    class SampleLocationListener implements LocationListener
    {
        public void onLocationChanged(Location lc)
        {
            double lt = lc.getLatitude();
            double ln = lc.getLongitude();
            GoogleMap gm = mf.getMap();
            LatLng ltn = new LatLng(lt, ln);
            gm.moveCamera(CameraUpdateFactory.newLatLng(ltn));
            gm.moveCamera(CameraUpdateFactory.zoomTo(5));
            Toast.makeText(getBaseContext(), "現在地は\n緯度:" + lt + "\n経度:" + ln + "です。",
                    Toast.LENGTH_LONG).show();
        }
        public void onProviderDisabled(String pv){}
        public void onProviderEnabled(String pv){}
        public void onStatusChanged(String pv, int staus, Bundle ex){}
    }
}
