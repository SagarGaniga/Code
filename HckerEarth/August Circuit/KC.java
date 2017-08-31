import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class KC
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
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] x = new long[n];
        long[] y = new long[n];
        for(int t = 0;t<n;t++)
        {
            x[t] = sc.nextLong();
        }
        for(int t = 0;t<n;t++)
        {
            y[t] = sc.nextLong();
        }

        ArrayList<Double> ar = new ArrayList<Double>();
        Double dist;
        for(int i=0;i<n;i++)
        {
            dist = Math.sqrt(x[i]*x[i]+y[i]*y[i]);
            ar.add(dist);
        }
        Collections.sort(ar);
        // System.out.println(ar);
        System.out.println((int)Math.ceil(ar.get(k-1)));
        

    }
}