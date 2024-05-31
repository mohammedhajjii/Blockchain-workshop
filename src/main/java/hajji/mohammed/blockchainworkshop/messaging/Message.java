package hajji.mohammed.blockchainworkshop.messaging;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
public class Message {
    private UUID id;
    private MessageType type;
    private List<UUID> receivers;
    private UUID sender;
    private String content;

    public Message(MessageType type){
        this.type = type;
        this.id = UUID.randomUUID();
    }

    public Message createReply(){

        Message message = switch (this.type){
            case TRANSACTION_REQUEST -> new Message(MessageType.TRANSACTION_RESPONSE);
            case NEW_MINED_BLOCK -> new Message(MessageType.REWARD);
            case BLOCK_INFOS_REQUEST -> new Message(MessageType.BLOCK_INFOS_RESPONSE);
            case BLOCKCHAIN_SNAPSHOT_REQUEST ->  new Message(MessageType.BLOCKCHAIN_SNAPSHOT_RESPONSE);
            case CREATE_CLIENT_REQUEST -> new Message(MessageType.CREATE_CLIENT_RESPONSE);
            default -> null;
        };

        if (message !=  null)
           message.addReceiver(this.getSender());

        return message;
    }


    public void addReceiver(UUID receiverId){
        this.receivers.add(receiverId);
    }

}
