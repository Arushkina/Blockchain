package transaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionUtils {
    private static List<Transaction> transactions = new ArrayList<>();
    public static Transaction createTransaction(String sender, String recipient, double amount) {
        Transaction newTransaction = new Transaction(sender, recipient, amount);
        transactions.add(newTransaction);
        return newTransaction;
    }
    public static List<Transaction> getAllTransactions() {
        return transactions;
    }
}
