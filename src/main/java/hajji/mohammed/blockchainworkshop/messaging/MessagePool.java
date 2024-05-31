package hajji.mohammed.blockchainworkshop.messaging;

import hajji.mohammed.blockchainworkshop.network.Network;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class MessagePool {
    private final Queue<Message> messageQueue;
    @Setter
    private Network network;

    public MessagePool() {
        this.messageQueue =  new ConcurrentLinkedQueue<>();
    }

    public void send(Message message){
        this.messageQueue.offer(message);
    }

    public Message deliver(){
        return messageQueue.poll();
    }

    public boolean hasMessage(){
        return !messageQueue.isEmpty();
    }
}
