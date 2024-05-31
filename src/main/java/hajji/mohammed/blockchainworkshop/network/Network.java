package hajji.mohammed.blockchainworkshop.network;

import hajji.mohammed.blockchainworkshop.configuration.NetworkConfiguration;
import hajji.mohammed.blockchainworkshop.messaging.Message;

import java.util.Set;
import java.util.UUID;

public interface Network {

    void init();

    Set<Node> getNodesByType(NodeType nodeType);

    Node getNodeById(UUID nodeId);

    void send(Message message);

    void newTransactionRequest(String sender, String recipient, double amount);



}
