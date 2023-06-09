package com.ugursahin.kriptoloji;

import android.os.Build;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class AESEncryption {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "ThisIsASecretKey";
    private static final String CHARSET = "UTF-8";


    public byte[] encrypt(String message) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(CHARSET), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        return cipher.doFinal(message.getBytes(CHARSET));
    }
    public String decrypt(byte[] encrypted) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(CHARSET), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decryptedBytes = cipher.doFinal(encrypted);
        return new String(decryptedBytes, CHARSET);
    }
}
