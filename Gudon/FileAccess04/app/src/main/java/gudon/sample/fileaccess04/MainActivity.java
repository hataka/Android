package gudon.sample.fileaccess04;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

import android.app.*;
import android.os.*;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	
	private List<File> musicFiles;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.main);
		ListView lv = new ListView(this);
    setContentView(lv);

		//musicFiles = new ArrayList<File>();
		
		File file = Environment.getExternalStorageDirectory();//SDカードにアクセス
		//searchMusicFiles(file);
		
		 List<String> mStrings = new ArrayList<String>();
     mStrings.add("aaa");
     mStrings.add("abc");
     mStrings.add("bbb");
     mStrings.add("ccc");
		//for(File f : musicFiles){
		//	mStrings.add(f.getName());
		//}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mStrings);
		lv.setAdapter(adapter);
		//ArrayAdapter<String> adapter 
		//	= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		

		//ListView listView = (ListView) findViewById(R.id.listview);
		//ListView listView = new ListView(this);// findViewById(R.id.listview);
		//listView.setAdapter(adapter);
	}
	
	//再帰的にディレクトリ内を調べるメソッド

	private void searchMusicFiles(File f){
		if(f.isDirectory()){ // ディレクトリならそれ以下のディレクトリ、ファイルを検査
			File[] files = f.listFiles();
   		for(File file : files){
   			searchMusicFiles(file); // 再帰
   		}
		}else{ // ファイルの場合は音楽ファイルかどうかの判断
			// Androidで扱えるのはmp3とwavファイルなので、
			// これらのファイルの場合リストに保存
			if(f.getName().endsWith("mp3") || f.getName().endsWith("MP3")
			|| f.getName().endsWith("wav") || f.getName().endsWith("WAV")){
				musicFiles.add(f);
			}
		}
	}
}





/*
public class MainActivity extends Activity {
	/ ** Called when the activity is first created. * /
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        Button button = new Button(this);
        button.setText("トーストを表示");
        setContentView(button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Context context = getApplicationContext();
        		CharSequence text = "Hello toast!";
        		int duration = Toast.LENGTH_SHORT;

        		Toast toast = Toast.makeText(context, text, duration);
        		toast.show();
            }
        });

	}
}
*/