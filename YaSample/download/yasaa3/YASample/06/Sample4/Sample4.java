package ya.sample;

import java.io.*;
import java.nio.*;
import java.util.*;
import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.media.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.graphics.*;
import android.hardware.camera2.*;
import android.hardware.camera2.params.*;

public class Sample4 extends Activity
{
    Button bt;
    TextureView tv;
    SurfaceTexture sft;
    Size ps;
    CameraManager cm;
    CameraDevice camera;
    CameraCaptureSession ccs;
    CaptureRequest.Builder pb;
    CaptureRequest.Builder cb;
    ImageReader ir;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        bt = new Button(this);
        bt.setText("撮影");

        tv = new TextureView(this);

        ll.addView(bt);
        ll.addView(tv);

        tv.setSurfaceTextureListener(new SampleSurfaceTextureListener());
        bt.setOnClickListener(new SampleClickListener());
    }
    public void onPause()
    {
        if(ccs != null)
        {
            ccs.close();
            ccs = null;
        }
        if(camera != null)
        {
            camera.close();
            camera = null;
        }
        if(ir != null)
        {
            ir.close();
            ir = null;
        }
        super.onPause();
    }

    class SampleSurfaceTextureListener
            implements TextureView.SurfaceTextureListener
    {
        public void onSurfaceTextureAvailable(SurfaceTexture st, int w, int h)
        {
            try
            {
                cm = (CameraManager) getSystemService(CAMERA_SERVICE);
                String id = cm.getCameraIdList()[0];
                CameraCharacteristics cs = cm.getCameraCharacteristics(id);
                StreamConfigurationMap map
                        = cs.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);

                ps = map.getOutputSizes(SurfaceTexture.class)[0];

                cm.openCamera("0", new SampleStateCallBack(), null);

            }catch (Exception e) {}
        }

        public void onSurfaceTextureSizeChanged
                (SurfaceTexture st, int w, int h) {}
        public boolean onSurfaceTextureDestroyed(SurfaceTexture st)
        {
            return true;
        }
        public void onSurfaceTextureUpdated(SurfaceTexture st) {}
    }

    class SampleStateCallBack extends CameraDevice.StateCallback
    {
        public void onOpened(CameraDevice cd)
        {
            camera = cd;
            startPreview();
        }
        public void onDisconnected(CameraDevice cd)
        {
            camera.close();
            camera = null;
        }
        public void onError(CameraDevice cd, int err)
        {
            camera.close();
            camera = null;
        }
    }

    private void startPreview()
    {
        try
        {
            sft = tv.getSurfaceTexture();
            sft.setDefaultBufferSize(ps.getWidth(), ps.getHeight());
            Surface sf = new Surface(sft);

            pb = camera.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            pb.addTarget(sf);

            camera.createCaptureSession(Arrays.asList(sf),
                    new SamplePreviewCaptureSessionStateCallback() , null);

        }catch(Exception e){}
    }

    class SamplePreviewCaptureSessionStateCallback
            extends CameraCaptureSession.StateCallback
    {
        public void onConfigured(CameraCaptureSession cs)
        {
            ccs = cs;
            updatePreview();
        }
        public void onConfigureFailed(CameraCaptureSession cs) {}
    }

    private void updatePreview()
    {
        try
        {
            pb.set(CaptureRequest.CONTROL_MODE,
                    CameraMetadata.CONTROL_MODE_AUTO);
            ccs.setRepeatingRequest(pb.build(), null, null);
        }catch(Exception e){}
    }

    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            takePicture();
        }
    }
    private void takePicture()
    {
        try {
            ir = ImageReader.newInstance
                    (ps.getWidth(),ps.getHeight(), ImageFormat.JPEG, 1);

            List<Surface> lsf = new ArrayList<Surface>(2);
            lsf.add(new Surface(tv.getSurfaceTexture()));
            lsf.add(ir.getSurface());

            cb = camera.createCaptureRequest
                    (CameraDevice.TEMPLATE_STILL_CAPTURE) ;
            cb.addTarget(ir.getSurface());
            cb.set(CaptureRequest.CONTROL_MODE,
                    CameraMetadata.CONTROL_MODE_AUTO);

            int rt = getWindowManager().getDefaultDisplay().getRotation();
            SparseIntArray OR = new SparseIntArray();
            OR.append(Surface.ROTATION_0,270);
            OR.append(Surface.ROTATION_90,180);
            OR.append(Surface.ROTATION_180,90);
            OR.append(Surface.ROTATION_270,0);
            cb.set(CaptureRequest.JPEG_ORIENTATION, OR.get(rt));

            SampleImageAvailableListener ial
                    = new SampleImageAvailableListener();
            ir.setOnImageAvailableListener(ial, null);

            camera.createCaptureSession(lsf,
                    new SampleCaptureSessionStateCallback(), null);

        }catch(Exception e){}
    }

    class SampleCaptureSessionStateCallback
            extends CameraCaptureSession.StateCallback
    {
        public void onConfigured(CameraCaptureSession cs)
        {
            try
            {
                SampleCaptureSessionCaptureCallback sc
                        = new SampleCaptureSessionCaptureCallback();
                cs.capture(cb.build(),sc,null);

            }catch(Exception e){}
        }
        public void onConfigureFailed(CameraCaptureSession cs) {}
    }

    class SampleCaptureSessionCaptureCallback
            extends CameraCaptureSession.CaptureCallback
    {
        public void onCaptureCompleted
                (CameraCaptureSession cs, CaptureRequest req, TotalCaptureResult res)
        {
            super.onCaptureCompleted(cs,req,res);

            startPreview();
        }
    }

    class SampleImageAvailableListener
            implements ImageReader.OnImageAvailableListener
    {
        public void onImageAvailable(ImageReader ir)
        {
            try
            {
                Image im = ir.acquireLatestImage();
                ByteBuffer buf = im.getPlanes()[0].getBuffer();
                byte[] bytes = new byte[buf.capacity()];
                buf.get(bytes);
                im.close();

                File dir =  Environment.getExternalStorageDirectory();
                File f = new File(dir, "pic.jpg");

                FileOutputStream fos = new FileOutputStream(f);
                fos.write(bytes);
                fos.close();

                Toast.makeText(getApplicationContext(),
                        "写真を保存しました。",
                        Toast.LENGTH_LONG).show();

                MediaScannerConnection.scanFile(getBaseContext(),
                        new String[]{f.getAbsolutePath()},
                        new String[]{"image/jpeg"},null);

            }catch(Exception e) {}
        }
    }
}
