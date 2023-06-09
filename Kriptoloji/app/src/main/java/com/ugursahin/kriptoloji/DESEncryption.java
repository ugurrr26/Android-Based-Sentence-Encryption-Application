package com.ugursahin.kriptoloji;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class DESEncryption {
    private static final String secretKeyString = "gizliana";



    public String encryptDes(String plainText) throws Exception {

        // DES şifreleme algoritmasını kullanarak SecretKey oluşturma
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey secretKey = new SecretKeySpec(secretKeyString.getBytes(), "DES");

        // Şifreleme işlemi
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        // Şifrelenmiş veriyi base64 formatına çevirme
        String encodedEncryptedText = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encodedEncryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        }

        return encodedEncryptedText;
    }
    public String decryptDes(String encodedEncryptedText) throws Exception {
        // DES şifreleme algoritmasını kullanarak SecretKey oluşturma
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey secretKey = new SecretKeySpec(secretKeyString.getBytes(), "DES");

        // Şifre çözme işlemi
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = new byte[0];
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encodedEncryptedText));
        }

        // Şifresi çözülmüş veriyi string formatına çevirme
        String decryptedText = new String(decryptedBytes);

        return decryptedText;
    }
}
