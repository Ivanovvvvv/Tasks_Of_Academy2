import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Задайте массив числом n: ");
        int n = scanner.nextInt();

        System.out.print("Введите интервал длины m: ");
        int m = scanner.nextInt();

        if (n <=0 || m < 0) {
            System.out.print("Аргумент n должен целым числом больше 0, аргумент m должен целым неотрицательным числом");
            return;
        }

        int[] circularArray = new int[n];
        for (int i = 0; i < n; i++) {
            circularArray[i] = i + 1;
        }

        int currentIndex = 0;
        StringBuilder path = new StringBuilder();

        do {
            path.append(circularArray[currentIndex]);
            currentIndex = (currentIndex + m-1) % n;
        } while (currentIndex != 0);

        System.out.print("Полученный путь: " + path); //Полученный путь
    }
}