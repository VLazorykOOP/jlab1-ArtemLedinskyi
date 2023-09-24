
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter task that u wanna check : ");
        int task = in.nextInt();
        switch (task) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
        }

    }

    public static void task1() {
        Scanner in = new Scanner(System.in);
        System.out.println("\tIt's first task \n 1) вхідні дані дійсного типу, результат – дійсного; 2) вхідні дані\n" +
                "цілого типу, результат – дійсного; 3) вхідні дані дійсного типу, результат – цілого.\n \tChoose task.");
        int task = in.nextInt();
        double result = 0.0;
        System.out.println("Enter first number : ");
        double x = in.nextDouble();
        System.out.println("Enter second number : ");
        double y = in.nextDouble();
        switch (task) {
            case 1:
                result = (1 / (x * y)) + (1 / (Math.pow(x, 2) + Math.pow(y, 2))) * (x - y);
                break;
            case 2:
                int intx = (int) x;//Перетворення з double в int
                int inty = (int) y;//Перетворення з double в int
                result = (1 / (intx * inty)) + (1 / (Math.pow(intx, 2) + Math.pow(inty, 2))) * (intx - inty);
                break;
            case 3:
                result = (int) ((1 / (x * y)) + (1 / (Math.pow(x, 2) + Math.pow(y, 2))) * (x - y));//Перетворення з double в int
                break;
        }
        System.out.println("Result is " + result);
    }
    public static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length : ");
        int n = in.nextInt();
        int[] X;

        if (n <= 300) {
            X = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Enter number : ");
                X[i] = in.nextInt();
            }

            int maxLength = 1; // Початкова максимальна довжина знайденого ланцюжка - 1, оскільки навіть одне число може бути ланцюжком.
            int currentLength = 1; // Початкова поточна довжина ланцюжка - 1, оскільки ми завжди розпочинаємо з одного числа.

            int endIndex = 0; // Індекс останнього елемента максимального ланцюжка - початково нуль, оскільки перше число є частиною ланцюжка.
            int currentEndIndex = 0; // Індекс останнього елемента поточного ланцюжка - початково нуль, оскільки перше число є частиною ланцюжка.

            for (int i = 1; i < n; i++) {//Починаєм цикл з 1, бо немає попереднього елемента для порівняння.
                if (X[i] > X[i - 1]) {//Перевіряє чи поточний елемент більший за попередній, якщо так, то буде вважатись частиною ланцюжка.
                    currentLength++;//Додаємо +1 до поточної довжини, щоб у нас була інформація про довжину, яка зараз присутня.
                    currentEndIndex = i;//Вказуємо, що останній елемент ланцюжка це X[i].
                } else {
                    currentLength = 1;//Якщо не більший, то ми обнулюємо і починаємо вимірювати новий ланцюжок.
                }

                if (currentLength > maxLength) {//Перевіряємо, чи поточний ланцюжок є найдовшим.
                    maxLength = currentLength;//Якщо currentLength більший за maxLength, то ми оновлюємо maxLength до currentLength.
                    endIndex = currentEndIndex;//Змінюємо, щоб вказати, що знайдений ланцюжок є більшим за попередній максимальний ланцюжок.
                }
            }
            int[] lis = new int[maxLength];//Масив, який буде містити найдовший ланцюжок чисел
            int startIndex = endIndex - maxLength + 1;//Показує на початок ланцюга

            for (int j = 0; startIndex <= endIndex; j++, startIndex++) {
                lis[j] = X[startIndex];
            }

            System.out.println("Найдовший ланцюжок чисел, упорядкований за зростанням:");
            System.out.println(Arrays.toString(lis));
        } else {
            System.out.println("OutOfRange!");
        }
    }

    public static void task3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length :");
        int n = in.nextInt();
        int A[][];
        int B[][];
        if (n <= 15) {
            A = new int[n][n];
            B = new int[n][n];
        } else {
            System.out.println("OutOfRange!");
            return;
        }

        for (int i = 0; i < n; i++) {//Вводимо значення для А
            for (int j = 0; j < n; j++) {
                System.out.println("Enter A[" + i + "][" + j + "]: ");
                A[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {//Вводимо значення для В
            for (int j = 0; j < n; j++) {
                System.out.println("Enter B[" + i + "][" + j + "]: ");
                B[i][j] = in.nextInt();
            }
        }
        int x[] = new int [n];//Матриця, яка зберігатиме відповідь
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(A[i][j]==B[j][i]) { // Перевіряє збіг рядків матриці A зі стовпцями матриці B
                    x[i] = 1;// Якщо умова виконується, то буде значення 1 в масиві Х
                } else {
                    x[i]=0;// Якщо умова виконується, то буде значення 0 в масиві Х
                }
            }
        }
        for(int num:x){//Вивід масиву
            System.out.println(num);
        }
    }
    public static void task4(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter words : ");
        String text = in.nextLine();//Зчитуєм рядок
        StringBuilder answer = new StringBuilder();// Створюєм об'єкт StringBuilder для зберігання результату
        String[] words= text.split("[,;!.?\\s]+");// Розділяєм введений рядок на слова, використовуючи регулярний вираз
        for(String word:words){// Перебираємо слова у масиві words
            boolean Unique = true; // Перевірка, чи слово містить унікальні символи
            for(int i=0;i<word.length();i++){
                char currentlet=word.charAt(i);
                for(int j=i+1;j<word.length();j++){
                    if(currentlet==word.charAt(j)){ // Якщо знайдемо однакові символи, слово стане неу нікальним
                        Unique=false;
                        break;
                    }
                }
            }
            if(Unique){// Якщо слово унікальні, додаємо його до результату
                answer.append(word).append(" ");
            }
        }
        System.out.println("Answer is " + answer.toString().trim());
    }
}
//Використав StringBuilder, якщо кожного разу добавляти до String, то буде багато сміття(бо String є незмінним і що разу створює новий рядок)
//А StringBuilder просто додає до існуючого рядка.
