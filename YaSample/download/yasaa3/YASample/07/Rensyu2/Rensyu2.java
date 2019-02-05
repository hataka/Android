package ya.sample;

import android.app.*;
import android.os.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class Rensyu2 extends Activity
{
    MapFragment mf;
    EditText[] et = new EditText[6];
    TextView[] tv = new TextView[6];

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
        menu.add(Menu.NONE, 0, 0, "緯度・経度の入力");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        switch(mi.getItemId())
        {
            case 0:
                et = new EditText[6];
                tv = new TextView[6];

                TableLayout tl = new TableLayout(this);

                for(int i=0; i<et.length; i++)
                {
                    et[i] = new EditText(this);
                    tv[i] = new TextView(this);
                }

                tv[0].setText("度");
                tv[1].setText("分");
                tv[2].setText("秒");
                tv[3].setText("度");
                tv[4].setText("分");
                tv[5].setText("秒");
                et[1].setText("0");
                et[2].setText("0");
                et[4].setText("0");
                et[5].setText("0");

                TableRow tr1 = new TableRow(this);
                TableRow tr2 = new TableRow(this);

                tr1.addView(et[0]);
                tr1.addView(tv[0]);
                tr1.addView(et[1]);
                tr1.addView(tv[1]);
                tr1.addView(et[2]);
                tr1.addView(tv[2]);

                tr2.addView(et[3]);
                tr2.addView(tv[3]);
                tr2.addView(et[4]);
                tr2.addView(tv[4]);
                tr2.addView(et[5]);
                tr2.addView(tv[5]);

                tl.addView(tr1);
                tl.addView(tr2);

                AlertDialog.Builder ab = new AlertDialog.Builder(this);
                ab.setView(tl);
                ab.setTitle("緯度・経度の入力");
                ab.setPositiveButton("OK", new SampleClickListener());
                AlertDialog ad = ab.create();
                ad.show();

            break;
        }
        return true;
    }
    class SampleClickListener implements DialogInterface.OnClickListener
    {
        public void onClick(DialogInterface dialog, int id)
        {
            try{
                double[] d = new double[6];

                for(int i=0; i<et.length; i++)
                {
                    String str = et[i].getText().toString();
                    d[i] = Double.parseDouble(str);
                }

                int lt = (int) (d[0] + d[1] / 60 + d[2] /3600);
                int ln = (int) (d[3] + d[4] / 60 + d[5] /3600);

                GoogleMap gm = mf.getMap();
                LatLng ltn = new LatLng(lt, ln);
                gm.moveCamera(CameraUpdateFactory.newLatLng(ltn));
                gm.moveCamera(CameraUpdateFactory.zoomTo(5));

                MarkerOptions mo = new MarkerOptions();
                mo.position(ltn);
                gm.addMarker(mo);
            }
            catch(NumberFormatException e)
            {
                Toast.makeText(getBaseContext(), "数値を入力してください。", Toast.LENGTH_LONG).show();
            }
        }
    }
}
