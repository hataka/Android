// -*- mode: java -*-  Time-stamp: <2017-06-12 11:32:18 kahata>
/*================================================================
 * title: インストール済みアプリ一覧を取得する
 * file: SslibLauncherActivity.java
 * path: F:\GitHub\hataka\codingground\android\Launcher\SslibLauncher\app\src\main\java\kahata\SslibLauncher\SslibLauncherActivity.java
 * url:  http://192.168.1.53/f/GitHub/hataka/codingground/android/Launcher/SslibLauncher/app/src/main/java/kahata/SslibLauncher/SslibLauncherActivity.java
 * created: Time-stamp: <2012-02-04 11:48:57 kahata>
 * revised: Time-stamp: <2017-06-12 11:32:18 kahata>
 * revision: AndroidStudio移植 build.gradle生成 GitHub Upload
 * Programmed By: kahata
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%a4%a5%f3%a5%b9%a5%c8%a1%bc%a5%eb%ba%d1%a4%df%a5%a2%a5%d7%a5%ea%b0%ec%cd%f7%a4%f2%bc%e8%c6%c0%a4%b9%a4%eb
 * description: 
 * 最終更新：moonlight_aska 2011年07月30日(土) 09:09:50履歴
 * インテント(Intent)を利用することで, インストールされている通常の
 * アプリケーションの一覧を取得することができる.
 * インストール済みのアプリ一覧を取得
 * AppList.java
 * getPackageManagerメソッドで, PackageManagerのインスタンスを取得する.
 * インテントのインスタンスを生成する. このとき, Intent.ACTION_MAINを指定する.
 * Intent.CATEGORY_LAUNCHERを指定する.
 * PackageManager#queryIntentActivitiesメソッドで, アプリ情報(ResolveInfo)を取得する.
 * ResolveInfo#loadLabelメソッドで, アプリ情報からアプリ名を取得し, リストに追加する.
 *================================================================*/

package kahata.SslibLauncher;

//import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
//import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SslibLauncherActivity extends ListActivity {

	//private List<ResolveInfo> mAppList;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayList<String> appList = new ArrayList<String>();
		// アプリ情報を取得
		PackageManager packageManager = getPackageManager();
		Intent intent = new Intent(Intent.ACTION_MAIN, null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		List<ResolveInfo> appInfo = packageManager.queryIntentActivities(intent, 0);
		if(appInfo != null) {
			for(ResolveInfo app : appInfo) {

				String pkg = app.activityInfo.packageName;
				//String ac = app.activityInfo.name;
				
				//String regex = "moonlight_aska";
				String regex = "kahata\\.Sslib";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(pkg);				
				
				// アプリ名をリストに追加
				if (m.find()) appList.add( (String)app.loadLabel(packageManager));
			}
		}
		//mAppList = appInfo;
		Collections.sort(appList);
		// リスト表示
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, appList);
		setListAdapter(adapter);
	}

	// アイテムが選択されたときの処理
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String item = (String)l.getItemAtPosition(position);
		
		//String name = item.substring(0,item.indexOf(" "));
		if(item.indexOf(" ")>0) item = item.substring(0,item.indexOf(" "));
		//ResolveInfo info = mAppList.get(position);
		//String pkg = info.activityInfo.packageName;
		//String ac = info.activityInfo.name;
		
		//Log.v("ListView", item);
		// インテントのインスタンス生成
		Intent intent = new Intent();
		String pkg = "kahata." + item;
		try {	
			// パッケージ名, クラス名をセット
			intent.setClassName(pkg, pkg + "." + item+"Activity");
			//intent.setClassName(pkg , pkg + "." + ac);
		// アプリを起動
		startActivity(intent);
		} catch (Exception e) {
			// 失敗した場合の処理
			//Toast.makeText(this, android.R.string.cancel, Toast.LENGTH_LONG).show();
			Toast.makeText(this, pkg, Toast.LENGTH_LONG).show();
		}
	}
}

