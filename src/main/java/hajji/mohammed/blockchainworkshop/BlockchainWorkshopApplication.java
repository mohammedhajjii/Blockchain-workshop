package hajji.mohammed.blockchainworkshop;

import hajji.mohammed.blockchainworkshop.entities.Transaction;
import hajji.mohammed.blockchainworkshop.wallets.Wallet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class BlockchainWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockchainWorkshopApplication.class, args);
    }


    @Bean
    CommandLineRunner start(){
        return args -> {

            /*
            System.out.println("<-----------------------DEQUE------------------------->");

            Deque<String> deque = new ConcurrentLinkedDeque<>();
            deque.push("B1");
            deque.push("B2");
            deque.push("B3");
            deque.push("B4");
            deque.push("B5");
            System.out.println("LIFO: " + deque);
            System.out.println("head: " + deque.peek());
            System.out.println("<------------------------------------------------>");
            System.out.println("<-----------------------QUEUE------------------------->");
            Queue<String> queue = new ConcurrentLinkedQueue<>();
            queue.offer("B1");
            queue.offer("B2");
            queue.offer("B3");
            queue.offer("B4");
            queue.offer("B5");
            System.out.println("FIFO: " + queue);
            System.out.println("head: " + queue.peek());

            queue.add("S");

            System.out.println("FIFO: " + queue);


            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash1 = digest.digest("DATA 1".getBytes(StandardCharsets.UTF_8));
            String data1 = Base64.getEncoder().encodeToString(hash1);

            byte[] hash2 = digest.digest("DATA 2".getBytes(StandardCharsets.UTF_8));
            String data2 = Base64.getEncoder().encodeToString(hash2);


            System.out.println("data 1: " + data1);
            System.out.println("data 2: " + data2);

             */



        };
    }
}
