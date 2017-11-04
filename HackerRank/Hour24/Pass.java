import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class Pass
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
        int test = 1;
        for(int t = 0;t<test;t++)
        {
            int aa= sc.nextInt();
            String pass = sc.next();
            boolean[] isIt = new boolean[4];

            if(pass.length() >= 6)
            {
                for(int i =0;i<pass.length(); i++)
                {
                    int a = pass.charAt(i);
                    // System.out.println(a);
                    if(a >= 48 && a <= 57)
                        isIt[0] = true;
                    
                    if(a >= 97 && a <= 122)
                        isIt[1] = true;

                    if(a >= 65 && a <=  90)
                        isIt[2] = true; 

                    if(a >= 33 && a<=43)
                        isIt[3] = true;
                }
                int count = 0;
                for (int i = 0 ; i<4;i++ ) 
                {
                    if(isIt[i] == false)
                        count++;
                }
                System.out.println(count);
            }
            else
            {
                System.out.println(6-pass.length());
            }
        }
    }
}
