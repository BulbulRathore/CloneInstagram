package com.example.cloneinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpLoginActivity extends AppCompatActivity {

    private EditText edtSignupUsername, edtSignupPassword, edtLoginUsername, edtLoginPassword;
    private Button btnSignup, btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_login_activity);

        edtSignupUsername = findViewById(R.id.edtSignupUsername);
        edtSignupPassword = findViewById(R.id.edtSignupPassword);
        edtLoginUsername = findViewById(R.id.edtLoginUsername);
        edtLoginPassword = findViewById(R.id.edtLoginPassword);

        btnSignup = findViewById(R.id.btnSignup);
       btnLogin = findViewById(R.id.btnLogin);

       btnSignup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final ParseUser appUser = new ParseUser();
               appUser.setUsername(edtSignupUsername.getText().toString());
               appUser.setPassword(edtSignupPassword.getText().toString());

               appUser.signUpInBackground(new SignUpCallback() {
                   @Override
                   public void done(ParseException e) {
                       if(e == null){
                           FancyToast.makeText(SignUpLoginActivity.this,appUser.get("username")+" is signed up successfully!!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                           Intent intent = new Intent(SignUpLoginActivity.this, WelcomeActivity.class);
                           startActivity(intent);
                       } else{
                           FancyToast.makeText(SignUpLoginActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                       }
                   }
               });
           }
       });

       btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ParseUser.logInInBackground(edtLoginUsername.getText().toString(), edtLoginPassword.getText().toString(), new LogInCallback() {
                   @Override
                   public void done(ParseUser user, ParseException e) {
                        if(user != null && e == null){
                            FancyToast.makeText(SignUpLoginActivity.this,user.get("username")+" is login successfully!!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                            Intent intent = new Intent(SignUpLoginActivity.this, WelcomeActivity.class);
                            startActivity(intent);
                        } else {
                            FancyToast.makeText(SignUpLoginActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                   }
               });
           }
       });

    }
}
