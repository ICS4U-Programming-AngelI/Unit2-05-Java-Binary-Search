import java.util.Scanner; // Import Scanner for user input
import java.util.Arrays; // Import Arrays.
import java.util.Random; // Import Random for generating numbers

/**
 * This program generates 10 random numbers between 0 and 100,
 * sorts them, and lets the user search for a number using Binary Search.
 * The program keeps running until the user types "q".
 */
public final class BinarySearchProgram {

    /**
     * Private constructor to prevent object creation.
     */
    private BinarySearchProgram() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Binary search function to find a number in a sorted array.
     * @param arr The sorted array
     * @param target The number to search for
     * @return The index of the number if found, or -1 if not found
     */
    public static int binarySearch(final int[] arr, final int target) {
        int low = 0; // Start index of the search range
        int high = arr.length - 1; // End index of the search range
        int index = -1; //index if number is not found

        // Keep searching while the range is valid
        while (low <= high) {
            int midpoint = (low + high) / 2; // Calculate the midpoint

            if (target < arr[midpoint]) { // If target is smaller than midpoint
                high = midpoint - 1; // Move the search to the left side
            } else if (target > arr[midpoint]) {
                // If target is larger than midpoint
                low = midpoint + 1; // Move the search to the right side
            } else { // If target equals midpoint
                index = midpoint; // Save the index where it was found
                break; // Exit loop
            }
        }
        return index; // Return index.
    }

    /**
     * Main method of the program.
     * @param args Unused
     */
    public static void main(final String[] args) {
        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); // Random number generator

        while (true) { // Repeat until user quits
            int[] numbers = new int[10]; //Create array to hold 10 numbers

            // Generate 10 random numbers between 0 and 100
            for (int i = 0; i < numbers.length; i++) {
                // Random number from 0 to 100
                numbers[i] = random.nextInt(101);
            }

            Arrays.sort(numbers); // Sort the array in ascending order

            // Display the sorted array to the user
            System.out.println();
            System.out.println("What number are you searching for in");
            System.out.println("the list below? Enter \"q\" to quit.");
            for (int i = 0; i < numbers.length; i++) {
                // Print numbers on one line
                System.out.print(numbers[i] + " ");
            }
            System.out.println(); // New line after printing numbers

            // Ask user for input
            System.out.print("Number: ");
            // Read input as String
            String userInput = scanner.nextLine();

            // Check if user wants to quit
            if (userInput.equalsIgnoreCase("q")) {
                System.out.println("Thank you for playing!");
                break; // Exit the loop
            }

            try {
                // Convert input to integer
                int target = Integer.parseInt(userInput);
                // Call binary search
                int index = binarySearch(numbers, target);

                if (index != -1) { // If number is found
                    System.out.println("The number " + target + "");
                    System.out.println(" is found at index " + index + ".");
                } else { // If not found
                    System.out.println("The number " + target + "");
                    System.out.println(" is not found in the list of numbers.");
                }
            } catch (NumberFormatException e) { // If input is invalid
                System.out.println("Invalid input.");
                System.out.println("Please enter a number or \"q\" to quit.");
            }
        }

        scanner.close(); // Close Scanner.
    }
}
