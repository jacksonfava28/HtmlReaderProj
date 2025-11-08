/***
 * Problem: You are given a long string containing a hidden word.
 * Write a function that finds and prints
 * the word hidden between two markers ("start" and "end").
 * Expected output: Hidden word: Hello
 */

public class StringC1 {

    public static void main(String[] args) {
        StringC1 c = new StringC1();
    }

    public StringC1() {
        String sentence = "This is a test startHelloend string.";
        findHiddenWord(sentence);  // Output: Hidden word: Hello
    }

    public void findHiddenWord(String sentence) {
        // Find where "start" begins and ends
        int startIndex = sentence.indexOf("start");
        int endIndex = sentence.indexOf("end");

        // Extract the text between "start" and "end"
        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
            String hidden = sentence.substring(startIndex + 5, endIndex);
            System.out.println("Hidden word: " + hidden);
        } else {
            System.out.println("Markers not found.");
        }
    }
}
