import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
class C00K0FF
{
     public static void main(String[] args) throws IOException
    {
        // FastReader sc = new FastReader();
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        for( int t = 0 ; t < test ; t++ )
        {
        	int[] array = new int[5];
            int n = sc.nextInt();
            boolean isItFull = true;
            for ( int  i = 0 ; i < n ; i++ ) 
            {
            	String s = sc.next();
            	for (int h = 0; h < 5 ; h++ ) 
            	{
            		if(array[h] == 0)
            		{
            			isItFull = false;
            			break;
            		}
            	}

            	if(isItFull == true)
            	{
            		break;
            	}

            	if(isItFull == false)
            	{
	           		if(s.equals("cakewalk"))
	           		{
	           			if(array[0] == 0)		
	           				array[0] = 1; 	
	           		}
	           		else if(s.equals("simple"))
	           		{
	           			if(array[1] == 0)
	           				array[1] = 1;
	           			// continue;
	           		}
	           		else if(s.equals("easy"))
	           		{
	           			if(array[2] == 0)
	           				array[2] = 1;
	           			// continue;
	           		}
	           		else if(s.equals("easy-medium") || s.equals("medium"))
	           		{
	           			array[3]++;
	           			// continue;
	           		}
	           		else if(s.equals("medium-hard") || s.equals("hard"))
	           		{
	           			array[4]++;
	           			// continue;
	           		}
	           	}

           		boolean cross = false;
           		for (int h = 0; h < 5 ; h++ ) 
            	{
            		// System.out.println(array[h]);
            		if(array[h] == 0)
            		{
            			isItFull = false;
            			break;
            		}
            		if(h == 4)
            			cross = true;
            	}
            	if(cross)
            		isItFull = true;
            }
            
            for (int h = 0; h < 5 ; h++ ) 
        	{
        		if(array[h] == 0)
        			isItFull = false;
        	}
        	// System.out.println(isItFull);
            if(isItFull)
            	System.out.println("Yes");
            else
            	System.out.println("No");

            
        }

    }
}

