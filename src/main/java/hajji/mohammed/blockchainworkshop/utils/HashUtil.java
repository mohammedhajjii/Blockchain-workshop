package hajji.mohammed.blockchainworkshop.utils;

import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashUtil {
    @SneakyThrows({NoSuchAlgorithmException.class})
    public static String generateSHA256Hash(String data) {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }
}
