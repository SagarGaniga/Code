import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class gcdtest
{
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
        // Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0;t<test;t++)
        {
            int arr[] = { 1, 2, 4, 8, 8, 12 };
            int n = arr.length / arr[0].length;

            int y = findMaxGCD(arr,n);
            System.out.println(y);
        }
    }

    public static int findMaxGCD(int[] arr, int n)
    {
        int high = 0;
        for (int i = 0; i < n; i++)
            high = max(high, arr[i]);
        int divisors[] = new int[high+1];

        for (int i = 0; i < n; i++)
        {
            // Calculating all the divisors
            for (int j = 1; j <= sqrt(arr[i]); j++)
            {
                // Divisor found
                if (arr[i] % j == 0)
                {
                    // Incrementing count for divisor
                    divisors[j]++;
     
                    // Element/divisor is also a divisor
                    // Checking if both divisors are
                    // not same
                    if (j != arr[i] / j)
                        divisors[arr[i] / j]++;
                }
            }
        }
    }
}