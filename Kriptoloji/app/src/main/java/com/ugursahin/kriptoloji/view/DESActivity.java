package com.ugursahin.kriptoloji.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ugursahin.kriptoloji.DESEncryption;
import com.ugursahin.kriptoloji.R;
import com.ugursahin.kriptoloji.databinding.ActivityDesactivityBinding;

public class DESActivity extends AppCompatActivity {
    private ActivityDesactivityBinding binding;
    private String sifrelenmisVeri;
    private String dekripteOlacakVeri;
    private  String dekirVeri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDesactivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
    public void desEncrypt(View view){
        DESEncryption desEncryption = new DESEncryption();
        String sifrelenecekVeri = binding.editTextMetin.getText().toString();
        if (sifrelenecekVeri.equals("")) {
            Toast.makeText(DESActivity.this, "Please Enter Text To Encrypt!", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            sifrelenmisVeri = desEncryption.encryptDes(sifrelenecekVeri);
            binding.textViewSonuc.setText(sifrelenmisVeri);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void desDecrypt(View view){
        DESEncryption desEncryption = new DESEncryption();
        dekripteOlacakVeri=binding.textViewSonuc.getText().toString();
        if(dekripteOlacakVeri.equals("")){
            Toast.makeText(DESActivity.this, "Please Encrypt a Text First!", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            dekirVeri = desEncryption.decryptDes(sifrelenmisVeri);
            binding.textViewDecrypt.setText(dekirVeri);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
            Intent intent = new Intent(DESActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        if (item.getItemId() == R.id.blowfish_select){
            Intent intent = new Intent(DESActivity.this,BlowfishActivity.class);
            startActivity(intent);
            finish();
        }
        if (item.getItemId() ==R.id.des_select){

        }
        return super.onOptionsItemSelected(item);
    }
}