import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class MATDYS
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
    public static void shuffle(int[] a, int low, int high, int n) 
    {
        int N = high - low;         
        if (Math.pow(2,n) >= Math.pow(2,3)) 
            return; 
        int mid = low + N/2; 
        // recursively sort 
        shuffle(a, low, mid, n+1); 
        shuffle(a, mid, high, n+1); 
        n++;
        // merge two sorted subarrays
        //int[] temp = new int[N];
        int[] even = new int[N/2];
        int[] odd = new int[N/2];
        int e=0,o=0;
        int i = low, j = mid;
        for (int k = low; k < high; k++) 
        {
            if (k % 2 == 0) 
            { 
                // Even
                even[e++] = a[k];
            } 
            else 
            { 
                // Odd
                odd[o++] = a[k];
            }
        }    
        System.out.println("EVEN:");
        for (int k = 0; k < e; k++){
            // a[low + k] = temp[k];
            System.out.print(even[k]);
        } 
        e=0;
        for(int k = low;k<high/2;k++)
        {
            a[k] = even[e++];
        }
        System.out.println();

        System.out.println("ODD:");
        for (int k = 0; k < o; k++){
            // a[low + k] = temp[k];
            System.out.print(odd[k]);
        }
        o=0;
        for(int k = high/2;k<high/2;k++)
        {
            a[k] = odd[o++];
        }       
        System.out.println();
        // for (int q =0;q<a.length;q++) 
        // {
        //     System.out.print(a[q]);         
        // }     
        // System.out.println();
    }
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        // Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0;t<test;t++)
        {
            int arr[] = {0,1,2,3,4,5,6,7};
            shuffle(arr,0,8,0);
            for (int i=0;i<8;i++) 
            {
                System.out.println(arr[i]);    
            }
        }
    }

    
}