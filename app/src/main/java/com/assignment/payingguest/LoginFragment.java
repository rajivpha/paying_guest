package com.assignment.payingguest;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginFragment extends Fragment implements View.OnClickListener {

    EditText uname, password;
    Button login;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        uname = view.findViewById(R.id.et_uname);
        password = view.findViewById(R.id.et_password);

        login = view.findViewById(R.id.btn_login);
        login.setOnClickListener(this);

        preferences = this.getActivity().getSharedPreferences("LoginLogout", Context.MODE_PRIVATE);
        editor = preferences.edit();

        if (preferences.getBoolean("loginStatus", false)) {
            Intent intent = new Intent(getActivity(), Dashboard.class);
            startActivity(intent);
            getActivity().finish();
        }

        return view;


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
                    Intent intent = new Intent(getActivity(), Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);
                    getActivity().finish();

                    break;
                }
        }
    }
}
