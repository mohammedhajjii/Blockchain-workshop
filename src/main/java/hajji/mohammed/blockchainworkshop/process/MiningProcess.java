package hajji.mohammed.blockchainworkshop.process;

import hajji.mohammed.blockchainworkshop.entities.Block;
import hajji.mohammed.blockchainworkshop.entities.BlockType;
import hajji.mohammed.blockchainworkshop.entities.MinedBlock;

public interface MiningProcess {
    MinedBlock mineBlock(Block block, int difficulty, BlockType type);
}
