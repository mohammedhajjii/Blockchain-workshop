package hajji.mohammed.blockchainworkshop.network;

import hajji.mohammed.blockchainworkshop.entities.TransactionPool;
import hajji.mohammed.blockchainworkshop.messaging.InboxManager;
import hajji.mohammed.blockchainworkshop.messaging.Message;
import hajji.mohammed.blockchainworkshop.messaging.MessagePool;
import lombok.Getter;
import lombok.Setter;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

@Getter @Setter
public abstract class Node implements Runnable{
    protected final UUID ID;
    protected final Queue<Message> inbox;
    protected final NodeType nodeType;
    protected final InboxManager inboxManager;

    public Node(NodeType type, InboxManager inboxManager) {
        this.ID = UUID.randomUUID();
        this.inbox = new ConcurrentLinkedQueue<>();
        this.nodeType = type;
        this.inboxManager = inboxManager;
    }

    public void sendMessage(Message message){
        inboxManager.send(message);
    }

    public abstract TransactionPool getTransactionPool();

}
