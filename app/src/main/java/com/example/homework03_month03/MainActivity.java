package com.example.homework03_month03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button skipBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skipBtn=findViewById(R.id.skip_btn);
        nextBtn=findViewById(R.id.next_btn);

        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.container_fl,new FirstFragment()).commit();
        }

    nextBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           if (fragment()instanceof FirstFragment){
               getSupportFragmentManager().beginTransaction().replace(R.id.container_fl,new SecondFragment()).addToBackStack(null).commit();
           }else if (fragment() instanceof SecondFragment){
               getSupportFragmentManager().beginTransaction().replace(R.id.container_fl,new ThirdFragment()).addToBackStack(null).commit();
           }
        }
    });
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             getSupportFragmentManager().beginTransaction().replace(R.id.container_fl,new ThirdFragment()).commit();
            }
        });
    }
    public Fragment fragment(){
        return getSupportFragmentManager().findFragmentById(R.id.container_fl);
    }
}