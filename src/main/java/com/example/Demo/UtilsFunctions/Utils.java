package com.example.Demo.UtilsFunctions;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Utils {
    public static String generateOtp(){

        String characters = "0123456789";

        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(characters.length());
            otp.append(characters.charAt(randomIndex));
        }

        return otp.toString();
    }

    public static String hashEmail(String email) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(email.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }


}
