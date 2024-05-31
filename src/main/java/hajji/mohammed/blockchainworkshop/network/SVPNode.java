package hajji.mohammed.blockchainworkshop.network;

import hajji.mohammed.blockchainworkshop.entities.TransactionPool;


public class SVPNode extends Node{

    private final TransactionPool transactionPool;


    public SVPNode(TransactionPool transactionPool) {
        super(NodeType.SVP, null);
        this.transactionPool = transactionPool;
    }


    @Override
    public void run() {

    }


    @Override
    public TransactionPool getTransactionPool() {
        return null;
    }
}
