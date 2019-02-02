package gudon.sample.fileaccess01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity {
	static private final String FILE_NAME = "xxx.txt";
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);
 		// ファイルアクセスデレクトリの表示
		//String filesDirectoryPath = context.getFilesDir().getPath();
		//=> /data/data/[package name]/files
		File fileDir = getFilesDir();
    // /data/user/0/gudon.sample.fileaccess01/files
    // /data/user/0/[package name]/files
		TextView tvFileDir = new TextView(this);
		tvFileDir.setText(String.format("ファイルアクセスデレクトリは「%s」です。",
				fileDir.getPath()));
		layout.addView(tvFileDir);
 
		final EditText ed = new EditText(this);
		layout.addView(ed);
 
		Button writeButton = new Button(this);
		writeButton.setText("書込み");
		writeButton.setOnClickListener(new View.OnClickListener() {
 
			@Override
			public void onClick(View v) {
				// openFileOutputメソッドの例
				// Editテキストに入力されたテキストをファイルに書き込む
				try {
					FileOutputStream outputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
					BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(outputStream));
					writer.write(ed.getText().toString());
					writer.close();
 
					ed.setText("");
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							"ファイルの書込みに失敗しました。\n" + e.getMessage(),
							Toast.LENGTH_LONG).show();
				}
			}
		});
		layout.addView(writeButton);
 
		final TextView tv = new TextView(this);
		layout.addView(tv);
 
		Button readButton = new Button(this);
		readButton.setText("読込み");
		readButton.setOnClickListener(new View.OnClickListener() {
 
			@Override
			public void onClick(View v) {
				// openFileInputメソッドの例
				// ファイルを読込みTextViewに表示する
				try {
					FileInputStream inputStream = openFileInput(FILE_NAME);
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
 
		// fileListメソッドの例
		// ファイルリストをTextViewに表示する
		fileListButton.setText("fileListの表示");
		fileListButton.setOnClickListener(new View.OnClickListener() {
 
			@Override
			public void onClick(View v) {
				String[] fileNames = fileList();
				StringBuilder fileList = new StringBuilder();
				for (String fileName : fileNames) {
					fileList.append(fileName).append('\n');
				}
				tv.setText(fileList);
			}
		});
		layout.addView(fileListButton);
 
		// deleteFileメソッドの例
		// ファイルリストをTextViewに表示する
		Button deleteFiletButton = new Button(this);
		deleteFiletButton.setText("ファイルの削除");
		deleteFiletButton.setOnClickListener(new View.OnClickListener() {
 
			@Override
			public void onClick(View v) {
				boolean result = deleteFile(FILE_NAME);
				if (result) {
					Toast.makeText(getApplicationContext(),
							"ファイルを" + "削除しました。", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(), "ファイルの削除に失敗しました。",
							Toast.LENGTH_LONG).show();
				}
			}
		});
		layout.addView(deleteFiletButton);
	}
}

