/***
 * Problem: In social media, hashtags always start with the "#" symbol.
 * Write a method that extracts and prints all the hashtags from a given string.
 * Expected output: Hashtag: #coding, Hashtag: #Java
 */

public class StringB {

    public static void main(String[] args) {
        StringB b = new StringB();
    }

    public StringB() {
        String post = "I love #coding and #Java!";
        extractHashtags(post); // Output: Hashtag: #coding, Hashtag: #Java
    }

    public void extractHashtags(String post) {
        // Split the string into words using spaces as separators
        String[] words = post.split(" ");

        // Loop through each word
        for (String word : words) {
            // Check if the word starts with '#'
            if (word.startsWith("#")) {
                // Remove punctuation like commas or exclamation points at the end
                word = word.replaceAll("[^#\\w]", "");
                System.out.println("Hashtag: " + word);
            }
        }
    }
}
