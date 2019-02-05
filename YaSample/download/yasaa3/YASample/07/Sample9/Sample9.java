package ya.sample;

import java.util.*;
import android.app.*;
import android.os.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import android.location.*;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class Sample9 extends Activity
{
    MapFragment mf;
    EditText et;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mf = MapFragment.newInstance();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(android.R.id.content, mf);
        ft.commit();
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(Menu.NONE, 0, 0, "住所の入力");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        switch(mi.getItemId())
        {
            case 0:
                LinearLayout ll = new LinearLayout(this);
                ll.setOrientation(LinearLayout.VERTICAL);
                et = new EditText(this);
                ll.addView(et);

                new AlertDialog.Builder(this)
                        .setView(ll)
                        .setTitle("住所の入力")
                        .setPositiveButton("OK", new SampleClickListener())
                        .show();

                break;
        }
        return true;
    }
    class SampleClickListener implements DialogInterface.OnClickListener
    {
        public void onClick(DialogInterface dialog, int id)
        {
            try{
                String str = et.getText().toString();

                Geocoder gc = new Geocoder(getApplicationContext());
                List<Address> adlist = gc.getFromLocationName(str, 1);
                Address ad = adlist.get(0);
                double lt = ad.getLatitude();
                double ln = ad.getLongitude();
                GoogleMap gm = mf.getMap();
                LatLng ltn = new LatLng(lt, ln);
                gm.moveCamera(CameraUpdateFactory.newLatLng(ltn));
                gm.moveCamera(CameraUpdateFactory.zoomTo(5));
                MarkerOptions mo = new MarkerOptions();
                mo.position(ltn);
                gm.addMarker(mo);
            }
            catch(Exception e)
            {
                Toast.makeText(getBaseContext(), "見つかりませんでした。", Toast.LENGTH_LONG).show();
            }
        }
    }
}
