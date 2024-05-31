package hajji.mohammed.blockchainworkshop.configuration;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.Cipher;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;

@Configuration
public class SecurityConfig {


    @Bean
    @SneakyThrows({NoSuchAlgorithmException.class, InvalidAlgorithmParameterException.class})
    public KeyPairGenerator keyPairGenerator() {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
        return keyPairGenerator;
    }

    @Bean
    @SneakyThrows({NoSuchAlgorithmException.class})
    public Signature ecdsaSignature() {
        return Signature.getInstance("SHA256withECDSA");
    }

}
