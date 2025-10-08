/* Program will calculate the volume and area of various shapes using JOptionPane Method.
*Deiontay Dawson
*CSC 151 - Java Programming
* Date: 10/8/2025

****************************Pseudocode*******************************

*/
/* Import programs to utilize the JOpt and some additional visuals */
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/* Intro dialog block (initial popup)*/
public class JavaLlama_Dawson_Deiontay {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
            "Hello, I am JavaLlama! Let's calculate some areas and volumes!");

        while (true) {
            String[] mainOptions = {"2-D", "3-D", "Exit"}; /* Options to choose 2-D, 3-D, or Exit */
            int choice = JOptionPane.showOptionDialog(
                null,
                "Choose a 2-D or 3-D shape!",
                "JavaLlama Area & Volume Calculator",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                mainOptions,
                mainOptions[0]
            );

            if (choice == -1 || choice == 2) break; /* Insert if/else loop to allow user to make multiple calclations without exit */

            if (choice == 0) handle2DShapes();
            else if (choice == 1) handle3DShapes();

            int again = JOptionPane.showConfirmDialog(
                null, "Do you want to calculate another shape?", 
                "Continue?", JOptionPane.YES_NO_OPTION
            );
            if (again != JOptionPane.YES_OPTION) break;
        }

        JOptionPane.showMessageDialog(null, "Goodbye from JavaLlama!");
    }
/* Choose 2-D shape option, insert variables to calculate */
    private static void handle2DShapes() {
        String[] shapes2D = {"Rectangle", "Circle", "Triangle", "Square", "Rhombus"};
        int shapeChoice = JOptionPane.showOptionDialog(
            null,
            "Which 2-D shape's area do you want to calculate?",
            "2-D Area Calculator",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            shapes2D,
            shapes2D[0]
        );
/* If/switch statements allows flow when switching shapes for functionality */
        if (shapeChoice == -1) return;

        switch (shapeChoice) {
            case 0 -> { // Rectangle
                double width = getDouble("Enter the rectangle width:");
                double height = getDouble("Enter the rectangle height:");
                double area = width * height;
                showResult("Rectangle", "A = width × height", area);
            }
            case 1 -> { // Circle
                double radius = getDouble("Enter the circle radius:");
                double area = Math.PI * Math.pow(radius, 2);
                showResult("Circle", "A = π × r²", area);
            }
            case 2 -> { // Triangle
                double base = getDouble("Enter the triangle base:");
                double triHeight = getDouble("Enter the triangle height:");
                double area = 0.5 * base * triHeight;
                showResult("Triangle", "A = ½ × base × height", area);
            }
            case 3 -> { // Square
                double side = getDouble("Enter the square side length:");
                double area = Math.pow(side, 2);
                showResult("Square", "A = side²", area);
            }
            case 4 -> { // Rhombus
                double d1 = getDouble("Enter the first diagonal:");
                double d2 = getDouble("Enter the second diagonal:");
                double area = 0.5 * d1 * d2;
                showResult("Rhombus", "A = ½ × d₁ × d₂", area);
            }
        }
    }
/* Same as 2-D format */
    private static void handle3DShapes() {
        String[] shapes3D = {"Sphere", "Cube", "Cylinder", "Cone", "Pyramid"};
        int shapeChoice = JOptionPane.showOptionDialog(
            null,
            "Which 3-D shape's volume do you want to calculate?",
            "3-D Volume Calculator",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            shapes3D,
            shapes3D[0]
        );

        if (shapeChoice == -1) return;

        switch (shapeChoice) {
            case 0 -> { // Sphere
                double radius = getDouble("Enter the sphere radius:");
                double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
                showResult("Sphere", "V = ⁴⁄₃ × π × r³", volume);
            }
            case 1 -> { // Cube
                double side = getDouble("Enter the cube side length:");
                double volume = Math.pow(side, 3);
                showResult("Cube", "V = side³", volume);
            }
            case 2 -> { // Cylinder
                double radius = getDouble("Enter the cylinder radius:");
                double height = getDouble("Enter the cylinder height:");
                double volume = Math.PI * Math.pow(radius, 2) * height;
                showResult("Cylinder", "V = π × r² × h", volume);
            }
            case 3 -> { // Cone
                double radius = getDouble("Enter the cone radius:");
                double height = getDouble("Enter the cone height:");
                double volume = (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
                showResult("Cone", "V = ⅓ × π × r² × h", volume);
            }
            case 4 -> { // Pyramid
                double baseSide = getDouble("Enter the pyramid base side length:");
                double pyramidHeight = getDouble("Enter the pyramid height:");
                double volume = (1.0 / 3.0) * Math.pow(baseSide, 2) * pyramidHeight;
                showResult("Pyramid", "V = ⅓ × base² × height", volume);
            }
        }
    }

    private static double getDouble(String prompt) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, prompt);
            if (input == null) return Double.NaN;
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    private static void showResult(String shape, String formula, double value) {
        if (Double.isNaN(value)) return;
        JOptionPane.showMessageDialog(
            null,
            shape + "\nFormula: " + formula + "\nResult: " + String.format("%.2f", value),
            shape + " Calculation",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
