import java.util.Scanner;

public class findMaxNumber_zavd_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Створюємо об'єкт Scanner для введення даних з клавіатури

        System.out.print("Введіть розмір масиву: ");
        int n = scanner.nextInt(); // Зчитуємо розмір масиву від користувача

        if (n > 400) { // Перевірка на відповідність розміру масиву умові (n <= 400)
            System.out.println("Розмір масиву повинен бути менше або дорівнювати 400.");
            return; // Вихід із програми у випадку невідповідного розміру масиву
        }

        int[] arr = new int[n]; // Створюємо масив цілих чисел розміром n

        for (int i = 0; i < n; i++) {
            System.out.print("Введіть число: ");
            arr[i] = scanner.nextInt(); // Зчитуємо елементи масиву від користувача
        }

        int maxUnique = findMaxUniqueNumber(arr); // Викликаємо функцію для знаходження максимального неповторюючого числа

        System.out.println("Максимальне неповторююче число: " + maxUnique); // Виводимо результат
    }

    public static int findMaxUniqueNumber(int[] arr) {
        int maxUnique = Integer.MIN_VALUE; // Початкове значення для максимального неповторюючого числа

        for (int i = 0; i < arr.length; i++) {
            int currentNumber = arr[i];
            boolean isUnique = true;

            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[j] == currentNumber) {
                    isUnique = false;
                    break; // Якщо знайдено однакове число, виходимо з циклу
                }
            }

            if (isUnique && currentNumber > maxUnique) {
                maxUnique = currentNumber; // Оновлюємо максимальне неповторююче число
            }
        }

        return maxUnique; // Повертаємо максимальне неповторююче число
    }
}
