package com.moonlight_aska.android.wifimanager04;

import android.app.ListActivity;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class WifiManager04 extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		WifiManager manager = (WifiManager)getSystemService(WIFI_SERVICE);
		WifiInfo info = manager.getConnectionInfo();
		String[] apInfo = new String[4];
		//　SSIDを取得
		apInfo[0] = String.format("SSID : %s", info.getSSID());
		// IPアドレスを取得
		int ipAdr = info.getIpAddress();
		apInfo[1] = String.format("IP Adrress : %02d.%02d.%02d.%02d", 
				(ipAdr>>0)&0xff, (ipAdr>>8)&0xff, (ipAdr>>16)&0xff, (ipAdr>>24)&0xff);
		// MACアドレスを取得
		apInfo[2] = String.format("MAC Address : %s", info.getMacAddress());
		// 受信信号強度&信号レベルを取得
		int rssi = info.getRssi();
		int level = WifiManager.calculateSignalLevel(rssi, 5);
		apInfo[3] = String.format("RSSI : %d / Level : %d/4", rssi, level);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, apInfo);
		setListAdapter(adapter);
	}
}