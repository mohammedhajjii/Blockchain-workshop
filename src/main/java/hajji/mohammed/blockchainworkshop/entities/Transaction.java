package hajji.mohammed.blockchainworkshop.entities;


import lombok.*;


@Data @Builder
public class Transaction {
    private String sender;
    private String recipient;
    private double amount;
    private String signature;
    public String getTransactionDetails(){
        return sender + "." + recipient  + "." + amount;
    }
}
