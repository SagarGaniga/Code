import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class Pattern
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
            int k = 2*n - 2;
  
            // outer loop to handle number of rows
            //  n in this case
            for (int i=0; i<n; i++)
            {
     
                // inner loop to handle number spaces
                // values changing acc. to requirement
                for (int j=0; j<k; j++)
                {
                    // printing spaces
                    System.out.print(" ");
                }
      
                // decrementing k after each loop
                k = k - 1;
      
                //  inner loop to handle number of columns
                //  values changing acc. to outer loop
                for (int j=0; j<=i; j++ )
                {
                    // printing stars
                    System.out.print("* ");
                }
      
                // ending line after each row
                System.out.println();
            }
        }
    }
}