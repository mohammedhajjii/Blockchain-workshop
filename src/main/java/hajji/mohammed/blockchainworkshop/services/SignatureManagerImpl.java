package hajji.mohammed.blockchainworkshop.services;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

@Service
@AllArgsConstructor
public class SignatureManagerImpl implements SignatureManager {

    private final Signature ecdsaSignature;

    @Override
    @SneakyThrows({InvalidKeyException.class, SignatureException.class})
    public String sign(String data, PrivateKey privateKey) {
        ecdsaSignature.initSign(privateKey);
        ecdsaSignature.update(data.getBytes());
        return Base64.getEncoder().encodeToString(ecdsaSignature.sign());
    }

    @Override
    @SneakyThrows({InvalidKeyException.class, SignatureException.class})
    public boolean verify(String signature, String signedData, PublicKey publicKey){
        ecdsaSignature.initVerify(publicKey);
        ecdsaSignature.update(signedData.getBytes());
        return ecdsaSignature.verify(Base64.getDecoder().decode(signature));
    }
}
