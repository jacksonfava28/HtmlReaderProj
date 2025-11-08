/***
 * Problem: You are given an email address, and you need to extract the username
 * (everything before the @ symbol).
 * Write a method that returns the username from an email string.
 * Expected output: Username: kim_possible25
 */

public class StringA {

    public static void main(String[] args) {
        StringA a = new StringA();
    }

    public StringA() {
        String email = "kim_possible25@milton.edu";
        System.out.println("Username: " + findUsername(email)); // Output: Username: kim_possible25
    }

    public String findUsername(String email) {
        // Find the index position of the '@' symbol
        int atIndex = email.indexOf('@');

        // Return everything before '@'
        return email.substring(0, atIndex);
    }

}
