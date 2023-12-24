import encryption.*;
import signature.*;
import consensus.ProofOfWork;
import block.*;
import transaction.Transaction;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            EncryptionUtils encryptionUtils = new EncryptionUtils();
            SignatureUtils signatureUtils = new SignatureUtils();

            // Example of Asymmetric Encryption
            System.out.println("Enter your message for encryption:");
            String originalMessage = scanner.nextLine();
            System.out.println("Original Message: " + originalMessage);

            KeyPair keyPair = AsymmetricEncryption.generateKeyPair();
            byte[] encryptedMessage = encryptionUtils.encryptMessage(originalMessage, keyPair);
            System.out.println("Encrypted message: " + new String(encryptedMessage));

            // Example of Digital Signature
            System.out.println("\nEnter your data for digital signature:");
            String originalData = scanner.nextLine();
            System.out.println("Original Data: " + originalData);

            KeyPair signatureKeyPair = signatureUtils.generateKeyPair();
            byte[] signature = signatureUtils.signData(originalData.getBytes(), signatureKeyPair);
            System.out.println("Signature: " + new String(signature));

            boolean isSignatureValid = signatureUtils.verifySignature(originalData.getBytes(), signature, signatureKeyPair);
            System.out.println("Is Signature Valid? " + isSignatureValid);

            scanner.close();

            // Example of Proof of Work (PoW) Consensus Mechanism
            int index = 1;
            long timestamp = System.currentTimeMillis();
            String previousHash = "0";
            String data = "Sample Block Data";

            String minedHash = ProofOfWork.mineBlock(index, timestamp, previousHash, data);

            // Creating a list of transactions (for example purposes)
            List<Transaction> transactions = new ArrayList<>();
            transactions.add(new Transaction("Sender1", "Receiver1", 10.0));
            transactions.add(new Transaction("Sender2", "Receiver2", 20.0));

            // Creating a block with the updated constructor
            Block block = new Block(index, timestamp, transactions, previousHash, minedHash);

            System.out.println("\nMined Block:");
            System.out.println("Index: " + block.getIndex());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Transactions: " + block.getTransactions());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Mined Hash: " + block.getHash());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
