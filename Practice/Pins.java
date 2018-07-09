import java.util.*;
class Pins{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // Create an object of Palindrome class
        Palindrome pal = new Palindrome();
        Set<Integer> palindromes = pal.allPalindromic(100000);
        // System.out.println(palindromes);
        for(int t = 0; t< T; t++){
            int N = sc.nextInt();
            int count = 0;
            if(palindromes.contains(N)){
                count++;
            }
            System.out.println(count);
        }

        
    }
}

// Class to findout palindromes
class Palindrome{

    // Constructor
    Palindrome(){
    }

    // Method which return all the palindrome number in the given range
    // It return a set
    // Takes 1 input parameter, the limit
    public Set<Integer> allPalindromic(int limit) {
        
        // Set which will contain the palindromic numbers
        // It is of integers
        Set<Integer> result = new HashSet<Integer>();
    
        // loop till 0 to 9 and add it the set because 0 to 9 are single decimal numbers
        // They will be palindrome for sure
        for (int i = 0; i <= 9 && i <= limit; i++){
            result.add(i);
        }
            
    
        // Boolean to check if we reached the limit
        boolean cont = true;

        // loop over the numbers from 1 to limit 

        /*=============================================================
         * Use this algorithm
         *===============================================================
         * Not try to find these numbers but instead create them. 
         * You can simply take any number and mirror it (which is always even in length) 
         * and for that same number simply add 0..9 in between 
         * (for the numbers with odd length).
        */
        for (int i = 1; cont; i++) {

            // We cant reverse the string easily so lets use string bufffer
            // // convert the number to string by appending it to ""
            // Then convert it into string buffer 
            // then reverse it
            StringBuffer rev = new StringBuffer("" + i).reverse(); 
            
            // Before entering into the loop of adding the number in the middle
            // Declare continue variable false
            cont = false;

            /*
            * Insert numbers from 0 to 9 in between all the integers i
            * This goes like, take a number say 11, reverse it and add 0 to 9 between it
            * so 11011 is pallindrome
            * 12121 is pallindrome
            * 1692961 is pallinfrome
            * wew
            */
            for (String d : ",0,1,2,3,4,5,6,7,8,9".split(",")) {
                // Parse the string into interger 
                int n = Integer.parseInt("" + i + d + rev);
                
                // Check if it crosses limit
                if (n <= limit) {
                    cont = true;
                    result.add(n);
                }
            }
        }
    
        return result;
    }
}