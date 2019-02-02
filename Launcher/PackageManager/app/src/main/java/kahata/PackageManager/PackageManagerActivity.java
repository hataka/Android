// -*- mode: java -*-  Time-stamp: <2017-06-12 8:59:33 kahata>
/*================================================================
 * title: インストール済みアプリリストを取得する
 * file: PackageManagerActivity.java
 * path: F:\GitHub\hataka\codingground\android\Launcher\PackageManager\app\src\main\java\kahata\PackageManager\PackageManagerActivity.java
 * url:  http://192.168.1.53/f/GitHub/hataka/codingground/android/Launcher/PackageManager/app/src/main/java/kahata/PackageManager/PackageManagerActivity.java
 * created: Time-stamp: <2012-02-04 20:12:16 kahata>
 * revision:Time-stamp: <2017-06-12 8:59:33 kahata> SndroidStudio移植 mHandler除去
 * Programmed By: kahata
 * link: https://sites.google.com/site/matsudroid/tips/tips/apuririsutowo-shutoku-suru
 * description: インストール済みアプリリストを取得する
 *================================================================*/

package kahata.PackageManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import kahata.TextDialog01.R;
//import kahata.TextDialog01.TextDialog01Activity.OKButtonClickHandler;


import android.view.Menu;
import android.view.MenuItem;
/**
 * メイン画面
 * @author kohichi.matsuda@gmail.com
 *
 */
public class PackageManagerActivity extends Activity implements OnItemClickListener, OnItemLongClickListener {

	Bundle savedInstanceStateOrg;
	
	//private static final int ONCREATE = 1;
	//private static final int ONITEMCLICK = 2;
	//private int menuindex = 0;

	private CustomData itemData;
	private Drawable icon = null;
	/*
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case ONCREATE:
				//getAppList(0);
				getAppList(R.id.menu_launcher);
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
	private ArrayList<CustomData>  myAppInfo;	   
	
	
	TextView textView;// = (TextView) findViewById(R.id.name);
	EditText editText;// = new EditText(this);					// (1)

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		savedInstanceStateOrg = savedInstanceState;
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);

		editText = new EditText(this);   
		textView = (TextView) findViewById(R.id.name);
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		mAppListView = listView;
		listView.setOnItemClickListener(this);
		listView.setOnItemLongClickListener(this);
	   
		//mHandler.sendEmptyMessage(ONCREATE);
		getAppList(R.id.menu_launcher);
	}

	/**
	 * アプリリストを取得し、ListView に設定
	 */
	PackageManager pm;
	private void getAppList(int menuid) {
		pm = getPackageManager();
		// 検索条件
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		// 検索
		List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
		//myAppList=new ArrayList<ResolveInfo>();
		myAppInfo = new ArrayList<CustomData>();
		// ArrayAdapter にアプリ名を追加
		for (ResolveInfo info : list) {
			String pkgname = info.activityInfo.packageName;
			
	   	switch(menuid){
				case R.id.menu_all:addAppInfo(info);break;
				case R.id.menu_launcher:if(pkgname.indexOf("Launcher")>-1)addAppInfo(info);break;
				case R.id.menu_test:if(pkgname.indexOf("Test")>-1)addAppInfo(info);break;
				case R.id.menu_kahata:
				
					if(pkgname.indexOf("kahata.")>-1)addAppInfo(info);
					//Menu testmenu = (Menu) findViewById(R.id.menu_test);
					//onCreateOptionsMenu(testmenu);
					break;
				case R.id.menu_moonlight:if(pkgname.indexOf("moonlight")>-1)addAppInfo(info);break;
				case R.id.menu_ndk:if(pkgname.indexOf("com.ndk")>-1)addAppInfo(info);break;
				case R.id.menu_gudon:if(pkgname.indexOf("gudon")>-1)addAppInfo(info);break;
				case R.id.menu_reverse:if(pkgname.indexOf("com.example")>-1)addAppInfo(info);break;
				case R.id.menu_ya:if(pkgname.indexOf("ya.")>-1)addAppInfo(info);break;
				case R.id.menu_techbooster:if(pkgname.indexOf("techbooster")>-1)addAppInfo(info);break;
				case R.id.menu_android:if(pkgname.indexOf("com.android")>-1)addAppInfo(info);break;
				case R.id.menu_google:if(pkgname.indexOf("com.google")>-1)addAppInfo(info);break;
				case R.id.menu_asus:if(pkgname.indexOf("com.asus")>-1)addAppInfo(info);break;
				case R.id.menu_nocategory:
					boolean special = pkgname.indexOf("kahata.")>-1
						|| pkgname.indexOf("moonlight")>-1
						|| pkgname.indexOf("gudon")>-1
						|| pkgname.indexOf("com.example")>-1
						|| pkgname.indexOf("ya.")>-1
						|| pkgname.indexOf("techbooster")>-1
						|| pkgname.indexOf("com.android")>-1
						|| pkgname.indexOf("com.google")>-1
						|| pkgname.indexOf("com.asus")>-1;
						if (!special) addAppInfo(info);break;
					default: addAppInfo(info);break; //onCreate(savedInstanceStateOrg);break;//;
				}//end of switch
		}  //for (ResolveInfo info : list)
		CustomAdapter customAdapater = new CustomAdapter(this, 0, myAppInfo);
			// ListView に ArrayAdapter を設定
		mAppListView.setAdapter(customAdapater);
	}

	
	private void getAppList(String kw,int kind) {
		pm = getPackageManager();
		// 検索条件
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		// 検索
		List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
		//myAppList=new ArrayList<ResolveInfo>();
		myAppInfo = new ArrayList<CustomData>();
		// ArrayAdapter にアプリ名を追加
		for (ResolveInfo info : list) {
			String pkgname = info.activityInfo.packageName;
   			String title = info.activityInfo.loadLabel(pm).toString();
			switch(kind)
   			{
   			case 0:
   				if(pkgname.indexOf(kw)>-1)addAppInfo(info);
   				break;
   			case 1:
   				if(title.indexOf(kw)>-1)addAppInfo(info);
   				break;
   			}
   		}
		CustomAdapter customAdapater = new CustomAdapter(this, 0, myAppInfo);
		// ListView に ArrayAdapter を設定
		mAppListView.setAdapter(customAdapater);
	}
	
