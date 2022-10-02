package cipher;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class BlowfishCipher {

    public byte[] encrypt(String operationMode, String text, String key) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance(String.format("Blowfish/%s/PKCS5Padding", operationMode));
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return cipher.doFinal(text.getBytes());
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException e) {
            throw new RuntimeException("Erro ao criptografar o texto: ", e);
        }
    }

    public byte[] encrypt(String operationMode, String text, String key, IvParameterSpec ivParameterSpec) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance(String.format("Blowfish/%s/PKCS5Padding", operationMode));
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
            return cipher.doFinal(text.getBytes());
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException | InvalidAlgorithmParameterException e) {
            throw new RuntimeException("Erro ao criptografar o texto: ", e);
        }
    }

    public byte[] decrypt(String operationMode, byte[] bytes, String key) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance(String.format("Blowfish/%s/PKCS5Padding", operationMode));
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return cipher.doFinal(bytes);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException e) {
            throw new RuntimeException("Erro ao descriptografar o texto: ", e);
        }
    }

    public byte[] decrypt(String operationMode, byte[] bytes, String key, IvParameterSpec ivParameterSpec) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance(String.format("Blowfish/%s/PKCS5Padding", operationMode));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
            return cipher.doFinal(bytes);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException | InvalidAlgorithmParameterException e) {
            throw new RuntimeException("Erro ao descriptografar o texto: ", e);
        }
    }

}
