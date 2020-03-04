
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtil {

    private static final String secretKey = System.getenv("SECRET_KEY");

    public static byte[] encrypt(byte[] clearText) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(),"AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return cipher.doFinal(clearText);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(byte[] encryptedText) {
          try {
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(),"AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return cipher.doFinal(encryptedText);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
