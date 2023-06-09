package com.ugursahin.kriptoloji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ugursahin.kriptoloji.view.BlowfishActivity;
import com.ugursahin.kriptoloji.view.DESActivity;
import com.ugursahin.kriptoloji.view.MainActivity;

public class BeginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
    }
    public void desScreen(View view){
        Intent intent = new Intent(BeginActivity.this, DESActivity.class);
        startActivity(intent);

    }
    public void aesScreen(View view){
        Intent intent = new Intent(BeginActivity.this, MainActivity.class);
        startActivity(intent);

    }
    public void blowfishScreen(View view){
        Intent intent = new Intent(BeginActivity.this, BlowfishActivity.class);
        startActivity(intent);

    }
}