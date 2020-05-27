package com.example.cloneinstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class WelcomeActivity extends AppCompatActivity {

    private Button btnWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnWelcome = findViewById(R.id.btnWelcome);
        btnWelcome.setText("Welcome " + ParseUser.getCurrentUser().get("username") );

        findViewById(R.id.btnLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                finish();
                FancyToast.makeText(WelcomeActivity.this,ParseUser.getCurrentUser().get("username")+" is successfully logout", Toast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
            }
        });
    }
}