	private void addAppInfo(ResolveInfo info) {
		itemData = new CustomData();
		itemData.setResolveInfo(info);
		if(info.activityInfo.loadLabel(pm).toString()!=null){
		//アプリ名取得
			itemData.setTextData(info.activityInfo.loadLabel(pm).toString()
					+ " : " + info.activityInfo.packageName);
		}else{
			itemData.setTextData("NoName");
		} 
		try {
			icon = pm.getApplicationIcon(info.activityInfo.packageName);
			//アイコンを表示させる為のImageViewを定義しておく事
			itemData.setImagaData(icon);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		myAppInfo.add(itemData);
		//adapter.add(info.activityInfo.loadLabel(pm).toString());
	}
	
	/**
	 * ListView のアイテムをクリック
	 */
	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		//Message msg = mHandler.obtainMessage(ONITEMCLICK, position, 0);
		//mHandler.sendMessage(msg);
		startActivitySafe(position);
	   return true;	
	}
	   
	/**
	 * クリックされたアイテムに対応するアプリを起動
	 * @param position
	 */
	Intent intent;
	Uri uri;
	ResolveInfo info;
	int action;

	private void startActivitySafe(int position) {
		final CharSequence[] items = {"Launch", "UnInstall","Information","マーケット検索","Google検索"};
		try {
			info = myAppInfo.get(position).getResolveInfo();
			uri=Uri.fromParts("package",info.activityInfo.packageName,null);
			
			new AlertDialog.Builder(PackageManagerActivity.this)
			.setTitle("MyLauncher")
			.setCancelable(true)
			.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int item) {
					switch(item)
					{
					case 0: action = 0; break;
					case 1: action = 1; break;
					case 2: action = 2; break;
					case 3: action = 3; break;
					case 4: action = 4; break;
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
						intent.setClassName(info.activityInfo.packageName, info.activityInfo.name);
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
						//finish();
						break;
					case 1:	
						intent = new Intent(Intent.ACTION_DELETE, uri);   
						startActivity(intent);
						action = 0;
						getAppList(R.id.menu_all);
						//getAppList(0);
						break;
					case 2:	
					/*	// http://iwatanlab.blogspot.com/2011/03/android.html
						Method getPackageSizeInfo = 
							pm.getClass().getMethod("getPackageSizeInfo", 
																String.class,
							 IPackageStatsObserver.class);

						getPackageSizeInfo.invoke(pm, info.packageName, new IPackageStatsObserver.Stub() {
							@Override
							public void onGetStatsCompleted(PackageStats pStats, boolean succeeded) 
							throws RemoteException {
							
								Log.i("AppSize", "codeSize: " + pStats.codeSize);
							}
						});
						*/
						
						new AlertDialog.Builder(PackageManagerActivity.this)
						   	.setTitle("Packade Information")
						   	.setMessage(getPackageInfo(info))
						   	.setNegativeButton("OK", new DialogInterface.OnClickListener() {
							  public void onClick(DialogInterface dialog, int id) {
								   dialog.cancel();
							  	}
						   	})
						   	.show();
						break;
					case 3:	
						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri.parse("market://search?q=pname:" 
								+info.activityInfo.packageName));
						startActivity(intent);
						break;
					case 4:
						Uri uri = Uri.parse("http://www.google.co.jp/search?q="
								+ info.activityInfo.packageName);
						Intent i = new Intent(Intent.ACTION_VIEW,uri);
						startActivity(i);
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

	public String getPackageInfo(ResolveInfo info)
	{
		String message ="";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		PackageInfo packageInfo = new PackageInfo(); //null;
		try {
		   packageInfo = getPackageManager().getPackageInfo(info.activityInfo.packageName, 
				   PackageManager.GET_META_DATA);
		} catch (NameNotFoundException e) {
		   e.printStackTrace();
		}
		Date dateFirstInstallTime = new Date(packageInfo.firstInstallTime);
		Date dateLastUpdateTime = new Date(packageInfo.lastUpdateTime);
	 
		//"versionCode : "+packageInfo.versionCode+" / "+"versionName : "+packageInfo.versionName);
		message =  "パッケージ名: " + info.activityInfo.packageName +"\n";
		message += "クラス名: " + info.activityInfo.name + "\n";
		message += "バージョンコード: "+packageInfo.versionCode+"\n";
		message += "バージョン名: "+packageInfo.versionName +"\n";
		message += "パーミッション: " + info.activityInfo.permission + "\n";//toString() + "#\n"; //..;
		message += "プロセス名: " + info.activityInfo.processName + "\n";
		message += "ターゲットアクティビティ: " + info.activityInfo.targetActivity + "\n\n";
		message += "インストール日時 :\t"+  formatter.format(dateFirstInstallTime) + "\n";
		message += "更新日時 :\t\t\t\t"+ formatter.format(dateLastUpdateTime);
		return message;
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO 自動生成されたメソッド・スタブ
		ResolveInfo info = myAppInfo.get(position).getResolveInfo();
		String pkg = info.activityInfo.packageName;
		String ac = info.activityInfo.name;
		intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		intent.setClassName(pkg, ac);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);		
		//finish();
	}

	//////////////////////////////////////////////////////////////////////////////////
	public class CustomData {
		private Drawable _imageData;
		private String 	_textData;
		private ResolveInfo _rsvInfo;
		
		public void setImagaData(Drawable image) {
			_imageData = image;
		}

		public Drawable getImageData() {
			return _imageData;
		}

		public void setTextData(String text) {
			_textData = text;
		}

		public String getTextData() {
			return _textData;
		}

		public void setResolveInfo(ResolveInfo info) {
			_rsvInfo = info;
		}
	
		public ResolveInfo getResolveInfo() {
			return _rsvInfo;
		}
	}

	public class CustomAdapter extends ArrayAdapter<CustomData> {
		private LayoutInflater layoutInflater_;

		public CustomAdapter(Context context, int textViewResourceId, List<CustomData> objects) {
			super(context, textViewResourceId, objects);
			layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// 特定の行(position)のデータを得る
			CustomData item = (CustomData)getItem(position);
		 
		 	// convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
			if (null == convertView) {
				convertView = layoutInflater_.inflate(R.layout.custom_layout, null);
			}
			// CustomDataのデータをViewの各Widgetにセットする
			ImageView imageView;
			imageView = (ImageView)convertView.findViewById(R.id.image);
			imageView.setImageDrawable(item.getImageData());

			TextView textView;
			textView = (TextView)convertView.findViewById(R.id.text);
			textView.setText(item.getTextData());
			return convertView;
		}
	}

///////////////////////////////////////////////////////////////////////////////
	private int menuindex = 0;
	// Creates the menu items
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//menu.clear();
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}	

