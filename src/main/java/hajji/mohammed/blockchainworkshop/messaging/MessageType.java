package hajji.mohammed.blockchainworkshop.messaging;

public enum MessageType {
    TRANSACTION_REQUEST,
    TRANSACTION_RESPONSE,
    NEW_MINED_BLOCK,
    REWARD,
    BLOCKCHAIN_SNAPSHOT_REQUEST,
    BLOCKCHAIN_SNAPSHOT_RESPONSE,
    BLOCK_INFOS_REQUEST,
    BLOCK_INFOS_RESPONSE,
    CREATE_CLIENT_REQUEST,
    CREATE_CLIENT_RESPONSE
}
