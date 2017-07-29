import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class MAXOR
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
        int t = sc.nextInt();
        for(int o = 0;o<t;o++)
        {
            int n = sc.nextInt();
            long count=0;
            int[] array = new int[n];
            for (int i =0;i<n;i++) 
            {
                array[i] = sc.nextInt();    
            }
            // System.out.println("sagar");
            for (int i=0;i<n-1;i++) 
            {
                for (int j = i+1;j<n;j++) 
                {  
                    // System.out.println(i+" = "+array[i]+" "+j+" = "+array[j]+" "+Math.max(array[i], array[j])); 
                    long a = array[i] | array[j];
                    if(a <= Math.max(array[i], array[j]))
                    {
                        count++;
                    }        
                }    
            }

            System.out.println(count);
        }
    }
}