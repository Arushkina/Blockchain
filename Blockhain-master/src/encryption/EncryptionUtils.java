package encryption;
import java.security.KeyPair;

public class EncryptionUtils {
    private final AsymmetricEncryption asymmetricEncryption;

    public EncryptionUtils() {
        this.asymmetricEncryption = new AsymmetricEncryption();
    }

    public byte[] encryptMessage(String message, KeyPair keyPair) throws Exception {
        return asymmetricEncryption.encrypt(message, keyPair.getPublic());
    }

    public String decryptMessage(byte[] encryptedMessage, KeyPair keyPair) throws Exception {
        return asymmetricEncryption.decrypt(encryptedMessage, keyPair.getPrivate());
    }
}
