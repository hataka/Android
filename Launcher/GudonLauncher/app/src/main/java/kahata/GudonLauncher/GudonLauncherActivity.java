// -*- mode: java -*-  Time-stamp: <2012-03-06 13:26:01 kahata>
/*================================================================
 * title: 愚鈍人ランチャー
 * file: GudonLauncherActivity.java
 * path: F:\android\workspace\GudonLauncher\src\kahata\GudonLauncher\GudonLauncherActivity.java
 * url:  http://localhost/android/workspace/GudonLauncher/src/kahata/GudonLauncher/GudonLauncherActivity.java
 * created: Time-stamp: <2012-03-06 13:26:01 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: https://sites.google.com/site/matsudroid/tips/tips/apuririsutowo-shutoku-suru
 * description: 愚鈍人ランチャー
 * インストール済みアプリリストを取得する
 *================================================================*/

package kahata.GudonLauncher;

import android.app.*;
import android.content.*;
import android.graphics.drawable.Drawable;
import android.content.pm.*;
import android.content.pm.PackageManager.*;
import android.content.res.Resources;
import android.content.DialogInterface.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.text.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * メイン画面
 * @author kohichi.matsuda@gmail.com
 *
 */
public class GudonLauncherActivity extends Activity implements OnItemClickListener, OnItemLongClickListener {
	
	public static String mypkgname;// = new GudonLauncherActivity().getPackageName();
	public static String myclasspath;// = new GudonLauncherActivity().getClass().getName();
	public static String myclassname;// = new GudonLauncherActivity().getClass().getSimpleName();
	
	public final static String WORKSPACE_LOCATION = "http://192.168.1.53/f/android/Gudon/";
	
	Bundle savedInstanceStateOrg;
	
	private static final int ONCREATE = 1;
	private static final int ONITEMCLICK = 2;
	//private int menuindex = 0;

