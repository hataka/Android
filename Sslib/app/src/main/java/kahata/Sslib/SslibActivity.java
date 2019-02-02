package kahata.Sslib;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

public class SslibActivity extends Activity {
    /** Called when the activity is first created. */
	LinearLayout llInside;
	LinearLayout llOutside;
	int width;
	int height;;	 
	TextView tv1;
	TextView tv2;
	Sslib211 p = new Sslib211();
	String result = p.output();
	int toggle=0;
	float fontsize = 24.0f;
	int selectedfont = 4;
	Bundle savedInstanceState1;
	
	String[] mStrings;
	ArrayAdapter<String> adapter;	

	private String curFile="Sslib211.java";
	private final String GIT_SITE = "https://github.com/hataka/codingground/tree/master/android/Sslib";
	
	@Override
 	public void onCreate(Bundle savedInstanceState) {
		savedInstanceState1 = savedInstanceState;
		super.onCreate(savedInstanceState);

		//setContentView(R.layout.main);

/*
		final Spinner sslib1spinner = (Spinner) findViewById(R.id.spinner01);
		/ *
		 * Android, arrays.xml で定義した配列を利用する
		 * http://www.serendip.ws/archives/4925
		 * /
		mStrings = getResources().getStringArray(R.array.sslib1);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mStrings);
		sslib1spinner.setAdapter(adapter);
		sslib1spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent,
					View view, int position, long id) {
				switch(position)
				{
				case 0:tv1.setText(new Sslib211().output());break;
				case 1:tv1.setText(new Sslib212().output());break;
				case 2:tv1.setText(new Sslib213().output());break;
				case 3:tv1.setText(new Sslib214().output());break;
				case 4:tv1.setText(new Sslib215().output());break;
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Toast.makeText(SslibActivity.this,
						"onNothingSelected", Toast.LENGTH_SHORT).show();
			}
		});

  		final Spinner sslib2spinner = (Spinner) findViewById(R.id.spinner02);
		/ *
		 * Android, arrays.xml で定義した配列を利用する
		 * http://www.serendip.ws/archives/4925
		 * /
		mStrings = getResources().getStringArray(R.array.sslib2);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mStrings);
		sslib2spinner.setAdapter(adapter);
		sslib2spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent,
					View view, int position, long id) {
				switch(position)
				{
				case 0:tv1.setText(new Sslib221().output());break;
				case 1:tv1.setText(new Sslib222().output());break;
				case 2:tv1.setText(new Sslib223().output());break;
				case 3:tv1.setText(new Sslib224().output());break;
				case 4:tv1.setText(new Sslib225().output());break;
				case 5:tv1.setText(new Sslib226().output());break;
				case 6:tv1.setText(new Sslib227().output());break;
				case 7:tv1.setText(new Sslib228().output());break;
				case 8:tv1.setText(new Sslib229().output());break;
				case 9:tv1.setText(new Sslib22a().output());break;
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Toast.makeText(SslibActivity.this,
						"onNothingSelected", Toast.LENGTH_SHORT).show();
			}
		});
		
 		

   		final Spinner sslib3spinner = (Spinner) findViewById(R.id.spinner03);
		/　*
		 * Android, arrays.xml で定義した配列を利用する
		 * http://www.serendip.ws/archives/4925
		 *　/
		mStrings = getResources().getStringArray(R.array.sslib3);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mStrings);
		sslib3spinner.setAdapter(adapter);
		sslib3spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent,
					View view, int position, long id) {
				switch(position)
				{
				case 0:tv1.setText(new Sslib231().output());break;
				case 1:tv1.setText(new Sslib232().output());break;
				case 2:tv1.setText(new Sslib233().output());break;
				case 3:tv1.setText(new Sslib234().output());break;
				case 4:tv1.setText(new Sslib235().output());break;
				case 5:tv1.setText(new Sslib236().output());break;
				case 6:tv1.setText(new Sslib237().output());break;
				case 7:tv1.setText(new Sslib238().output());break;
				case 8:tv1.setText(new Sslib239().output());break;
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Toast.makeText(SslibActivity.this,
						"onNothingSelected", Toast.LENGTH_SHORT).show();
			}
		});
*/
		LinearLayout parent = (LinearLayout) findViewById(R.id.parent);
		WindowManager windowmanager = (WindowManager)getSystemService(WINDOW_SERVICE);
		Display disp = windowmanager.getDefaultDisplay();
		width = disp.getWidth()*2;
		height = disp.getHeight()*2;	 
		
		llOutside = new LinearLayout(this);
		llOutside.setOrientation(LinearLayout.VERTICAL);
		llOutside.setGravity(Gravity.CENTER_HORIZONTAL);

		Resources resources = getResources();
		Configuration config = resources.getConfiguration();

		llInside = new LinearLayout(this);
		llInside.setOrientation(LinearLayout.VERTICAL);
		llInside.setGravity(Gravity.CENTER_HORIZONTAL);
 
		Button btn = new Button(this);
		btn.setText("画面遷移");
		btn.setVisibility(0);
		
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				// OK
				//Intent intent = new Intent(Sslib211Activity.this, SubActivity.class);
				// 次画面のアクティビティ起動
				//startActivity(intent);
		        Intent intent=new Intent();
		        intent.putExtra("keyword", "Sslib211に戻る");
				intent.setClassName("kahata.Sslib", "kahata.Sslib.SubActivity");
				startActivity(intent);
			}
		});
		llOutside.addView(btn);
		
		HorizontalScrollView hsv = new HorizontalScrollView(this);
		ScrollView sv = new ScrollView(this);
		
		switch(config.orientation) {
			case Configuration.ORIENTATION_PORTRAIT:
				//str = "縦方向";
				//str = "横方向";
				hsv.setLayoutParams(new LinearLayout.LayoutParams(
						ViewGroup.LayoutParams.FILL_PARENT,
						ViewGroup.LayoutParams.WRAP_CONTENT));
				llOutside.addView(hsv);
				hsv.addView(llInside);
				break;
			case Configuration.ORIENTATION_LANDSCAPE:
				//str = "横方向";
				sv.setLayoutParams(new LinearLayout.LayoutParams(
						ViewGroup.LayoutParams.FILL_PARENT,
						ViewGroup.LayoutParams.WRAP_CONTENT));
				llOutside.addView(sv);
				sv.addView(llInside);
				break;
			default :
				//str = "デフォルト";
				sv.setLayoutParams(new LinearLayout.LayoutParams(
					ViewGroup.LayoutParams.FILL_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT));
				llOutside.addView(sv);
				sv.addView(llInside);
			}		
 
		tv1 = new TextView(this);
		tv1.setHeight(height);
		tv1.setWidth(width);
		tv1.setBackgroundColor(Color.BLUE);
		tv1.setBackgroundColor(Color.rgb(0, 0, 64));
		//tv1.setTextSize(fontsize24.0f);
		tv1.setTextSize(fontsize);
	    tv1.setTypeface(Typeface.MONOSPACE);
		tv1.setTextColor(Color.rgb(0, 255, 255));
		tv1.setText(result);
		llInside.addView(tv1);

		tv2 = new TextView(this);
		tv2.setHeight(width);
		tv2.setWidth(height);
		tv2.setBackgroundColor(Color.BLUE);
		tv2.setBackgroundColor(Color.rgb(0, 0, 64));
		tv2.setTextSize(24.0f);
	    tv2.setTypeface(Typeface.MONOSPACE);
		tv2.setTextColor(Color.rgb(0, 255, 255));
		tv2.setText("こんにちわ");
		
		//parent.addView(llOutside);
		setContentView(llOutside);        
    }

    // メニューボタンが押されたときに実行される
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "ソースをブラウザで表示");
		menu.add(Menu.NONE, 2, Menu.NONE, "結果を表示");
		menu.add(Menu.NONE, 1, Menu.NONE, "View切り替え");
		menu.add(Menu.NONE, 3, Menu.NONE, "テキストトグル");
		menu.add(Menu.NONE, 4, Menu.NONE, "画面遷移");
		menu.add(Menu.NONE, 5, Menu.NONE, "フォントサイズ");
		return super.onCreateOptionsMenu(menu);
	}
	*/
	private int menuindex = 0;
    // Creates the menu items
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	//menu.clear();
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu_sslib, menu);
        return true;
    }
	
	// メニューが選択されたときに実行される
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		menuindex = item.getItemId();		
		// 選択されたIDを確認
		switch (item.getItemId()) {
		case R.id.menu_sslib211:curFile="Sslib211.java";tv1.setText(new Sslib211().output());break;
		case R.id.menu_sslib212:curFile="Sslib212.java";tv1.setText(new Sslib212().output());break;
		case R.id.menu_sslib213:curFile="Sslib213.java";tv1.setText(new Sslib213().output());break;
		case R.id.menu_sslib214:curFile="Sslib214.java";tv1.setText(new Sslib214().output());break;
		case R.id.menu_sslib215:curFile="Sslib215.java";tv1.setText(new Sslib215().output());break;
			
		case R.id.menu_sslib221:curFile="Sslib221.java";tv1.setText(new Sslib221().output());break;
		case R.id.menu_sslib222:curFile="Sslib222.java";tv1.setText(new Sslib222().output());break;
		case R.id.menu_sslib223:curFile="Sslib223.java";tv1.setText(new Sslib223().output());break;
		case R.id.menu_sslib224:curFile="Sslib224.java";tv1.setText(new Sslib224().output());break;
		case R.id.menu_sslib225:curFile="Sslib225.java";tv1.setText(new Sslib225().output());break;
		case R.id.menu_sslib226:curFile="Sslib226.java";tv1.setText(new Sslib226().output());break;
		case R.id.menu_sslib227:curFile="Sslib227.java";tv1.setText(new Sslib227().output());break;
		case R.id.menu_sslib228:curFile="Sslib228.java";tv1.setText(new Sslib228().output());break;
		case R.id.menu_sslib229:curFile="Sslib229.java";tv1.setText(new Sslib229().output());break;
		case R.id.menu_sslib22a:curFile="Sslib22a.java";tv1.setText(new Sslib22a().output());break;		
		
		case R.id.menu_sslib231:curFile="Sslib231.java";tv1.setText(new Sslib231().output());break;
		case R.id.menu_sslib232:curFile="Sslib232.java";tv1.setText(new Sslib232().output());break;
		case R.id.menu_sslib233:curFile="Sslib233.java";tv1.setText(new Sslib233().output());break;
		case R.id.menu_sslib234:curFile="Sslib234.java";tv1.setText(new Sslib234().output());break;
		case R.id.menu_sslib235:curFile="Sslib235.java";tv1.setText(new Sslib235().output());break;
		case R.id.menu_sslib236:curFile="Sslib236.java";tv1.setText(new Sslib236().output());break;
		case R.id.menu_sslib237:curFile="Sslib237.java";tv1.setText(new Sslib237().output());break;
		case R.id.menu_sslib238:curFile="Sslib238.java";tv1.setText(new Sslib238().output());break;
		case R.id.menu_sslib239:curFile="Sslib239.java";tv1.setText(new Sslib239().output());break;

		case R.id.menu_sslib241:curFile="Sslib241.java";tv1.setText(new Sslib241().output());break;
		case R.id.menu_sslib242:curFile="Sslib242.java";tv1.setText(new Sslib242().output());break;
		case R.id.menu_sslib243:curFile="Sslib243.java";tv1.setText(new Sslib243().output());break;
		case R.id.menu_sslib244:curFile="Sslib244.java";tv1.setText(new Sslib244().output());break;
		case R.id.menu_sslib245:curFile="Sslib245.java";tv1.setText(new Sslib245().output());break;

		case R.id.menu_sslib251:curFile="Sslib251.java";tv1.setText(new Sslib251().output());break;
		case R.id.menu_sslib252:curFile="Sslib252.java";tv1.setText(new Sslib252().output());break;
		case R.id.menu_sslib253:curFile="Sslib253.java";tv1.setText(new Sslib253().output());break;
		case R.id.menu_sslib254:curFile="Sslib254.java";tv1.setText(new Sslib254().output());break;
		case R.id.menu_sslib255:curFile="Sslib255.java";tv1.setText(new Sslib255().output());break;

		case R.id.menu_sslib261:curFile="Sslib261.java";tv1.setText(new Sslib261().output());break;
		case R.id.menu_sslib262:curFile="Sslib262.java";tv1.setText(new Sslib262().output());break;
		case R.id.menu_sslib263:curFile="Sslib263.java";tv1.setText(new Sslib263().output());break;
		case R.id.menu_sslib264:curFile="Sslib264.java";tv1.setText(new Sslib264().output());break;
		
		case R.id.menu_sslib271:curFile="Sslib271.java";tv1.setText(new Sslib271().output());break;
		case R.id.menu_sslib272:curFile="Sslib271.java";tv1.setText(new Sslib272().output());break;
		case R.id.menu_sslib273:curFile="Sslib273.java";tv1.setText(new Sslib273().output());break;
		case R.id.menu_sslib274:curFile="Sslib274.java";tv1.setText(new Sslib274().output());break;
		case R.id.menu_sslib275:curFile="Sslib275.java";tv1.setText(new Sslib275().output());break;

		case R.id.menu_sslib281:curFile="Sslib281.java";tv1.setText(new Sslib281().output());break;

		case R.id.menu_sslib291:curFile="Sslib291.java";tv1.setText(new Sslib291().output());break;
		case R.id.menu_sslib292:curFile="Sslib292.java";tv1.setText(new Sslib292().output());break;
		case R.id.menu_sslib293:curFile="Sslib293.java";tv1.setText(new Sslib293().output());break;

		case R.id.menu_sslib2a1:curFile="Sslib2a1.java";tv1.setText(new Sslib2a1().output());break;
		case R.id.menu_sslib2a2:curFile="Sslib2a2.java";tv1.setText(new Sslib2a2().output());break;
		case R.id.menu_sslib2a3:curFile="Sslib2a3.java";tv1.setText(new Sslib2a3().output());break;

		case R.id.menu_browse:
		    	// 指定したURLをWebviewに読み込む
				//Uri uri = Uri.parse("http://android.roof-balcony.com/");
				//Uri uri = Uri.parse("http://192.168.1.53/f/android/Sslib/Sslib211/src/kahata/Sslib211/Sslib211.java");
				Uri uri = Uri.parse(getRawSite(curFile));
				Intent i = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(i);
				Toast.makeText(this,
						curFile, Toast.LENGTH_SHORT).show();
				break;
			case R.id.menu_output:
				try {
					llInside.removeView(tv1);
					llInside.addView(tv2);
					setContentView(llOutside); 
				}catch (Exception e) {
					
				}
				Toast.makeText(this,
						"Menu1", Toast.LENGTH_SHORT).show();
				break;
			case R.id.menu_switchview:
				try {
					llInside.removeView(tv2);
					llInside.addView(tv1);
				}catch (Exception e) {
					
				}
				Toast.makeText(this,
						"Menu2", Toast.LENGTH_SHORT).show();
				break;
			case R.id.menu_texttoggle:
				toggle++;
				if(toggle%2==0) tv1.setText(result);
				else tv1.setText("ひろくんこんにちわ");
				Toast.makeText(this,
						"Menu3", Toast.LENGTH_SHORT).show();
				break;
			case R.id.menu_moveactivity:
		        Intent intent = new Intent(SslibActivity.this, SubActivity.class);
		        intent.putExtra("keyword", "ひろくんこんにちは このボタンを押せばSslib211に戻りますよ！");
		        // サブ画面の呼び出し 次画面のアクティビティ起動
				startActivity(intent);
				Toast.makeText(this,
						"Menu4", Toast.LENGTH_SHORT).show();
				break;
			case R.id.menu_fontsize:
				final CharSequence[] items = {"10", "12", "16", "20", "24", "28", "32"};

				new AlertDialog.Builder(SslibActivity.this)
				.setTitle("フォントサイズ")
				.setSingleChoiceItems(items, selectedfont, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						switch(item)
						{
						case 0: fontsize = 10.0f; break;
						case 1: fontsize = 12.0f; break;
						case 2: fontsize = 16.0f; break;
						case 3: fontsize = 20.0f; break;
						case 4: fontsize = 24.0f; break;
						case 5: fontsize = 28.0f; break;
						case 6: fontsize = 32.0f; break;
						case 7: fontsize = 12.0f; break;
						}
						selectedfont = item;
					}
				})
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Toast.makeText(SslibActivity.this,
							String.format("フォントサイズ: %2.1f",fontsize),
								Toast.LENGTH_SHORT).show();
					onCreate(savedInstanceState1);
					dialog.cancel();
	  			}
  				})
				.show();
				break;
		}
		return true;
	}
	/*
	https://github.com/hataka/codingground
	https://github.com/hataka/codingground/tree/master/android/Sslib
	https://github.com/hataka/codingground/blob          /master/android/Sslib/app/src/main/java/kahata/Sslib/Sslib225.java
	https://raw.githubusercontent.com/hataka/codingground/master/android/Sslib/app/src/main/java/kahata/Sslib/Sslib225.java
	*/
	public String getSrcSite(String fileName) {
		String site = GIT_SITE+"/app/src/main/java/kahata/Sslib/" + fileName; 
		site = site.replace("/tree/", "/blob/");
		return site;
	}

	public String getRawSite(String fileName) {
		String site = getSrcSite(fileName);
		site = site.replace("https://github.com/hataka/codingground/blob", "https://raw.githubusercontent.com/hataka/codingground");
		return site;
	}


}
