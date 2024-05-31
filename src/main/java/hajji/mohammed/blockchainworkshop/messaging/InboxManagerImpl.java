package hajji.mohammed.blockchainworkshop.messaging;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InboxManagerImpl implements InboxManager {

    private final Map<UUID, Inbox> inboxMap;

    public InboxManagerImpl() {
        this.inboxMap = new ConcurrentHashMap<>();
    }

    @Override
    public void send(Message message) {
        message.getReceivers()
                .forEach(uuid -> inboxMap.get(uuid).receive(message));
    }

    @Override
    public void createInbox(UUID nodeId, Inbox inbox) {
        inboxMap.put(nodeId, inbox);
    }
}
