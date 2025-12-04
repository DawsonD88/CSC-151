import javax.swing.*;
import java.awt.*;

public class Final_Project_Dawson_Deiontay extends JFrame {

    private static final double TABLE_PRICE = 20.0;
    private static final double CHAIR_PRICE = 10.0;

    // From seating chart
    private static final int[] CHAIR_SECTIONS = {
        10,10,9,9,5,5,6,6,6,6,9,9,7,7,4,4,4,4,3,3,8,8,10,10,3,3,4,4,4,4
    };
    private static final int DANCE_FLOOR_CHAIRS = 40;

    public Final_Project_Dawson_Deiontay() {

        setTitle("Wedding Rental Calculator");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 1, 5, 5));

        // Input fields
        JTextField tableField = new JTextField();
        JTextField chairField = new JTextField();

        JButton calcButton = new JButton("Calculate Total");
        JButton autoFillButton = new JButton("Auto-Fill Chairs From Seating Chart");

        JLabel tableLabel = new JLabel("Enter number of Tables (manual):");
        JLabel chairLabel = new JLabel("Enter number of Chairs:");
        JLabel resultLabel = new JLabel("Total: $0.00", SwingConstants.CENTER);

        add(tableLabel);
        add(tableField);
        add(chairLabel);
        add(chairField);
        add(calcButton);
        add(autoFillButton);
        add(resultLabel);

        // Manual calculation
        calcButton.addActionListener(e -> {
            try {
                int tables = Integer.parseInt(tableField.getText());
                int chairs = Integer.parseInt(chairField.getText());

                double total = (tables * TABLE_PRICE) + (chairs * CHAIR_PRICE);
                resultLabel.setText("Total: $" + String.format("%.2f", total));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Enter valid numbers.");
            }
        });

        // Auto-fill chairs only
        autoFillButton.addActionListener(e -> {
            int totalChairs = DANCE_FLOOR_CHAIRS;

            for (int c : CHAIR_SECTIONS)
                totalChairs += c;

            chairField.setText(String.valueOf(totalChairs));  // ONLY CHAIRS auto-filled

            try {
                int tables = Integer.parseInt(tableField.getText()); // USER MUST ENTER TABLES
                double total = (tables * TABLE_PRICE) + (totalChairs * CHAIR_PRICE);
                resultLabel.setText("Total: $" + String.format("%.2f", total));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Chairs have been auto-filled.\nPlease enter table count to calculate total.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Final_Project_Dawson_Deiontay().setVisible(true));
    }
}
