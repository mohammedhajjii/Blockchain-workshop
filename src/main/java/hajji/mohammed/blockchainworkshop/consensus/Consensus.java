package hajji.mohammed.blockchainworkshop.consensus;

import hajji.mohammed.blockchainworkshop.entities.Block;

public interface Consensus {
    Block mineBlock(Block block, int difficulty);
}
