// -*- mode: java -*-  Time-stamp: <2012-02-15 16:49:11 kahata>
/*================================================================
 * title: 
 * file: Sample063.java
 * path: F:\android\YASample\Sample063\src\ya\Sample063\Sample063.java
 * url:  http://localhost/f/android/YASample/Sample063/src/ya/Sample063/Sample063.java
 * created: Time-stamp: <2012-02-15 16:49:11 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: 
 * http://hocalhost/f/android/YASample/Sample063/AndroidManifest.xml
 * http://localhost/f/android/YASample/Sample063/res/layout/main.xml
 * http://localhost/f/android/YASample/Sample063/res/values/strings.xml
 * description: 
 *================================================================*/

package ya.Sample063;

import java.io.*;
import java.util.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.hardware.*;
import android.hardware.Camera.*;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Sample063 extends Activity
{
	Button bt;
	SurfaceView sv;
	SurfaceHolder sh;
	Camera cm;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this); 
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);
		
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
	  
		bt = new Button(this);
		bt.setText("撮影");
		
		sv = new SurfaceView(this);
		sh = sv.getHolder();
		
		sh.addCallback(new SampleSurfaceHolderCallback());		
		sh.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
  
		ll.addView(bt);
		ll.addView(sv);
		
		bt.setOnClickListener(new SampleClickListener());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "Sample063,java");
		menu.add(Menu.NONE, 1, Menu.NONE, "AndroidManifest.xml");
		menu.add(Menu.NONE, 2, Menu.NONE, "res/layout/main.xml");
		menu.add(Menu.NONE, 3, Menu.NONE, "res/values/strings.xml");
		return super.onCreateOptionsMenu(menu);
	}
	// メニューが選択されたときに実行される
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String url = "http://www.google.co.jp/";
		String toasttitle = "Google";
		// 選択されたIDを確認
		switch (item.getItemId()) {
			case 0:
				url = "http://193.168.1.53/f/android/YASample/Sample063/src/ya/Sample063/Sample063.java";
				toasttitle = "Sample063,java";
				break;
			case 1:
				//url= "http://193.168.1.53/f/android/YASample/Sample063/AndroidManifest.xml";
				url= "http://kahata.travel.coocan.jp/pukiwiki2016/index.php";
				toasttitle = "AndroidManifest.xml";
				break;
			case 2:
				url= "http://193.168.1.53/f/android/YASample/Sample063/res/layout/main.xml";
				toasttitle = "res/layout/main.xml";
				break;
			case 3:
				url= "http://193.168.1.53/f/android/YASample/Sample063/res/values/strings.xml";
				toasttitle = "res/values/strings.xml";
				break;
			default:
				break;
		}
		// 指定したURLをWebviewに読み込む
		Uri uri = Uri.parse(url);
		Intent i = new Intent(Intent.ACTION_VIEW,uri);
		startActivity(i);
		Toast.makeText(this,toasttitle, Toast.LENGTH_SHORT).show();
		return true;
	}
	
	class SampleSurfaceHolderCallback implements SurfaceHolder.Callback
	{
		public void surfaceCreated(SurfaceHolder holder)
		{
			cm = Camera.open();
			Camera.Parameters pr = cm.getParameters();
			List<Size> ss = pr.getSupportedPictureSizes();
			Size s = ss.get(0);
			pr.setPictureSize(s.width, s.height);
			cm.setParameters(pr);
		}
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) 
		{
			 try
			 {
				 WindowManager wm =  (WindowManager)getSystemService(WINDOW_SERVICE);
	  		  Display dp = wm.getDefaultDisplay(); 
				 int rt = dp.getRotation();
				 int d = 0;
				 switch (rt)
				 {
					 case Surface.ROTATION_0:
						 d = 90; break;
					 case Surface.ROTATION_90:
						 d = 0; break;
					 case Surface.ROTATION_180:
						 d = 270; break;
					 case Surface.ROTATION_270:
						 d = 180; break;
				  }

				  cm.setDisplayOrientation(d);
				  cm.setPreviewDisplay(sv.getHolder());
				  
				  Camera.Parameters pr = cm.getParameters();
				  pr.setPreviewSize(width, height);
				  cm.setParameters(pr);
				  cm.startPreview();
				 }
				 catch(Exception e){}
		}
		public void surfaceDestroyed(SurfaceHolder holder)
		{
			cm.stopPreview();
			cm.release();		
		}
	}
	class SampleClickListener implements OnClickListener
	{
		public void onClick(View v)
		{
			cm.takePicture(null,null, new SamplePictureCallback());
		}
		class SamplePictureCallback implements PictureCallback
		{
			public void onPictureTaken(byte[] data, Camera c)
			{
				try
				{
					File dir = new File(Environment.getExternalStorageDirectory(),"YASample");
					if(dir.exists() == false)
					{
						dir.mkdir();
					}	  
					File f = new File(dir, "pic.jpeg");  
					FileOutputStream fos = new FileOutputStream(f);
					fos.write(data);
					Toast.makeText(getApplicationContext(), "写真を保存しました。", Toast.LENGTH_LONG).show();
					fos.close();
					cm.startPreview();
				}
				catch(Exception e){}
			}
		}
	}  
}
