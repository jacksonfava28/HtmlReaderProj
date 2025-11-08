import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/***
 * Problem: You are given a long string containing multiple hidden words.
 * Write a function that finds and prints
 * the word hidden between two markers ("*" and "~").
 * Identify the song hidden in the text!
 */

public class StringC2 {

    public static void main(String[] args) {
        StringC2 c = new StringC2();
    }

    public StringC2() {
        findHiddenLyrics("hidden_lyrics.txt");
    }

    public void findHiddenLyrics(String fileName) {

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Keep searching for hidden words in the same line
                int start = line.indexOf('*');
                while (start != -1) {
                    int end = line.indexOf('~', start);
                    if (end == -1) break; // No closing marker

                    // Extract the hidden word
                    String hiddenWord = line.substring(start + 1, end);
                    System.out.print(hiddenWord + " "); // Print words on same line

                    // Look for the next '*'
                    start = line.indexOf('*', end);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
// it didn't work when i tried to get the lyrics, only one i had a problem with