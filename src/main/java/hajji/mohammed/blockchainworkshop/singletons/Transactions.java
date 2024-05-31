package hajji.mohammed.blockchainworkshop.singletons;

import hajji.mohammed.blockchainworkshop.entities.Transaction;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum Transactions {
    SINGLETON;
    private final Queue<Transaction> transactionQueue = new ConcurrentLinkedQueue<>();
    private final Lock lock = new ReentrantLock();
    public void putTransaction(Transaction transaction){
        lock.lock();
        try{
            transactionQueue.offer(transaction);
        }finally {
            lock.unlock();
        }
    }
    public Set<Transaction> getTransaction(int limit){
        lock.lock();
        try{

            Set<Transaction> transactionSet = IntStream.iterate(0, i -> i < limit, i -> i + 1)
                    .mapToObj(i -> transactionQueue.poll())
                    .collect(Collectors.toSet());
            return transactionSet;
        }finally {
            lock.unlock();
        }
    }

}
