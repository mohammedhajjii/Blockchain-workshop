package hajji.mohammed.blockchainworkshop.messaging;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public interface Inbox {
    void receive(Message message);
    Message read();
}
