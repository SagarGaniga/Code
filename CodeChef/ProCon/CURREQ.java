import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class CURREQ
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
        for(int q = 0;q<test;q++)
        {
            int s = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int t = sc.nextInt();

            int l = lcm(x,y);
            s= s*(l/x);
            x=l;
            t = t*(l/y);

            int g = greatestCommonFactor(s,x,t);

            System.out.println((s/g)+" "+(x/g)+" "+(t/g));
 

        }
    }

    static int lcm(int a, int b)
    {
        return a * (b / gcd(a, b));
    }

    static int gcd(int a, int b)
    {
        while (b > 0)
        {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    static int greatestCommonFactor(int a, int b, int c)
    {
        int limit = (int)Math.min(a, b);
        limit = Math.min(limit, c);
        for(int n = limit; n >= 2; n--)
        {
            if ( (a % n == 0) && (b % n == 0) && (c % n == 0) ) {
                return n;
            }
        }

        return 1;
    }
}