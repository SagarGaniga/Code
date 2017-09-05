import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class AllOrNot
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
        boolean allPresent = true;

        String st = sc.nextLine();
        String s = st.toLowerCase();
        
        boolean[] array = new boolean[26];

        char[] arr = s.toCharArray();
        
        for(int i = 0;i<s.length();i++)
        {   
            if((int)arr[i]  > 96 && (int)arr[i] < 123)
            {
                if(array[(int)arr[i] - 97] == false)
                {
                    array[(int)arr[i] - 97] = true;
                }
            }
        }
        for(int i = 0;i<26;i++)
        {
            if(array[i] == false)
            {
                allPresent = false;
                break;
            }
        }

        if(allPresent)
            System.out.println("pangram");
        else
            System.out.println("not pangram");
    }
}