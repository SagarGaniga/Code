import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class BeautifulPairs
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

            int[] array1 = new int[n];
            int[] array2 = new int[n];

            for (int i = 0;i<n;i++) 
            {
                array1[i] = sc.nextInt();
            } 

            int array1_most_frequent =  getPopularElement(array1);

            for (int i = 0;i<n;i++) 
            {
                array2[i] = sc.nextInt();
            }

            int array2_least_frequent = getLOElement(array2, n); 

            // System.out.println("GG : "+array1_most_frequent+" "+array2_least_frequent);

            for(i = 0;i < n ;i++)
            {
                if(array2[i] == array2_least_frequent)
                {
                    array2[i] =  array2_least_frequent
                }
            }

            int temp, count = 0;
            for (int i=0;i < n ;i++ ) 
            {
                temp = array1[i];
                for (int j = 0;j < n; j++ ) 
                {
                    if(array2[j] == temp){
                        
                    }    
                }
            }


        }
    }


    static public int getPopularElement(int[] a)
    {
      int count = 1, tempCount;
      int popular = a[0];
      int temp = 0;
      for (int i = 0; i < (a.length - 1); i++)
      {
        temp = a[i];
        tempCount = 0;
        for (int j = 1; j < a.length; j++)
        {
          if (temp == a[j])
            tempCount++;
        }
        if (tempCount > count)
        {
          popular = temp;
          count = tempCount;
        }
      }
      return popular;
    }

    static public int getLOElement(int[] a, int len)
    {
      int count = len, tempCount;
      int popular = a[0];
      int temp = 0;
      for (int i = 0; i < (a.length - 1); i++)
      {
        temp = a[i];
        tempCount = 0;
        for (int j = 1; j < a.length; j++)
        {
          if (temp == a[j])
            tempCount++;
        }
        if (tempCount < count)
        {
          popular = temp;
          count = tempCount;
        }
      }
      return popular;
    }
}
