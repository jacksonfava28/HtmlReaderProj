import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HTMLReaderProj implements ActionListener {

    private JFrame mainFrame;
    private JTextField urlField, searchField;
    private JTextArea resultsArea;
    private JButton searchButton;

    public HTMLReaderProj() {
        prepareGUI();
    }

    public static void main(String[] args) {
        new HTMLReaderProj();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Simple Search GUI");
        mainFrame.setSize(600, 400);
        mainFrame.setLayout(new GridLayout(4, 1, 0, 0)); // 4 rows, all touching

        // === URL Field ===
        urlField = new JTextField("Enter URL:");
        urlField.setFont(new Font("Arial", Font.PLAIN, 16));

        // === Search Term Field ===
        searchField = new JTextField("Enter Search Term:");
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));

        // === Search Button ===
        searchButton = new JButton("Search Button");
        searchButton.setFont(new Font("Arial", Font.BOLD, 18));
        searchButton.setFocusPainted(false);
        searchButton.setBackground(new Color(70, 130, 180));
        searchButton.setForeground(Color.BLACK);
        searchButton.addActionListener(this);

        // === Results Area ===
        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        resultsArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultsArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // === Add everything to frame ===
        mainFrame.add(urlField);
        mainFrame.add(searchField);
        mainFrame.add(searchButton);
        mainFrame.add(scrollPane);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String url = urlField.getText().trim();
        String term = searchField.getText().trim();

        if (url.isEmpty() || term.isEmpty() ||
                url.equals("Enter URL:") || term.equals("Enter Search Term:")) {
            resultsArea.setText("Please enter both a URL and a search term.");
        } else {
            resultsArea.setText("Searching for \"" + term + "\" in " + url + "...\n\n");
            resultsArea.append("(This is where results would appear)");
        }
    }
}
