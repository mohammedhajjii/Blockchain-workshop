package hajji.mohammed.blockchainworkshop.entities;

import java.util.UUID;

public record MinedBlock(
        UUID minerId,
        Block block,
        BlockType type) {
}
