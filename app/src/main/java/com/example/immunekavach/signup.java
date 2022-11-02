package com.example.immunekavach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class signup extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") ||pass.equals("")||repass.equals("") )
                    Toast.makeText(signup.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(signup.this, "reg done", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),login.class);
                                startActivity(intent);
                                finish();

                            }else {
                                Toast.makeText(signup.this, "reg failed", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(signup.this, "user already exists", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(signup.this, "passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}