	// メニューが選択されたときに実行される
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		menuindex = item.getItemId();
		
		switch(menuindex)
		{

		case R.id.menu_package:
			try{
				onCreate(savedInstanceStateOrg);
				new AlertDialog.Builder(this)
				.setTitle("パッケージ名から検索")
				.setMessage("検索語を入力してください")
				.setPositiveButton("OK",
					new OKButtonClickHandlerPackage(textView, editText))
					.setView(editText)									   // (2)
					.show();
			}
			catch(Exception e)
				{Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();}
	 		return true;
		
		
		case R.id.menu_title:
			try{
				onCreate(savedInstanceStateOrg);
				new AlertDialog.Builder(this)
				.setTitle("タイトルから検索")
				.setMessage("検索語を入力してください")
				.setPositiveButton("OK",
					new OKButtonClickHandlerTitle(textView, editText))
					.setView(editText)									   // (2)
					.show();
			}
			catch(Exception e)
				{Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();}
	 		return true;
		}

		getAppList(item.getItemId());
		return true;
	}	
	
	 /**
	 * OKボタンをクリックしたときのハンドラー
	 */
	private class OKButtonClickHandlerPackage implements OnClickListener {
		TextView textView;
		EditText editText;

		public OKButtonClickHandlerPackage(TextView textView, EditText editText) {
			this.textView = textView;
			this.editText = editText;
		}

		@Override
		public void onClick(DialogInterface dialog,
			int which) {
		   	getAppList(String.format("%s", editText.getText()),0);
		   	textView.setText(String.format("%s", editText.getText()));
		}
	}	

	 /**
	 * OKボタンをクリックしたときのハンドラー
	 */
	private class OKButtonClickHandlerTitle implements OnClickListener {
		TextView textView;
		EditText editText;

		public OKButtonClickHandlerTitle(TextView textView, EditText editText) {
			this.textView = textView;
			this.editText = editText;
		}

		@Override
		public void onClick(DialogInterface dialog,
			int which) {
		   	getAppList(String.format("%s", editText.getText()),1);
		   	textView.setText(String.format("%s", editText.getText()));
		}
	}	

/*
 * http://d.hatena.ne.jp/zakkiver24+rororossa/20110316/1300285365
 * 
	オプションメニューの内容を動的に変更する
	android
	Activityの状態などによってオプションメニューの内容を動的に変更したい場合、ActivityクラスのonPrepareOptionsMenuメソッドをオーバーライドして利用する。このメソッドは端末のmenuボタンを押下する度に呼ばれる。
	以下のような感じ。
	@Override
	public boolean onPrepareOptionsMenu (Menu menu) {
		super.onPrepareOptionsMenu(menu);

		//menu.clear();
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);


		// メニューアイテムを取得
		MenuItem menu0 = (MenuItem)menu.findItem(R.id.item0);
		MenuItem menu1 = (MenuItem)menu.findItem(R.id.item1);

		if (flag == 0) {
			// menu0を表示
			menu0.setVisible(true);
			// menu1を非表示
			menu1.setVisible(false);
		} else if (flag == 1) {
			// menu0を非表示
			menu0.setVisible(false);
			// menu1を表示
			menu1.setVisible(true);
		}
		return true;
	}
*/




}
