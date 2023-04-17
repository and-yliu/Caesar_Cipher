import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {
    //Fields
    private int shift;
    private Map<Character, Character> encrypt;
    private Map<Character, Character> decrypt;

    /**
     * Create to two HashMaps, one to encrypt, one to decrypt, base on a certain number of shifts.
     * @param shift by how much is each letter shifted
     */
    public CaesarCipher(int shift){
        this.shift = shift;
        this.encrypt = new HashMap<>();
        this.decrypt = new HashMap<>();

        // Loop through lowercase letters from a to z and create the encryption and decryption maps
        for (char c = 'a'; c <= 'z'; c++){
            char encryptedChar = (char) ((c - 'a' + shift) % 26 + 'a');
            encrypt.put(c, encryptedChar);
            decrypt.put(encryptedChar,c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            char encryptedChar = (char) ((c - 'A' + shift) % 26 + 'A');
            encrypt.put(c,encryptedChar);
            encrypt.put(encryptedChar, c);
        }
    }

    //Getter and Setter
    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public Map<Character, Character> getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(Map<Character, Character> encrypt) {
        this.encrypt = encrypt;
    }

    public Map<Character, Character> getDecrypt() {
        return decrypt;
    }

    public void setDecrypt(Map<Character, Character> decrypt) {
        this.decrypt = decrypt;
    }

    /**
     * A method to encrypt a given message by shift each letter by a certain amount of shift
     * @param message the input message
     * @return the encrypted message
     */
    public String encryptText(String message){
        String encryptedString = "";
        for(char c : message.toCharArray()){
            if (encrypt.containsKey(c)) {
                encryptedString = encryptedString + encrypt.get(c);
            } else {
                encryptedString = encryptedString + c;
            }
        }
        return encryptedString;
    }

    /**
     * A method to decrypt a given message by shift each letter by a certain amount of shift backwards
     * @param message the input message
     * @return the decrypted message
     */
    public String decryptText(String message){
        String decryptedString = "";
        for(char c : message.toCharArray()){
            if (decrypt.containsKey(c)) {
                decryptedString = decryptedString + decrypt.get(c);
            } else {
                decryptedString = decryptedString + c;
            }
        }
        return decryptedString;
    }
}
