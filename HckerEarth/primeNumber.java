import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 

class primeNumber
{
    static ArrayList<Integer> primes = new ArrayList<Integer>();
    static class PrimeNumberGenerator
    {
        int n;

        public PrimeNumberGenerator(int n)
        {
            this.n = n;
            addPrime();
        }

        void addPrime()
        {
            int rootn = (int)Math.sqrt(n);
            int[] marked = new int[n/2 + 500];

            for (int i=1; i<=(rootn-1)/2; i++)
                    for (int j=(i*(i+1))<<1; j<=n/2; j=j+2*i+1)
                        marked[j] = 1;

            primes.add(2);

            for (int i=1; i<=n/2; i++)
                    if (marked[i] == 0)
                        primes.add(2*i + 1);
            
            // System.out.println(primes);
            for (int i = 0; i < primes.size(); i++) 
            {
                System.out.print(primes.get(i)+" ");
            }
            System.out.println();
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
        int test = sc.nextInt();
        PrimeNumberGenerator png = new PrimeNumberGenerator(test);
    }
}