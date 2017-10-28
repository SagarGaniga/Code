import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class BUGCAL
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
            String a = sc.next();
            String b = sc.next();
            int l = b.length();  
            if(a.length() >  b.length())
            {
                l = a.length();                
            }     

            int[] array1 = new int[l];
            int[] array2 = new int[l];

            int len = l-1;
            for (int i = a.length()-1;i >= 0;i-- ) 
            {
                array1[len--] = Character.getNumericValue(a.charAt(i));    
            }

            len = l-1;

            for (int i = b.length()-1;i >= 0;i-- ) 
            {
                array2[len--] = Character.getNumericValue(b.charAt(i));    
            }
            len = l-1;

            String ss = "";
            for (int i = 0;i < l ;i++ ) 
            {
                int ans = array1[i]+array2[i];
                String ssa = Integer.toString(ans);
                ss+=ssa.charAt(ssa.length()-1);    
            }  
            int foo = Integer.parseInt(ss);
            System.out.println(foo); 
        }
    }
}
