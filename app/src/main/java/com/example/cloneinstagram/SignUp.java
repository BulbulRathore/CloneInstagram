package com.example.cloneinstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button btnsave;
    private EditText edtName,edtpunchSpeed,edtpunchPower,edtkickSpeed,edtkickPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave = findViewById(R.id.btnSave);
        edtName = findViewById(R.id.edtName);
        edtpunchPower = findViewById(R.id.edtpunchPower);
        edtpunchSpeed = findViewById(R.id.edtpunchSpeed);
        edtkickSpeed = findViewById(R.id.edtkickSpeed);
        edtkickPower = findViewById(R.id.edtkickPower);

        btnsave.setOnClickListener(SignUp.this);
    }

    @Override
    public void onClick(View btnView) {
        try {
            final ParseObject kickboxer = new ParseObject("Kickboxer");
            kickboxer.put("punch_speed", Integer.parseInt(edtpunchSpeed.getText().toString()));
            kickboxer.put("punch_power", Integer.parseInt(edtpunchPower.getText().toString()));
            kickboxer.put("name", edtName.getText().toString());
            kickboxer.put("kick_power", edtkickPower.getText().toString());
            kickboxer.put("kick_speed", edtkickSpeed.getText().toString());

            kickboxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(SignUp.this, "Object is saved", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                    } else {
                        FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                    }
                }
            });
        } catch (Exception e){
            FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

        }
    }

    //    public void HelloWorldIsPressed(View view){
//        ParseObject boxer = new ParseObject("Boxer");
//        ParseObject kickboxer = new ParseObject("Kickboxer");
//        kickboxer.put("punch_speed",400);
//        kickboxer.put("punch_power",399);
//        kickboxer.put("name","Bulbul");
//        boxer.put("punch_speed",200);
//        boxer.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if(e == null){
//                    Toast.makeText(SignUp.this,"Object is successfully saved",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//        kickboxer.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if(e == null){
//                    Toast.makeText(SignUp.this,"Kickboxer Object is successfully saved",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//    }
}
