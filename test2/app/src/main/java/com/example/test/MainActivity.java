package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    final int[] IMG ={R.drawable.img2} ;
    int tempfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button selectImageBtn = (Button)findViewById(R.id.button);

        staticLoadCVLibraries();

        selectImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text1=(TextView) findViewById(R.id.text1);

                if(text1.getText().toString()=="Hello World!"){
                    text1.setText("fuck");
                    convernomal();
                }else{
                    text1.setText("Hello World!");
                    convertGray();
                }

            }
        });

    }

    //OpenCV库静态加载并初始化
    private void staticLoadCVLibraries() {
        boolean load = OpenCVLoader.initDebug();
        if (load) {
            Log.i("CV", "Open CV Libraries loaded...");
        }
    }

    private void convertGray() {
        Mat src = new Mat();
        Mat temp = new Mat();
        Mat dst = new Mat();
        ImageView img2=new ImageView(this);
        ImageView img1=(ImageView) findViewById(R.id.imageView);
        Bitmap bmp= ((BitmapDrawable)img1.getDrawable()).getBitmap();
        Utils.bitmapToMat(bmp, src);
        Imgproc.cvtColor(src, temp, Imgproc.COLOR_BGRA2BGR);
        Log.i("CV", "image type:" + (temp.type() == CvType.CV_8UC3));
        Imgproc.cvtColor(temp, dst, Imgproc.COLOR_BGR2GRAY);
        Utils.matToBitmap(dst, bmp);
        img1.setImageBitmap(bmp);
    }

    private void convernomal() {

        ImageView img1=(ImageView) findViewById(R.id.imageView);
        tempfile=IMG[0];
        img1.setImageDrawable(getResources().getDrawable(tempfile));

    }



}


