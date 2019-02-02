// -*- mode: java -*-  Time-stamp: <2012-03-02 6:50:07 kahata>
/*================================================================
 * title: 
 * file: FileAccess03Activity.java
 * path: F:\android\Gudon\FileAccess03\SUBDIR_NAME\gudon\sample\fileaccess03\FileAccess03Activity.java
 * url:  http://192.168.24.92/android/Gudon/FileAccess09/SUBDIR_NAME/gudon/sample/fileaccess09/FileAccess03Activity.java
 * created: Time-stamp: <2012-03-02 6:50:07 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: http://ichitcltk.hustle.ne.jp/gudon/modules/pico_rd/index.php?content_id=93
 * link: http://www.javadrive.jp/android/edittext/index11.html
 * description: FileAccess03 「raw」デレクトリのファイルへのアクセス
 *================================================================*/

package gudon.sample.fileaccess11;

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

public class FileAccess11Activity extends Activity {

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

    
	static private final String SUBDIR_NAME = "src";
	static private final String FILE_NAME = "FileAccess11Activity.java";
	static private File subdir2;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    mypkgname = getPackageName();
	    myclasspath = new FileAccess11Activity().getClass().getName();
	    myclassname = new FileAccess11Activity().getClass().getSimpleName();

		File fileDir=getFilesDir();
		
		final File subDir= subdir2 = new File(fileDir,FileAccess11Activity.SUBDIR_NAME);
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
	
		readButton.setText("files/src デレクトリのファイル読込み");
		readButton.setOnClickListener(new SimpleClickListener());

		layout.addView(readButton);
		layout.addView(sv,new LinearLayout.LayoutParams(FP, FP));
	}
	
	class SimpleClickListener implements OnClickListener
	{
		public void onClick(View v)
		{
			String result = "";
			// rawデレクトリのファイルを読み込みTextViewに表示するコード
			try {
				Resources res = getResources();
				InputStream inputStream = res.openRawResource(R.raw.fileaccess11activity);

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(inputStream));
				String line;
				StringBuilder lines = new StringBuilder();
				while ((line = reader.readLine()) != null) {
					lines.append(line).append('\n');
				}
				reader.close();
				result = lines.toString(); 
			} catch (IOException e) {
				CommonLibrary.showDialog(FileAccess11Activity.this,"エラー","ファイルの読込みに失敗しました。\n" + e.getMessage());
			}

			try {
				File file = new File(FileAccess11Activity.subdir2,FileAccess11Activity.FILE_NAME);
				FileOutputStream outputStream = new FileOutputStream(file);
				//if ( file.exists() == false ) {  
					BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(outputStream));
					writer.write(result);
					writer.close();
				//}
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(),
						"ファイルの書込みに失敗しました。\n" + e.getMessage(),
						Toast.LENGTH_LONG).show();
			}
			
			
			
			
			// ファイルを読込みTextViewに表示する
			try {
					FileInputStream inputStream = new FileInputStream(new File(
							FileAccess11Activity.subdir2, FileAccess11Activity.FILE_NAME));
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(inputStream));
					String line;
					StringBuilder lines = new StringBuilder();
					while ((line = reader.readLine()) != null) {
						lines.append(line).append('\n');
					}
					reader.close();

					// インテントのインスタンス生成
					Intent intent=new Intent();
					intent.putExtra("keyword", lines.toString());
					intent.setClassName(mypkgname, mypkgname +".SubActivity");
					// 次画面のアクティビティ起動
					startActivity(intent);
				} catch (IOException e) {
					Toast.makeText(getApplicationContext(),
							"ファイルの読込みに失敗しました。\n" + e.getMessage(),
							Toast.LENGTH_LONG).show();
				}
	}  }
		

	
	//////////////////////////////////////////////////////////////////
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "FileAccess11Activity.java");
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
				url = "http://192.168.24.92/android/Gudon/FileAccess10/src/gudon/sample/fileaccess10/FileAccess11Activity.java";
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