package hajji.mohammed.blockchainworkshop.network;

import hajji.mohammed.blockchainworkshop.entities.Block;
import hajji.mohammed.blockchainworkshop.entities.Transaction;
import hajji.mohammed.blockchainworkshop.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NodeManagerImpl implements NodeManager {

    private final Map<UUID, Node> nodeMap;

    public NodeManagerImpl() {
        this.nodeMap = new ConcurrentHashMap<>();
    }

    @Override
    public void addNewNode(Node node) {
        nodeMap.put(node.getID(), node);
    }

    @Override
    public void reward(UUID minerID) {
        Miner miner = (Miner) nodeMap.get(minerID);
        miner.reward();
    }

    @Override
    public void deliverMessage(Message message) {

    }

}
