
import java.io.*;
import java.sql.*;

public class ExceptionHandlingExamples {

    // ArithmeticException Example
    public static void handleArithmeticException() {
        System.out.println("\nExample: ArithmeticException");
        try {
            // Attempt a division by zero
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }

    // NullPointerException Example
    public static void handleNullPointerException() {
        System.out.println("\nExample: NullPointerException");
        try {
            // Attempt to call a method on a null reference
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("Tried to access something on a null object.");
        }
    }

    // ArrayIndexOutOfBoundsException Example
    public static void handleArrayIndexOutOfBoundsException() {
        System.out.println("\nExample: ArrayIndexOutOfBoundsException");
        try {
            // Access an invalid index in an array
            int[] numbers = {4, 5, 6};
            int invalidIndex = numbers[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index used for the array.");
        }

        try {
            // Access an index beyond the array size
            String[] names = {"Alice", "Bob", "Charlie"};
            String invalidName = names[5]; // Invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Attempted to access an index beyond the array size.");
        }
    }

    // ClassCastException Example
    public static void handleClassCastException() {
        System.out.println("\nExample: ClassCastException");
        try {
            // Attempt an invalid type cast between unrelated types
            Object number = 42; // This is an Integer
            String str = (String) number; // Invalid cast from Integer to String
        } catch (ClassCastException e) {
            System.out.println("Tried to cast an incompatible type.");
        }
    }

    // IllegalArgumentException Example
    public static void handleIllegalArgumentException() {
        System.out.println("\nExample: IllegalArgumentException");
        try {
            // Example of passing an invalid argument to a method
            int age = -5; // Age cannot be negative
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // NumberFormatException Example
    public static void handleNumberFormatException() {
        System.out.println("\nExample: NumberFormatException");
        try {
            // Attempt to parse a non-numeric string as an integer
            int number = Integer.parseInt("NotANumber");
        } catch (NumberFormatException e) {
            System.out.println("Invalid format for number conversion.");
        }

        try {
            // Attempt to parse a string containing special characters as an integer
            int number = Integer.parseInt("123#");
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse a string with special characters into an integer.");
        }
    }

    // IOException Example
    public static void handleIOException() {
        System.out.println("\nExample: IOException");
        try {
            // Simulate reading a non-existent file
            FileReader file = new FileReader("nonexistentfile.txt");
            BufferedReader fileInput = new BufferedReader(file);
            fileInput.readLine();
            fileInput.close();
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }

    // FileNotFoundException Example
    public static void handleFileNotFoundException() {
        System.out.println("\nExample: FileNotFoundException");
        try {
            // Try to open a file that doesn't exist
            FileInputStream file = new FileInputStream("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // EOFException Example
    public static void handleEOFException() {
        System.out.println("\nExample: EOFException");
        try {
            // Attempt to read beyond the end of the file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("somefile.dat"));
            ois.readObject();  // Trying to read when there's no more data
        } catch (EOFException e) {
            System.out.println("Reached the end of the file unexpectedly.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // SQLException Example
    public static void handleSQLException() {
        System.out.println("\nExample: SQLException");
        try {
            // Simulate a database connection failure or SQL error
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nonexistentdb", "user", "password");
            Statement stmt = conn.createStatement();
            stmt.executeQuery("SELECT * FROM users");
        } catch (SQLException e) {
            System.out.println("A database error occurred: " + e.getMessage());
        }
    }

    // ClassNotFoundException Example
    public static void handleClassNotFoundException() {
        System.out.println("\nExample: ClassNotFoundException");
        try {
            // Try loading a class that doesn't exist at runtime
            Class.forName("com.nonexistent.Class");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Demonstrating Exceptions:");

        // Unchecked exceptions
        handleArithmeticException();
        handleNullPointerException();
        handleArrayIndexOutOfBoundsException();
        handleClassCastException();
        handleIllegalArgumentException();
        handleNumberFormatException();

        // Checked exceptions
        handleIOException();
        handleFileNotFoundException();
        handleEOFException();
        handleSQLException();
        handleClassNotFoundException();
    }
}
