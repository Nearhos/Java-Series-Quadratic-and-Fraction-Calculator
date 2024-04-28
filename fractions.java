package fractions;



/** Name: Nearhos Hatzinikolaou
* Course: ICS4U
* Date:
* Purpose: Allow the main to access methods stored in the class and store
Different objects
*/
 
public class fractions {
    private double denominator1;
    private double denominator2;
    private double numerator1;
    private double numerator2;
    private int n;
    private static String fractionA;
    private static String fractionB;
    private static String fractionC;
    private static double a,b,c;
    private static double [] aFrac = new double [2];
    private static double [] bFrac = new double [2];
    private static double [] cFrac = new double [2];
    private static long [] aFraclong = new long [2];
    private static long [] bFraclong = new long [2];
    private static long [] cFraclong = new long [2];
    private static double numerator;
    private static double denominator;
 
    // Intialize all the private variables
    public fractions (){
          denominator1 =0;
          denominator2=0;
          numerator1=0;
          numerator2=0;
          n=0;
          a=b=c=0;
          numerator=0;
          denominator=0;
          fractionA = fractionB = fractionC = "";
    }
   
    public static void setQuadraticValues(double newa, double newb, double newc){
        a = newa;
        b = newb;
        c = newc;
    }
   
    public static void setQuadraticValuesFraction(double [] newa, double [] newb, double [] newc){
        aFrac[0] = newa[0];
        bFrac[0] = newb[0];
        cFrac[0] = newc[0];
        aFrac[1] = newa[1];
        bFrac[1] = newb[1];
        cFrac[1] = newc[1];
    }
    public static void setQuadraticValuesFraction(long [] newa, long [] newb, long [] newc){
        aFraclong[0] = newa[0];
        bFraclong[0] = newb[0];
        cFraclong[0] = newc[0];
        aFraclong[1] = newa[1];
        bFraclong[1] = newb[1];
        cFraclong[1] = newc[1];
    }
   
    public static void setFraction(double numer, double deno){
        numerator = numer;
        denominator = deno;
    }
   
    // Checks to see if what the user inputted was a fraction
    // pre: The user input on a "fraction"
    // post: True or false on whether the user input was a fraction
    // True for fraction, false for not a fraction
    public boolean fractionChecker(String fraction) {
        String numerator = "";
        String denominator = "";
        int index = fraction.indexOf('/');
        // Finds the index of / inside of the user input
        if (index != -1) {
            // If the / is found return true
            return true;
        } else {
            // If it is not found, return false and make user re-input their answer
            System.out.println("This input is invalid, try again.");
            long invalid[] = new long[3];
            return false;
        }
    }
 
