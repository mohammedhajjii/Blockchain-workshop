package hajji.mohammed.blockchainworkshop.entities;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;


public class Blockchain {
    private final Deque<Block> chain;
    public Blockchain() {
        this.chain = new ConcurrentLinkedDeque<>();
    }
    private static int difficulty = 1;
    public void addBlock(Block block){
        chain.push(block);
    }
    public Block getBlockByIndex(int index){
        return chain.stream()
                .filter(block -> block.getIndex() == index)
                .findFirst()
                .orElse(null);
    }

    public Block getLatestBlock(){
        return chain.peek();
    }

    public static void adjustDifficulty(){
        difficulty += 1;
    }
}
