/*
For two strings A and B, we define the similarity of the strings to be the length of the longest prefix common to both strings. 
For example, the similarity of strings "abc" and "abd" is 2, while the similarity of strings "aaa" and "aaab" is 3.
Calculate the sum of similarities of a string S with each of it's suffixes.

Input Format

The first line contains the number of test cases T. Each of the next T lines contains a string each.

Constraints

1 <= T <= 10 
The length of each string is at most 100000 and contains only lower case characters.

Output Format

Output T lines containing the answer for the corresponding test case.

Sample Input

2
ababaa  
aa
Sample Output

11  
3
Explanation

For the first case, the suffixes of the string are "ababaa", "babaa", "abaa", "baa", "aa" and "a". 
The similarities of these strings with the string "ababaa" are 6,0,3,0,1, & 1 respectively. Thus, the answer is 6 + 0 + 3 + 0 + 1 + 1 = 11.

For the second case, the answer is 2 + 1 = 3.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
 
 
class SuffixArray
{
	private String[] text;
    private int length;
    private int[] index;
    private String[] suffix;
    static private String val;
 
    public SuffixArray(String text)
    {
        this.text = new String[text.length()]; 
 
        for (int i = 0; i < text.length(); i++)
        {
            this.text[i] = text.substring(i, i+1);
        } 
 
        this.length = text.length();
        this.index = new int[length];
        for (int i = 0; i < length; i++)
        {
            index[i] = i;
        }	
 
        suffix = new String[length];
    }
 
    public void createSuffixArray()
    {   
        for(int index = 0; index < length; index++)	
        {
            String text = "";
            for (int text_index = index; text_index < length; text_index++)
            {
                text+=this.text[text_index];
            } 
            suffix[index] = text;
        }
 
        int back;
        for (int iteration = 1; iteration < length; iteration++)
        {
            String key = suffix[iteration];
            int keyindex = index[iteration];
 
            for (back = iteration - 1; back >= 0; back--)
            {
                if (suffix[back].compareTo(key) > 0)
                {
                    suffix[back + 1] = suffix[back];
                    index[back + 1] = index[back];
                }
                else
                {
                    break;
                }
            }
            suffix[ back + 1 ] = key;
            index[back + 1 ] = keyindex;
        }
 
        System.out.println("SUFFIX \t INDEX");
        for (int iterate = 0; iterate < length; iterate++)
        {		
            System.out.println(suffix[iterate] + "\t" + index[iterate]);


        }
    }


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
        	val = sc.next();

        	SuffixArray suffixarray = new SuffixArray(val);
	        suffixarray.createSuffixArray();    

	        // System.out.println(suffix[0]);

        }
    }
}


