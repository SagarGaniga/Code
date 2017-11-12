import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class OrderStrings
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
        Scanner sc1 = new Scanner(System.in);
        int test = 1;

        for(int t = 0;t<test;t++)
        {
            int n = sc.nextInt();
            
            String[] strings = new String[n];
            
            String[][] array = new String[n][50];

            for (int i = 0;i<n;i++) 
            {
                strings[i] = sc.nextLine();
                
                String[] word = strings[i].split("\\s");
                
                for (int j =0;j < word.length; j++ ) 
                {
                    array[i][j] = word[j];
                }
            }
            
            String gg =  sc.nextLine();
            String[] words = gg.split("\\s");

            final int k = Integer.parseInt(words[0]);
            boolean rev = Boolean.valueOf(words[1]);
            String type = words[2];

            if(type.equals("lexicographic"))
            {                
                Arrays.sort(array, new Comparator<String[]>() {
                    @Override
                    public int compare(final String[] entry1, final String[] entry2) {
                        final String time1 = entry1[k-1];
                        final String time2 = entry2[k-1];
                        return time1.compareTo(time2);
                    }
                });
                Collections.reverse(Arrays.asList(array));
            }
            else if (type.equals("numeric")) 
            {
                Arrays.sort(array, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return Integer.compare(Integer.parseInt(o1[k-1]), Integer.parseInt(o2[k-1]));
                    }
                }); 

                Collections.reverse(Arrays.asList(array));
            }

            // If reverse is true
            if(rev ==  true)
            {
                for (int i=0; i<n; i++) 
                {
                    for (int j =0;j<50;j++ ) 
                    {
                        if(array[i][j] ==null)
                            break;

                        System.out.print(array[i][j] + " ");    
                    }
                    System.out.println();
                }   
            }
            else
            {
                for (int i=n-1; i>=0; i--) 
                {   
                    for (int j =0;j<50;j++ ) 
                    {
                        if(array[i][j] ==null)
                            break;

                        System.out.print(array[i][j] + " ");    
                    }
                    System.out.println();
                }
            }
        }
    }
}  
