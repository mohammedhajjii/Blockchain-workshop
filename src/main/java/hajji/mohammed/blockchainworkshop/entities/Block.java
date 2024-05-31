package hajji.mohammed.blockchainworkshop.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter @Setter @Builder
public class Block {
    private int index;
    private Instant timeStamp;
    private String previousHash;
    private String currentHash;
    private int nonce;
    private List<Transaction> transactionList;
    public String getBlockDetails(){
        return index + "." +
                timeStamp + "." +
                previousHash + "." +
                nonce + "." +
                transactionList.toString();
    }
}
