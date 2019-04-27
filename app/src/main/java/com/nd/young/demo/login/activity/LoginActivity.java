package com.nd.young.demo.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.nd.young.demo.login.R;
import com.nd.young.demo.login.service.UserService;

public class LoginActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 10001;
    private EditText mEtUserName;
    private EditText mEtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // New 一个Model 出来，该Model具有登陆逻辑
        final UserService userService = new UserService();
        mEtUserName = findViewById(R.id.etUserName);
        mEtPassword = findViewById(R.id.etPassword);
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = mEtUserName.getText().toString();
                String password = mEtPassword.getText().toString();
                boolean login = userService.login(userName, password);
                ResultActivity.start(LoginActivity.this, REQUEST_CODE, login);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE:
                if (resultCode != RESULT_OK) {
                    mEtUserName.requestFocus();
                    mEtUserName.setText("");
                    mEtPassword.setText("");
                }
                break;
        }
    }
}
