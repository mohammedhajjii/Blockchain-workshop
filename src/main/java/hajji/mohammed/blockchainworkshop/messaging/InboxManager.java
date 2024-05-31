package hajji.mohammed.blockchainworkshop.messaging;

import java.util.UUID;

public interface InboxManager {
    void send(Message message);
    void createInbox(UUID nodeId, Inbox inbox);
}
