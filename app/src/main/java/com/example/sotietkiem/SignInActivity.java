package com.example.sotietkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import data.DatabaseHandler;

public class SignInActivity extends AppCompatActivity {
    EditText edTaiKhoan, edPassword;
    Button btDangNhap,btDangKy;

    TextView tvTest;

    DatabaseHandler helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btDangNhap = findViewById(R.id.btDangNhap);

        edTaiKhoan = findViewById(R.id.edTaiKhoan);
        edPassword = findViewById(R.id.edPassword);

        btDangKy = findViewById(R.id.btDangKy);

        btDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edTaiKhoan.getText().toString().trim();
                String password = edPassword.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "vui lòng nhập thông tin đầy đủ", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(SignInActivity.this,MainActivity.class);
                    i.putExtra("username",username );
                    startActivity(i);
                }




            }
        });

        btDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}