    // Parses a fraction by taking the string version and turning it into a double
    // array
    // pre: String of the fraction
    // post: Returns the long array fraction
    public static long[] fractionparser(String fraction) {
    	fraction = fraction.trim();
        String numeratorString = "";
        String denominatorString = "";
        int index = fraction.indexOf('/');
     
        // Locate the /
        if (index != -1) {
            numeratorString = fraction.substring(0, index);
            denominatorString = fraction.substring(index + 1);
            // Remove the / and only keeps the numerator and denominator
        } else {
            numeratorString =   fraction;
            denominatorString = "1";
            
        }
 
        char[] numeratorchar = numeratorString.toCharArray();
        char[] denominatorchar = denominatorString.toCharArray();
        // Store each number of the numerator and denominator separately in an array
        int numeratorlength = numeratorString.length();
        int denominatorlength = denominatorString.length();
        // Determine the length of the numerator and denominator
 
        int numeratorbase10 = 0;
        for (int i = 0; i < numeratorlength; i++) {
            if (i == 0) {
                numeratorbase10 = 1;
            } else {
                numeratorbase10 = numeratorbase10 * 10;
            }
            // Turn the numerator into base 10
        }
        int denominatorbase10 = 0;
        for (int i = 0; i < denominatorlength; i++) {
            if (i == 0) {
                denominatorbase10 = 1;
            } else {
                denominatorbase10 = denominatorbase10 * 10;
            }
            // Turn the denominator into base 10
        }
        int[] numeratordigits = new int[numeratorlength];
        // Make an array to store the digits of the numerator
        // Create a boolean to see if numerator will be negative
        boolean numeratorisnegative = false;
        for (int i = 0; i < numeratorlength; i++) {
            char digit = numeratorchar[i];
            int intdigit = (int) (digit);
            if (intdigit >= 48 && intdigit <= 57 || intdigit == 45) {
                // If the number is not negative
                if (intdigit >= 48 && intdigit <= 57) {
                    intdigit = intdigit - 48; // Calculate the number
 
                    numeratordigits[i] = intdigit; // Store the number inside of the array
                } else { // iF the number is negative
                    numeratorisnegative = true;
                }
            } else {
                System.out.println("This input is invalid, try again.");
                long invalid[] = new long[3];
                return invalid;
            }
 
        }
 
        int[] denominatordigits = new int[denominatorlength];
        // Make an array to store the digits of the denominator
        // Create a boolean to see if denominator will be negative
        boolean denominatorisnegative = false;
        for (int i = 0; i < denominatorlength; i++) {
            char digit = denominatorchar[i];
            int intdigit = (int) (digit);
            if (intdigit >= 48 && intdigit <= 57 || intdigit == 45) {
                // If the number is not negative
                if (intdigit >= 48 && intdigit <= 57) {
                    intdigit = intdigit - 48; // Calculate the number
                    denominatordigits[i] = intdigit; // Store the number inside of the array
                } else { // If the number is negative
                    denominatorisnegative = true;
                }
            } else {
                System.out.println("This input is invalid, try again.");
                long invalid[] = new long[3];
                return invalid;
            }
 
        }
 
        int denominatoradded = 0;
        int numeratoradded = 0;
        int divisionfactor = 1;
 
        for (int i = 0; i < numeratorlength; i++) {
 
            numeratoradded = numeratoradded + numeratordigits[i] * (numeratorbase10 / (divisionfactor));
 
            divisionfactor = divisionfactor * 10;
 
        }
        // Convert the numerator to integers
        divisionfactor = 1;
        for (int i = 0; i < denominatorlength; i++) {
            denominatoradded = denominatoradded + denominatordigits[i] * (denominatorbase10 / (divisionfactor));
 
            divisionfactor = divisionfactor * 10;
        }
        // Convert the denominator to integers
        long[] parsedfraction = new long[2];
        if (denominatorisnegative == true && numeratorisnegative == false
                || denominatorisnegative == false && numeratorisnegative == true) {
            // If either the numerator or denominator are negative
            parsedfraction[0] = numeratoradded * -1;
            parsedfraction[1] = denominatoradded;
            // make the fraction negative (denominator can never be negative)
        } else { // If either are not negative
            parsedfraction[0] = numeratoradded;
            parsedfraction[1] = denominatoradded;
            // Store them as they are
        }
        numerator = parsedfraction[0];
        denominator = parsedfraction[1];
        return parsedfraction;
        // Return the parsed fraction
    }
 
   
   
    public fractions(double a, double b, double c) { // Constructor class
        denominator1 = 0;
        denominator2 = 0;
        numerator1 = 0;
        numerator2 = 0;
        n = 0;
        // Sets everything to defualt value
    }
    public fractions(long[] afraction, long[] bfraction, long[] cfraction) { // Constructor class
        denominator1 = 0;
        denominator2 = 0;
        numerator1 = 0;
        numerator2 = 0;
        n = 0;
        // Sets everything to defualt value
    }
 
    public fractions(int n) { // Overloaded constructor class for harmonic sum
        denominator1 = 1;
        denominator2 = n;
        numerator1 = 1;
        numerator2 = 1;
        this.n = n;
    }
 
    public fractions(double denominatoradded, double numeratoradded) { // Overloaded constructor class for maclaurin series
 
        denominator = denominatoradded;
        numerator = numeratoradded;
 
    }
 
