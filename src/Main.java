import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

// ЗАВДАННЯ 1

class Zavdanya1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо значення n та m
        System.out.print("Введіть значення n: ");
        double n = scanner.nextDouble();
        System.out.print("Введіть значення m: ");
        double m = scanner.nextDouble();

        // Варіант 1: вхідні дані дійсного типу, результат - дійсного
        double result1 = ((n + 1) * (m - 4) + n * m - Math.pow(n, 4) + Math.pow(m, 3)) / Math.pow((m + 2), 2);
        System.out.println("Результат у варіанті 1 (дійсний тип): " + result1);

        // Варіант 2: вхідні дані цілого типу, результат - дійсного
        int nInt = (int) n;
        int mInt = (int) m;
        double result2 = ((nInt + 1) * (mInt - 4) + nInt * mInt - Math.pow(nInt, 4) + Math.pow(mInt, 3)) / Math.pow((mInt + 2), 2);
        System.out.println("Результат у варіанті 2 (цілий тип, результат - дійсний): " + result2);

        // Варіант 3: вхідні дані дійсного типу, результат - цілого
        int result3 = (int) result1;
        System.out.println("Результат у варіанті 3 (дійсний тип, результат - цілий): " + result3);

        scanner.close();
    }
}


// ЗАВДАННЯ 2
class Zavdanya2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір масиву: ");
        int n = scanner.nextInt();

        int[] A = new int[n];
        System.out.println("Введіть масив цілих чисел:");

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : A) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        int maxUnique = Integer.MIN_VALUE;

        for (int num : A) {
            if (countMap.get(num) == 1 && num > maxUnique) {
                maxUnique = num;
            }
        }

        if (maxUnique != Integer.MIN_VALUE) {
            System.out.println("Максимальне унікальне число: " + maxUnique);
        } else {
            System.out.println("Унікальних чисел немає в масиві.");
        }
    }
}

// ЗАВДАННЯ 3
class Zavdanya3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір матриці (n): ");
        int n = scanner.nextInt();

        int[][] A = new int[n][n];

        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        int maxSumOfAbs = Integer.MIN_VALUE;
        int columnIndex = 0;

        for (int j = 0; j < n; j++) {
            int sumOfAbs = 0;
            for (int i = 0; i < n; i++) {
                sumOfAbs += Math.abs(A[i][j]);
            }

            if (sumOfAbs > maxSumOfAbs) {
                maxSumOfAbs = sumOfAbs;
                columnIndex = j;
            }
        }

        int minInColumn = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int current = Math.abs(A[i][columnIndex]);
            if (current < minInColumn) {
                minInColumn = current;
            }
        }

        System.out.println("Найменший елемент у стовпці з найбільшою сумою модулів: " + minInColumn);
    }
}

// ЗАВДАННЯ 4

class Zavdanya4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть символ для пошуку: ");
        char targetChar = scanner.next().charAt(0);

        System.out.print("Введіть текст: ");
        scanner.nextLine(); // Очищаємо буфер після попереднього next

        String text = scanner.nextLine();
        String[] words = text.split("[\\s.,!?;:]+"); // Розділяємо текст на слова

        int maxCount = 0;

        for (String word : words) {
            int charCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == targetChar) {
                    charCount++;
                }
            }

            if (charCount > maxCount) {
                maxCount = charCount;
            }
        }

        if (maxCount == 0) {
            System.out.println("Слова зі знайденим символом в тексті відсутні.");
        } else {
            System.out.println("Слова, що містять символ '" + targetChar + "' найбільшу кількість разів:");

            for (String word : words) {
                int charCount = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == targetChar) {
                        charCount++;
                    }
                }
                if (charCount == maxCount) {
                    System.out.println(word);
                }
            }
        }
    }
}
