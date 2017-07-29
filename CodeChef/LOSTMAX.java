import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class LOSTMAX
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
            String s = sc.nextLine();
            
            //ArrayList al = new ArrayList();
            String[] arr = s.split("\\s+");
            
            // System.out.println(Arrays.toString(arr));
            int[] array = new int[arr.length];
            for(int i =0;i<arr.length;i++)
            {
                array[i] = Integer.parseInt(arr[i]);
            }

            // for (int i = 0;i<array.length ;i++ ) 
            // {
            //     System.out.println(array[i]+2);    
            // }

            
            for(int i=0; i<array.length; i++)
            {
                if(array[i] == array.length-1)
                {
                    array[i] = -1;
                    break;
                }
            }

            int index = 0;
            int max = array[index];
            
            for(int i=1; i<array.length; i++)
            {
                if(array[i] > max)
                {
                    index = i;
                    max = array[i];
                }
            }
            System.out.println(max);
        }
    }
}