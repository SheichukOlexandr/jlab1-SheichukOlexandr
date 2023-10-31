import java.util.Scanner;
import java.util.HashSet;

public class Text_zavd_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть текст: ");
        String text = scanner.nextLine();

        String[] words = text.split("\\s+"); // Розділяємо текст на слова за допомогою пробілів

        for (String word : words) {
            if (hasUniqueCharacters(word)) {
                System.out.println(word);
            }
        }
    }

    public static boolean hasUniqueCharacters(String word) {
        HashSet<Character> charSet = new HashSet<>(); // Використовуємо HashSet для визначення унікальних символів

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (Character.isLetter(currentChar) && !charSet.add(currentChar)) {
                return false; // Якщо символ уже зустрічався, і це літера, то повертаємо false
            }
        }

        return true; // Повертаємо true, якщо всі літери унікальні
    }
}