package gudon.sample.fileaccess02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	static private final String FILE_PATH = "FileAccess02Activity.java";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		final TextView tv = new TextView(this);
		layout.addView(tv);

		Button readButton =  new Button(this);
		readButton.setText("assetsデレクトリのファイル読込み");
		readButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// assetsデレクトリのファイルを読み込みTextViewに表示するコード
				try {
					AssetManager assets = getResources().getAssets();
					InputStream inputStream = assets.open(FILE_PATH);
					/*
	    		Context context = getApplicationContext();
       		CharSequence text = String.format("ファイルアクセスデレクトリは「%s」です。", assets.getPath());
       		int duration = Toast.LENGTH_SHORT;
       		Toast toast = Toast.makeText(context, text, duration);
       		toast.show();
					*/
					//Toast.makeText(getApplicationContext(),
					//	String.format("ファイルアクセスデレクトリは「%s」です。", assets.toString()),
					//	Toast.LENGTH_SHORT).show();
					
					/** assets内のファイルをログ表示.*/
					//displayAssets("");
					
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(inputStream));
					String line;
					StringBuilder lines = new StringBuilder();
					while ((line = reader.readLine()) != null) {
						lines.append(line).append('\n');
					}
					reader.close();

					tv.setText(lines);
				} catch (IOException e) {
					Toast.makeText(getApplicationContext(),
							"ファイルの読込みに失敗しました。\n" + e.getMessage(),
							Toast.LENGTH_LONG).show();
				}
			}
		});
		layout.addView(readButton);

		Button fileListButton = new Button(this);
		fileListButton.setText("assetsデレクトリのファイルリストを表示");
		
		fileListButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// assetsデレクトリのファイルリストを表示するコード
				AssetManager assets = getResources().getAssets();
				String[] fileNames;
				try {
					fileNames = assets.list("");
					StringBuilder fileList = new StringBuilder();
					for (String fileName : fileNames) {
						fileList.append(fileName).append('\n');
					}
					tv.setText(fileList);
				} catch (IOException e) {
					Toast.makeText(getApplicationContext(),
							"ファイルリストの取得に失敗しました。\n" + e.getMessage(),
							Toast.LENGTH_LONG).show();
				}
			}
		});
		layout.addView(fileListButton);
	}

	/** 
	 * assets内の任意のフォルダ内のファイルをログ表示.
	 * http://android-blog.smartphone-app.net/archives/154
	 * @param dir
	 * (String) フォルダ名 
	 */ 
    private void displayAssets(String dir){
        AssetManager assetMgr = getResources().getAssets(); 
        try {  
            String files[] = assetMgr.list(dir);  
            for(int i = 0; i < files.length; i++) {    
                //Log.d("assets file", files[i]);
            	Toast.makeText(getApplicationContext(),
								files[i],Toast.LENGTH_LONG).show();
            }  
        } catch (IOException e) {  
        }  
    }


}

/*
import android.app.Activity;
import android.os.Bundle;

public class FileAccess02Activity extends Activity {
    / ** Called when the activity is first created. * /
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
*/