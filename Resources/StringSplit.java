public static void main(String args[])
{
    FastReader sc = new FastReader();
    // Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int o = 0;o<t;o++)
    {
        String s = sc.nextLine();
        
        //ArrayList al = new ArrayList();
        String[] arr = s.split("\\s+");
        
        // System.out.println(Arrays.toString(arr));
        int[] array = new int[arr.length];
        for(int i =0;i<arr.length;i++)
        {
            array[i] = Integer.parseInt(arr[i]);
        }

        for (int i = 0;i<array.length ;i++ ) 
        {
            System.out.println(array[i]+2);    
        }

        

    }
}