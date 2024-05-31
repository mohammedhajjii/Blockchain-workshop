package hajji.mohammed.blockchainworkshop.exceptions;

public class NegativeOrNullAmountException extends IllegalArgumentException {

    public NegativeOrNullAmountException() {
        super("Negative amount not accepted");
    }
}
