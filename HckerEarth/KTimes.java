import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
class KTimes
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
        int n = sc.nextInt();
        int[] count = new  int[n+1];
        
        for(int i = 0;i<n;i++)
        {
            int a = sc.nextInt();
            count[a]++;
        }   
        int k = sc.nextInt();
        for(int i = 0;i<n;i++)
        {
            if(count[i] == k)
            {
                System.out.println(i);
                break;
            }
        }
    }
}