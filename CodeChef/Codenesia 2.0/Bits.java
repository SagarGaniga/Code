// Akanksha is a lazy engineering student. And needs your help to solve her assignment. 
// She has T numbers and her assignment is to tell number of bits when converted to its 
// binary equivalent to be altered to convert the number to its additive identity. 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class Bits
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
            String s = Integer.toBinaryString(n);
            char[] arr = s.toCharArray();

            // System.out.println();

            int count = 0;
            for (int i = 0;i<arr.length ;i++ ) 
            {
                if(arr[i] == '1')
                {
                    count++;
                }    
            }
            System.out.println(count);            


        }
    }
}
