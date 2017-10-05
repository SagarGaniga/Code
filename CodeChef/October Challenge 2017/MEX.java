import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class MEX
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
            int k = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0 ;i<n; i++ ) 
            {
                arr[i] = sc.nextInt();
            }
            // shuffleArray(arr);
            Arrays.sort(arr);
            // System.out.println(arr[n-1]);

            ArrayList<Integer> al = new ArrayList<Integer>();
            int index = 0;
            for (int i = 0;i<arr[n-1];i++ ) 
            {
                if(arr[index] != i)
                {
                    al.add(i);
                }   
                else
                {
                    index++;
                }
            }

            if(k > al.size())
            {
                System.out.println((arr[n-1]+1+(k - al.size())));
            }
            else if (al.size() == 0) 
            {
                System.out.println((arr[n-1]+1));
            }
            else if(k==0 && al.size() != 0)
            {
                System.out.println(al.get(0));   
            }
            else
            {
                System.out.println(al.get(k));   
            }
        }   
    }
}
