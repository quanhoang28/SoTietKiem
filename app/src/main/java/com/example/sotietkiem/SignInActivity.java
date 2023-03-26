package com.example.sotietkiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import data.User;
import data.Utils;

public class SignInActivity extends AppCompatActivity {
    EditText edTaiKhoan, edPassword;
    Button btDangNhap,btDangKy;

    TextView tvTest;

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


        btDangNhap.setOnClickListener(GetLogin());

        btDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    @NonNull
    private View.OnClickListener GetLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userPref = sharedPreferences.getString(Utils.KEY_USER,null);
                User user = gson.fromJson(userPref,User.class);
                // user = null có nghĩa là chưa có user đăng ký
                if ( user == null) {
                    return;
                }
                // ktra user name, password có trùng với đối  tương user trong share preferences không
                boolean isValid = edTaiKhoan.getText().toString().trim().equals(user.getUserName()) && edPassword.getText().toString().trim().equals(user.getPassword());
                // nếu kquả trùng với user đã đăng ký thì start main activity
                if (isValid) {
                    Intent intent = new Intent(SignInActivity.this ,MainActivity.class);
                    // khởi tạo bundle để truyền user data cho MainActivity
                    Bundle bundle = new Bundle();
                    // vì user là object nên dùng putSerializable
                    bundle.putSerializable(Utils.KEY_USER_PROFILE, user);
                    // hoặc có thể dùng putString, nếu chỉ dùng username.
                    // bundle.putString,....

                    // put bundle cho intent
                    intent.putExtras(bundle);
                    startActivity(intent);
                    Toast.makeText(SignInActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                    // sau khi start main activity thì finish login activity
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(SignInActivity.this, "Đăng nhập không thành công", Toast.LENGTH_LONG).show();
                }
            }
        };
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