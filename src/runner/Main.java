package runner;

import cipher.BlowfishCipher;
import converter.HexConverter;

import javax.crypto.spec.IvParameterSpec;

public class Main {

    private static final String ECB = "ECB";
    private static final String CBC = "CBC";
    private static final String KEY = "ABCDE";
    private static final String KEY_2 = "11111";

    public static void main(String[] args) {
        BlowfishCipher cipher = new BlowfishCipher();
        HexConverter hexConverter = new HexConverter();

        // Caso 1
        System.out.println("Caso 1:");
        String encryptedHex = hexConverter.convertBytesToStringHex(cipher.encrypt(ECB, "FURB", KEY));
        System.out.println("Conteúdo do texto cifrado (em hexadecimal): " + encryptedHex);
        System.out.println("Qual a extensão (quantidade de caracteres) do texto cifrado: " + encryptedHex.length());

        // Caso 2
        System.out.println("\nCaso 2:");
        encryptedHex = hexConverter.convertBytesToStringHex(cipher.encrypt(ECB, "COMPUTADOR", KEY));
        System.out.println("Conteúdo do texto cifrado (em hexadecimal): " + encryptedHex);
        System.out.println("Qual a extensão (quantidade de caracteres) do texto cifrado: " + encryptedHex.length());

        // Caso 3
        System.out.println("\nCaso 3:");
        encryptedHex = hexConverter.convertBytesToStringHex(cipher.encrypt(ECB, "SABONETE", KEY));
        System.out.println("Conteúdo do texto cifrado (em hexadecimal): " + encryptedHex);
        System.out.println("Qual a extensão (quantidade de caracteres) do texto cifrado: " + encryptedHex.length());

        // Caso 4
        System.out.println("\nCaso 4:");
        encryptedHex = hexConverter.convertBytesToStringHex(cipher.encrypt(ECB, "SABONETESABONETESABONETE", KEY));
        System.out.println("Conteúdo do texto cifrado (em hexadecimal): " + encryptedHex);
        System.out.println("Qual a extensão (quantidade de caracteres) do texto cifrado: " + encryptedHex.length());

        // Caso 5
        System.out.println("\nCaso 5:");
        byte[] furbEncrypted = cipher.encrypt(CBC, "FURB", KEY);
        encryptedHex = hexConverter.convertBytesToStringHex(furbEncrypted);
        System.out.println("Conteúdo do texto cifrado (em hexadecimal): " + encryptedHex);
        // Código comentado, pois a tentativa de descriptografar o texto retorna uma exceção
        //String furbDecrypted = new String(cipher.decrypt(CBC, furbEncrypted, KEY), StandardCharsets.UTF_8);
        //System.out.println("Texto decifrado: " + furbDecrypted);

        // Caso 6
        System.out.println("\nCaso 6:");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{1, 1, 2, 2, 3, 3, 4, 4});
        encryptedHex = hexConverter.convertBytesToStringHex(cipher.encrypt(CBC, "FURB", KEY, ivParameterSpec));
        System.out.println("Conteúdo do texto cifrado (em hexadecimal): " + encryptedHex);

        // Caso 7
        System.out.println("\nCaso 7:");
        ivParameterSpec = new IvParameterSpec(new byte[]{1, 1, 2, 2, 3, 3, 4, 4});
        encryptedHex = hexConverter.convertBytesToStringHex(cipher.encrypt(CBC, "SABONETESABONETESABONETE", KEY, ivParameterSpec));
        System.out.println("Conteúdo do texto cifrado (em hexadecimal): " + encryptedHex);

        // Caso 8
        System.out.println("\nCaso 8:");
        ivParameterSpec = new IvParameterSpec(new byte[]{10, 20, 30, 40, 50, 60, 70, 80});
        byte[] saboneteEncrypted = cipher.encrypt(CBC, "SABONETESABONETESABONETE", KEY, ivParameterSpec);
        encryptedHex = hexConverter.convertBytesToStringHex(saboneteEncrypted);
        System.out.println("Conteúdo do texto cifrado (em hexadecimal): " + encryptedHex);
        //Tentativa de descriptografar o texto
        //ivParameterSpec = new IvParameterSpec(new byte[]{1, 1, 2, 2, 3, 3, 4, 4});
        //String furbDecrypted = new String(cipher.decrypt(CBC, furbEncrypted, KEY, ivParameterSpec), StandardCharsets.UTF_8);
        //System.out.println("Texto decifrado: " + furbDecrypted);

        // Caso 9
        System.out.println("\nCaso 9:");
        furbEncrypted = cipher.encrypt(ECB, "FURB", KEY);
        encryptedHex = hexConverter.convertBytesToStringHex(furbEncrypted);
        System.out.println("Conteúdo do texto cifrado (em hexadecimal): " + encryptedHex);
        // Código comentado, pois a tentativa de descriptografar o texto retorna uma exceção
        //String furbDecrypted = new String(cipher.decrypt(ECB, furbEncrypted, KEY_2), StandardCharsets.UTF_8);
        //System.out.println("Texto decifrado: " + furbDecrypted);
    }

}
