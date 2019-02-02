// -*- mode: java -*-  Time-stamp: <2012-02-04 18:16:07 kahata>
/*================================================================
 * title: 
 * file: Services01.java
 * created: Time-stamp: <2012-02-04 18:16:07 kahata>
 * link: 
 * description: 起動中のサービス一覧を取得する
 * 最終更新：moonlight_aska 2011年09月26日(月) 23:30:19履歴
 * アクティビティマネージャ(ActivityManager)クラスを利用することで, 
 * 起動中のサービスの一覧を取得することができる.
 * 起動中のサービス一覧を取得
 * Services01.java
 * getSystemServiceメソッドで, ActivityManagerのインスタンスを取得する.
 * ActivityManager#getRunningServicesメソッドで, 起動中のサービス情報(RunningServiceInfo)を取得する.
 * RunningServiceInfo.service#getShortClassName, getClassNameメソッド等で, クラス情報を取得し, リストに追加する.
 *================================================================*/

package com.moonlight_aska.android.services01;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.app.ListActivity;
import android.app.ActivityManager.RunningServiceInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Services01 extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayList<String> serviceList = new ArrayList<String>();
		ActivityManager activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
		// 起動中のサービス情報を取得
		List<RunningServiceInfo> runningService = activityManager.getRunningServices(100);
		if(runningService != null) {
			for(RunningServiceInfo srvInfo : runningService) {
				serviceList.add(srvInfo.service.getShortClassName());
			}
		}
		// リスト表示
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, serviceList);
		setListAdapter(adapter);
	}
}