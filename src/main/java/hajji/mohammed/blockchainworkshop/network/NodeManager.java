package hajji.mohammed.blockchainworkshop.network;

import hajji.mohammed.blockchainworkshop.entities.Block;
import hajji.mohammed.blockchainworkshop.entities.Transaction;
import hajji.mohammed.blockchainworkshop.entities.TransactionPool;
import hajji.mohammed.blockchainworkshop.messaging.Message;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;

import java.util.UUID;

public interface NodeManager {
    void addNewNode(Node node);
    void reward(UUID minerID);

    void deliverMessage(Message message);
}
