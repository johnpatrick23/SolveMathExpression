package com.oneclique.solvemathexpression;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.oneclique.solvemathexpression.util.MathSolve;

import java.io.IOException;

import static com.oneclique.solvemathexpression.util.MathUtils.isValidExpression2;

public class MainActivity extends AppCompatActivity {
    SurfaceView cameraView;
    TextView textView;
    TextView result;
    CameraSource cameraSource;
    final int requestCameraPermissionID = 1001;
    private static final String TAG = "MainActivity";
    TextRecognizer textRecognizer;
    public static final int REQUEST_PERM_WRITE_STORAGE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraView = findViewById(R.id.surface);
        textView = findViewById(R.id.text);
        result = findViewById(R.id.result);

        result.setText("");
        textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();

        if (!textRecognizer.isOperational()) {
            Log.w("MainActivity", "Detector Dependencies are not yet available.");
        } else {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
            }
            try {
                if(cameraSource!=null){
                    cameraSource.start(cameraView.getHolder());
                }
            } catch (IOException e) {
                e.getStackTrace();
            }
            if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERM_WRITE_STORAGE);

            } else{
                startCamera();
            }
        }
    }

    public void startCamera(){
        cameraSource = new CameraSource.Builder(getApplicationContext(), textRecognizer)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(1280, 1024)
                .setRequestedFps(2.0f)
                .setAutoFocusEnabled(true)
                .build();
        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder)
            {
                try
                {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    cameraSource.start(cameraView.getHolder());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
            {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder)
            {
                cameraSource.stop();
            }
        });

        textRecognizer.setProcessor(new Detector.Processor<TextBlock>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<TextBlock> detections)
            {
                final SparseArray<TextBlock> items = detections.getDetectedItems();
                if (items.size() != 0)
                {
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i=0 ; i<items.size(); i++)
                            {
                                TextBlock item = items.valueAt(i);
                                stringBuilder.append(item.getValue());
                            }

                            String math = stringBuilder.toString().toLowerCase().trim().replace(" ", "");
                            if(isValidExpression2(math.replace('x', '*'))){
                                MathSolve mathSolve = new MathSolve();
                                math = math.replace('*', 'x');
                                String res = stringBuilder.toString() + "=" + mathSolve.calculate(result, math, 'd');
                                textView.setText(res.toLowerCase().replace(" ", ""));
                                result.setText("");
                            }else {
                                textView.setText("");
                                result.setText("");
                            }
                            //result.setText(stringBuilder.toString());
                        }
                    });
                }
            }
        });
    }
}