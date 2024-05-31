package hajji.mohammed.blockchainworkshop.singletons;

import hajji.mohammed.blockchainworkshop.wallets.Wallet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Wallets {
    SINGLETON;

    private final Map<String, Wallet> walletHashMap = new ConcurrentHashMap<>();

    public Wallet getWallet(String address){
        return walletHashMap.get(address);
    }
    public void putWallet(Wallet wallet){
        walletHashMap.put(wallet.getAddress(), wallet);
    }

    public boolean containsWallet(String address){
        return walletHashMap.containsKey(address);
    }
}
