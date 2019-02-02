package ya.Sample075;

import com.google.android.maps.*;

//import android.app.Activity;
//import android.app.AlertDialog;
import android.content.*;
import android.location.*;
import android.os.*;
import android.widget.*;

public class Sample075 extends MapActivity
{
	//public static final Sample075 CommonLibrary = null;
	MapView mv;
    LocationManager lm;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);

      mv= new MapView(this, "0ZEldpaTWV2dKLtPZARBsGq-B2WQyggZc9A7HLQ");  //APIキーが必要
      mv.setEnabled(true);
      mv.setClickable(true);
      mv.setBuiltInZoomControls(true);
      MapController mc = mv.getController();
      mc.setZoom(12);
      
      lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
      
      ll.addView(mv);
    }
   public void onResume()
   {
      super.onResume();
      //lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 50, new SampleLocationListener());   
      lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 50, new SampleLocationListener());   
   }
   protected boolean isRouteDisplayed()
   {
      return false;
   }
   class SampleLocationListener implements LocationListener
   {
      public void onLocationChanged(Location lc)
      {
         double dlt = lc.getLatitude();
         double dln = lc.getLongitude();

    	 int lt = (int) (lc.getLatitude() * 1E6);
         int ln = (int) (lc.getLongitude() * 1E6);
         GeoPoint gp = new GeoPoint(lt, ln);
         mv.getController().animateTo(gp);
         // WIFI 位置 緯度:34.8797614 経度:135.76644
         CommonLibrary.showDialog(Sample075.this,"現在位置","現在地は\n緯度:" + dlt + "\n経度:" + dln + "です。");
      }
      public void onProviderDisabled(String pv){}
      public void onProviderEnabled(String pv){}
      public void onStatusChanged(String pv, int staus, Bundle ex){}
   }
}
