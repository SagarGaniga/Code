import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class PERFCONT
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
            int p = sc.nextInt();
            int cake = 0;
            int hard = 0;
            int inp;
            for (int i = 0;i<n;i++) 
            {
                inp = sc.nextInt();
                if(inp >= p/2)
                    cake++;
                else if(inp <= p/10)
                    hard++; 
            }

            if(cake==1 && hard == 2)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
