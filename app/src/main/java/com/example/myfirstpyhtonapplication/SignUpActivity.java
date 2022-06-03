package com.example.myfirstpyhtonapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity  extends AppCompatActivity {
    EditText RegEmail;
    EditText PassReg;
    EditText PassRegagine;
    EditText Phone;
    TextView textViewSignin;


    Button gotowork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();



        setContentView(R.layout.signup);

        RegEmail = findViewById(R.id.editTextTextEmailAddress2);
        PassReg = findViewById(R.id.editTextTextPassword2);
        PassRegagine =findViewById(R.id.editTextTextPassword3);
        Phone = findViewById(R.id.editTextPhone2);


        gotowork = findViewById(R.id.button3);
        gotowork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,WorkSpaceActivity.class);
                        startActivity(intent);
            }
        });


        textViewSignin =findViewById(R.id.textViewSignin);
        textViewSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this ,MainActivity.class);
                startActivity(intent);
            }
        });


    }


}

