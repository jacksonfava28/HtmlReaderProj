import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HTMLReaderProj implements ActionListener {

    private JFrame mainFrame;
    private JTextField urlField, searchField;
    private JTextArea resultsArea;
    private JButton searchButton;

    public static void main(String[] args) {
        new HTMLReaderProj();
    }

    public HTMLReaderProj() {
        prepareGUI();
    }

    // Reads HTML from a URL and extracts links containing the search term
    private void HtmlRead(String urlString, String searchTerm) {
        try {
            URL url = new URL(urlString);
            URLConnection urlc = url.openConnection();
            urlc.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlc.getInputStream())
            );

            String line;
            int foundCount = 0;

            while ((line = reader.readLine()) != null) {
                // Only look for lines with href
                if (line.contains("href=")) {
                    int start = line.indexOf("href=") + 6;
                    String sub = line.substring(start);
                    int end = sub.indexOf("\"");
                    if (end == -1) end = sub.indexOf("'");
                    if (end != -1) {
                        String link = sub.substring(0, end);
//                        System.out.println(line);
                        // Filter links by search term
                        if (link.toLowerCase().contains(searchTerm.toLowerCase())) {
                            resultsArea.append(link + "\n");
                            foundCount++;
                        }
                    }
                }
            }

            if (foundCount == 0) {
                resultsArea.append("No links found containing \"" + searchTerm + "\".");
            }

            reader.close();
        } catch (Exception ex) {
            resultsArea.append("Error: " + ex.getMessage());
        }
    }

    // Sets up GUI
    private void prepareGUI() {
        mainFrame = new JFrame("HTML Link Search");
        mainFrame.setSize(600, 400);
        mainFrame.setLayout(new GridLayout(4, 1));

        urlField = new JTextField("Enter URL:");
        searchField = new JTextField("Enter Search Term:");

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);

        mainFrame.add(urlField);
        mainFrame.add(searchField);
        mainFrame.add(searchButton);
        mainFrame.add(scrollPane);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    // Handles button press
    @Override
    public void actionPerformed(ActionEvent e) {
        String url = urlField.getText().trim();
        String term = searchField.getText().trim();

        resultsArea.setText(""); // Clear old results

        if (url.isEmpty() || term.isEmpty() ||
                url.equals("Enter URL:") || term.equals("Enter Search Term:")) {
            resultsArea.setText("Please enter both a URL and a search term.");
            return;
        }

        resultsArea.append("Searching for links containing \"" + term + "\" at:\n" + url + "\n\n");
        HtmlRead(url, term);
    }
}
