import java.util.Scanner;

public class Vigenere2 {

    public static void main(String[] args) {
        System.out.println("Digite a palavra cifrada.");
        Scanner teclado = new Scanner(System.in);
        String cifra = teclado.nextLine();

        forcaBruta(cifra);
        teclado.close();
    }

    public static void forcaBruta(String cifra) {
        for (int key1 = 0; key1 < 26; key1++) {
            for (int key2 = 0; key2 < 26; key2++) {
                for (int key3 = 0; key3 < 26; key3++) {
                    String key = "" + (char) ('A' + key1) + (char) ('A' + key2) + (char) ('A' + key3);
                    String textoClaro = decryptVigenere(cifra, key);

                    if (textoClaro.length() <= 6) { // Verifica se o texto claro é maior ou igual a 6, e imprime.
                        System.out.println("Chave: " + key + ", Texto claro: " + textoClaro);
                    }
                }
            }
        }
    }

    public static String decryptVigenere(String cifra, String key) {
        StringBuilder textoClaro = new StringBuilder();
        int keyLength = key.length();
        for (int i = 0; i < cifra.length(); i++) { // Percorre a cifra.
            char c = cifra.charAt(i); // Usa a cifra para descriptografar.
            char k = key.charAt(i % keyLength);
            int shift = k - 'A';
            char decryptedChar = (char) (((c - 'A' - shift + 26) % 26) + 'A');
            textoClaro.append(decryptedChar); // Junta as strings.
        }
        return textoClaro.toString();
    }
}
