package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button selectImageBtn = (Button)findViewById(R.id.button);

        selectImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text1=(TextView) findViewById(R.id.text1);

                if(text1.getText()=="Hello World!"){
                    text1.setText("fuck");
                }else{
                    text1.setText("Hello World!");
                }

            }
        });

    }
}
