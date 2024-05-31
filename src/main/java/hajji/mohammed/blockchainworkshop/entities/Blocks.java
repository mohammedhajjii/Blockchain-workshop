package hajji.mohammed.blockchainworkshop.entities;

import hajji.mohammed.blockchainworkshop.utils.HashUtil;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

public class Blocks {

    public static  Block generateBlock(
            int index,
            String previousHash,
            List<Transaction> transactions){
        return Block.builder()
                .index(index)
                .timeStamp(Instant.now())
                .previousHash(previousHash)
                .nonce(0)
                .transactionList(transactions)
                .build();
    }

    public static String calculateHash(Block block){
        return HashUtil.generateSHA256Hash(block.getBlockDetails());
    }

    public static Block gensisBlock(){
        return generateBlock(0, null, List.of());
    }

}
