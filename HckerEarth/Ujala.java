import java.util.*;
import java.io.*;

class Ujala
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
            FastReader sc = new FastReader();

            int t = sc.nextInt();

            for(int j=0;j<t;j++)
            {
                long k = sc.nextLong();     
                int[] array =  new int[7]; 
                int sum = 0;
                for(int i = 0;i<7;i++)
                {
                    array[i] = sc.nextInt();
                    sum+=array[i];  //Calculate the total subject per week
                }

                //We need to find the total weeks taken to complete all subjects
                //We can say that total subject divided by subject per week will give total week
                //this is calculated as below
                int week = (int)(k/sum);    
                

                //Once we get the total weeks, we need the subject left for last week
                //Here we calculate the number of subject left for last week as below:
                k = (int)(k - ((week)*sum));    //0

                //if the number of weeks require is exactly a perfect week, I mean it ends on sunday, K will become 0
                //this will raise issue and cannot be solved
                //we can assume that it ended on sunday, as it is a perfect week
                //lets be on the safer side and make a generalized algorithm
                //so in this case, we assume last week subjects as
                if(k == 0)
                    k = sum;

                //Now once we have the number of subjects left for last week we can apply the Ujala Loop here
                //check for everyday and if k becomes zero its the day we finish at
                //0 is monday and 6 is sunday
                
                for(int i=0;i<7;i++)
                {
                    k=k-array[i];
                    //System.out.println("k = "+k);
                    if(k<=0)
                    {
                        //System.out.println("i = "+i);
                        if(i==6)
                            System.out.println("SUNDAY");
                        else if(i==0)
                            System.out.println("MONDAY");
                        else if(i==1)
                            System.out.println("TUESDAY");
                        else if(i==2)
                            System.out.println("WEDNESDAY");
                        else if(i==3)
                            System.out.println("THURSDAY");
                        else if(i==4)
                            System.out.println("FRIDAY");
                        else if(i==5)
                            System.out.println("SATURDAY");
                        
                        break;
                    }
                }

            }
        }
        catch(Exception e)
        {
            //return;
            System.out.println(e);
        }
        
    }
}