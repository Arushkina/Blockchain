package block;

import transaction.Transaction;
import utils.HashingUtils;

import java.util.List;

public class Block {
    private int index;
    private long timestamp;
    private List<Transaction> transactions;
    private String previousHash;
    private String hash;
    private String data;
    private int nonce;

    // Constructor
    public Block(int index, long timestamp, List<Transaction> transactions, String previousHash, String hash) {
        this.index = index;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.hash = hash;
        this.nonce = 0;
    }

    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public String getData() {
        return data;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
    // calculate the hash of the block based on its attributes
    public String calculateHash() {
        String dataToHash = index + timestamp + transactions.toString() + previousHash + nonce;
        return HashingUtils.applySHA256(dataToHash);
    }
}
