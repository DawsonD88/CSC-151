/* Program will calculate th area of a rectandgle using JOptionPane and Method.
*Deiontay Dawson
*CSC 151 - Java Programming
* Date: 9/5/2025
****************************Pseudocode*******************************
*Ask user "Enter the length of the rectangle:"
*Input length
*Ask user "Enter the width of the rectangle:"
*Input width
*Set area = length * width
*Display "The area of the rectangle is: " + area
*/
import javax.swing.JOptionPane;

public class AreaRec_JOpt{
    public static void main(String[] args) {
        // Menu
        String[] options = {"Rectangle", "Circle"};
        int choice = JOptionPane.showOptionDialog(
            null,
            "Which shape's area do you want to calculate?",
            "Area Calculator",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
        );

        if (choice == 0) { // Rectangle
            String lengthStr = JOptionPane.showInputDialog("Enter the length of the rectangle:");
            String widthStr = JOptionPane.showInputDialog("Enter the width of the rectangle:");

            double length = Double.parseDouble(lengthStr);
            double width = Double.parseDouble(widthStr);

            double rectangleArea = length * width;

            JOptionPane.showMessageDialog(null, 
                "The area of the rectangle is: " + rectangleArea);

        } else if (choice == 1) { // Circle
            String radiusStr = JOptionPane.showInputDialog("Enter the radius of the circle:");

            double radius = Double.parseDouble(radiusStr);

            double circleArea = Math.PI * radius * radius;

            JOptionPane.showMessageDialog(null, 
                "The area of the circle is: " + circleArea);
        } else {
            JOptionPane.showMessageDialog(null, "No option selected. Program will exit.");
        }
    }
}
