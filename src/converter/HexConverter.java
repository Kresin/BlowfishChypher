package converter;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class HexConverter {

    public String convertBytesToStringHex(byte[] bytes) {
        return Hex.encodeHexString(bytes);
    }

    public String convertHexToString(String str) {
        try {
            byte[] bytes = Hex.decodeHex(str);
            return new String(bytes);
        } catch (DecoderException e) {
            throw new RuntimeException("Erro ao converter hexadecimal para String: ", e);
        }
    }

}
