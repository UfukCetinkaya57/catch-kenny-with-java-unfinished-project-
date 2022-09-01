package com.ufukcetinkaya.catchkenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
       // hideImages();
        score = 0;
        new CountDownTimer(5000,500) {

            @Override
            public void onTick(long millisUntilFinished) {
                        Random r=new Random();
                        int a=r.nextInt(550);
                        int b = r.nextInt(1050);
                        imageView.setX(a);
                        imageView.setY(b);
            }
            @Override
            public void onFinish() {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Finished");
                alert.setCancelable(false);
                if(score >= 10){
                    alert.setMessage("Oyunu kazandınız! Skorunuz " + score +  " Oyuna yeniden başlamak istiyor musunuz?");

                }
                else{
                   int count =10-score;
                    alert.setMessage("Oyunu kazanamadınız! Oyunu kazanmak için: " + count +  " kere daha yakalamanız gerekiyordu. Oyuna yeniden başlamak  istiyor musunuz?");
                }
                    //zorluk levelleri de eklenerek yapılsın.
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                });

                 alert.show();

            }
        }.start();
    }

        //ekrandaki başka yere tıklandığında skoru artırma

    public void fail(View view){

    }
    public void imageClick(View view){
        score +=1;
    }

}