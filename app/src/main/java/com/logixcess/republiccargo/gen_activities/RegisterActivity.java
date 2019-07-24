package com.logixcess.republiccargo.gen_activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.logixcess.republiccargo.R;
import com.logixcess.republiccargo.customer.activities.MainActivity;

public class RegisterActivity extends AppCompatActivity {

    TextView tv_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tv_signin = findViewById(R.id.tv_signin);
        tv_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
    public void signup_Click(View view)
    {
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }

}
