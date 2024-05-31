package hajji.mohammed.blockchainworkshop.network;

import hajji.mohammed.blockchainworkshop.entities.Block;
import hajji.mohammed.blockchainworkshop.entities.BlockType;
import hajji.mohammed.blockchainworkshop.entities.MinedBlock;
import hajji.mohammed.blockchainworkshop.entities.TransactionPool;
import hajji.mohammed.blockchainworkshop.messaging.InboxManager;
import hajji.mohammed.blockchainworkshop.process.MiningProcess;
import hajji.mohammed.blockchainworkshop.utils.HashUtil;

import java.util.stream.IntStream;

public class Miner extends Node implements MiningProcess {
    private final TransactionPool transactionPool;
    private double score;

    public Miner(TransactionPool transactionPool, InboxManager inboxManager) {
        super(NodeType.MINER, inboxManager);
        this.score = 0.0;
        this.transactionPool = transactionPool;
    }

    @Override
    public void run() {


    }


    public void reward(){
        this.score += 0.5;
    }


    @Override
    public MinedBlock mineBlock(Block block, int difficulty, BlockType type) {
        IntStream.iterate(
                0,
                value -> {
                    String blockDataPlusNonce = block.toString() + value;
                    return !HashUtil.generateSHA256Hash(blockDataPlusNonce)
                            .startsWith("0".repeat(difficulty));

                },
                value -> value + 1
        ).max().ifPresent(value -> {
            int nonce = value + 1;
            block.setNonce(nonce);
            block.setCurrentHash(HashUtil.generateSHA256Hash(block.getBlockDetails()));
        });

        return new MinedBlock(this.ID, block, type);
    }

    @Override
    public TransactionPool getTransactionPool() {
        return this.transactionPool;
    }
}
