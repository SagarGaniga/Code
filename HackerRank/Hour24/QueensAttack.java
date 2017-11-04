// Queen's Attack II

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class QueensAttack
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
    
    static int abs(int a)
    {
    	if(a >= 0 )
    		return a;
    	else
    		return a*-1;
    }
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        // Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int row_of_queen = sc.nextInt();
        int col_of_queen = sc.nextInt();

        long total = (n-1)+(n-1)+Math.min(n-col_of_queen, n-row_of_queen) + Math.min(col_of_queen - 1,n-row_of_queen) + Math.min(row_of_queen -1, col_of_queen -1) + Math.min(row_of_queen-1, n-col_of_queen);
        int row_of_obstacle, col_of_obstacle;
        System.out.println(total);
        for (int  i = 0;i < k;i++) 
        {
        	row_of_obstacle = sc.nextInt();
        	col_of_obstacle = sc.nextInt();


        	if(row_of_obstacle == row_of_queen)
        	{
        		//Queen and Obstacle are in same row. The Obstacle will definaitely hinder queens movement in horizontal direction
        		
        		//check if obstacle is after the queen or before queen (LOL, why?, OMG you should do that)

        		if(col_of_obstacle > col_of_queen)
        		{
        			// obstacle after queen
        			total = total - (n - col_of_obstacle +1);
        		}
        		else
        		{
        			// obstacle before queen
        			total = total - (col_of_obstacle);
        		}
        		// System.out.println(total);

        	}
        	else if(col_of_obstacle == col_of_queen)
        	{
        		// Queen and Obstacle are in same column. The Obstacle will definaitely hinder queens movement in verticle direction

        		// check if obstacle is up or down wrt queen

        		if(row_of_queen > row_of_obstacle)
        		{
        			// obstacle below queen
        			total = total - (row_of_obstacle);
        		}
        		else
        		{
        			// obstacle above queen
        			total = total - (n - row_of_obstacle + 1);
        		}

        		// System.out.println(total);
        	}
        	else
        	{
        		// Only diagonal obstacle is possible now

        		int queen_diff = abs(row_of_queen - col_of_queen);
        		int obstacle_diff = abs(row_of_obstacle - col_of_obstacle);

        		// for north_east
        		if((queen_diff == obstacle_diff) && (col_of_obstacle > col_of_obstacle))
        		{
        			total = total - (Math.min(n-col_of_obstacle, n-row_of_obstacle) + 1);
        		}

        		if((queen_diff == obstacle_diff) && (col_of_obstacle < col_of_obstacle))
        		{
        			total = total - (Math.min(col_of_obstacle, row_of_obstacle));	
        		}
        	}

        } 

        System.out.println(total);
    }
}

