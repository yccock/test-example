package com.test.tools.util;

import java.security.MessageDigest;

public class EncryptUtil {

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static final String salt = "encrypt-test";
    private static final String algorithm = "SHA";


    public static String encode(String rawToken) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            result = byteArrayToHexString(md.digest(mergeTokenAndSalt(rawToken).getBytes("utf-8")));
        } catch (Exception ex) {
        }
        return result;
    }

    public static boolean isTokenValid(String encToken, String rawToken) {
        String pass1 = "" + encToken;
        String pass2 = encode(rawToken);

        return pass1.equals(pass2);
    }

    private static String mergeTokenAndSalt(String token) {
        if (token == null) {
            token = "";
        }

        if ((salt == null) || "".equals(salt)) {
            return token;
        } else {
            return token + "[" + salt.toString() + "]";
        }
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static void main(String[] args) {
        System.out.println(encode("test"));
    }
}
