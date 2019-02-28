package com.example.beta;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreadedActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threaded);

        //get variabel from previous activity
        iv = findViewById(R.id.imgVwProfil);
        Intent intent = getIntent();
        String strMsg = intent.getStringExtra("VarStr1");
        TextView tv1 = findViewById(R.id.txtvwhello);
        tv1.setText("Hello and wellcome " + strMsg);
    }

    public void fnTakePic(View vw) {
        Runnable run = new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView tv1 = (TextView) findViewById(R.id.txtvwhello);
                        tv1.setText(tv1.getText().toString() + "... this is your picture hehehe..");
                    }
                });
            }
        };
        Thread thr = new Thread(run);
        thr.start();
    }

    protected void onActivityResult(int requestcode, int resultCode, Intent data) {
        super.onActivityResult(requestcode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(bp);
    }
}
