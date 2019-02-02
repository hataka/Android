package kahata.KahataLauncher;

//package kahta.ReverseHandbookLauncher;

//-*- mode: java -*-  Time-stamp: <2012-02-04 20:12:16 kahata>
/*================================================================
* title: インストール済みアプリリストを取得する
* file: MainActivity.java
* path: F:\android\workspace\work\MainActivity.java
* url:  http://localhost/android/workspace/work/MainActivity.java
* created: Time-stamp: <2012-02-04 20:12:16 kahata>
* revision: $Id$
* Programmed By: kahata
* To compile:
* To run: 
* link: https://sites.google.com/site/matsudroid/tips/tips/apuririsutowo-shutoku-suru
* description: インストール済みアプリリストを取得する
*================================================================*/

//package kahata.MyLauncher;

import java.util.ArrayList;
import java.util.List;

//import kahata.KahataLauncher.KahataLauncherActivity;

//import kahata.KahataLauncher.ArrArrayListayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

//import android.net.Uri;
/**
* メイン画面
* @author kohichi.matsuda@gmail.com
*
*/
public class KahataLauncherActivity extends Activity implements OnItemClickListener, OnItemLongClickListener {

	private static final int ONCREATE = 1;
	private static final int ONITEMCLICK = 2;
	private int menuindex = 0;
	
	/*
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case ONCREATE:
				getAppList(0);
				break;
			case ONITEMCLICK:
				startActivitySafe(msg.arg1);
				break;
			default:
				break;
			}
		};
	};
	*/
	private ListView mAppListView;
	private List<ResolveInfo> mAppList;
	private ArrayList<ResolveInfo> myAppList;//=new ArrayList<ResolveInfo>();
     
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ListView listView = (ListView) findViewById(R.id.listView1);
		mAppListView = listView;
		listView.setOnItemClickListener(this);
		listView.setOnItemLongClickListener(this);
     
