import java.util.Scanner;

//Defining class
public class Performance {

    //Declaring a private array of integers named marks to store the marks of 10 students
    private int[] marks;

    //This constructor initializes the marks array with a size of 10 when a Performance object is created
    public Performance() {
        marks = new int[10];
    }

    //User can enter marks for 10 students and store them in the marks array
    public void readMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks for 10 students:");
        for (int i = 0; i < 10; i++) {
            marks[i] = scanner.nextInt();
        }
    }
    //Method to find and return the highest mark in the marks array
    public int highestMark() {
        int max = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > max) {
                max = marks[i];
            }
        }
        return max;
    }

    //Method to find and return the least mark in the marks array
    public int leastMark() {
        int min = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < min) {
                min = marks[i];
            }
        }
        return min;
    }

    //Method to find and return the mode in the marks array
    public int getMode() {
        int mode = marks[0];
        int maxFrequency = 1;

        for (int i = 0; i < marks.length; i++) {
            int currentMark = marks[i];
            int currentFrequency = 1;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] == currentMark) {
                    currentFrequency++;
                }
            }

            if (currentFrequency > maxFrequency || (currentFrequency == maxFrequency && currentMark > mode)) {
                mode = currentMark;
                maxFrequency = currentFrequency;
            }
        }

        return mode;
    }

    //Method to find and return the frequency of the mode in the marks array
    public int getFreqAtMode() {
        int mode = getMode();
        int frequency = 0;

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == mode) {
                frequency++;
            }
        }

        return frequency;
    }

    //Method to print the highest mark, least mark, mode, and mode frequency to the console
    public void display() {
        System.out.println("Highest Mark: " + highestMark());
        System.out.println("Least Mark: " + leastMark());
        System.out.println("Mode: " + getMode());
        System.out.println("Mode Frequency: " + getFreqAtMode());
    }

    //Creating a Performance object, calls the readMarks method to read marks from the user, and then calls the display method to print the results
    public static void main(String[] args) {
        Performance performance = new Performance();
        performance.readMarks();
        performance.display();
    }
}
