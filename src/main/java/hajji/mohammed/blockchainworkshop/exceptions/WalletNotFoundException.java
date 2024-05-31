package hajji.mohammed.blockchainworkshop.exceptions;

public class WalletNotFoundException extends IllegalArgumentException {

    public WalletNotFoundException(String address) {
        super("No wallet associated with address: " + address);
    }
}
