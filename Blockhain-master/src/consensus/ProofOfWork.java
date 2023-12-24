package consensus;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProofOfWork {
    private static final int DIFFICULTY = 4;
    public static String mineBlock(int index, long timestamp, String previousHash, String data) {
        int nonce = 0;
        String hash = calculateHash(index, timestamp, previousHash, data, nonce);
        while (!hash.substring(0, DIFFICULTY).equals("0".repeat(DIFFICULTY))) {
            nonce++;
            hash = calculateHash(index, timestamp, previousHash, data, nonce);
        }

        return hash;
    }

    private static String calculateHash(int index, long timestamp, String previousHash, String data, int nonce) {
        String input = index + timestamp + previousHash + data + nonce;
        return applySHA256(input);
    }

    private static String applySHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
