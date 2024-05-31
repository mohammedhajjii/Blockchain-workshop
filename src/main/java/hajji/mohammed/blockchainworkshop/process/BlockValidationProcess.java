package hajji.mohammed.blockchainworkshop.process;

import hajji.mohammed.blockchainworkshop.entities.Block;

public interface BlockValidationProcess extends TransactionValidationProcess{
    void validateBlock(Block block);
}