    // Adds two fractions with each other by multiplying both with a common
    // denominator
    // pre: The numerator and denominator for both fractions
    // post: Returns the sum in the form of a fraction array
    public double[] addfractions() {
 
        double addednumerator, commondenominator;
        // Intialize the sum of the numerator and common denominator
        if (numerator1 < 0 && denominator1 < 0) {
            // If the numerator is negatative and the denomiantor is also negative
            numerator1 = numerator1 * -1;
            denominator1 = denominator1 * -1;
            // Make the fraction positive as two negatives make a positive
        }
        if (numerator2 < 0 && denominator2 < 0) {
            // Same case here but for the second denominator
            // Make the negative fraction positive
            numerator2 = numerator2 * -1;
            denominator2 = denominator2 * -1;
        }
 
        commondenominator = denominator1 * denominator2;
        // Get the common denominator by multiplying the two denominators together
        numerator1 = numerator1 * denominator2;
        // Update the numerators by cross multiplying
        numerator2 = numerator2 * denominator1;
 
        addednumerator = numerator1 + numerator2;
        // Get the sum of the two numerators
        double[] addedfraction = new double[2];
        // Intialize and store the sum of the two fractions
        addedfraction[0] = addednumerator;
        addedfraction[1] = commondenominator;
 
        return addedfraction;
        // Return the answer
 
    }
    // Adds two fractions with each other by multiplying both with a common
    // denominator
    // pre: The numerator and denominator for both fractions
    // post: Returns the sum in the form of a fraction array
    public long[] addfractionslong(long numerator1, long denominator1, long numerator2, long denominator2) {
 
        long addednumerator, commondenominator;
        // Intialize the sum of the numerator and common denominator
        if (numerator1 < 0 && denominator1 < 0) {
            // If the numerator is negatative and the denomiantor is also negative
            numerator1 = numerator1 * -1;
            denominator1 = denominator1 * -1;
            // Make the fraction positive as two negatives make a positive
        }
        if (numerator2 < 0 && denominator2 < 0) {
            // Same case here but for the second denominator
            // Make the negative fraction positive
            numerator2 = numerator2 * -1;
            denominator2 = denominator2 * -1;
        }
 
        commondenominator = denominator1 * denominator2;
        // Get the common denominator by multiplying the two denominators together
        numerator1 = numerator1 * denominator2;
        // Update the numerators by cross multiplying
        numerator2 = numerator2 * denominator1;
 
        addednumerator = numerator1 + numerator2;
        // Get the sum of the two numerators
        long[] addedfraction = new long[2];
        // Intialize and store the sum of the two fractions
        addedfraction[0] = addednumerator;
        addedfraction[1] = commondenominator;
 
        return addedfraction;
        // Return the answer
 
    }
   
   
    public long[] addfractions(double numerator1, double denominator1, double numerator2, double denominator2) {
         
        double addednumerator, commondenominator;
        // Intialize the sum of the numerator and common denominator
        if (numerator1 < 0 && denominator1 < 0) {
            // If the numerator is negatative and the denomiantor is also negative
            numerator1 = numerator1 * -1;
            denominator1 = denominator1 * -1;
            // Make the fraction positive as two negatives make a positive
        }
        if (numerator2 < 0 && denominator2 < 0) {
            // Same case here but for the second denominator
            // Make the negative fraction positive
            numerator2 = numerator2 * -1;
            denominator2 = denominator2 * -1;
        }
 
        commondenominator = denominator1 * denominator2;
        // Get the common denominator by multiplying the two denominators together
        numerator1 = numerator1 * denominator2;
        // Update the numerators by cross multiplying
        numerator2 = numerator2 * denominator1;
 
        addednumerator = numerator1 + numerator2;
        // Get the sum of the two numerators
        long[] addedfraction = new long[2];
        // Intialize and store the sum of the two fractions
        addedfraction[0] = (long) addednumerator;
        addedfraction[1] = (long) commondenominator;
 
        return addedfraction;
        // Return the answer
 
    }
      // Multiplies two fractions with each other
    // pre: Numerator and denominator of two fractions
    // post: Returns the product of the two fractions in an array
    public double[] fractionmultiply() {
     if (numerator1 < 0 && denominator1 < 0) {
         // If the first fraction has double negative
         // Make the numerator and denominator positive
         numerator1 = numerator1 * -1;
         denominator1 = denominator1 * -1;
     }
     if (numerator2 < 0 && denominator2 < 0) {
         // Same case here
         // Change the double negative into a positive
         numerator2 = numerator2 * -1;
         denominator2 = denominator2 * -1;
     }
     double mulipliednumerator = numerator1 * numerator2;
     // Calculate and store the product of the numerators
     double muliplieddenominator = denominator1 * denominator2;
     // Calculate and store the product of the denominators
     double[] multipliedfraction = new double[2];
     multipliedfraction[0] = mulipliednumerator;
     multipliedfraction[1] = muliplieddenominator;
     // Create an array and store the product of the two fractions
     // (numerator/denominator)
     return multipliedfraction;
     // Return the fraction
 }
 
