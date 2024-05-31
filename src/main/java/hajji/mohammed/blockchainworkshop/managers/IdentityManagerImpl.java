package hajji.mohammed.blockchainworkshop.managers;

import hajji.mohammed.blockchainworkshop.exceptions.NegativeOrNullAmountException;
import hajji.mohammed.blockchainworkshop.singletons.Wallets;
import hajji.mohammed.blockchainworkshop.utils.HashUtil;
import hajji.mohammed.blockchainworkshop.wallets.Wallet;
import lombok.AllArgsConstructor;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

@AllArgsConstructor
public class IdentityManagerImpl implements IdentityManager {

    private final KeyPairGenerator ecKeyPairGenerator;

    @Override
    public Wallet registerNewClient(double initialBalance) {
        if (initialBalance <= 0)
            throw new NegativeOrNullAmountException();

        KeyPair generatedKeyPair = ecKeyPairGenerator.generateKeyPair();
        PublicKey publicKey = generatedKeyPair.getPublic();
        PrivateKey privateKey = generatedKeyPair.getPrivate();
        String publicKeyHash = HashUtil
                .generateSHA256Hash(Base64.getEncoder().encodeToString(publicKey.getEncoded()));


        Wallet wallet = Wallet.builder()
                .address(publicKeyHash)
                .publicKey(publicKey)
                .privateKey(privateKey)
                .balance(initialBalance)
                .build();

        Wallets.SINGLETON.putWallet(wallet);

        return wallet;
    }
}
