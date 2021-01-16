import java.util.LinkedList;
import java.util.Arrays;


public class Primes {

    public static void generatePrimes(int limit){

        long start = System.currentTimeMillis();

        LinkedList<Integer> primes = new LinkedList<Integer>();
        //add 2 to our primes, so we can start with 3
        // and increment our potential prime by 2
        primes.add(2);
        boolean isPrime = true;
        int numOfPrimes = 1;
        
        for (int potential=3; potential<limit; potential+=2) {
            //loop through the primes already collected
            //to check for multiples.
            //we only have to check up to the square root of
            //the potential prime
            for (int prime : primes) {
                if (Math.pow(prime, 2) > potential) {
                    break;
                }
                if (potential % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(potential);
                numOfPrimes += 1;
            }
            //reset this variable
            isPrime = true;
        }
        long end = System.currentTimeMillis();

        //gather the last 10 items of the linked list
        LinkedList<Integer> last10 = new LinkedList<Integer>();
        for (int x = numOfPrimes - 10; x<numOfPrimes; x++) {
            last10.add(primes.get(x));
        }

        //print the last 10 primes found
        System.out.println("Completed in " + (end - start) + " ms.");
        System.out.println("Showing last 10 primes found: " + last10);
        System.out.println();
    }

    public static void sieve(int limit) {

    	long start = System.currentTimeMillis();

        boolean[] sieve = new boolean[limit];

        //keep track of how many primes there are
        int numOfPrimes = 1;

        //mark 0, 1 as composite
        //
        //if the sieve[x] == false, then it is prime
        sieve[0] = true;
        sieve[1] = true;

        //mark all multiples of 2 as composite
        for (int multiple = 4; multiple < limit; multiple += 2) {
            sieve[multiple] = true;
        }

        for (int potential = 3; potential < limit; potential += 2) {
            //check if the current potential prime is composite
            //false == prime
            if (sieve[potential] == false) {
                //keep track of how many primes there are
                numOfPrimes += 1;
                //mark all multiples as true
                for (int factor = (int)Math.pow(potential, 2); factor < limit; factor += potential) {
                    sieve[factor] = true;
                }
            }
        }

        //convert the sieve to an array of primes
        int[] primes = new int[numOfPrimes];
        int currentPrime = 0;
        for (int x = 0; x < limit; x++) {
            if (sieve[x] == false) {
                primes[currentPrime] = x;
                currentPrime += 1;
            }
        }

        long end = System.currentTimeMillis();

        //gather the last 10 items of the linked list
        LinkedList<Integer> last10 = new LinkedList<Integer>();
        for (int x = primes.length - 10; x < primes.length; x++) {
            last10.add(primes[x]);
        }

        //print the last 10 primes found
        System.out.println("Completed in " + (end - start) + " ms.");
        System.out.println("Showing last 10 primes found: " + last10);
        System.out.println();

    }

    public static void main(String []args) {

        if (args.length != 1) {
            System.out.println("Error.  Takes exactly 1 arguement.");
            System.exit(1);
        }
        try {
            //convert given arguement to a int and create
            //a linked list to store the primes
            int limit = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {
            System.out.println("Error.  Arguement given must be a valid integer.");
            System.exit(1);
        }
        int limit = Integer.parseInt(args[0]);
        if (limit < 100) {
            System.out.println("");
            System.exit(1);
        }

        System.out.println("Benchmarking 2 algorithms that generate prime numbers.");
        System.out.println();
        System.out.println("Generating primes up to: " + args[0]);
        generatePrimes(limit);
        System.out.println("Sieving primes up to " + args[0]);
        sieve(limit);
        
    }

}

    