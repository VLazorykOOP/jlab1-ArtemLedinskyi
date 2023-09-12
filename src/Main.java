import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter task that u wanna check : ");
        int task= in.nextInt();
        switch (task){
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
        }

    }
    public static void task1(){
        Scanner in = new Scanner(System.in);
        System.out.println("\tIt's first task \n 1) вхідні дані дійсного типу, результат – дійсного; 2) вхідні дані\n" +
                "цілого типу, результат – дійсного; 3) вхідні дані дійсного типу, результат – цілого.\n \tChoose task.");
        int task = in.nextInt();
        double result = 0.0;
        System.out.println("Enter first number : ");
        double x = in.nextDouble();
        System.out.println("Enter second number : ");
        double y = in.nextDouble();
        switch (task){
            case 1:
                result = (1/(x*y))+(1/(Math.pow(x,2)+Math.pow(y,2)))*(x-y);
                break;
            case 2:
                int intx = (int) x;
                int inty = (int) y;
                result = (1/(intx*inty))+(1/(Math.pow(intx,2)+Math.pow(inty,2)))*(intx-inty);
                break;
            case 3:
                result =(int) ((1/(x*y))+(1/(Math.pow(x,2)+Math.pow(y,2)))*(x-y));
                break;
        }
        System.out.println("Result is " + result);
    }
    public static void task2(){
        Scanner in = new Scanner(System.in);
        System.out.println("Task 2 \n Задано масив з натуральних чисел" +
                "A(n),n<=500 i B(m), m<=200." +
                "Розробити яка будує симетричну різницю.");
        int A[];
        int B[];
        System.out.println("Enter length for A : ");
        int n= in.nextInt();
        if(n<=500){
            A = new int[n];
        }else {
            System.out.println("OutOfMemory!");
            return;
        }
        for(int i=0;i<n;i++){
            System.out.println("Enter number : ");
            int num = in.nextInt();
            A[i]=num;
        }
        System.out.println("Enter length for B : ");
        int m= in.nextInt();
        if(m<=200){
            B=new int[m];
        }else{
            System.out.println("OutOfMemory!");
            return;
        }
        for (int i=0;i<m;i++){
            System.out.println("Enter number : ");
            int num = in.nextInt();
            B[i]=num;
        }
        int maxlen = Math.max(n,m);
        int C[]= new int[maxlen];
        for (int i = 0; i <maxlen; i++) {
            if (i < n && i < m) {
                if (A[i] != B[i]) {
                    C[i] = A[i];//Тут я вже міг їх використовувати, одразу додаючи їх у set, але на той час я якось не подумав про цю проблему з повторами.
                } else {// set.add(A[i]); і те саме з іншими випадками.Але так як я вирішив не руйнувати логіку цього коду, то вирішив просто вже готовий
                    C[i] = B[i];//Масив додати у множини
                }
            } else if (i < n) {
                C[i] = A[i];
            } else {
                C[i] = B[i];
            }
        }
        Set<Integer> set = new HashSet<>();// Не було ідеї як позбутись елементів, які будуть повторюватись, ця проблема виникає тоді, коли у нас один
        for(int num :C){//Масив більше за інший, в такому випадку числа, які не співпадають за індексом будуть додаватись просто у масив, я вирішив використати
            set.add(num);// множини(Set), бо там автоматично видаляє числа, що дублуються, використав саме HashSet, бо нам не важливий порядок чисел, що у нас є.
        }
        int index=0;
        int Answer[]= new int[set.size()];
        for (int num: set){
            Answer[index]=num;
            index++;
        }
        System.out.println(set);
    }
}
