import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class JONSNOW
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
            int n = sc.nextInt();
            int m = sc.nextInt();

            // int[] a = new int[n];
            // int[] b = new int[m];
            int aCount=0,bCount=0;
            for (int i = 0;i<n;i++) 
            {
                // a[i] = s.nextInt();
                aCount+=sc.nextInt();   
            }

            for (int i = 0;i<m;i++) 
            {
                // b[i] = s.nextInt();  
                bCount += sc.nextInt(); 
            }
            // System.out.println("a = "+aCount+" b = "+bCount);
            if(bCount>aCount)
                System.out.println("Death");
            else
                System.out.println("Snow");
        }
    }
}