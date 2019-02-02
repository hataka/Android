package info.caldia.matsudroid.sample.applist;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * メイン画面
 * @author kohichi.matsuda@gmail.com
 *
 */
public class MainActivity extends Activity implements OnItemClickListener {
	
	private static final int ONCREATE = 1;
	private static final int ONITEMCLICK = 2;
	/*	
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case ONCREATE:
				getAppList();
				break;
			case ONITEMCLICK:
				startActivitySafe(msg.arg1);
				break;
			default:
				break;
			}
		};
	};
	*/
	private ListView mAppListView;
	private List<ResolveInfo> mAppList;
	
    /** Called when the activity is first created. */
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(R.id.include_AppList);
        mAppListView = listView;
        listView.setOnItemClickListener(this);
        //mHandler.sendEmptyMessage(ONCREATE);
        getAppList();
    }
    
    /**
     * アプリリストを取得し、ListView に設定
     */
    private void getAppList() {
    	
    	// ListView に設定する ArrayAdapter を作成
        ArrayAdapter<String> adapter = 
        	new ArrayAdapter<String>(
        			this, android.R.layout.simple_list_item_1);
        
        // アプリ一覧を取得する
        PackageManager pm = getPackageManager();
        // 検索条件
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        // 検索
        List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
        
        // ArrayAdapter にアプリ名を追加
        for (ResolveInfo info : list) {
			adapter.add(info.activityInfo.loadLabel(pm).toString());
		}

        // ListView に ArrayAdapter を設定
        mAppListView.setAdapter(adapter);
        
        mAppList = list;

    }

    /**
     * ListView のアイテムをクリック
     */
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		//Message msg = mHandler.obtainMessage(ONITEMCLICK, position, 0);
		//mHandler.sendMessage(msg);
		startActivitySafe(position);
	}
	
	/**
	 * クリックされたアイテムに対応するアプリを起動
	 * @param position
	 */
	private void startActivitySafe(int position) {

		try {
			ResolveInfo info = mAppList.get(position);
			
			String pkg = info.activityInfo.packageName;
			String ac = info.activityInfo.name;
			
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			intent.setClassName(pkg, ac);
			
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			startActivity(intent);
			finish();
		} catch (Exception e) {
			// 失敗した場合の処理
			Toast.makeText(this, android.R.string.cancel, Toast.LENGTH_LONG).show();
		}
		
	}
}