package hajji.mohammed.blockchainworkshop.services;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface SignatureManager {
    String sign(String data, PrivateKey privateKey);
    boolean verify(String signature, String signedData, PublicKey publicKey);
}
