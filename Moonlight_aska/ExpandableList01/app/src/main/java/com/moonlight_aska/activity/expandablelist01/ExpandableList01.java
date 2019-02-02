// -*- mode: java -*-  Time-stamp: <2012-02-02 18:08:09 kahata>
/*================================================================
 * title: 
 * file: ExpandableList01.java
 * created: Time-stamp: <2012-02-02 18:08:09 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: 
 * description: 
 *================================================================*/

package com.moonlight_aska.activity.expandablelist01;
//      com.moonlight_aska.activity
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class ExpandableList01 extends ExpandableListActivity{
	private static final int ITEM_NUM = 3;
	private static final int SUBITEM_NUM = 4;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// アイテムのリスト
		List<Map<String, String>> itemList = new ArrayList<Map<String, String>>();
		for(int i=0; i<ITEM_NUM; i++) {
			Map<String, String> item = new HashMap<String, String>();
			item.put("ITEM", "Item " + (i+1));
			itemList.add(item);
		}
		// 各アイテムのサブアイテムのリスト
		List<List<Map<String, String>>> allSubItemList = new ArrayList<List<Map<String, String>>>();
		// サブアイテム, 詳細のリスト
		for(int i=0; i<ITEM_NUM; i++) {
			List<Map<String, String>> subItemList = new ArrayList<Map<String, String>>();
			for(int j=0; j<SUBITEM_NUM; j++) {
				Map<String, String> subItem = new HashMap<String, String>();
				subItem.put("SUBITEM", "SubItem " + (i+1) + "-" + (j+1));
				subItem.put("DETAIL", "Detail " + (i+1) + "-" + (j+1));
				subItemList.add(subItem);
			}
			allSubItemList.add(subItemList);
		}

		// アダプタを作成
		SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this, 
				itemList,
				android.R.layout.simple_expandable_list_item_1,new String[] {"ITEM"},
				new int[]{android.R.id.text1},
				allSubItemList,
				android.R.layout.simple_expandable_list_item_2, new String[]{"SUBITEM", "DETAIL"},
				new int[]{android.R.id.text1, android.R.id.text2} 
			);
		// アダプタを設定
		setListAdapter(adapter);
	}

	// サブアイテムが選択されたときの処理
	@SuppressWarnings("unchecked")
	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		// TODO Auto-generated method stub
		// アダプタを取得
		ExpandableListAdapter adapter = parent.getExpandableListAdapter();
		// アダプタから選択されたサブアイテムのデータを取得
		Map<String, String> child = (Map<String, String>)adapter.getChild(groupPosition, childPosition);
		Map<String, String> subItem = child;
		Log.v("ExpListView", subItem.get("SUBITEM") + " / " + subItem.get("DETAIL"));
		return super.onChildClick(parent, v, groupPosition, childPosition, id);
	}
}
