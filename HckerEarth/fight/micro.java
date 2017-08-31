import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class micro
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
        
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] shops = new int[n];
        for (int i =0;i<n;i++) 
        {
            shops[i] = sc.nextInt();    
        }
        for (int i = 0;i<q;i++) 
        {
            int count = 0;
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c =sc.nextInt();

            int[] copy = Arrays.copyOfRange(shops, a-1, b);    
            
            Arrays.sort(copy);
            for (int j = 0;j < copy.length;j++) 
            {
                if(copy[i] > c)
                    break
                count++;
                //System.out.println(copy[j]);    
            }
            System.out.println(count);
        }
    }
}