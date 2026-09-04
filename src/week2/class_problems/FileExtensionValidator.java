package week2.class_problems;

import java.util.Scanner;

public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {

        int lastDot = filename.lastIndexOf('.');

        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "Rejected - invalid file type";
        }

        String extension = filename.substring(lastDot + 1);

        if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip")) {

            return "Accepted";
        } else {
            return "Rejected - invalid file type";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        System.out.println(validateFileExtension(filename));

        scanner.close();
    }
}
