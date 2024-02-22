import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        // Запрос пути к файлу с координатами центра и радиусом окружности
        String pathFile1 = pathFiles(scanner, "Введите путь к файлу 1, где указаны координаты центра и радиус окружности: ");
        // Запрос пути к файлу с координатами точек
        String pathFile2 = pathFiles(scanner, "Введите путь к файлу 2, где указаны координаты точек: ");

        // Получение центра и радиуса окружности из файла 1
        float[] centerAndRadius = readFile1(pathFile1);
        float centerX = centerAndRadius[0];
        float centerY = centerAndRadius[1];
        float radius = centerAndRadius[2];

        // Обработка точек из файла 2 и вывод на консоль результата
        readDotsFromFile2(pathFile2, radius, centerX, centerY);
    }

    // Метод для запроса пути к файлам
    private static String pathFiles(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    // Метод для чтения центра и радиуса окружности из файла1
    private static float[] readFile1(String file1) throws IOException {
        float[] centerAndRadiusFromFile1 = new float[3];// мы знаем что будет 3 числа. 1 - координата х центра, 2 - координата y центра, 3 - радиус

        BufferedReader brFile1 = new BufferedReader(new FileReader(file1));
        String line1 = brFile1.readLine();
        if (line1 != null) {
            String[] stringArray = line1.split(" ");

            centerAndRadiusFromFile1[0] = Float.parseFloat(stringArray[0]); // centerX
            centerAndRadiusFromFile1[1] = Float.parseFloat(stringArray[1]); // centerY

            String line2 = brFile1.readLine();
            centerAndRadiusFromFile1[2] = Float.parseFloat(line2); // radius
        }
        return centerAndRadiusFromFile1;
    }

    // Метод для обработки точек из файла
    private static void readDotsFromFile2(String fileName2, float radius, float centerX, float centerY) throws IOException {
        int dotCount = 1;
        BufferedReader points = new BufferedReader(new FileReader(fileName2));{
            String line;
            //dotCount1<101 ограничиваем число, считываемых точек с файла до 100
            while ((line = points.readLine()) != null && dotCount<101) {
                String[] coordinates = line.split(" ");
                float dotX = Float.parseFloat(coordinates[0]);
                float dotY = Float.parseFloat(coordinates[1]);

                float distance = (float) Math.sqrt(Math.pow(dotX - centerX, 2) + Math.pow(dotY - centerY, 2));

                if (distance == radius) {
                    System.out.println("0"); //0 - точка лежит на окружности
                } else if (distance < radius) {
                    System.out.println("1"); //1 - точка внутри
                } else {
                    System.out.println("2"); //2 - точка снаружи
                }
                dotCount++;
            }
        }
    }
}