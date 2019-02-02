// -*- mode: java -*-  Time-stamp: <2012-03-02 6:50:07 kahata>
/*================================================================
 * title: 
 * file: FileAccess03Activity.java
 * path: F:\android\Gudon\FileAccess03\src\gudon\sample\fileaccess03\FileAccess03Activity.java
 * url:  http://192.168.24.92/android/Gudon/FileAccess09/src/gudon/sample/fileaccess09/FileAccess03Activity.java
 * created: Time-stamp: <2012-03-02 6:50:07 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=93
 * link: http://www.javadrive.jp/android/edittext/index11.html
 * description: FileAccess03 「raw」デレクトリのファイルへのアクセス
 *================================================================*/

package gudon.sample.fileaccess10;

import java.io.*;
import android.net.Uri;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.app.*;
import android.content.*;
import android.content.res.Resources;
import android.graphics.*;

public class MainActivity extends Activity {

    private final int FP = ViewGroup.LayoutParams.FILL_PARENT;
    //private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;

    /*
	getPackage() String パッケージ名を返す。
	getName()    String クラス名（パッケージ付き。つまり限定名（FQN））を返す。
	getSimpleName()	String クラス名（パッケージ無し。つまり単純名）を返す。
	getCanonicalName()	String クラス名（正準名）を返す。
	*/
    String mypkgname;
    String myclasspath;
    String myclassname;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    mypkgname = getPackageName();
	    myclasspath = new MainActivity().getClass().getName();
	    myclassname = new MainActivity().getClass().getSimpleName();

		File fileDir=getFilesDir();
		final File subDir=new File(fileDir,"src");
		if(!subDir.exists()){
			subDir.mkdir();
		}	    
		initializeView();
	}
	
	public void initializeView()
	{
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout, new LinearLayout.LayoutParams(FP, FP));

        HorizontalScrollView hsv = new HorizontalScrollView(this);
		ScrollView sv = new ScrollView(this);
		sv.addView(hsv,new LinearLayout.LayoutParams(FP, FP));
		
		final TextView tv = new TextView(this);
		tv.setBackgroundColor(Color.WHITE);
		tv.setTextSize(16.0f);
	    tv.setTypeface(Typeface.MONOSPACE);
		tv.setTextColor(Color.BLACK);

		hsv.addView(tv,new LinearLayout.LayoutParams(FP, FP));

		Button readButton = new Button(this);
	
		readButton.setText("filesデレクトリのファイル読込み");
		readButton.setOnClickListener(new SimpleClickListener());

		layout.addView(readButton);
		layout.addView(sv,new LinearLayout.LayoutParams(FP, FP));
	}
	
	class SimpleClickListener implements OnClickListener
	{
		public void onClick(View v)
		{
			//filesフォルダにtest.txtが存在しなければ、res/raw/test.txtをコピーする。  
			File file = MainActivity.this.getFileStreamPath("MainActivity.java");  
			if ( file.exists() == false ) {  
				Resources res = MainActivity.this.getResources();  
		        try {  
		        	CommonLibrary.fileCopy(res.openRawResource(R.raw.fileaccess10activity),
		        			openFileOutput(file.getName(),MODE_PRIVATE));  
		        } catch (IOException e) {  
		        	//e.printStackTrace();  
		        	String msg = "ファイルのコピーに失敗しました。\n" + e.getMessage();
		            CommonLibrary.showDialog(MainActivity.this,	"エラー",msg);
		        }
			}
			// ファイルを読込みTextViewに表示する
			try {
				FileInputStream inputStream = openFileInput(myclassname + ".java");
				//FileInputStream inputStream 
				//	= new FileInputStream(new File(subDir,myclassname + ".java"));
				String result = CommonLibrary.fileReadAllfromInputStream(inputStream);
				// インテントのインスタンス生成
				Intent intent=new Intent();
				intent.putExtra("keyword", result);
				intent.setClassName(mypkgname, mypkgname +".SubActivity");
				// 次画面のアクティビティ起動
				startActivity(intent);
			} catch (IOException e) {
				Toast.makeText(getApplicationContext(),
						"ファイルの読込みに失敗しました。\n" + e.getMessage(),
						Toast.LENGTH_LONG).show();
				CommonLibrary.showDialog(MainActivity.this,"エラー","ファイルの読込みに失敗しました。\n" + e.getMessage());
			}
		}
	}  

	
	//////////////////////////////////////////////////////////////////
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "MainActivity.java");
		return super.onCreateOptionsMenu(menu);
	}
	// メニューが選択されたときに実行される
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String url = "http://www.google.co.jp/";
		String toasttitle = "Google";
		// 選択されたIDを確認
		switch (item.getItemId()) {
			case 0:
				//url = "http://192.168.1.53/f/android/Gudon/FileAccess10/src/gudon/sample/fileaccess10/FileAccess10Activity.java";
				//url = "http://192.168.1.53/f/GitHub/hataka/codingground/android/Gudon/FileAccess10/app/src/main/java/gudon/sample/fileaccess10/MainActivity.java";
				url = "https://github.com/hataka/codingground/blob/master/android/Gudon/FileAccess10/app/src/main/java/gudon/sample/fileaccess10/MainActivity.java";
				toasttitle = "FileAccess10Activity";
				break;
			default:
				break;
		}
		// 指定したURLをWebviewに読み込む
		Uri uri = Uri.parse(url);
		Intent i = new Intent(Intent.ACTION_VIEW,uri);
		startActivity(i);
		Toast.makeText(this,toasttitle, Toast.LENGTH_SHORT).show();
		return true;
	}
	/////////////////////////////////////////////////////////////////////////
}