    // Multiplies two fractions with each other
    // pre: Numerator and denominator of two fractions
    // post: Returns the product of the two fractions in an array
    public long[] fractionmultiply(double numerator1, double denominator1, double numerator2, double denominator2) {
        if (numerator1 < 0 && denominator1 < 0) {
            // If the first fraction has double negative
            // Make the numerator and denominator positive
            numerator1 = numerator1 * -1;
            denominator1 = denominator1 * -1;
        }
        if (numerator2 < 0 && denominator2 < 0) {
            // Same case here
            // Change the double negative into a positive
            numerator2 = numerator2 * -1;
            denominator2 = denominator2 * -1;
        }
        double mulipliednumerator = numerator1 * numerator2;
        // Calculate and store the product of the numerators
        double muliplieddenominator = denominator1 * denominator2;
        // Calculate and store the product of the denominators
        long[] multipliedfraction = new long[2];
        multipliedfraction[0] = (long) mulipliednumerator;
        multipliedfraction[1] = (long) muliplieddenominator;
        // Create an array and store the product of the two fractions
        // (numerator/denominator)
        return multipliedfraction;
        // Return the fraction
    }
   
    // Multiplies two fractions with each other
    // pre: Numerator and denominator of two fractions
    // post: Returns the product of the two fractions in an array
    public long[] fractionmultiplylong(long numerator1, long denominator1, long numerator2, long denominator2) {
        if (numerator1 < 0 && denominator1 < 0) {
            // If the first fraction has double negative
            // Make the numerator and denominator positive
            numerator1 = numerator1 * -1;
            denominator1 = denominator1 * -1;
        }
        if (numerator2 < 0 && denominator2 < 0) {
            // Same case here
            // Change the double negative into a positive
            numerator2 = numerator2 * -1;
            denominator2 = denominator2 * -1;
        }
        long mulipliednumerator = numerator1 * numerator2;
        // Calculate and store the product of the numerators
        long muliplieddenominator = denominator1 * denominator2;
        // Calculate and store the product of the denominators
        long[] multipliedfraction = new long[2];
        multipliedfraction[0] = mulipliednumerator;
        multipliedfraction[1] = muliplieddenominator;
        // Create an array and store the product of the two fractions
        // (numerator/denominator)
        return multipliedfraction;
        // Return the fraction
    }
   
    // Gets the greatest common divisor/factor of a fraction
    // Ex. 10/5 the GCD is 5 as it is the greatest value that can be divided by both
    // numbers
    // pre: Numerator and denominator of a fraction
    // post: Returns the GCD
    public double getGCD() {
        if (denominator % numerator == 0) {
            // If the denominator is divisible by numerator without any leftover
            // Example 2/14 can be 1/7
            double gcd = numerator;
            // The GCD is the numerator
            return gcd;
            // Return the GCD
        } else {
            // If the denominator is not divisble by the numerator
            // Example 6/2
            double remainderofnumerator = denominator % numerator;
            // Store the GCD as the left over
            return getGCD(remainderofnumerator, numerator);
            // Return GCD
        }
    }
   
