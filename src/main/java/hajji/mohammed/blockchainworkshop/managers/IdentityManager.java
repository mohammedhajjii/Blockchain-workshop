package hajji.mohammed.blockchainworkshop.managers;

import hajji.mohammed.blockchainworkshop.wallets.Wallet;

public interface IdentityManager {
    Wallet registerNewClient(double initialBalance);
}
