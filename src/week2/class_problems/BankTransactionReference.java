package week2.class_problems;

import java.util.Scanner;

public class BankTransactionReference {

    // Normalize the reference
    public static String normalizeReference(String raw) {

        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference;
        }

        String bankCode = reference.substring(0, 3).toUpperCase();
        String remaining = reference.substring(3);

        return bankCode + remaining;
    }

    // Validate and format the reference
    public static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bankCode = reference.substring(0, 3);

        // Date: ddMMyy
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);

        // Sequence number
        String sequence = reference.substring(9, 14);

        StringBuilder result = new StringBuilder();

        result.append("[")
                .append(bankCode)
                .append("] DATE: ")
                .append(day)
                .append("/")
                .append(month)
                .append("/")
                .append(year)
                .append(" | SEQ: ")
                .append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = scanner.nextLine();

        String normalizedReference = normalizeReference(raw);

        System.out.println(validateAndFormat(normalizedReference));

        scanner.close();
    }
}
