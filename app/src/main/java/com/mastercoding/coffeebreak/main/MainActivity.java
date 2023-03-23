package com.mastercoding.coffeebreak.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.mastercoding.coffeebreak.R;

import com.mastercoding.coffeebreak.CreateAccount.Create_account;

public class MainActivity extends AppCompatActivity {
    TextView msgWelcome;
    Animation animation_txtWelcome;
    LottieAnimationView lottieAnimationView;
    FirebaseAuth mAuth = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //this code implement style front page in this app
        msgWelcome=findViewById(R.id.tv_welcome);
        lottieAnimationView=findViewById(R.id.splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Create_account.class);
                startActivity(intent);
            }
        },6000);

        animation_txtWelcome=AnimationUtils.loadAnimation(this,R.anim.anim_text);
        msgWelcome.setAnimation(animation_txtWelcome);

//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    sleep(3000);
//                    Intent i = new Intent(getApplicationContext(),Login.class);
//                    startActivity(i);
//                    finish();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        thread.start();

    }

//    @Override
//    public void onStart() {
//        super.onStart();
// if (mAuth.getCurrentUser()!=null){
//            startActivity(new Intent(this, Products.class));
//        }
//    }
}