    // Gets the greatest common divisor/factor of a fraction
    // Ex. 10/5 the GCD is 5 as it is the greatest value that can be divided by both
    // numbers
    // pre: Numerator and denominator of a fraction
    // post: Returns the GCD
    public double getGCD(double numerator, double denominator) {
 
        if (denominator % numerator == 0) {
            // If the denominator is divisible by numerator without any leftover
            // Example 2/14 can be 1/7
            double gcd = numerator;
            // The GCD is the numerator
            return gcd;
            // Return the GCD
        } else {
            // If the denominator is not divisble by the numerator
            // Example 6/2
            double remainderofnumerator = denominator % numerator;
            // Store the GCD as the left over
            return getGCD(remainderofnumerator, numerator);
            // Return GCD
        }
    }
    public long getGCD(long numerator, long denominator) {
    	 
        if (denominator % numerator == 0) {
            // If the denominator is divisible by numerator without any leftover
            // Example 2/14 can be 1/7
           long gcd = numerator;
            // The GCD is the numerator
            return gcd;
            // Return the GCD
        } else {
            // If the denominator is not divisble by the numerator
            // Example 6/2
            long remainderofnumerator = denominator % numerator;
            // Store the GCD as the left over
            return getGCD(remainderofnumerator, numerator);
            // Return GCD
        }
    }
    // Simplifies a fraction to the lowest it can be
    // pre: Numerator and denominator of two fractions
    // post: Returns the simplified fraction
    public double[] factionsimplifier(double numer, double deno) {
 
        double gcd = getGCD(numer,deno);
        // Calculate GCD using previous method
        double[] simplifiedfraction = new double[2];
        simplifiedfraction[0] = numer / gcd;
        simplifiedfraction[1] = deno / gcd;
        // Calculate the simplified fraction by dividing both numerator and denominator
        // by GCD
        // Ex. 2/6 GCD is 2 so divide 2 & 6 by 2 to get 1/3
        if (simplifiedfraction[1] < 0) { // If the denominator is negative
            simplifiedfraction[0] = simplifiedfraction[0] * -1;
            simplifiedfraction[1] = simplifiedfraction[1] * -1;
            // Make both the numerator and denominator negative
        }
        return simplifiedfraction;
        // Return the simplified fraction
 
    }
 // Simplifies a fraction to the lowest it can be
    // pre: Numerator and denominator of two fractions
    // post: Returns the simplified fraction
    public long[] factionsimplifier(long numer, long deno) {
 
         long gcd = getGCD(numer,deno);
        // Calculate GCD using previous method
     
        long[] simplifiedfraction = new long[2];
        simplifiedfraction[0] = numer / gcd;
        simplifiedfraction[1] = deno / gcd;
        // Calculate the simplified fraction by dividing both numerator and denominator
        // by GCD
        // Ex. 2/6 GCD is 2 so divide 2 & 6 by 2 to get 1/3
        if (simplifiedfraction[1] < 0) { // If the denominator is negative
            simplifiedfraction[0] = simplifiedfraction[0] * -1;
            simplifiedfraction[1] = simplifiedfraction[1] * -1;
            // Make both the numerator and denominator negative
        }
        return simplifiedfraction;
        // Return the simplified fraction
 
    }
 
    // Gets the decimal value of the harmonic sum
    // pre: The user inputted number they wanted to go up to
    // post: Returns the harmonic sum in decimal value
    public float decimalvalue(double n) {
        float sum = 0;
        // Loop until the user number is met
        for (float i = 1; i < n + 1; i++) {
            sum = sum + (1 / i);
            // Calculates the sum
        }
        return sum;
        // Returns the harmonic sum
 
    }
 
    // Takes each fraction being added and turns it into a string to display to the
    // user
    // pre: The fraction being added
    // post: Returns the string to display to the user
    public String toString(double[] harmonicdisplay) {
    	String dashes;
    	if(harmonicdisplay[0]>harmonicdisplay[1]) {
    		dashes = spacemaker(harmonicdisplay[0]);
    	}
    	else {
    	 dashes = spacemaker(harmonicdisplay[1]);}
    	
        String fraction = harmonicdisplay[0] + " " + "\n"+dashes+"\n" + harmonicdisplay[1];
        return fraction;
 
    }
    // Takes each fraction being added and turns it into a string to display to the
    // user
    // pre: The fraction being added
    // post: Returns the string to display to the user
    public String toString(long[] harmonicdisplay) {
    	String dashes;
        String fraction;
    	if(harmonicdisplay[1] != 1 && harmonicdisplay[0] != 0) {
    	if(harmonicdisplay[0]>harmonicdisplay[1]) {
    		dashes = spacemaker(harmonicdisplay[0]);
    	}
    	else {
    	 dashes = spacemaker(harmonicdisplay[1]);}
    	
       fraction = harmonicdisplay[0] + " " + "\n"+dashes+"\n" + harmonicdisplay[1];
        return fraction;
 
    }else if(harmonicdisplay[0] == 0) {
    	fraction ="0";
    	return fraction;
    	
    	}
    else {
    	fraction = ""+harmonicdisplay[0];
    	return fraction;
    }
    }
 
