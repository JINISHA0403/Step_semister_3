package week2.class_problems;

import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {

        // Check if phone number has exactly 10 digits
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Get last 4 digits
        String lastFourDigits = phone.substring(6);

        // Create masked phone number
        StringBuilder maskedNumber = new StringBuilder("XXXXXX");
        maskedNumber.append(lastFourDigits);

        // Insert hyphen
        maskedNumber.insert(6, "-");

        return maskedNumber.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        System.out.println(maskPhoneNumber(phone));

        scanner.close();
    }
}