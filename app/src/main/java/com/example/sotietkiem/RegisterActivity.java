package com.example.sotietkiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.User;
import data.Utils;

import com.google.gson.Gson;

//import data.DatabaseHandler;

public class RegisterActivity extends AppCompatActivity {

    EditText edUserName, edPassword,edPhone,edConfimrPassword,edGmail;
    Button btDangKy;

    private SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    private final Gson gson = new Gson();
//    DatabaseHandler helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        anhxa();

//        helper = new DatabaseHandler(RegisterActivity.this);


        btDangKy.setOnClickListener(Registered());

    }



    @NonNull
    private View.OnClickListener Registered() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edUserName.getText().toString().trim();
                String password = edPassword.getText().toString().trim();
                String confirmPassword = edConfimrPassword.getText().toString().trim();
                String gmail = edGmail.getText().toString().trim();
                String phone = edPhone.getText().toString().trim();

                boolean isValid = checkUserName(userName) && checkPassword(password,confirmPassword);
//                helper.addNewUser(username,password);

                if ( isValid) {
                    // nếu dữ liệu hợp lệ, tạo đối tượng user để lưu vô share preference.
                    User newUser = new User();
                    newUser.setUserName(userName);
                    newUser.setPassword(password);
                    newUser.setEmail(gmail);
                    newUser.setPhoneNumber(phone);

                    // vì user là object nên convert qua string với format là json để lưu vào share perferences
                    String userStr = gson.toJson(newUser);
                    editor.putString(Utils.KEY_USER,userStr);
                    editor.commit();
                    // dùng Toast để show thông báo đăng ký thành công
                    Toast.makeText(RegisterActivity.this, "Đăng ký tài khoản thành công", Toast.LENGTH_LONG).show();
                    //finish RegisterActivity.
                    finish();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Đăng ký tài khoản không thành công", Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    void anhxa()
    {
        btDangKy = findViewById(R.id.btDK);

        edUserName = findViewById(R.id.edUserNameRe);
        edPassword = findViewById(R.id.edPaswordRe);
        edConfimrPassword = findViewById(R.id.edConfirmPasswordRe);
        edPhone = findViewById(R.id.edPhoneNumberRe);
        edGmail = findViewById(R.id.edGmailRe);
    }

    private boolean checkUserName(String userName) {
        if (userName.isEmpty()) {
            edUserName.setError("Vui lòng nhập tên đăng nhập");
            return false;
        }
        if (userName.length() <= 6 ) {
            edUserName.setError("Tên đăng nhập ít nhất phải 6 ký tự");
            return false;
        }
        return true;
    }
    private  boolean checkPassword(String password, String confirmPassword) {
        if (password.isEmpty()) {
            edPassword.setError("Vui lòng nhập mật khẩu");
            return false;
        }
        if (password.length() <= 5) {
            edPassword.setError("Mật khẩu phải lớn hơn 5 ký tự");
            return  false;
        }
        if (!password.equals(confirmPassword)) {
            edPassword.setError("Xác nhận mật khẩu không khớp");
            return  false;
        }
        return  true;
    }
}