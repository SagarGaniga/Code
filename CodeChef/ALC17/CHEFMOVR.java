import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class CHEFMOVR
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
            int d = sc.nextInt();

            int array[] = new int[n];
            int mean = 0;
            for(int i = 0;i<n;i++)
            {
                array[i] = sc.nextInt();
                mean+=array[i];
            }
            if(mean % n != 0)
            {
                System.out.println("-1");
                break;
            }
            mean  = mean/n;

            int count = 0;

            for(int i=0;i+d <n;i++)
            {
                if(array[i] == array[i+d])
                {
                    continue;
                }
                else if(array[i]>array[i+d])
                {
                    if(array[i] > mean)
                    {  
                        count+= array[i] - mean;
                        array[i+d]+= array[i] - mean;
                        array[i] = mean;
                    }
                }
                else if(array[i+d]>array[i])
                {
                    if(array[i+d] > mean)
                    {  
                        count+= array[i+d] - mean;
                        array[i]+= array[i+d] - mean;
                        array[i+d] = mean;
                    }
                }
            }
            for(int i = 0;i<n;i++)
            {
                System.out.println(array[i]);
            }
            System.out.println("count : "+count);
        }
    }

    static int abs(int c)
    {
        if(c>=0)
            return c;
        else
            return c*-1;
    }
}