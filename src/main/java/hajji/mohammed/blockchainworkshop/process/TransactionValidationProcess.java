package hajji.mohammed.blockchainworkshop.process;

import hajji.mohammed.blockchainworkshop.entities.Transaction;

public interface TransactionValidationProcess {

    boolean validateTransaction(Transaction transaction);
}
