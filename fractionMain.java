 
/** Name: Justin Tran
 * Course: ICS4U
 * Date: November 7th, 2022
 * Purpose: Allow the user to open the menu and access the functions of fractions
 */
  package fractions;

import java.util.*;
import java.lang.Math;
 
public class fractionMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        fractions play = new fractions();
        int choice = -1;
 
        System.out.println("Hello and welcome to the world of fractions!");
        System.out.println("Although fractions may be a bit scary and math isn't fun for some people, ");
        System.out.println("We will be giving you four things you can calculate!");
        System.out.println("Please click enter to continue");
        input.nextLine();
 
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            // main menu
            System.out.println("\nMAIN MENU");
            System.out.println("0. Exit");
            System.out.println("1. Find the harmonic sum of a number");
            System.out.println("2. Approximate e to the power of a number");
            System.out.println("3. Determine roots based on a quadratic equation");
            System.out.println("4. Add two fractions");
            System.out.println("5. Multiply two fractions");
            System.out.println("6. Get GCD of a fraction");
            System.out.println("7. Simplify fraction");
            System.out.println("8. Turn improper fraction into a mixed fraction");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            if (choice != 0) {
                if (choice == 1) {
                    System.out.println(
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    harmonicsum(); // Calls upon the harmonic sum calculator
                    input.nextLine(); // For the continue after completing a function
 
                } else if (choice == 2) { // Maclaurin series
                    System.out.println(
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    int i = 0;
                    long x = 0;
                    while (i == 0) { // Loop until an approiate answer is given
                        System.out.println("Enter a x value from -4 to 6");
 
                        x = input.nextLong();
                        input.nextLine();
                        i = 1;
 
                        if (x > 6 || x < -4) { // If a number is out of the range
                            i = 0;
                            System.out.println("The number has to be from -4 to 6, please input a valid number");
                            // Tell the user to reinput a valid number
                        }
                    }
                    calculatemaclaurinseries(x);
 
                } else if (choice == 3) { // Determine roots based on quadratic equation
                    System.out.println(
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println();
                    // Explains to user what their values can be Ex. Integer or Fraction
                    System.out.println(
                            "Do your values contain fractions that cannot be reduced to integers? (Ex. 1/2 cannot be reduced to as whole number (integer) while 1/1 can)");
                    System.out
                            .println("Enter no if it is only integers, if fractions are involved type anything else.");
                    // Explains to enter no if integers are only used and anything else if not used
                    String answer = input.next();
                    input.nextLine();
                    if (answer.equalsIgnoreCase("no")) { // If integers are only used
                        System.out.println(
                                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("Enter a quadratic equation in the form of ax^2+bx+c");
                        System.out.println("Make sure your values are in integer form!");
                        System.out.println("Enter a value: ");
                        double a = input.nextDouble(); // Asks and stores a value of quad formula
                        System.out.println("Enter b value: ");
                        double b = input.nextDouble(); // Asks and stores b value of quad formula
                        System.out.println("Enter c value: ");
                        double c = input.nextDouble(); // Asks and stores c value of quad formula
                        input.nextLine();
                        double[] roots = play.decimalrootfinder(a, b, c); // Bring to Nearhos's method
 
                        if (roots.length == 3) { // If there are 3 roots it is not possible (quadratic has 2 max)
                            System.out.println("This quadratic is not factorable");
                        }
 
                        else if (roots.length == 1) { // If it has one root
                            if (roots[0] == 0) { // If the root is 0
                                System.out.println("Root 1: " + -1 * roots[0]);
                            } else { // If it is anything other than 0
                                System.out.println("Root 1: " + roots[0]);
                            }
                        } else if (roots.length == 2) {
                            System.out.println("Root 1: " + roots[1]); // Print root 1
                            System.out.println("Root 2: " + roots[0]); // Print root 2
                            if (roots[0] == 0) {
                                System.out.println("Root 1: " + -1 * roots[0]); // If a root equals 0
                            }
 
                        }
                    } else { // If fractions are used
                        String afract, bfract, cfract;
                        afract = bfract = cfract = "";
 
                        do { // Loop until all answers are fractions
                            System.out.println(
                                    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("Enter a quadratic equation in the form of ax^2+bx+c");
                            System.out.println("Make sure your values are in fraction form! (numerator/denominator)");
                            System.out.println("Enter a value: ");
                            afract = input.next(); // Asks and stores a value of quad formula
                            System.out.println("Enter b value: ");
                            bfract = input.next(); // Asks and stores b value of quad formula
                            System.out.println("Enter c value: ");
                            cfract = input.next(); // Asks and stores c value of quad formula
                            input.nextLine();
 
                            // If fractions are not used
                            // Goes through a Nearhos's method to see if fractions are used
                            if (play.fractionChecker(afract) == false || play.fractionChecker(bfract) == false
                                    || play.fractionChecker(cfract) == false) {
                                System.out.println("You entered an integer, make sure to enter fractions");
                                System.out.println("Click enter to continue...");
                                input.nextLine();
                                // Make user reinput their answers
                            }
                        } while (play.fractionChecker(afract) == false || play.fractionChecker(bfract) == false
                                || play.fractionChecker(cfract) == false);
                        long[] afraction = play.fractionparser(afract); // Uses Nearhos's method to parser all the
                                                                        // fractions
                        long[] bfraction = play.fractionparser(bfract);
                        long[] cfraction = play.fractionparser(cfract);
 
                        quadraticformula(afraction[0], afraction[1], bfraction[0], bfraction[1], cfraction[0],
                                cfraction[1]); // Calculate the roots
                    }
                } else if (choice == 4) { // Add two fractions together
                    System.out.println(
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter integer for numerator 1: ");
                    int numer1 = input.nextInt(); // Keeps and stores numerator of first fraction
                    System.out.println("Enter integer for denominator 1: ");
                    int deno1 = input.nextInt(); // Keeps and stores denominator of first fraction
                    System.out.println("Enter integer for numerator 2: ");
                    int numer2 = input.nextInt(); // Keeps and stores numerator of second fraction
                    System.out.println("Enter integer for denominator 2: ");
                    int deno2 = input.nextInt(); // Keeps and stores denominator of second fraction
                    input.nextLine();
                    long[] sum = play.addfractions(numer1, deno1, numer2, deno2);
                    // Calls to nearhos's method to add fractions
                    // Stores the answer in an array (0 is numerator, 1 is denominator)
                    long[] simplifiedSum = play.factionsimplifier(sum[0], sum[1]);
                    // Calls to nearhos's method to simplify the sum of the fractions
                    // Stores the simplified answer in an array
                    System.out.println("The sum is:  " + simplifiedSum[0] + "/" + simplifiedSum[1]);
                    // Prints out the sum of the two fractions
 
                } else if (choice == 5) { // Multiply two fractions
                    System.out.println(
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter integer for numerator 1: ");
                    int numer1 = input.nextInt(); // Keeps and stores numerator of first fraction
                    System.out.println("Enter integer for denominator 1: ");
                    int deno1 = input.nextInt(); // Keeps and stores denominator of first fraction
                    System.out.println("Enter integer for numerator 2: ");
                    int numer2 = input.nextInt(); // Keeps and stores numerator of second fraction
                    System.out.println("Enter integer for denominator 2: ");
                    int deno2 = input.nextInt(); // Keeps and stores denominator of second fraction
                    input.nextLine();
                    long[] product = play.fractionmultiply(numer1, deno1, numer2, deno2);
                    // Calls to nearhos's method to multiply fractions
                    // Stores the answer in an array (0 is numerator, 1 is denominator)
                    long[] simplifiedFraction = play.factionsimplifier(product[0], product[1]);
                    // Calls to nearhos's method to simplify the product of the fractions
                    // Stores the simplified answer in an array
                    System.out.println("The product is: " + simplifiedFraction[0] + "/" + simplifiedFraction[1]);
 
                } else if (choice == 6) { // Get the greatest common divisor/factor
                    System.out.println(
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter integer for numerator: ");
                    int numer = input.nextInt(); // Asks and stores numerator
                    System.out.println("Enter integer for denominator: ");
                    int deno = input.nextInt(); // Asks and stores denominator
                    input.nextLine();
                    System.out.println("The GCD is: " + play.getGCD(numer, deno));
                    // Call and print nearhos's method to print out the GCD
                } else if (choice == 7) { // Simplify a fraction
                    System.out.println(
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    int tryagain = 1;
                    long[] fraction = null;
                    while (tryagain == 1) {
                        tryagain = 0;
                        System.out.println("Enter fraction a/b: ");
                        String unsimplifiedfraction = input.next();
                        fraction = play.fractionparser(unsimplifiedfraction);
                        int arraylength = fraction.length;
                        if (arraylength == 3) {
                            tryagain = 1;
                        }
                    }
 
                    long[] simplified = play.factionsimplifier(fraction[0], fraction[1]);
                    // Stores an array of the simplified fraction
                    System.out.println("Simplified fraction : " + simplified[0] + "/" + simplified[1]);
                    // Prints out simplified fraction
                } else if (choice == 8) { // Turn improper to mixed fraction
                    System.out.println(
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter numerator: ");
                    long n = input.nextLong();
                    System.out.println("Enter denominator: ");
                    long d = input.nextLong();
                    input.nextLine();
 
                    long[] mixed = play.impropertomixed(n, d); // Use Nearhos's method to convert
 
                    System.out.println("Mixed fraction: " + mixed[0] + " " + mixed[1] + "/" + mixed[2]);
                    // Print out the mixed fraction
                } else if (choice < 0 || choice > 8) {
                    // If the user choice were any of the numbers not used for the menu
                    input.nextLine();
                    System.out.println(
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You entered an invalid choice, please re-input a new one.");
                    // Inform the user they made a mistake
                }
 
                System.out.println();
                System.out.println("Click enter to continue...");
                // Add a buffer so the user is able to see the function before the menu is shown
                // again
                input.nextLine();
 
                // Make user click enter to pull back menu so the answer/function stays
            }
        } while (choice != 0);
            System.out.println("Goodbye and thank you for your wonderful time.");
    }
 
    // Asks the user to enter their value n and calculates the harmonic sum
    // pre: None
    // post: Brings n to a different method to print the fractions & answer
    // Only prints the decimal value
    public static void harmonicsum() {
        Scanner input = new Scanner(System.in);
        fractions play = new fractions();
        System.out.println("Enter your n value as the denominator");
        long n = input.nextLong(); // Asks and stores the n value user wants
        long harmonicsum[] = new long[2]; // Create an array for the answer
        harmonicsum[0] = 1; // Start off both as 1
        harmonicsum[1] = 1;
        float decimalvalue;
 
        for (long i = 2; i < n + 1; i++) {
            harmonicsum = play.addfractions(harmonicsum[0], harmonicsum[1], 1, i);
            // Keeps on adding until the user number is reached (harmonic sum)
            harmonicsum = play.factionsimplifier(harmonicsum[0], harmonicsum[1]);
            // Simplifies the answer
        }
        System.out.println(harmonicsum[0] + "/" + harmonicsum[1]);
        // Prints out the unsimplified fraction
        String dashes = play.spacemaker(harmonicsum[0]);
        // Makes dashes for fraction
        printHarmonicSum(n, harmonicsum, dashes);
        // Calls a method to print out each fraction in the process
        decimalvalue = play.decimalvalue(n);
        // Calculates decimal value
        System.out.println();
        System.out.println("Approximatley: " + decimalvalue);
        // Prints out the decimal value
 
    }
 
    // Prints out all the fractions used for harmonic sum
    // pre: The n value, answer and the dashes for the fraction
    // post: None, prints the harmonic sum fractions in this function
    public static void printHarmonicSum(long n, long[] harmonicsum, String dashes) {
        for (long i = 1; i < n + 1; i++) {
            if (i == n) {
                System.out.print(" " + 1 + " ");
                System.out.print("   ");
                System.out.print("     ");
                System.out.print(harmonicsum[0]);
                // Prints out the last numerator
            } else {
                System.out.print(" " + 1 + " ");
                System.out.print("   ");
                System.out.print("    ");
                // Prints out all 1 for numerator
            }
        }
 
        System.out.println();
        for (long i = 1; i < n + 1; i++) {
            if (i == n) {
                System.out.print("---");
                System.out.print("   ");
                System.out.print("= ");
                System.out.print("   ");
                System.out.print(dashes);
                // Prints out the dashes
            } else {
                System.out.print("---");
                System.out.print("   ");
                System.out.print("+");
                System.out.print("   ");
                // Prints out the addition sign and dashes for the added fractions
            }
        }
        System.out.println();
 
        for (long i = 1; i < n + 1; i++) {
            if (i == n) {
                System.out.print(" " + i + " ");
                System.out.print("   ");
                System.out.print("      ");
 
                System.out.print(harmonicsum[1]);
                // Same but denominator
            } else if (i > 9) {
                System.out.print(" " + i + " ");
                System.out.print("   ");
                System.out.print("   ");
                // Same but denominator
            } else {
                System.out.print(" " + i + " ");
                System.out.print("   ");
                System.out.print("    ");
                // Same but denominator
            }
 
        }
 
    }
 
    // Finds the discriminant of the quadratic equation
    // pre: The fractions of the a,b and c value
    // post: Returns the discriminant
    public static long[] discriminantfinder(long numerator1, long denominator1, long numerator2, long denominator2,
            long numerator3, long denominator3) {
        fractions frac = new fractions();
        long[] discriminant = new long[2]; // Will store the b^2 and 4ac value inside the discriminant
        long[] bsqaured = frac.fractionmultiply(numerator2, denominator2, numerator2, denominator2); // Calculates b^2
        long[] negfourac = frac.fractionmultiply(numerator1, denominator1, numerator3, denominator3); // Calculates 4ac
        negfourac[0] = negfourac[0] * -4;
 
        if (numerator2 != 0) { // If b is a valid fraction
            if (negfourac[0] != 0) { // If 4ac is not 0
                discriminant = frac.addfractions(negfourac[0], negfourac[1], bsqaured[0], bsqaured[1]);
                // Discriminant is b^2 + 4ac
            } else { // If 4ac is 0
                discriminant = bsqaured;
                // Discriminant is b^2 only
            }
        } else { // If b is not a valid fraction
            discriminant = negfourac; // Discriminant is only 4ac
 
        }
 
        return discriminant; // Returns the discriminant value
    }
 
    // Displays the roots
    // pre: Fraction for both of the roots
    // post: Prints out the two roots
    public static void rootdisplayer(long root1numerator, long root1denominator, long root2numerator,
            long root2denominator) {
        fractions play = new fractions();
        if (root1numerator != 0 && root2numerator != 0) { // If the roots are both not 0 (0 divided by anything is 0)
            long root1[] = play.factionsimplifier(root1numerator, root1denominator); // Simplify first root
            long root2[] = play.factionsimplifier(root2numerator, root2denominator); // Simplify second root
 
            if (root1[1] == 1 && root2[1] == 1) { // If it is an integer (denominator is 0)
                System.out.println("The 1st root is " + root1[0]); // Print out root 1 as an integer
                System.out.println("The 2nd root is " + root2[0]); // Print out root 2 as an integer
            } else if (root1[1] == 1) { // If the first root denominator is the only integer
                System.out.println("The 1st root is " + root1[0] + ""); // Print out the root as an integer
                System.out.println("The 2nd root is " + root2[0] + "/" + root2[1]); // Print out the root as a fraction
            } else if (root2[1] == 1) { // If the second root denominator is the only integer
                System.out.println("The 1st root is " + root1[0] + "/" + root1[1]); // Print out the first root as a
                                                                                    // fraction
                System.out.println("The 2nd root is " + root2[0] + ""); // Print out the second root as an integer
            } else { // If both roots are fractions
 
                System.out.println("The 1st root is " + root1[0] + "/" + root1[1]);
                System.out.println("The 2nd root is " + root2[0] + "/" + root2[1]);
                // Print out both roots as a fraction
            }
        } else if (root1numerator == 0) { // Only the first root is zero
            long root2[] = play.factionsimplifier(root2numerator, root2denominator); // Simplify the fraction of second
                                                                                     // root
            if (root2[1] == 1) { // If the second root is an integer
                System.out.println("The 1st root is 0"); // tell user that the first root is zero
                System.out.println("The 2nd root is " + root2[0]); // Print out the other root as an integer
 
            } else { // If the second root is a fraction
                System.out.println("The 1st root is 0");
                System.out.println("The 2nd root is " + root2[0] + "/" + root2[1]);
                // Print out second root as a fraction
            }
        } else { // If the second root is zero
            long root1[] = play.factionsimplifier(root1numerator, root1denominator); // Simplify first root fraction
            if (root1[1] == 1) { // If the first root is an integer
                System.out.println("The 1st root is " + root1[0]); // Print out the root as an integer
                System.out.println("The 2nd root is 0"); // Tell the user that the second root is zero
 
            } else { // If the first root is a fraction
                System.out.println("The 1st root is " + root1[0] + "/" + root1[1]); // Print out first root as a
                                                                                    // fraction
                System.out.println("The 2nd root is 0");
            }
        }
    }
 
    // Calculates the Maclaurin series based on a user-inputted number
    // pre: The user inputted number between -4-6
    // post: Displays the Maclaurin series sum
    public static void calculatemaclaurinseries(long x) {
        long numeratoradded = 1;
        long denominatoradded = 1;
        long numerator;
        long denominator;
        long[] sumfraction = { 1, 1 };
 
        fractions fract = new fractions(numeratoradded, denominatoradded);
 
        if (x != 0) { // If x isn't 0 (numerator 0 will make everything 0)
 
            for (long n = 1; n < 15; n++) { // Loop until 15 or it will break the code
                long base = x; // Store the base number
                if (x == -1) { // if x is -1
                    base = Math.abs(x); // Take the absolute value of it (make it +)
                }
                numerator = (long) Math.pow(base, n); // Calculate numerator by x to the power of n
 
                denominator = (long) fract.factorial(n); // Get the factorial of n as the denominator
                long gcd = fract.getGCD(numerator, denominator); // Find the GCD
                denominator = denominator / gcd; // Simplify the fraction
                numerator = numerator / gcd;
 
                sumfraction = fract.addfractions(numeratoradded, denominatoradded, numerator, denominator);
                // Keep on adding the sums together
                sumfraction = fract.factionsimplifier(sumfraction[0], sumfraction[1]);
                // Simplify the sum fraction
                numeratoradded = sumfraction[0];
                denominatoradded = sumfraction[1];
                 // Store the sum numerator and denominator in an array
                if (Math.abs(x) == 1 && n == 13) {
                    n = 15;
                }
            }
        }
 
        if (x != -1) { // If x isn't -1 (will give error)
            double decimalval = fract.fractiontodecimal(sumfraction[0], sumfraction[1]);
            // Get the decimal value
            System.out.println("e^" + x + " is equal to = " + sumfraction[0] + " the decimal value is " + decimalval);
            // Display the sum
            String divider = fract.spacemaker(sumfraction[0]);
            System.out.println("                  " + divider);
            System.out.println("                  "
                    + ""
                    + "" + sumfraction[1]);
            // Display the denominator + fraction line
        } else { // If it is -1
            // Same thing here
            double decimalval = fract.fractiontodecimal(sumfraction[1], sumfraction[0]);
            // Swap the numerator and denominator
            System.out.println("e^" + x + " is equal to = " + sumfraction[1] + " the decimal value is " + decimalval);
            String divider = fract.spacemaker(sumfraction[1]);
            System.out.println("                  " + divider);
            System.out.println("                  "
                    + ""
                    + "" + sumfraction[0]);
 
        }
    }
 
    // Calculates the quadratic formula if the values are all fractions
    // pre: The numerator and denominator of the a,b and c values
    // post: Calculates and prints out the roots then goes back to main menu
    public static void quadraticformula(long afractionnumerator, long afractiondenominator, long bfractionnumerator,
            long bfractiondenominator, long cfractionnumerator, long cfractiondenominator) {
        fractions play = new fractions();
        long[] afraction = { afractionnumerator, afractiondenominator };
        long[] bfraction = { bfractionnumerator, bfractiondenominator };
        long[] cfraction = { cfractionnumerator, cfractiondenominator };
        // Stores a,b and c values as a fraction
        long[] discriminant = discriminantfinder(afraction[0], afraction[1], bfraction[0], bfraction[1], cfraction[0],
                cfraction[1]); // Stores the values of b^2 - 4ac inside of an array
 
        // will throw error if a is zero
        if (discriminant[0] == 0) { // If b^2 - 4ac equals 0
            long twoa = 2 * afraction[0]; // Denominator will always be 0 (2*0 = 0)
 
            if (bfraction[0] == 0) { // If the b value is 0
                long[] root = { 0, 0 }; // The root will be 0 (0 +- 0 will still be 0)
                System.out.println("The root is " + root[0]); // Display to the user that the root is 0
            } else { // If the b value is not zero
                long[] root = play.fractionmultiply(afraction[1], twoa, -1 * bfraction[0], bfraction[1]);
                // Calculate the root by multiplying the two fractions of the b value and two a
                // value (two fractions divided is multiplication)
                root = play.factionsimplifier(root[0], root[1]); // Simplify the fraction
                if (root[1] == 1) { // If the root is an integer
                    System.out.println("The root is " + root[0]); // Print out the root as an integer
                } else { // If it is not an integer
                    System.out.println("The root is " + root[0] + "/" + root[1]);
                    // Print out the root as a fraction
                }
            }
 
        } else if (discriminant[0] > 0) { // If the discriminant is greater than 0
            discriminant = play.factionsimplifier(discriminant[0], discriminant[1]);
            // Simplify the discriminant fraction
            if (discriminant[1] == 1) { // If the discriminant is an integer
                float radicansqaured = play.sqaureroot(discriminant[0]);
                // Square root the discriminant using Nearhos's method (also used to check if
                // you get an integer)
                if (radicansqaured != -1) {
                    // If the discriminant square rooted is an integer
                    long twoa = 2 * afraction[0]; // Calculate 2a value
                    long negb = -1 * bfraction[0]; // Get a negative b value
 
                    if (bfraction[0] != 0) {
                        // If b value is not 0
                        long[] negbplusdiscrimsqaured = play.addfractions((long) radicansqaured, discriminant[1], negb,
                                bfraction[1]); // Calculate root one (add)
 
                        long[] negbminusdiscrimsqaured = play.addfractions(-1 * (long) radicansqaured, discriminant[1],
                                negb, bfraction[1]); // Calculate root two (subtract)
                        long[] root1 = play.fractionmultiply(negbminusdiscrimsqaured[0], negbminusdiscrimsqaured[1],
                                afraction[1], twoa); // Divide the numerator by the 2a value for root 1 (add)
                        long[] root2 = play.fractionmultiply(negbplusdiscrimsqaured[0], negbplusdiscrimsqaured[1],
                                afraction[1], twoa); // Divide the numerator by the 2a value for root 2 (subtract)
 
                        rootdisplayer(root1[0], root1[1], root2[0], root2[1]); // Call method to display the two roots
 
                    }
 
                    else { // If b is zero
                        long[] root1 = play.fractionmultiply((long) radicansqaured, discriminant[1], afraction[1],
                                twoa); // Calculate root 1
                        long[] root2 = play.fractionmultiply(-1 * (long) radicansqaured, discriminant[1], afraction[1],
                                twoa); // Calculate root 2
 
                        rootdisplayer(root1[0], root1[1], root2[0], root2[1]);
                        // Instantly display roots without needing to add negb (b = 0 so no need)
 
                    }
                } else { // If radical is not an integer
                    long[] simplifiedradical = play.simplifyradical(discriminant[0]);
                    // Simplify the radical Ex. sqrt(16) is also 2 sqrt(4)
                    long twoa = 2 * afraction[0]; // Calculate the 2a value (without denominator)
                    long negb = -1 * bfraction[0]; // Get -b value for the numerator
                    long[] negbdividby2a = play.fractionmultiply(negb, bfraction[1], 1, twoa);
                    // Calculate the total -b/2a value stored in an array as a fraction
                    System.out.println("Root 1: ");
                    System.out.println(negbdividby2a[0] + "\t \t" + simplifiedradical[0] + "squareroot ("
                            + simplifiedradical[1] + ")");
                    System.out.println("-----\t+\t-----------------------"); // Display Root 1
                    System.out.println(negbdividby2a[1] + "\t \t\t" + twoa + afraction[1]);
                    System.out.println("Decimal form: " + ((negbdividby2a[0]/negbdividby2a[1]) + (Math.sqrt(simplifiedradical[0]*simplifiedradical[1]) / (twoa / afraction[1]))));
                    System.out.println("Root 2: ");
                    System.out.println(negbdividby2a[0] + "\t \t" + simplifiedradical[0] + "squareroot ("
                            + simplifiedradical[1] + ")");
                    System.out.println("-----\t-\t-----------------------");
                    System.out.println(negbdividby2a[1] + "\t \t\t" + twoa + "/" + afraction[1]); // Display root 2
                    System.out.println("Decimal form: " + ((negbdividby2a[0]/negbdividby2a[1]) + (Math.sqrt(simplifiedradical[0]/simplifiedradical[1]) / (twoa / afraction[1]))));
 
                }
            }
 
            else { // If the discriminant is not an integer
 
                float demoninatorradicansqaured = play.sqaureroot(discriminant[1]);
                float numeratorradicansqaured = play.sqaureroot(discriminant[0]);
                // If the denominator and numerator are both squareable
                if (demoninatorradicansqaured != -1 && numeratorradicansqaured != -1) {
 
                    long twoa = 2 * afraction[0]; // Calculate the 2a value (no denominator)
                    long negb = -1 * bfraction[0]; // Calculate the -b value (no denominator)
 
                    if (bfraction[0] != 0) { // If the b value isn't 0
                        long[] negbplusdiscrimsqaured = play.addfractions((long) numeratorradicansqaured,
                                (long) demoninatorradicansqaured, negb, bfraction[1]);
                        // Calculate -b + sqrt(b^2 - 4ac) for root one (plus) and stores it in an array
                        // (fraction)
                        long[] negbminusdiscrimsqaured = play.addfractions(-1 * (long) numeratorradicansqaured,
                                (long) demoninatorradicansqaured, negb, bfraction[1]);
                        // Calculate -b + sqrt(b^2 - 4ac) for root two (subtract) and stores it in an
                        // array (fraction)
                        long[] root1 = play.fractionmultiply(negbminusdiscrimsqaured[0], negbminusdiscrimsqaured[1],
                                afraction[1], twoa);
 
                        long[] root2 = play.fractionmultiply(negbplusdiscrimsqaured[0], negbplusdiscrimsqaured[1],
                                afraction[1], twoa);
                        // Takes the value calculated above and divids it by 2a for both roots
                        rootdisplayer(root1[0], root1[1], root2[0], root2[1]);
                        // Call method to display both roots
                    }
 
                    else { // If b value is 0
                        long[] root1 = play.fractionmultiply((long) numeratorradicansqaured,
                                (long) demoninatorradicansqaured, afraction[1], twoa);
                        long[] root2 = play.fractionmultiply(-1 * (long) numeratorradicansqaured,
                                (long) demoninatorradicansqaured, afraction[1], twoa);
                        // Calculate and store both roots in an array by doing 4ac/2a (no b value)
                        rootdisplayer(root1[0], root1[1], root2[0], root2[1]);
                        // Calls method to print out both roots in a fraction
                    }
                } else { // If the denominator and numerator are not squareable
                    long twoa = 2 * afraction[0];
                    long negb = -1 * bfraction[0];
                    // Calculate and store the -b and 2a values (no denominator)
                    long[] negbdivided2a = play.fractionmultiply(negb, bfraction[1], afraction[1], twoa);
                    // Calculate -b/2a and stores it in an array (fraction)
                    if (bfraction[0] != 0) { // If the b value is not 0
                        negbdivided2a = play.factionsimplifier(negbdivided2a[0], negbdivided2a[1]);
                        discriminant = play.factionsimplifier(discriminant[0], discriminant[1]);
                        // Simplify the -b/2a and discriminant fractions if possible
                        System.out.println("Root 1: ");
                        System.out.println(
                                negbdivided2a[0] + "\t \tsquareroot (" + discriminant[0] + "/" + discriminant[1] + ")");
                        // Displays the numerator of the first root
                        System.out.println("-----\t+\t-----------------------"); // Division symbol
                        System.out.println(negbdivided2a[1] + "\t \t\t" + twoa + "/" + afraction[1]);
                        System.out.println("Root 2: ");
                        System.out.println(
                                negbdivided2a[0] + "\t \tsquareroot (" + discriminant[0] + "/" + discriminant[1] + ")");
                        // Displays the numerator of the second root
                        System.out.println("-----\t-\t-----------------------"); // Division symbol
                        System.out.println(negbdivided2a[1] + "\t \t\t" + twoa + "/" + afraction[1]);
                        // Displays the denominator of the second root
                    } else { // If b is 0
                        System.out.println(
                                "squareroot(" + discriminant[0] + "/" + discriminant[1] + ") / (" + twoa + "/"
                                        + afraction[1] + ")"); // Display the first root without b value
 
                        System.out.println(
                                "- squareroot(" + discriminant[0] + "/" + discriminant[1] + ") / (" + twoa + "/"
                                        + afraction[1] + ")"); // Display the second root without b values
                       
                    }
                }
            }
        } else { // If discriminant is negative
            // Tell the user that there are no zero's in the quadratic equation
            System.out.println("This function has no real solutions");
        }
 
    }
}
 
