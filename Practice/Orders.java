
// ======================================================================================== 
// Question
// ======================================================================================== 

// In Byteland it is always the military officer's main worry to order his soldiers on parade correctly. 
// Luckily, ordering soldiers is not really such a problem. 
// If a platoon consists of n men, all of them have different rank 
// (from 1 - lowest to n - highest) and on parade they should be lined up from left to right in increasing order of rank.

// Well, Sgt Johnny thought the same, until one day he was faced with a new command. 
// He soon discovered that his elite commandos preferred to do the fighting, and leave the thinking to their superiors. 
// So, when at the first rollcall the soldiers lined up in fairly random order it was not because of their lack of discipline, but simply because they couldn't work out how to form a line in correct order of ranks. 

// Sgt Johnny was not at all amused, particularly as he soon found that none of the soldiers even remembered his own rank. 

// Over the years of service every soldier had only learned which of the other soldiers were his superiors. But Sgt Johnny was not a man to give up easily when faced with a true military challenge. 

// After a moment's thought a solution of brilliant simplicity struck him and he issued the following order: 

// "men, starting from the left, one by one, do: (step forward; go left until there is no superior to the left of you; get back in line).". 

// This did indeed get the men sorted in a few minutes. The problem was solved... for the time being.

// The next day, the soldiers came in exactly the same order as the day before, and had to be rearranged using the same method. History repeated. 

// After some weeks, Sgt Johnny managed to force each of his soldiers to remember how many men he passed when going left, and thus make the sorting process even faster.

// If you know how many positions each man has to walk to the left, can you try to find out what order of ranks the soldiers initially line up in?


// ======================================================================================== 
// Solution
// 1 2 3
// 0 1 0
// 2 1 3

// 1 2 3 4 5
// 0 1 2 0 1
// 3 2 1 5 4

// 1 2 3 4 5
// 2 0 2 1 1
// 3 2 1 5 4

    // 1 2 3 4 5
    // 0 1 2 0 1
    // 3 2 1 5 4

    // 1 2 3 4 5
    // 1 1 1 4 4 
    // 3 2 1 5 4

    // 1 2 3
    // 0 1 0
    // 1 1 3
    // 2 1 3



// ========================================================================================


import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
 
public class Orders {


    // IDK yet
    private static int[] st;
    
    // varibale to hold position?
    private static int position;
 
    private static void build(int idx, int l, int r) {
        
        // l  = 0 and R = N-1
            if (l == r) {
                st[idx] = 1;
                return;
            }
        
        // Get the mid node
        int mid = l + (r - l) / 2;
        // System.out.println(mid);
        // Recursively build the tree
        
        // index, left, right
        build(idx * 2 + 1, l, mid);

        // index, left, right
        build(idx * 2 + 2, mid + 1, r);

        // System.out.println();
        st[idx] = st[idx * 2 + 1] + st[idx * 2 + 2];
        // System.out.println(st[idx]);
    }
 
    private static void update(int idx, int l, int r, int value) {
        if (l == r) {
            st[idx] = 0;
            position = l;
            return;
        }
 
        int mid = l + (r - l) / 2;
        if (st[idx * 2 + 1] >= value) update(idx * 2 + 1, l, mid, value);
        else update(idx * 2 + 2, mid + 1, r, value - st[idx * 2 + 1]);
        st[idx] = st[idx * 2 + 1] + st[idx * 2 + 2];
    }
 
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        int T = in.readInt();
        while (T-- > 0) {
            // take N
            int N = in.readInt();
            
            // Create array with N size
            int[] w = new int[N];

            // Take input in this array
            for (int i = 0; i < N; i++) w[i] = in.readInt();
 
            // Height of the tree
            // WOW TREE
            // Formula is ciel(log(N)/log(2))
            int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2.0));
            // 
            // Max nodes in tree is n=(2^h+1)-1
            int maxTreeSize = (int) Math.pow(2, treeHeight + 1) - 1;
            
            // Set the size of the array as the size of the tree
            st = new int[maxTreeSize];
 
            // Call the build constructor
            // pass index = 0, l = 0 and R = N-1
            build(0, 0, N - 1);

            // for(int i = 0;i<st.length;i++){
            //     System.out.print(st[i] + " ");
            // }
            // System.out.println();

            // Create a Rank array with size N
            int[] rank = new int[N];

            // interate reverse
            for (int i = N - 1; i >= 0; i --) {
                update(0, 0, N - 1, i - w[i] + 1);
                rank[i] = position + 1;
            }
 
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<N;i++) {
                if (i != 0) sb.append(" ");
                sb.append(rank[i]);
            }
            System.out.println(sb);
        }
    }
 
    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
 
        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
    }
} 

