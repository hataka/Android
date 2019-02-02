package gudon.sample.fileaccess11;

import java.io.*;
import java.nio.channels.FileChannel;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class CommonLibrary {

	//ダイアログの表示
	public static void showDialog(final Activity activity,String title,String text) {
		AlertDialog.Builder ad=new AlertDialog.Builder(activity);
		ad.setTitle(title);
		ad.setMessage(text);
		ad.setPositiveButton("OK",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int whichButton) {
				activity.setResult(Activity.RESULT_OK);
			}
		});
		ad.create();
		ad.show();
	}

	public int result= 0;
	public static void show3ButtonDialog(final Activity activity,String title,String text)
	{
		AlertDialog.Builder ad =new AlertDialog.Builder(activity);
		ad.setTitle(title);
		ad.setMessage(text);
		// 肯定的な意味を持つボタンを設定
		ad.setPositiveButton("Positive", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				// Positive Buttonが押された時の処理を記述{
				activity.setResult(Activity.RESULT_OK);
			}
		});
		// 中立的な意味を持つボタンを設定
		ad.setNeutralButton("Neutral", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				// Neutral Buttonが押された時の処理を記述
				activity.setResult(Activity.RESULT_CANCELED);
			}
		});
		// 否定的な意味を持つボタンを設定
		ad.setNegativeButton("Negative", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				// Negative Buttonが押された時の処理を記述
				activity.setResult(Activity.RESULT_FIRST_USER);
			}
		});
		ad.create();
		ad.show();
	}
	
	//バイトデータ→ファイル
		public static void data2file(byte[] w,String fileName) 
			throws Exception {
			FileOutputStream fos=null;
			try {
				fos=new FileOutputStream(fileName);
					fos.write(w);
					fos.close();
			} catch (Exception e) {
				if (fos!=null) fos.close();
				throw e;
			}
		}

		//ファイル→バイトデータ
		public static byte[] file2data(String fileName) 
			throws Exception {
			int size;
			byte[] w=new byte[1024];
			FileInputStream fin=null;
			ByteArrayOutputStream out=null;
			try {
				fin=new FileInputStream(fileName);
				out=new ByteArrayOutputStream();
				while (true) {
					size=fin.read(w);
						if (size<=0) break;
						out.write(w,0,size);
				}
				fin.close();
				out.close();
				return out.toByteArray();
			} catch (Exception e) {
				try {
					if (fin!=null) fin.close();
					if (out!=null) out.close();
				} catch (Exception e2) {
				}
			throw e;
			}
		}

	public static void fileCopy(InputStream is , OutputStream os )throws IOException{	
		BufferedReader br = null;	
		BufferedWriter bw = null;	
		try {	
			br = new BufferedReader(new InputStreamReader(is));		
			bw = new BufferedWriter(new OutputStreamWriter(os));	 
	
			String str;		
			while((str = br.readLine()) != null){		
				bw.append(str +"\n");		 
			}	 
			bw.flush();	 
		} finally {	 
			if (br != null) br.close();	
			if (bw != null)bw.close();		 
		}	
	}	

		/**
	 * ファイルをコピーします。
	 * @param file コピー元ファイル
	 * @param newFileName コピー先ファイル名
	 */
	public static void copy(File file, String newFileName) {

		FileChannel ifc = null;
		FileChannel ofc = null;
		try {
			// 入力元ファイルのストリームからチャネルを取得
			FileInputStream fis = new FileInputStream(file);
			ifc = fis.getChannel();

			// 出力先ファイルのチャネルを取得
			File outFile = new File(file.getParent(), newFileName);
			FileOutputStream fos = new FileOutputStream(outFile);
			ofc = fos.getChannel();

			// バイトを転送します。
			ifc.transferTo(0, ifc.size(), ofc);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ifc != null) {
				try {
					// 入力チャネルを close します。
					ifc.close();
				} catch (IOException e) {
				}
			}
			if (ofc != null) {
				try {
					// 出力チャネルを close します。
					ofc.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	public static String fileReadAllfromInputStream(FileInputStream inputStream)throws IOException{	
		String line;
		StringBuilder lines = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = reader.readLine()) != null) {
				lines.append(line).append('\n');
			}
			reader.close();
			return lines.toString();
		} catch (IOException e) {
			return e.toString();
		}
	}

	public static void copyTextFile(String inpath, String outpath) {
		try { 
			// 入力ストリームを作成。
			FileReader fr = new FileReader(inpath); // in.txtは入力ファイル名。
			BufferedReader br = new BufferedReader(fr);

			// 出力ストリームを作成。
			FileWriter fw = new FileWriter(outpath); // out.txtは出力ファイル名。
			BufferedWriter bw = new BufferedWriter(fw);

			// 読込みループ。
			String line; // 読み込まれた１行。
			while( (line = br.readLine()) != null ) {
				bw.write(line); bw.newLine();
			}
			// 入力・出力ストリームを閉じる。
			br.close(); fr.close(); 
			bw.close(); fw.close();
		} catch ( Exception e ) { }
	}

 	public static void copyTextFile2(String inpath, String outpath) {
		try { 
			// 入力ストリームを作成。
			FileReader fr = new FileReader(inpath); // in.txtは入力ファイル名。
			BufferedReader br = new BufferedReader(fr);

			// 出力ストリームを作成。
			FileWriter fw = new FileWriter(outpath); // out.txtは出力ファイル名。
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			// 読込みループ。
			String line; // 読み込まれた１行。
			while( (line = br.readLine()) != null ) {
				pw.println(line);
			}

			// 入力・出力ストリームを閉じる。
			br.close(); fr.close();
			pw.close(); bw.close(); fw.close();
		} catch ( Exception e ) { }
	}

	public static void copyByteFile(String inpath, String outpath) {
		try {
			byte b1 = 12;
			byte b2 = -12;
			int n1 = 12;
			int n2 = 256;

			// 出力ストリームを作成。
			FileOutputStream fos = new FileOutputStream("file.txt");
			// ファイルに出力。
			fos.write(b1);
			fos.write(b2);
			fos.write(n1);
			fos.write(n2);
			// 出力ストリームを閉じる。
			fos.close();

			// 入力ストリームを作成。 
			FileInputStream fis = new FileInputStream("file.txt"); 
			// 読込みループ。
			int c; // 読み込まれた１バイト。入出力はint型で行われる。
			 // byte型は、-128～127。int型は、0～255。
			while( (c = fis.read()) != -1 ) {
				System.out.print("整数値：" + c); 
				System.out.println("　バイト値：" + (byte)c); 
			}
			// 入力ストリームを閉じる。
			fis.close();
		} catch ( Exception e ) { } 
	}	

	public static void copyByteFile2(String inpath, String outpath) {
		try {
			byte b1 = 12;
			byte b2 = -12;
			int n1 = 12;
			int n2 = 256;

			// 出力ストリームを作成。
			PrintWriter pw = new PrintWriter("file.txt");
			// ファイルに出力。
			pw.println(b1);
			pw.println(b2);
			pw.println(n1);
			pw.println(n2);
			// 出力ストリームを閉じる。
			pw.close();

			// 入力ストリームを作成。 
			FileInputStream fis = new FileInputStream("file.txt"); 
			// 読込みループ。
			int c; // 読み込まれた１バイト。入出力はint型で行われる。
			// byte型は、-128～127。int型は、0～255。
			while( (c = fis.read()) != -1 ) {
				System.out.print("整数値：" + c); 
				System.out.println("　バイト値：" + (byte)c); 
			}
			// 入力ストリームを閉じる。
			fis.close();
		} catch ( Exception e ) { } 
	}

}
