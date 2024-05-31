package hajji.mohammed.blockchainworkshop.managers;

import hajji.mohammed.blockchainworkshop.entities.Transaction;
import hajji.mohammed.blockchainworkshop.exceptions.InsufficientBalanceException;
import hajji.mohammed.blockchainworkshop.exceptions.NegativeOrNullAmountException;
import hajji.mohammed.blockchainworkshop.exceptions.WalletNotFoundException;
import hajji.mohammed.blockchainworkshop.services.SignatureManager;
import hajji.mohammed.blockchainworkshop.singletons.Wallets;
import hajji.mohammed.blockchainworkshop.wallets.Wallet;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class TransactionManagerImpl implements TransactionManager {

    private final SignatureManager signatureManager;

    @Override
    public boolean verifyTransaction(Transaction transaction) {
        if (Wallets.SINGLETON.containsWallet(transaction.getSender()))
            throw new WalletNotFoundException(transaction.getSender());

        if (Wallets.SINGLETON.containsWallet(transaction.getRecipient()))
            throw new WalletNotFoundException(transaction.getRecipient());

        Wallet senderWallet = Wallets.SINGLETON.getWallet(transaction.getSender());

        if (senderWallet.getBalance() < transaction.getAmount())
            throw new InsufficientBalanceException();


        return signatureManager
                .verify(
                        transaction.getSignature(),
                        transaction.getTransactionDetails(),
                        senderWallet.getPublicKey()
                );
    }

    @Override
    public Transaction transferFunds(String sender, String recipient, double amount) {
        if (Wallets.SINGLETON.containsWallet(sender))
            throw new WalletNotFoundException(sender);

        if (Wallets.SINGLETON.containsWallet(recipient))
            throw new WalletNotFoundException(recipient);

        if (amount <= 0)
            throw new NegativeOrNullAmountException();

        Wallet senderWallet = Wallets.SINGLETON.getWallet(sender);

        Transaction transaction = Transaction.builder()
                .sender(sender)
                .recipient(recipient)
                .amount(amount)
                .build();

        String transactionSignature = signatureManager
                .sign(transaction.getTransactionDetails(), senderWallet.getPrivateKey());

        transaction.setSignature(transactionSignature);
        return transaction;
    }

    @Override
    public void confirmTransaction(Transaction transaction) {
        String senderAddress = transaction.getSender();
        String recipientAddress = transaction.getRecipient();
        double amount = transaction.getAmount();

        if (Wallets.SINGLETON.containsWallet(senderAddress))
            throw new WalletNotFoundException(senderAddress);

        if (Wallets.SINGLETON.containsWallet(recipientAddress))
            throw new WalletNotFoundException(recipientAddress);

        if (amount <= 0)
            throw new NegativeOrNullAmountException();


        Wallet senderWallet = Wallets.SINGLETON.getWallet(senderAddress);
        Wallet recipientWallet = Wallets.SINGLETON.getWallet(recipientAddress);

        if (senderWallet.getBalance() < amount)
            throw new InsufficientBalanceException();

        senderWallet.setBalance(senderWallet.getBalance() - amount);
        recipientWallet.setBalance(recipientWallet.getBalance() + amount);

    }
}
