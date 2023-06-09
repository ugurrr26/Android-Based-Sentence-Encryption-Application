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

import com.ugursahin.kriptoloji.R;
import com.ugursahin.kriptoloji.databinding.ActivityBlowfishBinding;
import com.ugursahin.kriptoloji.BlowfishEncryption;

public class BlowfishActivity extends AppCompatActivity {

    private ActivityBlowfishBinding binding;
    private String sifrelenmisVeri;
    private String dekripteOlacakVeri;
    private  String dekirVeri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBlowfishBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
    public void blowfishEncrypt(View view) {
        BlowfishEncryption blowfishEncryption = new BlowfishEncryption();
        String sifrelenecekVeri = binding.editTextMetin.getText().toString();
        if (sifrelenecekVeri.equals("")) {
            Toast.makeText(BlowfishActivity.this, "Please Enter Text To Encrypt!", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            sifrelenmisVeri = blowfishEncryption.encryptBlowfish(sifrelenecekVeri);
            binding.textViewSonuc.setText(sifrelenmisVeri);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void blowfishDecrypt(View view){
        BlowfishEncryption blowfishEncryption = new BlowfishEncryption();

        dekripteOlacakVeri=binding.textViewSonuc.getText().toString();
        if(dekripteOlacakVeri.equals("")){
            Toast.makeText(BlowfishActivity.this, "Please Encrypt a Text First!", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            dekirVeri = blowfishEncryption.decryptBlowfish(sifrelenmisVeri);
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
            Intent intent = new Intent(BlowfishActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        if (item.getItemId() == R.id.blowfish_select){

        }
        if (item.getItemId() ==R.id.des_select){
            Intent intent = new Intent(BlowfishActivity.this,DESActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}