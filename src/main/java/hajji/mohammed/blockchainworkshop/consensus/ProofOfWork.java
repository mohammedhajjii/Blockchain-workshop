package hajji.mohammed.blockchainworkshop.consensus;

import hajji.mohammed.blockchainworkshop.entities.Block;
import hajji.mohammed.blockchainworkshop.utils.HashUtil;

import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ProofOfWork implements Consensus {
    @Override
    public Block mineBlock(Block block, int difficulty) {

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
            block.setCurrentHash(HashUtil.generateSHA256Hash(block.toString() + nonce));
        });

        return block;
    }
}
