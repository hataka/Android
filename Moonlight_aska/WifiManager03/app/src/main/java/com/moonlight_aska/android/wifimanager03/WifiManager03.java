package com.moonlight_aska.android.wifimanager03;

import java.util.List;
import android.app.ListActivity;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class WifiManager03 extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		WifiManager manager = (WifiManager)getSystemService(WIFI_SERVICE);
		// WiFi設定の一覧を取得
		List<WifiConfiguration> cfgList = manager.getConfiguredNetworks();
		if(cfgList != null) {
			String[] nets = new String[cfgList.size()];
			for(int i=0; i<cfgList.size(); i++) {
				nets[i] = String.format("Network ID:%4d\nSSID:%s", 
						cfgList.get(i).networkId, cfgList.get(i).SSID);
			}
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nets);
			setListAdapter(adapter);
		}
	}
}