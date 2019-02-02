package kahata.BizCard3Test;

import android.app.Activity;
import android.os.Bundle;

/**
 * 参照アクティビティ
 */
public class ShowActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 自動生成されたR.javaの定数を指定してXMLからレイアウトを生成
		setContentView(R.layout.show);
	}
}
