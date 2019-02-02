// -*- mode: java -*-  Time-stamp: <2012-02-02 17:58:59 kahata>
/*================================================================
 * title: リストアクティビティを作成する
 * file: List01.java
 * created: Time-stamp: <2012-02-02 17:58:59 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%ea%a5%b9%a5%c8%a5%a2%a5%af%a5%c6%a5%a3%a5%d3%a5%c6%a5%a3%a4%f2%ba%ee%c0%ae%a4%b9%a4%eb
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%c8%a5%c3%a5%d7%a5%da%a1%bc%a5%b8
 * description: リストアクティビティを作成する
 *================================================================*/

package com.moonlight_aska.android.list01;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List01 extends ListActivity {
	private static final int ITEM_NUM = 5;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// アイテムのリスト
		String[] items = new String[ITEM_NUM];
		for(int i=0; i<ITEM_NUM; i++) {
			items[i] = new String("Item" + (i+1));
		}
		// アダプタを作成
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
			android.R.layout.simple_list_item_1, items);
		// アダプタを設定
		setListAdapter(adapter);
	}

	// アイテムが選択されたときの処理
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String item = (String)l.getItemAtPosition(position);
		Log.v("ListView", item);
	}
}
