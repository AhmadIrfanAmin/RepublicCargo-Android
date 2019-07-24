package com.logixcess.republiccargo.gen_activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.logixcess.republiccargo.R;
import com.logixcess.republiccargo.customer.activities.MainActivity;

public class LoginActivity extends AppCompatActivity {

    TextView tv_signup;
    Button cirLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cirLoginButton = findViewById(R.id.cirLoginButton);
        tv_signup = findViewById(R.id.tv_signup);
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
    public void loginClick(View view)
    {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
