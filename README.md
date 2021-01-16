# Java-Primes
A small java application that generates primes and compares 2 algorithms.


The first algorithm creates a linked list of primes, then brute force checks potential factors for each number.
The second algorithm uses the seive of Eratosthenes, then creates an array of primes from that sieve.


The appliation times itself in miliseconds.


Below is the usage case to generate all primes up to 1 billion.
The benchmark was completed on:
  Intel Xeon CPU E3-1245 @3.3GHz
  12.0 GB RAM


Usage:
java Primes 1000000000


Output:
Benchmarking 2 algorithms that generate prime numbers.


Generating primes up to: 1000000000
Completed in 1472884 ms.
Showing last 10 primes found: [999999733, 999999739, 999999751, 999999757, 999999761, 999999797, 999999883, 999999893, 999999929, 999999937]


Sieving primes up to 1000000000
Completed in 18390 ms.
Showing last 10 primes found: [999999733, 999999739, 999999751, 999999757, 999999761, 999999797, 999999883, 999999893, 999999929, 999999937]




Summary:
The first algorithm took just under 24 minutes to complete.

The second algorithm (the sieve) took just over 18 seconds to complete.  Which is about 80 times faster.

