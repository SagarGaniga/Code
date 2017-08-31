import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
class princess 
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

    public static void main(String args[]) throws IOException
    {
        try
        {
            Set<String> s = new HashSet<String>();
            //Scanner sc = new Scanner(System.in);
            FastReader sc = new FastReader();
            int t = sc.nextInt();
            for (int q= 0;q<t;q++) 
            {
                boolean pal = false;
                String st = sc.next();
                int l = st.length();
                int size= (l*(l+1)/2) - l;
                //printSubString(st, s);
                //String[] array = s.toArray(new String[s.size()]);
                String[] array = new String[size];
                int k=0;
                for (int i = 0; i < l; i++) 
                {
                    for (int j = i+2; j <= st.length(); j++) 
                    {
                        //System.out.println(st.substring(i,j));
                        array[k++]=st.substring(i,j);
                    }
                }
                for(int i = 0;i<size;i++)
                {
                    //System.out.println(array[i]);
                    pal = isItPal(array[i]);
                    if(pal==true)
                        break;
                }
                if(pal == true)
                    System.out.println("YES");
                else
                    System.out.println("NO");

            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    // static void printSubString(String s, Set<String> set) 
    // {
    //     try
    //     {
    //         if(!set.contains(s)) 
    //         {
    //             if(s.length() != 1) 
    //             {           
    //                 for(int i=0; i<(s.length()); i++) 
    //                 {
    //                     if(i==0) 
    //                     {
    //                         printSubString(s.substring(i+1, s.length()), set);
    //                     } 
    //                     else if(i == (s.length()-1)) 
    //                     {
    //                         printSubString(s.substring(0,i), set);
    //                     } 
    //                     set.add(s);
    //                 }
    //             }
    //         }
    //         return;
    //     }
    //     catch(Exception e)
    //     {
    //         System.out.println(e);
    //     }
        
    // }


    static boolean isItPal(String s)
    {
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) 
        {
            if (s.charAt(i) != s.charAt(n - i - 1)) 
            {
                return false;
            }
        }
        return true;
    }
}