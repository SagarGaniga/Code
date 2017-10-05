import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Bill
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
 
    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        for(int t = 0;t < test;t++)
        {
            String decoded = sc.next();
            String encoded = sc.next();
            int l = sc.nextInt();
            int q = sc.nextInt();
            String key = "";
            for (int i = 0; i < l ; i++ ) 
            {
                key+=(encoded.charAt(i) - decoded.charAt(i));    
            }
            // int foo = Integer.parseInt(key);
            // System.out.println(foo);
            for (int i = 0;i<q;i++ ) 
            {
                String line = sc.nextLine();
                String res = "";
                int index = 0;

                for(int j = 0; j < line.length();j++)
                {
                    int bar = ((int)line.charAt(j) - ((int)key.charAt(index%l)-48));
                    // System.out.println(((int)line.charAt(j) + ((int)key.charAt(j%l)-48)));
                    // System.out.println("line char = "+(int)line.charAt(j));
                    // System.out.println("key char = "+((int)key.charAt(j%l)-48));
                    if((int)line.charAt(j) >= 65 && (int)line.charAt(j) <= 90){
                        if(bar < 65){
                            int a = 65 - bar;
                            res+=((char) (91-a));
                        }
                        else
                            res+=((char) bar);    
                        index++;
                    }
                    else if((int)line.charAt(j) >= 97 && (int)line.charAt(j) <= 122){
                        if(bar < 97){
                            int a = 97 - bar;
                            res+=((char) (123-a));
                        }
                        else
                            res+=((char) bar);
                        index++;
                    }
                    else if((int)line.charAt(j) == 32 )
                    {
                        res+=line.charAt(j);
                    }
                    else{
                        res+=line.charAt(j);
                        index++;
                    }
                }
                System.out.println(res);
            }
        }

    }
}