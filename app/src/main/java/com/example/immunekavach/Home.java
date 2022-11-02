package com.example.immunekavach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.text.TextRunShaper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {
    Button button7;
    Button button5;
    Button button6;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button button1 = findViewById(R.id.viewpdf);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,WebActivity.class);
                startActivity(intent);
            }
        });
        Button button6 = findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Home.this,doctor.class);
                startActivity(intent);

            }
        });

        textView=(TextView)findViewById(R.id.textView13);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Home.this, about.class);
                startActivity(intent);
            }
        });

        button5= findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {gotoUrl("https://docs.google.com/forms/d/e/1FAIpQLSfi-fo2w8S5XQ0APbF_GfV9srUrueauB0Oj8qEnP0aFNkistg/viewform");}
        });


        button6=findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,doctor.class);
                startActivity(intent);
            }
        });


        button7 = findViewById(R.id.button7);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.mohfw.gov.in/");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));




    }
}