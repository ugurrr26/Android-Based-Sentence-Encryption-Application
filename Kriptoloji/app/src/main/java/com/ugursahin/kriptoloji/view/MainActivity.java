package com.ugursahin.kriptoloji.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ugursahin.kriptoloji.AESEncryption;
import com.ugursahin.kriptoloji.R;
import com.ugursahin.kriptoloji.databinding.ActivityMainBinding;

import java.util.Base64;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    byte[] sifrelenmisVeri;
    private  String dekirVeri;
    private String dekripteOlacakVeri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }
    public void aesEncrypt(View view){

        AESEncryption aesEncryption = new AESEncryption();

        try {
            String sifrelenecekVeri = binding.editTextMetin.getText().toString();
            if(sifrelenecekVeri.equals("")){
                Toast.makeText(MainActivity.this, "Please Enter Text To Encrypt!", Toast.LENGTH_LONG).show();
                return;
            }
            sifrelenmisVeri = aesEncryption.encrypt(sifrelenecekVeri);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                binding.textViewSonuc.setText(Base64.getEncoder().encodeToString(sifrelenmisVeri));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void aesDecrypt(View view){
        AESEncryption aesEncryption = new AESEncryption();
        try {
            dekripteOlacakVeri=binding.textViewSonuc.getText().toString();
            if(dekripteOlacakVeri.equals("")){
                Toast.makeText(MainActivity.this, "Please Encrypt a Text First!", Toast.LENGTH_LONG).show();
                return;
            }
            dekirVeri = aesEncryption.decrypt(sifrelenmisVeri);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        binding.textViewDecrypt.setText(dekirVeri);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.aes_select ){

        }
        if (item.getItemId() == R.id.blowfish_select){
            Intent intent = new Intent(MainActivity.this,BlowfishActivity.class);
            startActivity(intent);
            finish();
        }
        if (item.getItemId() ==R.id.des_select){
            Intent intent = new Intent(MainActivity.this,DESActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}