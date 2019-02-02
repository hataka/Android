// -*- mode: java -*-  Time-stamp: <2012-02-04 11:48:57 kahata>
/*================================================================
 * title: 
 * file: AppList.java
 * created: Time-stamp: <2012-02-04 11:48:57 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%a4%a5%f3%a5%b9%a5%c8%a1%bc%a5%eb%ba%d1%a4%df%a5%a2%a5%d7%a5%ea%b0%ec%cd%f7%a4%f2%bc%e8%c6%c0%a4%b9%a4%eb
 * description: インストール済みアプリ一覧を取得する
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

package com.moonlight_aska.android.applist;

import java.util.ArrayList;
import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
import android.widget.ArrayAdapter;
//import android.widget.ListView;

public class AppList extends ListActivity {
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

				//String regex = "Sslib2";
				//Pattern p = Pattern.compile(regex);
				//Matcher m = p.matcher((String)app.loadLabel(packageManager));				
				
				// アプリ名をリストに追加
				appList.add( (String)app.loadLabel(packageManager));
				//if (m.find()) appList.add( (String)app.loadLabel(packageManager));
			}
		}
		// リスト表示
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, appList);
		setListAdapter(adapter);
		// setOnItemClickListernerでクリック時のイベントクラス呼び出し
        //setOnItemClickListener(new ClickEvent());
	}

/*	
	// アイテムが選択されたときの処理
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String item = (String)l.getItemAtPosition(position);
		Log.v("ListView", item);
	
		// TODO Auto-generated method stub
		// インテントのインスタンス生成
		Intent intent = new Intent();
		// パッケージ名, クラス名をセット
		// パッケージ名, クラス名をセット
		//intent.setClassName("kahata.Sslib211", "kahata.Sslib211.Sslib211Activity");
		intent.setClassName("kahata."+ item , "kahata."+item + "."+ item + "Activity");
		// アプリを起動
		startActivity(intent);
	
	}
*/

}
/*
	// イベントクラスの定義
    class ClickEvent implements OnItemClickListener {
        // onItemClickメソッドには、AdapterView(adapter)、選択した項目View(TextView)、選択された位置のint値、IDを示すlong値が渡される
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
    		AlertDialog.Builder diag = new AlertDialog.Builder(TestApp.this);// ダイアログの表示内容
            diag.setTitle("Select Value");
            TextView textview = (TextView)view;
            diag.setMessage(textview.getText());
            
            // ダイアログに表示するボタンの定義
            DialogInterface.OnClickListener listner = new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                    setResult(RESULT_OK);
                }
            };
    	    
            // ダイアログに表示するボタンの設定(第一引数はラベル、第二引数は設定するリスナー)
            diag.setPositiveButton("OK",listner);
            // ダイアログの作成、表示
            diag.create();
            diag.show();            
    	}

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
    	
    }
*/





/*
String str = "Document created by 20090801";
String regex = "2000[5678]";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(str);

if (m.find()){
  System.out.println("マッチしました");
}else{
  System.out.println("マッチしません");
}
*/