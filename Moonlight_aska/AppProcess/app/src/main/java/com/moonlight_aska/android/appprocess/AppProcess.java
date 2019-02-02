// -*- mode: java -*-  Time-stamp: <2012-02-04 17:56:08 kahata>
/*================================================================
 * title: 
 * file: AppProcess.java
 * created: Time-stamp: <2012-02-04 17:56:08 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%c8%a5%c3%a5%d7%a5%da%a1%bc%a5%b8
 * description: 起動中のアプリ一覧を取得する
 * 最終更新：moonlight_aska 2011年09月26日(月) 23:27:55履歴
 * アクティビティマネージャ(ActivityManager)クラスを利用することで, 
 * 起動中のアプリケーションの一覧を取得することができる.
 * 起動中のアプリ一覧を取得
 * AppProcess.java
 * getSystemServiceメソッドで, ActivityManagerのインスタンスを取得する.
 * ActivityManager#getRunningAppProcessesメソッドで, 
 * 起動中のアプリのプロセス情報(RunningAppProcessInfo)を取得する.
 * getPackageManagerメソッドで, PackageManagerのインスタンスを取得する.
 * PackageManager#getApplicationInfoメソッドで, アプリのプロセス情報から
 * アプリ情報(ApplicationInfo)を取得する.
 * PackageManager#getApplicationLabelメソッドで, アプリ情報からアプリ名を取得し, リストに追加する.
 *================================================================*/

package com.moonlight_aska.android.appprocess;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.app.ListActivity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.ArrayAdapter; 

public class AppProcess extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayList<String> appList = new ArrayList<String>();
		ActivityManager activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
		// 起動中のアプリ情報を取得
		List<RunningAppProcessInfo> runningApp = activityManager.getRunningAppProcesses();
		PackageManager packageManager = getPackageManager();
		if(runningApp != null) {
			for(RunningAppProcessInfo app : runningApp) {
				try {
					// アプリ名をリストに追加
					ApplicationInfo appInfo = packageManager.getApplicationInfo(app.processName, 0);
					appList.add( (String)packageManager.getApplicationLabel(appInfo));
				}
				catch(NameNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		// リスト表示
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, appList);
		setListAdapter(adapter);
	}
}