package com.assignment.payingguest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText uname,password;
    Button login;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

    }

    public void initialize(){

        uname=findViewById(R.id.et_uname);
        password=findViewById(R.id.et_password);

        login=findViewById(R.id.btn_login);
        login.setOnClickListener(this);

        preferences = getSharedPreferences("LoginLogout", Context.MODE_PRIVATE);
        editor = preferences.edit();

        if (preferences.getBoolean("loginStatus",false)){
            Intent intent = new Intent(MainActivity.this,Dashboard.class);
            startActivity(intent);
            finish();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String username = uname.getText().toString();
                String pwd = password.getText().toString();
                if (username.equals("admin") && pwd.equals("admin")) {
                    editor.putString("user", "admin").commit();
                    editor.putBoolean("loginStatus", true).commit();
                    Intent intent = new Intent(MainActivity.this, Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);
                    finish();

                    break;
                }

        }
    }
}
