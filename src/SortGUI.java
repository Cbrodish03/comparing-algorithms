import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 */
public class SortGUI extends JFrame{

    private static JTextArea outputText;
    private JTextField sizeField;

    public SortGUI() {
        JFrame frame = new JFrame("Sorting Algorithm Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());

        outputText = new JTextArea();
        outputText.setEditable(false);
        frame.add(new JScrollPane(outputText), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(new JLabel("Number of Students:"));
        sizeField = new JTextField(5);
        sizeField.setText("10");    // default value
        buttonPanel.add(sizeField);

        // insertion sort button
        JButton insertionButton = new JButton("Insertion Sort");
        insertionButton.addActionListener((ActionEvent e) -> runSort("insertion"));
        buttonPanel.add(insertionButton);

        // selection sort button
        JButton selectionButton = new JButton("Selection Sort");
        selectionButton.addActionListener((ActionEvent e) -> runSort("selection"));
        buttonPanel.add(selectionButton);

        // bubble sort button
        JButton bubbleButton = new JButton("Bubble Sort");
        bubbleButton.addActionListener((ActionEvent e) -> runSort("bubble"));
        buttonPanel.add(bubbleButton);

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    private void runSort(String algorithm) {
        int size;
        try {
            size = Integer.parseInt(sizeField.getText());
            if (size <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Illegal size, enter value > 0");
            return;
        }

        StudentGenerator generator = new StudentGenerator(size);
        Student[] students = generator.getStudents();
        Sort sorting = new Sort(students);
        switch (algorithm) {
            case "insertion" -> sorting.insertionSort();
            case "selection" -> sorting.selectionSort();
            case "bubble" -> sorting.bubbleSort();
        }

        outputText.setText(sorting.printStatistics());

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortGUI::new);
    }
}