	//mHandler.sendEmptyMessage(ONCREATE);
  	getAppList(0);
  }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "全カテゴリー表示");
		menu.add(Menu.NONE, 1, Menu.NONE, "Sslib");
		menu.add(Menu.NONE, 2, Menu.NONE, "Sslib以外");
		menu.add(Menu.NONE, 3, Menu.NONE, "ListView");
		menu.add(Menu.NONE, 4, Menu.NONE, "Graphic");
		menu.add(Menu.NONE, 5, Menu.NONE, "MainActivity");
		menu.add(Menu.NONE, 6, Menu.NONE, "PackageManager");
		menu.add(Menu.NONE, 7, Menu.NONE, "Screen");
		menu.add(Menu.NONE, 8, Menu.NONE, "Webview");
		return super.onCreateOptionsMenu(menu);
	}
	// メニューが選択されたときに実行される
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		menuindex = item.getItemId();
		getAppList(item.getItemId());
		return true;
	}

  /**
   * アプリリストを取得し、ListView に設定
   */
  private void getAppList(int option) {
     
	// ListView に設定する ArrayAdapter を作成
	ArrayAdapter<String> adapter =
		new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1);
     
	// アプリ一覧を取得する
	PackageManager pm = getPackageManager();
	// 検索条件
	Intent intent = new Intent(Intent.ACTION_MAIN);
	intent.addCategory(Intent.CATEGORY_LAUNCHER);
	// 検索
	List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
	myAppList=new ArrayList<ResolveInfo>();

	// ArrayAdapter にアプリ名を追加

	
	
	
	for (ResolveInfo info : list) {
		//adapter.add(info.activityInfo.loadLabel(pm).toString());
		String packageName = info.activityInfo.packageName;

		
		switch(option)
		{
		case 0:
			if(packageName.indexOf("kahata.")>-1)
			{
				myAppList.add(info);
				adapter.add(info.activityInfo.loadLabel(pm).toString());
			}		
			break;
		case 1: //おかしい
			if(packageName.indexOf("kahata.Sslib")>-1)
			{
				myAppList.add(info);
				adapter.add(info.activityInfo.loadLabel(pm).toString());
			}		
			break;
		case 2:
			if(!(packageName.indexOf("Sslib")>-1))
				if(packageName.indexOf("kahata.")>-1)
			{
				myAppList.add(info);
				adapter.add(info.activityInfo.loadLabel(pm).toString());
			}		
		case 3:
			if(packageName.indexOf("com.example.listview")>-1)
			{
				myAppList.add(info);
				adapter.add(info.activityInfo.loadLabel(pm).toString());
			}		
			break;
		case 4:
			if(packageName.indexOf("com.example.graphic")>-1)
			{
				myAppList.add(info);
				adapter.add(info.activityInfo.loadLabel(pm).toString());
			}		
			break;
		case 5:
			if(packageName.indexOf("com.example.mainactivity")>-1)
			{
				myAppList.add(info);
				adapter.add(info.activityInfo.loadLabel(pm).toString());
			}		
			break;
		case 6:
			if(packageName.indexOf("com.example.packagemanager")>-1)
			{
				myAppList.add(info);
				adapter.add(info.activityInfo.loadLabel(pm).toString());
			}		
			break;
		case 7:
			if(packageName.indexOf("com.example.screen")>-1)
			{
				myAppList.add(info);
				adapter.add(info.activityInfo.loadLabel(pm).toString());
			}		
			break;
		case 8:
			if(packageName.indexOf("com.example.webview")>-1)
			{
				myAppList.add(info);
				adapter.add(info.activityInfo.loadLabel(pm).toString());
			}		
			break;
		}
	}
	// ListView に ArrayAdapter を設定
	mAppListView.setAdapter(adapter);
	mAppList = list;

  }

  /**
   * ListView のアイテムをクリック
   */
	@Override
	//public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
	//public void onItemLongClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		//Message msg = mHandler.obtainMessage(ONITEMCLICK, position, 0);
		//mHandler.sendMessage(msg);
		startActivitySafe(position);
		return true;    
}
     
	/**
	 * クリックされたアイテムに対応するアプリを起動
	 * @param position
	 */
	String pkg;
	String ac;
	Intent intent;
	Uri uri;
	int action;
	private void startActivitySafe(int position) {
		final CharSequence[] items = {"Launch", "UnInstall"};
		//int idx;
		try {
			//ResolveInfo info = mAppList.get(position);

			ResolveInfo info = myAppList.get(position);
			pkg = info.activityInfo.packageName;
			ac = info.activityInfo.name;
			uri=Uri.fromParts("package",pkg,null);
			
			Toast.makeText(this, pkg + "\n" + ac, Toast.LENGTH_LONG).show();
			Log.v("Info", pkg + " :::: " + ac);			
			
			
			new AlertDialog.Builder(KahataLauncherActivity.this)
			.setTitle("MyLauncher")
			.setCancelable(true)
			.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int item) {
					switch(item)
					{
					case 0: action = 0; break;
					case 1: action = 1; break;
					}				
				}
			})
			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {

					switch(action)
					{
					case 0:	
						intent = new Intent(Intent.ACTION_MAIN);
						intent.addCategory(Intent.CATEGORY_LAUNCHER);
						intent.setClassName(pkg, ac);
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
						//finish();
						break;
					case 1:	
						intent = new Intent(Intent.ACTION_DELETE, uri);   
						startActivity(intent);
						action = 0;
						getAppList(0);
						break;
					}
				}
			})
         	.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
         		public void onClick(DialogInterface dialog, int id) {
                  dialog.cancel();
              }
          })	
						.show();			
		} catch (Exception e) {
			// 失敗した場合の処理
			Toast.makeText(this, android.R.string.cancel, Toast.LENGTH_LONG).show();
		}
	}


	@Override
//	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
//			long arg3) {
public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO 自動生成されたメソッド・スタブ
		//Toast.makeText(this, android.R.string.cancel, Toast.LENGTH_LONG).show();
		ResolveInfo info = myAppList.get(position);
		pkg = info.activityInfo.packageName;
		ac = info.activityInfo.name;
		intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		intent.setClassName(pkg, ac);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);		
		//finish();
		//return false;
	}
}
