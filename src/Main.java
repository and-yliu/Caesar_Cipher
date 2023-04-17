public class Main {
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(1);
        String message = "defend the east wall of the castle";
        String encryptedMessage = cipher.encryptText(message);
        String decryptedMessage = cipher.decryptText(encryptedMessage);
        System.out.println("Original: " + message);
        System.out.println("Encrypted: " + encryptedMessage);
        System.out.println("Decrypted: " + decryptedMessage);
    }
}