package ya.Sample075;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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

}
