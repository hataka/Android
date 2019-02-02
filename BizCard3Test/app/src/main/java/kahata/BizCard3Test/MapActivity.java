package kahata.BizCard3Test;

import android.os.Bundle;

/**
 * 地図表示アクティビティ
 * MapViewを扱うアクティビティはcom.google.android.maps.MapActivityを継承する必要がある
 */
public class MapActivity extends com.google.android.maps.MapActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 自動生成されたR.javaの定数を指定してXMLからレイアウトを生成
		setContentView(R.layout.map);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}