package com.logixcess.republiccargo.gen_activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.logixcess.republiccargo.ApiUtils.RetrofitClientInstance;
import com.logixcess.republiccargo.R;
import com.logixcess.republiccargo.customer.activities.MainActivity;
import com.logixcess.republiccargo.interfaces.GetDataService;
import com.logixcess.republiccargo.models.User;
import com.logixcess.republiccargo.utils.Helper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    TextView tv_signin;
    EditText et_email,et_name,et_password;
    Spinner sp_user_types;
    GetDataService dataService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_email = findViewById(R.id.et_email);
        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);
        sp_user_types = findViewById(R.id.sp_user_types);
        tv_signin = findViewById(R.id.tv_signin);
        tv_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        dataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
    }
    private Boolean validate()
    {
        if(TextUtils.isEmpty(et_email.getText()))
        {
            et_email.setError("Email needs to be filled up");
            return false;
        }
        if(TextUtils.isEmpty(et_name.getText()))
        {
            et_name.setError("Name needs to be filled up");
            return false;
        }
        if(TextUtils.isEmpty(et_password.getText()))
        {
            et_password.setError("Password needs to be filled up");
            return false;
        }
        return true;
    }
    public void signup_Click(View view)
    {
        if(validate())
        {
            User user = new User(et_name.getText().toString(),et_email.getText().toString(),et_password.getText().toString(),sp_user_types.getSelectedItem().toString());
            /**
             Create new user
             **/
            Call<User> call1 = dataService.createUser(user);
            call1.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user1 = response.body();
                    if(user1 != null)
                    {
                        Helper.my_user = user1;
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    }

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    call.cancel();
                }
            });
        }
        else
        {
            return;
        }
    }

}
