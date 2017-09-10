import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class CHEFPDIG
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
            String s = sc.next();
            char[] ch = s.toCharArray();
            ArrayList<Character> res = new ArrayList<Character>();
            for(int i = 0;i<s.length()-1;i++)
            {
                for(int j = i+1;j<s.length();j++)
                {
                    int one = Character.getNumericValue(ch[i])*10 + Character.getNumericValue(ch[j]);
                    int two = Character.getNumericValue(ch[j])*10 + Character.getNumericValue(ch[i]);

                    // System.out.println("One is "+one);
                    // System.out.println("Two is "+two);
                    // System.out.println(one);
                    // System.out.println(two);
                    if(one >= 65 && one <= 90)
                    {
                        //System.out.print((char)one);
                        //res.add((char)one);
                        if(!res.contains((char)one))
                            res.add((char)one);
                    }
                    if(two >= 65 && two <= 90)
                    {
                        //System.out.print((char)two);
                        // res.add((char)two);
                        if(!res.contains((char)two))
                            res.add((char)two);
                    }
                }
            }
            Collections.sort(res);
            for (char a : res) 
            {
                System.out.print(a);    
            }
            System.out.println();
        }
    }
}