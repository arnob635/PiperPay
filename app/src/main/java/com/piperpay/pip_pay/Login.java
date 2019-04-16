package com.piperpay.pip_pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView txt;
    ImageView fAuth;
    Button mbtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mbtn1=(Button) findViewById(R.id.loginBtn);

        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change = new Intent(Login.this,dashboard.class);
                startActivity(change);
            }
        });

        txt=(TextView) findViewById(R.id.create);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change = new Intent(Login.this,Signup.class);
                startActivity(change);
            }
        });



        fAuth = findViewById(R.id.fingerPrintAuth);
        fAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,fingerPrintLogin.class);
                startActivity(intent);

            }
        });




    }


}
