import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 

class primeNumber
{
    //Globle arraylist to store prime numbers
    static ArrayList<Integer> primes = new ArrayList<Integer>();
    
    //Class which generates prime numbers
    static class PrimeNumberGenerator
    {
        int n;  

        public PrimeNumberGenerator(int n)
        {
            this.n = n;
            addPrime(); //call the method which adds primary numbers
        }

        void addPrime()
        {
            /*
            *if the number n is not a prime number, it can be factorized into two factors a and b
            * n = a*b 
            *if both a and b are greater than square root of n, a*n would be greater than n
            *So atleast one of those factors must be lesser than square root of n
            *To check if n is a prime number we only need to check for factors less than or equal to square roor
            */

            //Take Square root of n
            int rootn = (int)Math.sqrt(n);
            
            //
            int[] marked = new int[n/2 + 500];

            for (int i=1; i<=(rootn-1)/2; i++)
                    for (int j=(i*(i+1))<<1; j<=n/2; j=j+2*i+1)
                        marked[j] = 1;

            for (int i =0;i<(rootn-1)/2;i++) 
            {
                System.out.println(marked[i])    
            }
            primes.add(2);

            for (int i=1; i<=n/2; i++)
                    if (marked[i] == 0)
                        primes.add(2*i + 1);

            // System.out.println(primes);
        }
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int mm = 200;
        PrimeNumberGenerator png = new PrimeNumberGenerator(mm);
        
        int test = sc.nextInt();
        
        for(int t = 0;t<test;t++)
        {
            int sl = sc.nextInt();
            String string = sc.next();

            char[] ch = string.toCharArray();

            for (int i=0;i<sl;i++) 
            {
                int ascii = ch[i];
                //System.out.println("ascii == "+ascii);    
                char near = (char)getNearestPrime(ascii);

                System.out.print(near);    
            }
            System.out.println();
        }

    }

    public static int getNearestPrime(int ascii)
    {
        int distance = Math.abs(primes.get(0) - ascii);
        int idx = 0;
        for(int c = 1; c < primes.size(); c++)
        {
            int cdistance = Math.abs(primes.get(c) - ascii);
            if(cdistance < distance)
            {
                idx = c;
                distance = cdistance;
            }
        }

        int theNumber = primes.get(idx);
        if(theNumber >= 127)
            return 113;
        else if(theNumber <=65)
            return 67;
        else
            return theNumber;
    }
}

