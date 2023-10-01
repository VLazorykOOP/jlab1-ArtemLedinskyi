
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter task that u wanna check : ");
        int task = in.nextInt();
        switch (task) {
            case 1 -> task1();
            case 2 -> task2();
            case 3 -> task3();
            case 4 -> task4();
        }

    }

    public static void task1() {
        Scanner in = new Scanner(System.in);
        System.out.println("\tIt's the first task\n 1) Вхідні дані дійсного типу, результат – дійсного; 2) Вхідні дані " +
                "цілого типу, результат – дійсного; 3) Вхідні дані дійсного типу, результат – цілого.\n \tОберіть завдання.");
        int task = in.nextInt();
        double result = 0.0;
        System.out.println("Введіть перше число: ");
        double x = in.nextDouble();
        System.out.println("Введіть друге число: ");
        double y = in.nextDouble();
        switch (task) {
            case 1:
                result = (1.0 / (x * y)) + (1.0 / (Math.pow(x, 2) + Math.pow(y, 2))) * (x - y);
                break;
            case 2:
                int intx = (int) x; // Перетворення з double в int
                int inty = (int) y; // Перетворення з double в int
                result = (1.0 / (intx * inty)) + (1.0 / (Math.pow(intx, 2) + Math.pow(inty, 2))) * (intx - inty);
                break;
            case 3:
                result = (int) ((1.0 / (x * y)) + (1.0 / (Math.pow(x, 2) + Math.pow(y, 2))) * (x - y)); // Перетворення з double в int
                break;
        }
        System.out.println("Результат: " + result);
    }

    public static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть довжину послідовності: ");
        int n = in.nextInt();

        if (n <= 300) {
            int[] X = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.println("Введіть число: ");
                X[i] = in.nextInt();
            }

            int maxLength = 1; // Початкова максимальна довжина знайденого ланцюжка - 1, оскільки навіть одне число може бути ланцюжком.
            int currentLength = 1; // Початкова поточна довжина ланцюжка - 1, оскільки ми завжди розпочинаємо з одного числа.

            int endIndex = 0; // Індекс останнього елемента максимального ланцюжка - початково нуль, оскільки перше число є частиною ланцюжка.
            int currentEndIndex = 0; // Індекс останнього елемента поточного ланцюжка - початково нуль, оскільки перше число є частиною ланцюжка.

            for (int i = 1; i < n; i++) {
                // Починаєм цикл з 1, бо немає попереднього елемента для порівняння.
                if (X[i] > X[i - 1]) {
                    // Перевіряємо чи поточний елемент більший за попередній, якщо так, то він є частиною ланцюжка.
                    currentLength++; // Додаємо +1 до поточної довжини, щоб мати інформацію про поточну довжину ланцюжка.
                    currentEndIndex = i; // Вказуємо, що останній елемент ланцюжка - це X[i].
                } else {
                    currentLength = 1; // Якщо не більший, то обнулюємо і починаємо вимірювати новий ланцюжок.
                }

                if (currentLength > maxLength) {
                    // Перевіряємо, чи поточний ланцюжок є найдовшим.
                    maxLength = currentLength; // Якщо currentLength більший за maxLength, то оновлюємо maxLength до currentLength.
                    endIndex = currentEndIndex; // Оновлюємо індекс останнього елемента максимального ланцюжка.
                }
            }

            int[] lis = new int[maxLength]; // Масив, який буде містити найдовший ланцюжок чисел.
            int startIndex = endIndex - maxLength + 1; // Індекс початку ланцюжка.

            for (int j = 0; startIndex <= endIndex; j++, startIndex++) {
                lis[j] = X[startIndex];
            }

            System.out.println("Найдовший ланцюжок чисел, упорядкований за зростанням:");
            System.out.println(Arrays.toString(lis));
        } else {
            System.out.println("Значення довжини послідовності знаходиться за межами допустимого діапазону (<= 300).");
        }
    }

    public static void task3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть розмірність матриць:");
        int n = in.nextInt();
        int[][] A;
        int[][] B;

        if (n <= 15) {
            A = new int[n][n];
            B = new int[n][n];
        } else {
            System.out.println("Помилка: розмірність матриць перевищує максимально допустиму (15).");
            return;
        }

        System.out.println("Введіть значення для матриці A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = in.nextInt();
            }
        }

        System.out.println("Введіть значення для матриці B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                B[i][j] = in.nextInt();
            }
        }

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = 1; // Початкове значення - 1, ми припускаємо, що матриці A та B співпадають.
            for (int j = 0; j < n; j++) {
                if (A[i][j] != B[j][i]) {
                    x[i] = 0; // Якщо знайдено хоча б одну нерівність, встановлюємо значення 0 в масиві x.
                    break; // Виходимо з циклу, оскільки немає сенсу перевіряти інші елементи.
                }
            }
        }

        System.out.println("Результат:");
        for (int num : x) {
            System.out.println(num);
        }
    }

    public static void task4() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter words: ");
        String text = in.nextLine(); // Зчитуємо рядок

        StringBuilder answer = new StringBuilder(); // Створюємо об'єкт StringBuilder для зберігання результату
        String[] words = text.split("[,;!.?\\s]+"); // Розділяємо введений рядок на слова, використовуючи регулярний вираз

        for (String word : words) { // Перебираємо слова у масиві words
            boolean isUnique = true; // Перевірка, чи слово містить унікальні символи

            for (int i = 0; i < word.length(); i++) {
                char currentLetter = word.charAt(i);

                for (int j = i + 1; j < word.length(); j++) {
                    if (currentLetter == word.charAt(j)) { // Якщо знайдемо однакові символи, слово стане неуникним
                        isUnique = false;
                        break;
                    }
                }
            }

            if (isUnique) { // Якщо слово унікальне, додаємо його до результату
                answer.append(word).append(" ");
            }
        }

        System.out.println("Результат: " + answer.toString().trim());
    }
}
//Використав StringBuilder, якщо кожного разу добавляти до String, то буде багато сміття(бо String є незмінним і що разу створює новий рядок)
//А StringBuilder просто додає до існуючого рядка.