    // Takes the numerator of the harmonic sum and creates dashes based on the
    // number
    // pre: Numerator of harmonic sum
    // post: Returns the amount of dashes in a string
    public String spacemaker(double numeratorofharmonicsum) {
        String space = "" + numeratorofharmonicsum + "";
        int dividelength = space.length();
        String dashes = "";
        // Calculates the amount of dashes needed to format it into a fraction for the
        // user
        for (int i = 0; i < dividelength; i++) {
            dashes = dashes + "~";
        }
        // Adds dashes until the it reaches the length of the spaces
        return dashes;
        // Returns the dashes
    }
 // Takes the numerator of the harmonic sum and creates dashes based on the
    // number
    // pre: Numerator of harmonic sum
    // post: Returns the amount of dashes in a string
    public String spacemaker(long numeratorofharmonicsum) {
        String space = "" + numeratorofharmonicsum + "";
        int dividelength = space.length();
        String dashes = "";
        // Calculates the amount of dashes needed to format it into a fraction for the
        // user
        for (int i = 0; i < dividelength; i++) {
            dashes = dashes + "~";
        }
        // Adds dashes until the it reaches the length of the spaces
        return dashes;
        // Returns the dashes
    }
 
 
    // Converts a fraction to decimal form
    // pre: The fraction
    // post: Returns the decimal form of the fraction
    public double fractiontodecimal(double fractionnumerator, double fractiondenominator) {
 
        double decimal = fractionnumerator / fractiondenominator;
        // Divide the numerator by denominator
        return decimal;
        // Return the decimal form
    }
 
    // Square roots the numerator of a fraction if valid
    // pre: The numerator of a fraction
    // post: Squaree root or -1 if it is not valid (decimals)
    public float sqaureroot(long fractionnumerator) {
 
        float sqaureroot = (float) Math.sqrt(fractionnumerator);
        // Calculates the sqrt
        float decimalchecker = fractionnumerator % sqaureroot;
        // Cheats if there is a decimal
        if (decimalchecker != 0) {
            // If there is a decimal it is not valid
            sqaureroot = -1;
        }
        return sqaureroot;
        // Return the square root of the numerator
    }
 
    
    // Finds the root of a quadratic equation
    // pre: The a, b and c values
    // post: Returns the roots in decimal form
    public double[] decimalrootfinder(double a, double b, double c) {
        double result = b * b - 4 * a * c;
        // Cacalculates b^2 - 4ac
        if (result > 0) {
            // If b^2 - 4ac is not negative
            double root1 = (-b + Math.sqrt(result)) / (2 * a);
            double root2 = (-b - Math.sqrt(result)) / (2 * a);
            // Calculate both roots by +-ing it by b then dividing by 2a
            double[] roots = new double[2];
            roots[0] = root1;
            roots[1] = root2;
            return roots;
            // Stores are returns the two roots
        } else if (result == 0) {
            // If b^2 -4ac is 0 there will only be one root
            double root1 = -b / (2 * a);
            // No need to add the sqrt 0 part
            double[] roots = new double[1];
            roots[0] = root1;
            return roots;
        } else { // if it is negative
            double[] roots = new double[3];
            roots[0] = 0;
            roots[1] = 0;
            roots[2] = 0;
            return roots;
            // It is invalid (no such thing as 3 roots)
        }
    }
 
    // Simplifies the radical
    // pre: The radican
    // post: Returns the simplified radical if possible
    public long[] simplifyradical(long radican) {
        double coefficent = 1;
        double inside = radican;
        long[] simplifiedradical = { 1, radican };
 
        // Find all the squares that could be factors and see if they are applicable starting with 4 and running
           // untill it is half as big as the radican since a factor cannnot be as half as big as radican
            // and the sqaure increases by two times the factor which starts a two, this searches for all factors greater than 1
            /// if statment check if goes in an even amount of times if so this is a factor
            // this algothrithm will run untill it finds the largest factor
 
        for (long factor = 2, sqaure = 4; sqaure <= (radican / 2); factor++, sqaure = (factor * factor)) {
            // Is this square a factor?
            double possiblefactor = (double) radican / sqaure;
            if (possiblefactor == (long) (possiblefactor)) {
                simplifiedradical[0] = factor;
                simplifiedradical[1] = (long) possiblefactor;
            }
        }
 
      // Otherwise if possible to be simplified, i will return the original radical
        return simplifiedradical;
    }
 
