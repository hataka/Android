package gudon.sample.fileaccess08;

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
	static private final String DIR_NAME = "my_files";
	static private final String FILE_NAME = "xxx.txt";

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DoSuCommand su = new DoSuCommand();
        su.init();
        
        LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		final File fileDir=getDir(DIR_NAME, MODE_PRIVATE);
		// ファイルアクセスデレクトリの表示
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
					FileOutputStream outputStream = new FileOutputStream(new File(fileDir,FILE_NAME));
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
					FileInputStream inputStream = new FileInputStream(new File(fileDir,FILE_NAME));
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
    }
}

/*
import android.app.Activity;
import android.os.Bundle;

public class FileAccess08Activity extends Activity {
    / ** Called when the activity is first created. * /
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
*/