	private CustomData itemData;
	private Drawable icon = null;
/*
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case ONCREATE:
				//getAppList(0);
				getAppList(R.id.menu_gudon_all);
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

		mypkgname = getPackageName();
		myclasspath = new GudonLauncherActivity().getClass().getName();
		myclassname = new GudonLauncherActivity().getClass().getSimpleName();

		editText = new EditText(this);	
		textView = (TextView) findViewById(R.id.textview);
		textView.setAutoLinkMask(Linkify.ALL);
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		mAppListView = listView;
		listView.setOnItemClickListener(this);
		listView.setOnItemLongClickListener(this);
		
		//mHandler.sendEmptyMessage(ONCREATE);
		getAppList(R.id.menu_gudon_all);
	}

	/**
	 * アプリリストを取得し、ListView に設定
	 */
	PackageManager pm;
	private void getAppList(int menuid) {
		pm = getPackageManager();
		boolean special; 
		
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
			
				switch(menuid)
			{
			//case R.id.menu_all:addAppInfo(info);break;
			case R.id.menu_launcher:
				special = pkgname.indexOf("Launcher")>-1
				|| pkgname.indexOf("kahata.PackageManager")>-1;				
				if(special)addAppInfo(info);
				break;
	 		case R.id.menu_gudon_all:
				if(pkgname.indexOf("gudon.sample")>-1) addAppInfo(info);
				break;
			case R.id.menu_gudon_dialog:
				if(pkgname.indexOf("gudon.sample.dialog")>-1) addAppInfo(info);
				break;
			case R.id.menu_gudon_fileaccess:
				if(pkgname.indexOf("gudon.sample.fileaccess")>-1) addAppInfo(info);
				break;
			case R.id.menu_gudon_graphic:
				special = pkgname.indexOf("gudon.sample.graphics")>-1
					|| pkgname.indexOf("gudon.sample.gviewevent")>-1
					|| pkgname.indexOf("gudon.sample.surfaceview")>-1;
				if(special) addAppInfo(info);
				break;
			case R.id.menu_gudon_layout:
				if(pkgname.indexOf("gudon.sample.layout")>-1) addAppInfo(info);
				break;
			case R.id.menu_gudon_listview:
				if(pkgname.indexOf("gudon.sample.listview")>-1) addAppInfo(info);
				break;
			case R.id.menu_dudon_menu:
				if(pkgname.indexOf("gudon.sample.menu")>-1) addAppInfo(info);
				break;
			case R.id.menu_gudon_spinner:
				if(pkgname.indexOf("gudon.sample.spinner")>-1) addAppInfo(info);
				break;
			case R.id.menu_gudon_sqlite:
				if(pkgname.indexOf("gudon.sample.sqlite")>-1) addAppInfo(info);
				break;
			case R.id.menu_gudon_tablelayout:
				if(pkgname.indexOf("gudon.sample.table_layout")>-1) addAppInfo(info);
				break;
			case R.id.menu_gudon_toast:
				if(pkgname.indexOf("gudon.sample.toast")>-1) addAppInfo(info);
				break;
			case R.id.menu_gudon_misc:
	 			special = pkgname.indexOf("gudon.sample.graphics")>-1
					|| pkgname.indexOf("gudon.sample.gviewevent")>-1
					|| pkgname.indexOf("gudon.sample.surfaceview")>-1
						|| pkgname.indexOf("gudon.sample.dialog")>-1
						|| pkgname.indexOf("gudon.sample.fileaccess")>-1
						|| pkgname.indexOf("gudon.sample.layout")>-1
						|| pkgname.indexOf("gudon.sample.listview")>-1
						|| pkgname.indexOf("gudon.sample.menu")>-1
						|| pkgname.indexOf("gudon.sample.spinner")>-1
						|| pkgname.indexOf("gudon.sample.sqlite")>-1
						|| pkgname.indexOf("gudon.sample.table_layout")>-1
						|| pkgname.indexOf("gudon.sample.toast")>-1;
				if(pkgname.indexOf("gudon.sample")>-1 && !special) addAppInfo(info);
				break;
			case R.id.menu_kahata:
				if(pkgname.indexOf("kahata.")>-1)addAppInfo(info);
				break;
			case R.id.menu_test:if(pkgname.indexOf("Test")>-1)addAppInfo(info);break;
			/*
			case R.id.menu_moonlight:if(pkgname.indexOf("moonlight")>-1)addAppInfo(info);break;
			case R.id.menu_gudon:if(pkgname.indexOf("gudon")>-1)addAppInfo(info);break;
			case R.id.menu_reverse:if(pkgname.indexOf("com.example")>-1)addAppInfo(info);break;
			case R.id.menu_ya:if(pkgname.indexOf("ya.")>-1)addAppInfo(info);break;
			case R.id.menu_techbooster:if(pkgname.indexOf("techbooster")>-1)addAppInfo(info);break;
			*/
			case R.id.menu_android:if(pkgname.indexOf("com.android")>-1)addAppInfo(info);break;
			
			case R.id.menu_google:if(pkgname.indexOf("com.google")>-1)addAppInfo(info);break;
			case R.id.menu_asus:if(pkgname.indexOf("com.asus")>-1)addAppInfo(info);break;
			case R.id.menu_nocategory:
				special = pkgname.indexOf("kahata.")>-1
					|| pkgname.indexOf("moonlight")>-1
					|| pkgname.indexOf("gudon")>-1
					|| pkgname.indexOf("com.example")>-1
					|| pkgname.indexOf("ya.")>-1
					|| pkgname.indexOf("techbooster")>-1
					|| pkgname.indexOf("com.android")>-1
					|| pkgname.indexOf("com.google")>-1
					|| pkgname.indexOf("com.asus")>-1;
					if (!special) addAppInfo(info);
				break;
			default: addAppInfo(info);break; //onCreate(savedInstanceStateOrg);break;//;
			}
		}
		CustomAdapter customAdapater = new CustomAdapter(this, 0, myAppInfo);
		// ListView に ArrayAdapter を設定
		mAppListView.setAdapter(customAdapater);
		Collections.sort(myAppInfo, new AppInfoComparator());
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
	