    // Takes a number and calculates the factorial of it
    // pre: The number
    // post: Returns the factorial
    public double factorial(double number) {
        if (number > 0) // If number is greater than 0
            return number * factorial(number - 1); // Loop multiply it, decreasing the value by 1 each time
        else
            return 1; // Return 1 if it is 0
    }
    // Takes a number and calculates the factorial of it
    // pre: The number
    // post: Returns the factorial
    public long factoriallong(long number) {
        if (number > 0) // If number is greater than 0
            return number * factoriallong(number - 1); // Loop multiply it, decreasing the value by 1 each time
        else
            return 1; // Return 1 if it is 0
    }
 
 
    // Turns an inproper fraction into a mixed fraction
    // pre: The numerator and denominator of a fraction
    // post: Returns the mixed fraction
    public long[] impropertomixed(long n2, long d) {
        long[] mixed = new long[3];
 
        long whole = n2 / d; // Whole number is the amount of times numerator can go into denominator
        long mixedNumerator = Math.abs(n2 % d); // Get the left-over
        // Make the numerator the always postive since it the whole number will already
        // be negative
 
        mixed[0] =  whole;
        mixed[1] =  mixedNumerator;
        mixed[2] =  d;
        // Store and return the mixed fraction
        return mixed;
    }
 
    public void setFractions(double numer1, double deno1, double numer2, double deno2) {
        numerator1 = numer1;
        denominator1 = deno1;
        numerator2 = numer2;
        denominator2 = deno2;
       
    }
 
     // Finds the discriminant of the quadratic equation
     // pre: The fractions of the a,b and c value
     // post: Returns the discriminant
     public  long[] GetDiscriminant() {
 
   long[] discriminant = new long[2]; // Will store the b^2 and 4ac value
     // inside the discriminant
     long[] bsqaured = fractionmultiply(bFrac[0], bFrac[1],bFrac[0],bFrac[1]); // Calculates
     // b^2
     long[] ac = fractionmultiply(aFrac[0], aFrac[1],cFrac[0],cFrac[1]); // Calculates
     // 4ac
     long[] negfourac = {(long) (ac[0] * -4),ac[1]};
   
     if (numerator2 != bFrac[0]) { // If b is a valid fraction
     if (negfourac[0] != 0) { // If 4ac is not 0
     discriminant = addfractions(negfourac[0], negfourac[1], bsqaured[0],
     bsqaured[1]);
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
   
    
           
     // Finds the discriminant of the quadratic equation
     // pre: The fractions of the a,b and c value
     // post: Returns the discriminant
     public  long[] GetDiscriminantlong() {
 
  long[] discriminant = new long[2]; // Will store the b^2 and 4ac value
     // inside the discriminant
     long[] bsqaured = fractionmultiplylong(bFraclong[0], bFraclong[1],bFraclong[0],bFraclong[1]); // Calculates
     // b^2
     long [] ac = fractionmultiplylong(aFraclong[0], aFraclong[1],cFraclong[0],cFraclong[1]); // Calculates
     // 4ac
     long [] negfourac = {ac[0] * -4,ac[1]};
   
     if (numerator2 != bFrac[0]) { // If b is a valid fraction
     if (negfourac[0] != 0) { // If 4ac is not 0
     discriminant = addfractionslong(negfourac[0], negfourac[1], bsqaured[0],
     bsqaured[1]);
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
     public  long[] Get2a() {
    	 
         long[] twoa = new long[2]; // Will store the b^2 and 4ac value
           // inside the discriminant
           twoa = fractionmultiply(2, 1 , aFrac[0],aFrac[1]); // Calculates
           // b^2
         
         
           return twoa; // Returns the discriminant value
           }
   
     public  long[] Get2along() {
 
           long[] twoa = new long[2]; // Will store the b^2 and 4ac value
             // inside the discriminant
             twoa = fractionmultiplylong(2, 1 , aFraclong[0],aFraclong[1]); // Calculates
             // b^2
           
           
             return twoa; // Returns the discriminant value
             }
           
 }
 




