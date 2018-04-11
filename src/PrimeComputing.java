// Assignment #: 11
// Name:
// StudentID:
// Lecture:
// Description: TEST CHANGE PLEASE IGNORE


//We will be using LinkedList as a Queue
import java.util.LinkedList;

public class PrimeComputing
 {
  private int n, lastPrime, primeCount;
  private LinkedList<Integer> originalQueue;
  private LinkedList<Integer> primeQueue;
  private LinkedList<Integer> backupQueue;

  //Constructor to initialize all queues
  public PrimeComputing(int enteredNum)
   {
       n = enteredNum;
       lastPrime = 0;
       primeCount = 0;
       originalQueue = new LinkedList<>();
       primeQueue = new LinkedList<>();
       backupQueue = new LinkedList<>();
       for (int i = 2; i <= n; i++) {
           originalQueue.add(i);
           backupQueue.add(i);
       }

   }

  // computes all prime numbers up to some n
  public void computePrimesUpToN()
   {
       int nextPrime = 2;
       lastPrime = 2;
       
       System.out.println("\nProcessing......");
       
       do {
           nextPrime = originalQueue.pop();
           System.out.println("The next prime to divide: " + nextPrime);

           primeQueue.add(nextPrime);

           int selectedElement = 0;
           int lastElement = originalQueue.getLast();

           do {
               selectedElement = originalQueue.pop();
               if (selectedElement % nextPrime != 0)
                   originalQueue.add(selectedElement);
           } while (selectedElement != lastElement);

           lastPrime = nextPrime;
           
       } while (nextPrime <= Math.sqrt(n));
    
       while (originalQueue.peek() != null) {
           primeQueue.add(originalQueue.pop());
       }

       
   }

  //It prints out all primes up to N, by displaying 10 prime numbers
  //in each line.
  public void printResults()
     {
         System.out.println("\n-----------------------");
         System.out.println("The prime(s) up to " + n);
         System.out.println("-----------------------");
         
         int count = 0;
         primeCount = 0;
         
         while (primeQueue.isEmpty() == false)
         {
             int primeNum = primeQueue.remove();
             System.out.print(primeNum + "\t");
             
             count++;
             //displaying 10 primes in each line
             if (count%10 == 0)
                 System.out.print("\n");
         }
         System.out.println("\n-----------------------");
         primeCount = count;
     }
     
  // It returns the laegest prime that was used to divide other integers
  // in the original queue. Note that this is not the largest prime found.
  public int getMaxPrime()
     {
         return lastPrime;
     }
    
  // It return the count of prime numbers up to n
  public int getCount()
     {
         return primeCount;
     }
}