	class AppInfoComparator implements java.util.Comparator {
		public int compare(Object s, Object t) {
			return ((CustomData)s).getTextData().compareTo(((CustomData)t).getTextData());
		}
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
		final CharSequence[] items = {"Launch","ブラウザを起動" ,"Backup","UnInstall",
				"Information","マーケット検索","Google検索"}; //, "画面遷移"};
		try {
			info = myAppInfo.get(position).getResolveInfo();
			uri=Uri.fromParts("package",info.activityInfo.packageName,null);
			
			new AlertDialog.Builder(GudonLauncherActivity.this)
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
					case 5: action = 5; break;
					case 6: action = 6; break;
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
						final CharSequence[] items = {"AndroidManifest.xml","MainActivity.java",
								"layout/main.xml", "プロジェクト フォルダ"};

						new AlertDialog.Builder(GudonLauncherActivity.this)
						.setTitle(info.activityInfo.loadLabel(pm).toString())
						.setItems(items, new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int item) {
								Toast.makeText(GudonLauncherActivity.this, 
									String.format("%sが選択されました。",items[item]), Toast.LENGTH_LONG).show();
								String url="";
								switch(item)
								{
								case 0:
									url = makeAndroidManifestLocalpath(info.activityInfo.packageName,
											info.activityInfo.name);
									break;
								case 1:
									url = makeActivityLocalpath(info.activityInfo.packageName,
											info.activityInfo.name);
									break;
								case 2:
									url = makeLayoutMainLocalpath(info.activityInfo.packageName,
											info.activityInfo.name);
									break;
								case 3:
									url = makeProjectFolderLocalpath(info.activityInfo.packageName,
											info.activityInfo.name);
									break;
								}
								Uri uri = Uri.parse(url);
								intent = new Intent(Intent.ACTION_VIEW,uri);
								startActivity(intent);
							}

						})
						.show();
						break;
					case 2:
						new AlertDialog.Builder(GudonLauncherActivity.this)
						.setTitle("バックアップ")
						.setMessage("パッケージをバックアップします. よろしいですか?\nバックアップ先: /Removable/MicroSD/backups/")
						.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					  public void onClick(DialogInterface dialog, int id) {
					  	if(backupPackage(info.activityInfo.packageName) == true){
								Toast.makeText(GudonLauncherActivity.this,
										"バックアップに成功しました.", Toast.LENGTH_LONG).show();
					  		}
					  		dialog.cancel();
				  		}
						})
						.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					  public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
					  	}
						})
						.show();
						break;
					case 3:
						intent = new Intent(Intent.ACTION_DELETE, uri);	
						startActivity(intent);
						action = 0;
						getAppList(R.id.menu_all);
						//getAppList(0);
						break;
		
					case 4:	
						new AlertDialog.Builder(GudonLauncherActivity.this)
								.setTitle("Package Information")
								.setMessage(getPackageInfo(info))
								.setNegativeButton("OK", new DialogInterface.OnClickListener() {
							  public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
							  	}
								})
								.show();
						break;
					case 5:	
						intent = new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri.parse("market://search?q=pname:" 
								+info.activityInfo.packageName));
						startActivity(intent);
						break;
					case 6:
						uri = Uri.parse("http://www.google.co.jp/search?q="
								+ info.activityInfo.packageName);
						intent = new Intent(Intent.ACTION_VIEW,uri);
						startActivity(intent);
						break;
					
					//case 7:
						/**
						 * 別のアプリのfiles/ディレクトリ permission denied !! アクセス不可!!
						 */
						/*
						//http://www.adamrocker.com/blog/196/android_file_io.html
						// rawデレクトリのファイルを読み込みTextViewに表示するコード
						try {
							// openFileInputメソッドの例
							// ファイルを読込みTextViewに表示する
							//File srcFile = new File("/data/data/gudon.sample.fileaccess01/files/xxx.txt");
							//File dstFile = new File(dstFilePath);
							
							//FileInputStream inputStream = new FileInputStream(srcFile);
							
							//http://dokumaru.wordpress.com/2011/08/21/android-access-local-file-from-other-app/
							//inputStream = gudon.sample.fileaccess01.FileAccess01Activity.getApplicationContext().openFileOutput("hoge.bin", Context.MODE_WORLD_READABLE);
							//fos.close();
							
							//BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
							//String line;
							//StringBuilder lines = new StringBuilder();
							//while ((line = reader.readLine()) != null) {
							//	lines.append(line).append('\n');
							//}
							//reader.close();

							//tv.setText(lines);									
							//Intent intent=new Intent();
							//intent.putExtra("keyword", lines.toString());
							//intent.setClassName("kahata.GudonLauncher", "kahata.GudonLauncher.SubActivity");
							// 次画面のアクティビティ起動
						} catch (Exception e) {
						//Toast.makeText(getApplicationContext(),
						//"ファイルの読込みに失敗しました。\n" + e.getMessage(),
						//Toast.LENGTH_LONG).show();
							CommonLibrary.showDialog(GudonLauncherActivity.this,"エラー","ファイルの読込みに失敗しました。\n" + e.getMessage());
						}
				*/
					//	break;
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

	public boolean backupPackage(String pkgName)
	{
		String result ="";
		String[] pkgs;
		String cmd = "/system/bin/ls /data/app/" + pkgName + "-*.apk\n"; 
		DoSuCommand su = new DoSuCommand();
		if(su.init() == true){
			if(su.write(cmd) == true) result = su.read(); //OK /data/app/gudon.sample.graphics02-1.apk
			pkgs = result.split("\n");		
			if(pkgs.length ==1){
				try {
					FileInputStream input=new FileInputStream(pkgs[0]);
				  FileOutputStream output=new FileOutputStream("/Removable/MicroSD/backups/"
				  	+ pkgs[0].replace("/data/app/",""));
				  byte buf[]=new byte[256];
				  int len;
				  while((len=input.read(buf))!=-1){
					   output.write(buf,0,len);
				  }
					  output.flush();
					  output.close();
					  input.close();
						su.deinit();
						su = null;
					  //CommonLibrary.showDialog(GudonLauncherActivity.this,"success",
						//		"/Removable/MicroSD/" + pkgs[0].replace("/data/app/",""));
						return true;
				}catch(Exception e){
					CommonLibrary.showDialog(GudonLauncherActivity.this,"error",e.toString());
					return false;
				}
			}
		}
		return false;
	}

	public String makeActivityLocalpath(String pkgName, String className)
	{
		String url = "";
		String projectName = className
			.replace(info.activityInfo.packageName + ".","").replace("Activity","");
		url = WORKSPACE_LOCATION + projectName
		 + "/src/" + className.replace(".", "/") + ".java";		
		return url;
	}

	public String makeLayoutMainLocalpath(String pkgName, String className)
	{
		String url = "";
		String projectName = className
			.replace(info.activityInfo.packageName + ".","").replace("Activity","");
		url = WORKSPACE_LOCATION + projectName + "/res/layout/main.xml";		
		return url;
	}

	public String makeAndroidManifestLocalpath(String pkgName, String className)
	{
		String url = "";
		String projectName = className
			.replace(info.activityInfo.packageName + ".","").replace("Activity","");
		url = WORKSPACE_LOCATION + projectName + "/AndroidManifest.xml";		
		return url;
	}
	
	public String makeProjectFolderLocalpath(String pkgName, String className)
	{
		String url = "";
		String projectName = className
			.replace(info.activityInfo.packageName + ".","").replace("Activity","");
		url = WORKSPACE_LOCATION + projectName + "/";		
		return url;
	}

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
	/**
	 * 自分のアプリをroot権限でコマンドを実行する方法
	 * http://relog.xii.jp/archives/2011/02/root.html
	 */
	float getPackageSize(String pkgName)
	{
		String result ="";
		String[] pkgs;
		String cmd = "/system/bin/ls /data/app/" + pkgName + "-*.apk\n"; 
		float filesize=0;
		DoSuCommand su = new DoSuCommand();
		if(su.init() == true){
			if(su.write(cmd) == true) result = su.read();
				su.deinit();
		}
			su = null;
			pkgs = result.split("\n");		
		if(pkgs.length ==1){
			File file = new File(pkgs[0]);
			filesize = file.length();
		}
		return filesize;
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

		if(getPackageSize(info.activityInfo.packageName) >0)
		{
			message += "\n" + String.format("ファイルサイズ: %10.1f KB",
					getPackageSize(info.activityInfo.packageName)/1000);
		}
		
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

			String message ="";
			//SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			ResolveInfo info = item.getResolveInfo();
			
			PackageInfo packageInfo = new PackageInfo(); //null;
			try {
				packageInfo = getPackageManager().getPackageInfo(info.activityInfo.packageName, 
						PackageManager.GET_META_DATA);
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
			Date dateFirstInstallTime = new Date(packageInfo.firstInstallTime);
			Date dateLastUpdateTime = new Date(packageInfo.lastUpdateTime);

			message += formatter.format(dateFirstInstallTime) + " \n";
			message += formatter.format(dateLastUpdateTime) + " ";
			
			TextView infoView;
			infoView = (TextView)convertView.findViewById(R.id.info);
			infoView.setText(message);
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
		Intent intent=new Intent();		
		Uri uri = null;
		switch(menuindex)
		{
		case R.id.menu_subactivity:
			//intent.putExtra("keyword", result);
			intent.setClassName(mypkgname, mypkgname + ".SubActivity");			
			startActivity(intent);
			return true;
		case R.id.menu_frame:
			uri = Uri.parse(WORKSPACE_LOCATION + "frame.php");
			intent = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(intent);
			return true;
		case R.id.menu_website:
			uri = Uri.parse("http://ichitcltk.hustle.ne.jp/gudon/");
			intent = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(intent);
			return true;
		case R.id.menu_workspace:
			uri = Uri.parse(WORKSPACE_LOCATION);
			intent = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(intent);
			return true;
		case R.id.menu_pukiwiki2012:
			uri = Uri.parse("http://192.168.24.92/pukiwiki2012/?Android%E9%96%8B%E7%99%BA%2F%E6%84%9A%E9%88%8D%E4%BA%BA#te090acb");
			intent = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(intent);
			return true;
		case R.id.menu_package:
			try{
				onCreate(savedInstanceStateOrg);
				new AlertDialog.Builder(this)
				.setTitle("パッケージ名から検索")
				.setMessage("検索語を入力してください")
				.setPositiveButton("OK",
					new OKButtonClickHandlerPackage(textView, editText))
					.setView(editText)										// (2)
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
					.setView(editText)										// (2)
					.show();
			}
			catch(Exception e)
				{Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();}
	 		return true;
		}

		getAppList(item.getItemId());

		//sortmyAppInfo();

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



