package hajji.mohammed.blockchainworkshop.wallets;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;
import java.security.PublicKey;

@Getter @Setter @Builder
public class Wallet {
    private String address;
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private Double balance;
}
