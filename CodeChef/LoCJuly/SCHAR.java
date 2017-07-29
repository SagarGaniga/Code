import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class SCHAR
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

            int[] array = new int[s.length()];

            for (int i =0;i<s.length();i++) 
            {
                array[i] = (int)s.charAt(i);
            }   

            // System.out.println(Arrays.toString(array));
            // System.out.println("part 1");

            int index = 0;
            int cost=0;
            boolean flag= false;
            while(index != s.length()-1)
            {

                flag = false;   
                // System.out.println("part 2");
                for(int j = s.length()-1;j>index;j--)
                {
                    // System.out.println("part 9");
                    if(array[index]==array[j])
                    {
                        // System.out.println("part 6");
                        flag = true;
                        index = j;
                        break;
                    }
                }
                // System.out.println("part 3");
                if(flag==false)
                {
                    // System.out.println("part index");
                    
                    cost += abs(array[index] - array[index+1]);
                    index++;
                }
                // System.out.println(array[index]);
            }
            // System.out.println("part 4");
            System.out.println(cost);
        }
    }

    static int abs(int a)
    {
        // System.out.println("part 5");
        if(a>=0)
            return a;
        else
            return a*-1;
    }
}