public class Tree{
    private static int[] st;
    private static void build(int idx, int l, int r){
        // Base case
        if (l == r) {
            st[idx] = 1;
            System.out.println("id: "+idx+" value: "+st[idx]);
            return;
        }

        // System.out.println(idx);
        int mid = l + (r - l) / 2;

        // System.out.println("Mid: "+mid);
        // System.out.println("Left: "+l);
        // System.out.println("Right: "+r);
        // System.out.println("idx: "+idx);

        // System.out.println("Go Left");
        build(idx * 2 + 1, l, mid);

        // System.out.println("Go Right");
        build(idx * 2 + 2, mid+1, r);

        st[idx] = st[idx * 2 + 1] + st[idx * 2 + 2];
        System.out.println("id: "+idx+" value: "+st[idx]);
    }

    public static void main(String[] args){
        int N = 3;

        int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2.0));
        
        System.out.println("Tree Height: "+treeHeight);

        int maxTreeSize = (int) Math.pow(2, treeHeight + 1) - 1;

        System.out.println("Max Nodes: "+maxTreeSize);

        st = new int[maxTreeSize];

        build(0, 0, N - 1);



    }
}