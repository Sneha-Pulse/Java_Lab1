public class Alphabetwar{                              
    //Defining the class, which basically are blueprints for creating objects that encapsulate attributes and methods

//To declare two static String variables that represent the letters associated with the left and right sides in the battle
    private static String left_letters = "wpsb";
    private static String right_letters = "mqdz";

//Assign strengths to each letter using static variables
    private static  int strength_w = 4;
    private static  int strength_p = 3;
    private static  int strength_b = 2;
    private static  int strength_s = 1;
    private static  int strength_m = 4;
    private static  int strength_q = 3;
    private static  int strength_d = 2;
    private static  int strength_z = 1;

//default constructor
    public Alphabetwar() {                           
        //Constructors are special methods used to initialize objects when they are created            
    }

//Parameterized constructor that allows setting the strength of each letter when creating an instance of the class
    public Alphabetwar(int w, int p, int b, int s, int m, int q, int d, int z) {
        strength_w = w;
        strength_p = p;
        strength_b = b;
        strength_s = s;
        strength_m = m;
        strength_q = q;
        strength_d = d;
        strength_z = z;
    }

//Takes a single word and determines the winner based on the strengths of its letters, it then determines the winner or declares a tie
    public String battle(String word) {
        int leftStrength = 0;
        int rightStrength = 0;

        for (char letter : word.toCharArray()) {
            if (left_letters.indexOf(letter) != -1) {
                leftStrength += getStrength(letter);
            } else if (right_letters.indexOf(letter) != -1) {
                rightStrength += getStrength(letter);
            }
        }

        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (rightStrength > leftStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

//Takes two words and compares their strengths to determine the winner, it then determines the winner or declares a tie
    public String battle(String leftWord, String rightWord) {
        int leftStrength = Strength(leftWord, left_letters);
        int rightStrength = Strength(rightWord, right_letters);

        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (rightStrength > leftStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

//This private method calculates the strength of a word based on the letters it contains and a given set of side letters
    private int Strength(String word, String sideLetters) {
        int strength = 0;

        for (char letter : word.toCharArray()) {
            if (sideLetters.indexOf(letter) != -1) {
                strength += getStrength(letter);
            }
        }

        return strength;
    }

//This private method returns the strength associated with a specific letter
    private int getStrength(char letter) {
        switch (letter) {
            case 'w':
                return strength_w;
            case 'p':
                return strength_p;
            case 'b':
                return strength_b;
            case 's':
                return strength_s;
            case 'm':
                return strength_m;
            case 'q':
                return strength_q;
            case 'd':
                return strength_d;
            case 'z':
                return strength_z;
            default:
                return 0; 
        }
    }

//The main method is the entry point of the program, it creates an Alphabetwar object and calls the battle method to simulate battles and print the results
    public static void main(String[] args) {
        Alphabetwar game = new Alphabetwar();
        System.out.println(game.battle("z"));         
        System.out.println(game.battle("zdqmwpbs")); 
        System.out.println(game.battle("wwwwwwz"));   
    }
}
