package com.assignment.payingguest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogout;
    private TextView txt_display;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initialize();

    }
    private void initialize(){
        txt_display = findViewById(R.id.tv_display);
        btnLogout = findViewById(R.id.btn_logout);
        preferences = getSharedPreferences("LoginLogout", Context.MODE_PRIVATE);
        editor = preferences.edit();
        txt_display.setText("Welcome, "+preferences.getString("user",""));
        btnLogout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_logout:
                editor.remove("user");
                editor.putBoolean("loginStatus",false).commit();
                Intent intent = new Intent(Dashboard.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;
        }
    }
}
