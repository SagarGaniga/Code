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
        // Scanner sc = new Scanner(System.in);
        // int test = sc.nextInt();
        // for(int t = 0;t<test;t++)
        // {
            //number of elements
            int n = sc.nextInt();
            

            //array to hold the count
            //Java initializes it to 0
            long[] arr = new long[n];
            long[] count = new long[n];
            
            for(int i = 0;i<n;i++)
            {
                arr[i] = sc.nextLong();
                count[(int)arr[i]]++;
            }   
            int k = sc.nextInt();
            ArrayList<Long> al = new ArrayList<Long>();
            for(int i = 0;i<n;i++)
            {
                if(count[i] == k)
                {
                    // System.out.println(arr[i]);
                    al.add(arr[i]);
                }
            }
            Collections.sort(al);
            System.out.println(al.get(0));

        // }
    }
}