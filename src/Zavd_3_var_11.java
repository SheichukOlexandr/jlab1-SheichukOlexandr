import java.util.Scanner;

public class Zavd_3_var_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Створюємо об'єкт Scanner для введення даних з клавіатури

        System.out.print("Введіть розмір матриці (n <= 20): ");
        int n = scanner.nextInt(); // Зчитуємо розмір матриці від користувача

        if (n > 20) { // Перевірка на відповідність розміру матриці умові (n <= 20)
            System.out.println("Розмір матриці повинен бути менше або дорівнювати 20.");
            return; // Вихід із програми у випадку невідповідного розміру матриці
        }

        int[][] matrix = new int[n][n]; // Створюємо матрицю розміром n x n

        // Заповнюємо матрицю елементами
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Введіть елемент A[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt(); // Зчитуємо елементи матриці від користувача
            }
        }

        int maxSumColumnIndex = findMaxSumColumn(matrix); // Знаходимо стовпець з найбільшою сумою модулів елементів
        int minInMaxSumColumn = findMinInColumn(matrix, maxSumColumnIndex); // Знаходимо найменше значення в цьому стовпці

        System.out.println("Мінімальний елемент у стовпці " + maxSumColumnIndex + ": " + minInMaxSumColumn); // Виводимо результат
    }

    public static int findMaxSumColumn(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE; // Початкове значення для максимальної суми
        int maxSumColumnIndex = -1; // Початкове значення для індексу стовпця з максимальною сумою

        for (int j = 0; j < matrix[0].length; j++) { // Цикл для кожного стовпця
            int sum = 0;

            for (int i = 0; i < matrix.length; i++) { // Сумуємо модулі елементів стовпця
                sum += Math.abs(matrix[i][j]);
            }

            if (sum > maxSum) { // Перевіряємо, чи сума більше попередньої максимальної суми
                maxSum = sum;
                maxSumColumnIndex = j; // Оновлюємо індекс стовпця з максимальною сумою
            }
        }

        return maxSumColumnIndex; // Повертаємо індекс стовпця з найбільшою сумою модулів
    }

    public static int findMinInColumn(int[][] matrix, int columnIndex) {
        int minInColumn = matrix[0][columnIndex]; // Початкове значення мінімуму - перший елемент стовпця

        for (int i = 1; i < matrix.length; i++) { // Цикл для знаходження мінімуму
            if (matrix[i][columnIndex] < minInColumn) {
                minInColumn = matrix[i][columnIndex]; // Оновлюємо мінімальне значення
            }
        }

        return minInColumn; // Повертаємо мінімальне значення в стовпці
    }
}
