package hajji.mohammed.blockchainworkshop.managers;

import hajji.mohammed.blockchainworkshop.entities.Transaction;

public interface TransactionManager {
    boolean verifyTransaction(Transaction transaction);
    Transaction transferFunds(String sender, String recipient, double amount);
    void confirmTransaction(Transaction transaction);
}
