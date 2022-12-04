import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Запись текста в файл oldFiles.txt
        String text = "Checked Exception - это исключения , которые мы должны обрабатывать . Если \n" +
                "этого не сделать , код не скопелируется.\n" +
                "\n" +
                "Unchecked Exception -  это исключения возникающие во время компиляции кода.\n" +
                "Непроверяемые исключения чаще всего являются следствием ошибок программиста.";
        String result = text.replaceAll("\s+", "");
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\User\\IdeaProjects\\HomrWorkFiles\\oldFiles.txt");
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Программа отработала успешно. Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        //Вывожу его содержимое в концоль
        try {
            FileReader fileReader = new FileReader("C:\\Users\\User\\IdeaProjects\\HomrWorkFiles\\oldFiles.txt");
            Scanner scanner = new Scanner(fileReader);
            System.out.println(" Вот что содержит этот файл : ");
            int i = 1;
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
                i++;
            }
            fileReader.close();

        } catch (FileNotFoundException notFoundException) {
            System.out.println(notFoundException.getMessage());
            System.out.println("Файл не доступен");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n_____________________________________________\n");


        //Копирую содержимое файла oldFiles.txt в новый файл newFiles.txt
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\User\\IdeaProjects\\HomrWorkFiles\\newFiles.txt");
            fileWriter.write(result);
            fileWriter.close();
            System.out.println("Программа отработала успешно. Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        //Вот что получилось на выходе
        try {
            FileReader fileReader = new FileReader("C:\\Users\\User\\IdeaProjects\\HomrWorkFiles\\newFiles.txt");
            Scanner scanner = new Scanner(fileReader);
            System.out.println(" Вот что содержит этот файл : ");
            int i = 1;
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
                i++;
            }
            fileReader.close();

        } catch (FileNotFoundException notFoundException) {
            System.out.println(notFoundException.getMessage());
            System.out.println("Файл не доступен");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n_____________________________________________\n");


        String fileName = "C:\\Users\\User\\IdeaProjects\\HomrWorkFiles\\oldFiles.txt";

        try (BufferedWriter bf = Files.newBufferedWriter(Path.of(fileName),
                StandardOpenOption.TRUNCATE_EXISTING)) {
            System.out.println(fileName +" очищен");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}