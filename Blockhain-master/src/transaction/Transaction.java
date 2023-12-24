package transaction;
import utils.HashingUtils;
public class Transaction {
    private String sender;
    private String recipient;
    private double amount;
    private String transactionId;

    // Constructor
    public Transaction(String sender, String recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.transactionId = calculateTransactionId();
    }
    private String calculateTransactionId() {
        String data = sender + recipient + Double.toString(amount);
        return HashingUtils.applySHA256(data);
    }
}
