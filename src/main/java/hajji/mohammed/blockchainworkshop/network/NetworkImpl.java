package hajji.mohammed.blockchainworkshop.network;

import hajji.mohammed.blockchainworkshop.configuration.NetworkConfiguration;
import hajji.mohammed.blockchainworkshop.entities.TransactionPool;
import hajji.mohammed.blockchainworkshop.messaging.Message;
import hajji.mohammed.blockchainworkshop.messaging.MessagePool;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

@Component
public class NetworkImpl implements Network {

    private final Set<Node> nodeSet;
    private final MessagePool messagePool;
    private final TransactionPool transactionPool;

    private final NetworkConfiguration networkConfiguration;

    public NetworkImpl(MessagePool messagePool, TransactionPool transactionPool, NetworkConfiguration networkConfiguration) {
        this.messagePool = messagePool;
        this.transactionPool = transactionPool;
        this.networkConfiguration = networkConfiguration;
        this.nodeSet = new ConcurrentSkipListSet<>();
    }

    @Override
    public void init() {

    }

    @Override
    public Set<Node> getNodesByType(NodeType nodeType) {
        return nodeSet.stream()
                .filter(node -> node.getNodeType() == nodeType)
                .collect(Collectors.toSet());
    }

    @Override
    public Node getNodeById(UUID nodeId) {
        return nodeSet.stream()
                .filter(node -> node.getID().equals(nodeId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void send(Message message) {

    }

    @Override
    public void newTransactionRequest(String sender, String recipient, double amount) {

    }
}
