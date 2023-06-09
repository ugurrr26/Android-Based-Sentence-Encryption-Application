package com.ugursahin.kriptoloji;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class BlowfishEncryption {
    private static final String secretKeyString = "ThisIsASecretKey";



    public String encryptBlowfish(String plainText) throws Exception {
        // Blowfish şifreleme algoritmasını kullanarak SecretKey oluşturma
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        SecretKey secretKey = new SecretKeySpec(secretKeyString.getBytes(), "Blowfish");

        // Şifreleme işlemi
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        // Şifrelenmiş veriyi base64 formatına çevirme
        String encodedEncryptedText = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encodedEncryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        }

        return encodedEncryptedText;
    }

    public String decryptBlowfish(String encodedEncryptedText) throws Exception {
        // Blowfish şifreleme algoritmasını kullanarak SecretKey oluşturma
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        SecretKey secretKey = new SecretKeySpec(secretKeyString.getBytes(), "Blowfish");

        // Şifre çözme işlemi
        Cipher cipher = Cipher.getInstance("Blowfish");
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
