package com.example.sotietkiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import data.DataQuery;
import data.DatabaseHandler;
import data.User;
import data.Utils;

public class SignInActivity extends AppCompatActivity {
    EditText edTaiKhoan, edPassword;
    Button btDangNhap,btDangKy;

    TextView tvTest;

    ArrayList<User> lstUser;
    SharedPreferences.Editor editor;
    private final Gson gson =new Gson();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

       anhxa();

       btDangNhap.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


//               lstUser = DataQuery.getAll(SignInActivity.this);

               DatabaseHandler helper = new DatabaseHandler(SignInActivity.this);
               SQLiteDatabase db = helper.getReadableDatabase();
               String username = edTaiKhoan.getText().toString().trim();
               String password = edPassword.getText().toString().trim();

               User dbUser = DataQuery.GetUser(SignInActivity.this,username);

               if(username == dbUser.getUserName())
               {
                   Toast.makeText(SignInActivity.this, "Username đúng", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(SignInActivity.this, "không đúng", Toast.LENGTH_SHORT).show();
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

    void anhxa(){
        btDangNhap = findViewById(R.id.btDangNhap);

        edTaiKhoan = findViewById(R.id.edUserNameLo);
        edPassword = findViewById(R.id.edPaswordLo);

        btDangKy = findViewById(R.id.btDangKy);

    }

    private void checkUserLogin() {

    }
}