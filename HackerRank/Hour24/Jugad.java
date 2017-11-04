// Queen's Attack II

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class Jugad
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

        int row_of_obstacle, col_of_obstacle;

        // arrya of nearest obstacle in all 8 direction

        /*
            0 North
            1 NorthEast
            2 East
            3 SouthEast
            4 South
            5 SouthWest
            6 West
            7 NorthWest
        */

        int array[][] = new int[8][2];

        for (int i = 0;i<8;i++) 
        {
             array[i][0] = n+1;
             array[i][1] = n+1;  
        }


        //for  WEST
        array[6][0] = -1;
        array[6][1] = -1;

        //for  South
        array[4][0] = -1;
        array[4][1] = -1;

        // NW
        array[7][0] = -1;
        array[7][1] = -1;        

        //SW
        array[5][0] = -1;
        array[5][1] = -1;

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
                    // East

                    if(array[2][1] > col_of_obstacle)
                    {
                        array[2][1] = col_of_obstacle;
                        array[2][0] = row_of_obstacle;  
                    }
                }
                else
                {
                    // obstacle before queen
                    // West
                    if(array[6][1] < col_of_obstacle)
                    {
                        array[6][1] = col_of_obstacle;
                        array[6][0]  = row_of_obstacle; 
                    }
                }
            }
            else if(col_of_obstacle == col_of_queen)
            {
                // Queen and Obstacle are in same column. The Obstacle will definaitely hinder queens movement in verticle direction

                // check if obstacle is up or down wrt queen

                if(row_of_queen > row_of_obstacle)
                {
                    // obstacle below queen
                    // South
                    if(array[4][0] < row_of_obstacle)
                    {
                        array[4][1] = col_of_obstacle;
                        array[4][0] = row_of_obstacle;  
                    }   
                }
                else
                {
                    // obstacle above queen
                    // north

                    if(array[0][0] > row_of_obstacle)
                    {
                        array[0][0] = row_of_obstacle;
                        array[0][1] = col_of_obstacle;
                    }
                }
            }
            else
            {
                // Only diagonal obstacle is possible now

                /***********************
                    (y1-y2)/(x1-x2) is 1 or -1 if x1,y1 and x2,y2 is diagonal
                    it is basically angle of line between two coordinates
                                        *************************************/
                
                if(((col_of_obstacle - col_of_queen) == (row_of_obstacle - row_of_queen))  || ((col_of_obstacle - col_of_queen) ==  -(row_of_obstacle - row_of_queen)))
                {
                    if(col_of_obstacle > col_of_queen)
                    {
                        if(row_of_obstacle > row_of_queen)
                        {
                            // NE  = 1
                            if(array[1][1] > col_of_obstacle)
                            {
                                array[1][0] = row_of_obstacle;
                                array[1][1] = col_of_obstacle;
                            }
                        }
                        else
                        {
                            // SE  = 3
                            if(array[3][1] > col_of_obstacle)
                            {
                                array[3][0] = row_of_obstacle;
                                array[3][1] = col_of_obstacle;
                            }
                        }
                    }
                    else
                    {

                        // System.out.println("We are here");
                        if(row_of_obstacle > row_of_queen)
                        {
                            // NW  = 7
                            if(array[7][1] < col_of_obstacle)
                            {
                                array[7][0] = row_of_obstacle;
                                array[7][1] = col_of_obstacle;
                            }
                        }
                        else
                        {
                            // SW  = 5
                            if(array[5][1] < col_of_obstacle)
                            {
                                array[5][0] = row_of_obstacle;
                                array[5][1] = col_of_obstacle;
                            }
                        }   
                    }
                }
            }
        } 
        long total = 0;
        // for (int i = 0;i<8;i++) 
        // {
        //     System.out.println("( "+array[i][0]+" , "+array[i][1]+" )");
        // }

        /*
            0 North
            1 NorthEast
            2 East
            3 SouthEast
            4 South
            5 SouthWest
            6 West
            7 NorthWest
        */
        int sum = 0;
        // North
        if (array[0][0] != n+1) 
        {
            sum = abs(array[0][0] - row_of_queen) -1;
            total = total +  sum;
            // System.out.println(sum);
        }
        else
        {
            sum = abs(n - row_of_queen);
            total = total + sum;
            // System.out.println(sum);
        }


        // East
        if(array[2][1] != 9)
        {
            sum  = abs(array[2][1] - col_of_queen) - 1;
            total = total + sum;
            // System.out.println(sum);
        }
        else
        {   
            sum =abs(n - col_of_queen);
            total = total + sum;
            // System.out.println(sum);
        }


        // South
        if(array[4][0] != -1)
        {

            sum = (abs(array[4][0] - row_of_queen)) - 1;
            total = total + sum;
            // System.out.println(sum);
        }
        else
        {
            sum = abs(row_of_queen -1);
            total = total + sum;
            // System.out.println(sum);
        }


        // west
        if(array[6][0] != -1)
        {
            sum = abs(array[6][1] - col_of_queen) - 1;
            total = total + sum;
            // System.out.println(sum);
        }
        else
        {
            sum  = abs(col_of_queen - 1);
            total  = total + sum;
            // System.out.println(sum);
        }


        // NE
        if(array[1][0] != n+1)
        {
            sum = abs(array[1][1] - col_of_queen) - 1;
            total = total + sum;
            // System.out.println(sum);
        }
        else
        {
            sum = abs(Math.min(n-col_of_queen, n-row_of_queen));
            total = total + sum;
            // System.out.println(sum);
        }

        //SE
        if(array[3][0] != n+1)
        {
            sum = (abs(array[3][1] - col_of_queen)) - 1;
            total = total + sum;
            // System.out.println(sum);
        }
        else {
            sum = abs(Math.min(row_of_queen-1, n-col_of_queen));
            total = total + sum;
            // System.out.println(sum);
        }


        // SW
        if(array[5][0] != -1)
        {
            sum = (abs(array[5][1] - col_of_queen)) - 1;
            total = total + sum;
            // System.out.println(sum);
        }
        else
        {
            sum =  abs(Math.min(row_of_queen -1, col_of_queen -1));
            total = total + sum;
            // System.out.println(sum);
        }


        // NW
        if(array[7][0] != -1)
        {
            sum = abs(array[7][1] - col_of_queen) - 1;
            total = total + sum;
            // System.out.println(sum);
        }
        else
        {
            sum =abs(Math.min(col_of_queen - 1,n-row_of_queen));
            total = total + sum;
            // System.out.println(sum);
        }

        System.out.println(total);
    }
}

