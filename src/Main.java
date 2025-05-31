import java.util.Scanner;
/**
 * Main class for project, expects user input from terminal to guide process and visualization
 */
public class Main {
    // ask user the size of input (number of students)
    // ask user what sorting algorithm they want to use
    // tell user statistics of the sort they just performed (number of comparisons and swaps, time?, etc.)

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String algorithm;
        int size;
        Sort sort;
        StudentGenerator generator;

        do {
            System.out.println("How many students would you like to generate? [ex. 100]");
            size = scanner.nextInt();
            generator = new StudentGenerator(size);
            sort = new Sort(generator.getStudents());

            System.out.println("What sorting algorithm would you like to use? [insertion/bubble/selection]");
            algorithm = scanner.next();
            if (algorithm.startsWith("i") || algorithm.startsWith("I")) {
                System.out.println("Performing insertion sort on an array of " + size + " students!" );
                long startTime = System.nanoTime();
                sort.insertionSort();
                long endTime = System.nanoTime();
                System.out.println(sort.printStatistics());
                System.out.println("Sort time: " + ((endTime - startTime) / 1000000) + "ms");
            }
            else if (algorithm.startsWith("b") || algorithm.startsWith("B")) {
                System.out.println("Performing bubble sort on an array of " + size + " students!" );
                long startTime = System.nanoTime();
                sort.bubbleSort();
                long endTime = System.nanoTime();
                System.out.println(sort.printStatistics());
                System.out.println("Sort time: " + ((endTime - startTime) / 1000000) + "ms");
            }
            else if (algorithm.startsWith("s") || algorithm.startsWith("S")) {
                System.out.println("Performing selection sort on an array of " + size + " students!" );
                long startTime = System.nanoTime();
                sort.selectionSort();
                long endTime = System.nanoTime();
                System.out.println(sort.printStatistics());
                System.out.println("Sort time: " + ((endTime - startTime) / 1000000) + "ms");
            }


            System.out.println("Would you like to run another sort? [Y/N]");
            input = scanner.next();
        } while (input.startsWith("y") || input.startsWith("Y"));
        scanner.close();
    }
}
