package com.example.beta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Instant;
import java.time.Year;
import java.util.Calendar;


public class firstactivity extends AppCompatActivity {

    TextView txtvwAge;
    EditText edtName,edtYear;
    Button btnClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstactivity);

        txtvwAge = findViewById(R.id.txtvwAge);
        edtName = findViewById(R.id.edtName);
        edtYear = findViewById(R.id.edtYear);
    }

    public void fnGreet(View vw){
        String strName = edtName.getText().toString();
        String strAge = edtYear.getText().toString();
        int desiredvalue = Integer.parseInt(strAge);
        int year = Year.now().getValue();
        int result =  year-desiredvalue;
        txtvwAge.setText("Hello and welcome" +" "+strName + " your are " + result + " years old");
    }

    public  void fnThreadActivity(View vw) {
        Intent intent = new Intent(this, ThreadedActivity.class);
        String strMsg = ((EditText) findViewById(R.id.edtName)).getText().toString();
        intent.putExtra("VarStr1",strMsg);
        startActivity(intent);
    }
}
