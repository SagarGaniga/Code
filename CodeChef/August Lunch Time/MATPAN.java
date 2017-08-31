import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class MATPAN
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
            int[] n_array = new int[26];
            for(int i = 0;i<26;i++)
            {
                n_array[i] = sc.nextInt();
                //n_array[i] = i+1;
            }
            String s = sc.next();
            char[] s_array =  s.toCharArray();
            int[] ascii = new int[s.length()];
            for(int i = 0;i<s.length();i++)
            {
                ascii[i] = (int)s_array[i];
                ascii[i] = ascii[i]- 97;
            }
            boolean[] marked = new boolean[26]; 
            for(int i = 0;i<s.length();i++)
            {
                // System.out.println(marked[i]);
                if(marked[ascii[i]] == false)
                {
                    marked[ascii[i]] = true;
                }
            }
            int count = 0;
            for(int i = 0;i<26;i++)
            {
                if(marked[i]==false)
                {
                    count+= n_array[i];
                }
            }
            System.out.println(count);


        }
    }
}