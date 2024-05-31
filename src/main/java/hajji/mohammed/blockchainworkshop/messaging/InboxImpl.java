package hajji.mohammed.blockchainworkshop.messaging;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class InboxImpl implements Inbox {

    private final Queue<Message> messageQueue;

    public InboxImpl() {
        this.messageQueue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void receive(Message message) {
        messageQueue.offer(message);
    }

    @Override
    public Message read() {
        return messageQueue.poll();
    }
}
