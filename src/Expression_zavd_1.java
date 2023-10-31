import java.util.Scanner;

public class Expression_zavd_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть значення x: ");
        double x = scanner.nextDouble(); // Вхідні дані дійсного типу

        System.out.println("Введіть значення y: ");
        double y = scanner.nextDouble(); // Вхідні дані дійсного типу

        // Рахуємо результат для вхідних даних дійсного типу
        double resultDouble = calculateExpression(x, y);
        System.out.println("Результат для дійсних вхідних даних: " + resultDouble);
        // Переводимо вхідні дані в цілі числа
        int xInt = (int) x;
        int yInt = (int) y;

        // Рахуємо результат для вхідних даних цілого типу
        double resultInt = calculateExpression(xInt, yInt);
        System.out.println("Результат для цілих вхідних даних: " + resultInt);

        // Рахуємо результат для вхідних даних дійсного типу, результат - ціле число
        int resultIntFromDouble = (int) calculateExpression(x, y);
        System.out.println("Результат для дійсних вхідних даних, результат - ціле число: " + resultIntFromDouble);
    }

    // Метод для обчислення виразу
    public static double calculateExpression(double x, double y) {
        // Формула для обчислення виразу
        return 1 / (x * y) + 1 / (Math.pow(x, 2) + Math.pow(y, 2)) * (x - y);
    }


}
