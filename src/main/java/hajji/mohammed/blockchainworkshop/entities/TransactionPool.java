package hajji.mohammed.blockchainworkshop.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


@Component
public class TransactionPool {

    private final Queue<Transaction> transactionQueue;

    public TransactionPool() {
        this.transactionQueue = new ConcurrentLinkedQueue<>();
    }

    public  void addTransaction(Transaction transaction){
        transactionQueue.offer(transaction);
    }

    public  Queue<Transaction> getPendingTransactions(){
        return transactionQueue;
    }

    public  boolean removeTransaction(Transaction transaction){
        return transactionQueue.remove(transaction);
    }


}
