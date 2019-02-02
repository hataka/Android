package gudon.sample.fileaccess06;


//package gudon.sample.file_access6;

//import gudon.sample.fileaccess08.DoSuCommand;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView tvPath;
	private File upDir;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

 //     DoSuCommand su = new DoSuCommand();
 //     su.init();

        tvPath = (TextView) findViewById(R.id.tv_path);

		final FileArrayAdapter adapter = new FileArrayAdapter(this,
				R.layout.list_row);
		ListView lv = (ListView) findViewById(R.id.list);
		lv.setAdapter(adapter);
		reflushAdapter(adapter, new File("/"));

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ListView listView = (ListView) parent;
				File file = (File) listView.getItemAtPosition(position);
				if (file.isDirectory()) {
					reflushAdapter(adapter, file);
				} else {
					Intent intent = new Intent(MainActivity.this,
							SubActivity.class);
					intent.putExtra("filePath", file.getPath());
					startActivity(intent);
				}
			}
		});

		Button upButton = (Button) findViewById(R.id.up_button);
		upButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (upDir != null) {
					reflushAdapter(adapter, upDir);
				}
			}
		});
	}

	void reflushAdapter(FileArrayAdapter adapter, File dir) {
		adapter.clear();

		upDir = dir.getParentFile();
		File[] files = dir.listFiles();
		if (files != null) {
			for (File file : files) {
				adapter.add(file);
			}
		} else {
			Toast.makeText(this, "このデレクトリにはアクセスできません", Toast.LENGTH_LONG)
					.show();
		}
		tvPath.setText(dir.getPath());
	}

	private class FileArrayAdapter extends ArrayAdapter<File> {
		private int resourceId;

		public FileArrayAdapter(Context context, int resourceId) {
			super(context, resourceId);
			this.resourceId = resourceId;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			File file = (File) getItem(position);
			if (convertView == null) {
				LayoutInflater inflater = (LayoutInflater) getContext()
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(resourceId, null);
			}
			TextView tv = (TextView) convertView.findViewById(R.id.list_text);
			tv.setText(file.getName());
			ImageView image = (ImageView) convertView
					.findViewById(R.id.list_image);
			if (file.isDirectory()) {
				image.setVisibility(View.VISIBLE);
			} else {
				image.setVisibility(View.INVISIBLE);
			}
			return convertView;
		}
	}

}

/*
import android.app.Activity;
import android.os.Bundle;

public class FileAccess06Activity extends Activity {
    / ** Called when the activity is first created. * /
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
*/