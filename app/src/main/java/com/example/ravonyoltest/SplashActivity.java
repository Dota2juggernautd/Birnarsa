package com.example.ravonyoltest;
import android.content.Intent;

import android.media.Image;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

//    private static int SPLASH_SCREEN_TIME_OUT=5000;
//    #After completion of 2000 ms, the next activity will get started.
    Button kirish,royxatdan_otish,next,main_kirish;
    TextView regestration,kirish_text;
    EditText email , parol,login, parol1;
    ImageView mvd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        royxatdan_otish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvd.setVisibility(View.GONE);
                kirish.setVisibility(View.GONE);
                royxatdan_otish.setVisibility(View.GONE);
                parol.setVisibility(View.VISIBLE);
                email.setVisibility(View.VISIBLE);
                regestration.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SplashActivity.this, "Malumotlar saqlandi", Toast.LENGTH_SHORT).show();
            }
        });

        kirish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parol.setVisibility(View.GONE);
                email.setVisibility(View.GONE);
                regestration.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                kirish_text.setVisibility(View.VISIBLE);
                login.setVisibility(View.VISIBLE);
                parol1.setVisibility(View.VISIBLE);
                main_kirish.setVisibility(View.VISIBLE);
            }
        });
        main_kirish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
    private void init(){
        mvd = findViewById(R.id.mvd);
        kirish = findViewById(R.id.kirish);
        royxatdan_otish = findViewById(R.id.royhatdan_otish);
        parol = findViewById(R.id.parol);
        email = findViewById(R.id.email);
        regestration = findViewById(R.id.regestration);
        next = findViewById(R.id.next);
        kirish_text = findViewById(R.id.kirish_text);
        login = findViewById(R.id.login);
        parol1 = findViewById(R.id.parol1);
        main_kirish = findViewById(R.id.kirish_main);


    }

}
//    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        //This method is used so that your splash activity
//        //can cover the entire screen.
//
//        setContentView(R.layout.activity_splash);
//        //this will bind your MainActivity.class file with activity_main.
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent i=new Intent(SplashActivity.this,MainActivity.class);
//                //Intent is used to switch from one activity to another.
//
//                startActivity(i);
//                //invoke the SecondActivity.
//
//                finish();
//                //the current activity will get finished.
//            }
//        }, SPLASH_SCREEN_TIME_OUT);
