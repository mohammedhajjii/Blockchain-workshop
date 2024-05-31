package hajji.mohammed.blockchainworkshop.exceptions;

public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException() {
        super("insufficient balance for requested operation");
    }
}
