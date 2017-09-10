import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
class StringMatch
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
        int cfor19 = 0;
        int cfor21 = 0;
        for(int t = 0;t<test;t++)
        {
            String str=sc.nextLine();
            String[] words = str.split(" ");
            
            for (int i = 0; i < words.length; i++) 
            {
                words[i] = words[i].replaceAll("[^\\w]", "");
            }
            
            // System.out.println("first :"+words[0].charAt(0));
            for (int  i = 0; i < words.length; i++) 
            {
                // boolean isN = 
                if(words[i].matches("-?\\d+(\\.\\d+)?"))
                {
                    if(words[0].charAt(0) == 'G')
                    {
                        if(Integer.parseInt(words[i]) == 19)
                            cfor19 = cfor19 + 2;
                        else if(Integer.parseInt(words[i]) == 21)
                            cfor21 = cfor21 + 2;    
                        else
                            continue;
                    }
                    else
                    {
                        if(Integer.parseInt(words[i]) == 19)
                            cfor19++;
                        else if(Integer.parseInt(words[i]) == 21)
                            cfor21++;
                        else
                            continue;
                    }
                    
                }
            }
        }
        if(cfor21>=cfor19)
            System.out.println("No Date");
        else
            System.out.println("Date");
    }
}