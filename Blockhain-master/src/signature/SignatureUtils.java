package signature;

import java.security.KeyPair;

public class SignatureUtils {

    private final DigitalSignature digitalSignature;

    public SignatureUtils() {
        this.digitalSignature = new DigitalSignature();
    }

    public KeyPair generateKeyPair() throws Exception {
        return digitalSignature.generateKeyPair();
    }

    public byte[] signData(byte[] data, KeyPair keyPair) throws Exception {
        return digitalSignature.signData(data, keyPair.getPrivate());
    }

    public boolean verifySignature(byte[] data, byte[] signatureBytes, KeyPair keyPair) throws Exception {
        return digitalSignature.verifySignature(data, signatureBytes, keyPair.getPublic());
    }
}
