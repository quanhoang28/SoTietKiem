package com.example.sotietkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.DatabaseHandler;

public class RegisterActivity extends AppCompatActivity {

    EditText edUserName, edPassword;
    Button btDangKy;
    DatabaseHandler helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btDangKy = findViewById(R.id.btDK);

        edUserName = findViewById(R.id.edTaiKhoan);
        edPassword = findViewById(R.id.edPasword);

        helper = new DatabaseHandler(RegisterActivity.this);

        btDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUserName.getText().toString();
                String password = edPassword.getText().toString();
                helper.addNewUser(username,password);

                Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();

                Bundle goi = getIntent().getExtras();


                Intent i = new Intent(RegisterActivity.this, SignInActivity.class);
                startActivity(i);



            }

        });
    }
}